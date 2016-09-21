package _05_shoppingCart.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.naming.*;

import javax.sql.*;

import _00_init.GlobalService;

public class OrderListsDAO implements OrderListsDAO_interface,java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	private int memberId = 0;
	private DataSource ds = null;
	
	public OrderListsDAO() throws NamingException
	{
		Context ctx = new InitialContext();
		ds = (DataSource) ctx.lookup(GlobalService.JNDI_DB_NAME);
	}
	
	public void insertOrderLists(OrderListsVO olv) throws SQLException
	{
		//加到訂單
		String sqlOrderLists = "INSERT INTO OrderLists (Members_ID,OrderLists_Date,OrderLists_Address,"
				+ "OrderLists_PaymentMethod,OrderLists_TotalAmount) "
				+ "VALUES (?,?,?,?,?)";
		
		//加到明細
		String sqlDetails = "INSERT INTO ShoppingDetails (Members_ID,OrderLists_ID,"
				+ "ProductListingBook_ID,ProductListingFood_ID,ShoppingDetails_BookQuantity,ShoppingDetails_FoodQuantity,"
				+ "ShoppingDetails_Date,ShoppingDetails_BookPrice,ShoppingDetails_FoodPrice,"
				+ "ShoppingDetails_isShipments)"
				+ "VALUES (?,?,?,?,?,?,?,?,?,?)";
		
		//減少庫存
		String selectBookList = "SELECT ProductListingBook_ID,ProductListingBook_Quantity FROM ProductListingBook WHERE ProductListingBook_ID=?";
		String selectFoodList = "SELECT ProductListingFood_ID,ProductListingFood_Quantity FROM ProductListingFood WHERE ProductListingFood_ID=?";
		String updateBookList = "UPDATE ProductListingBook set ProductListingBook_Quantity=? WHERE ProductListingBook_ID=?";
		String updateFoodList = "UPDATE ProductListingFood set ProductListingFood_Quantity=? WHERE ProductListingFood_ID=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		PreparedStatement pstmt4 = null;
		PreparedStatement pstmt5 = null;
		PreparedStatement pstmt6 = null;		
		ResultSet generatedKeys = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		
		try
		{
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sqlOrderLists,Statement.RETURN_GENERATED_KEYS);
			
			pstmt.setInt(1, olv.getMembers_ID());
			Timestamp ts = new Timestamp(olv.getOrderLists_Date().getTime());
			pstmt.setTimestamp(2, ts);
			pstmt.setString(3, olv.getOrderLists_Address());
			pstmt.setString(4, olv.getOrderLists_PaymentMethod());
			pstmt.setDouble(5, olv.getOrderLists_TotalAmount());
			pstmt.executeUpdate();
			
			int id = 0;
			
			//Retrieves any auto-generated keys created as a result of executing this Statement object.
			//If this Statement object did not generate any keys, an empty ResultSet object is returned.
			generatedKeys = pstmt.getGeneratedKeys();
			
			if (generatedKeys.next())
			{
				id = generatedKeys.getInt(1);  //orderListId
			}
			else 
			{
				throw new SQLException("Creating user failed, no generated key obtained.");
			}
			
			
			List<ShoppingDetailsVO> details = olv.getDetails();
			pstmt2 = conn.prepareStatement(sqlDetails);
			pstmt3 = conn.prepareStatement(selectBookList);
			pstmt5 = conn.prepareStatement(selectFoodList);
			
			int chooseBookQty = 0;
			int chooseFoodQty = 0;
			int chooseBookId = 0;
			int chooseFoodId = 0;
			
			for (ShoppingDetailsVO sd : details)
			{
				pstmt2.setInt(1, olv.getMembers_ID());
				pstmt2.setInt(2, id);
				pstmt2.setInt(3, sd.getProductListingBook_ID());
				pstmt2.setInt(4, sd.getProductListingFood_ID());
				pstmt2.setInt(5, sd.getShoppingDetails_BookQuantity());
				pstmt2.setInt(6, sd.getShoppingDetails_FoodQuantity());
				pstmt2.setTimestamp(7, ts);
				pstmt2.setDouble(8, sd.getShoppingDetails_BookPrice());
				pstmt2.setDouble(9, sd.getShoppingDetails_FoodPrice());
				pstmt2.setString(10, sd.getShoppingDetails_isShipments());

				chooseBookId = sd.getProductListingBook_ID();
				chooseBookQty = sd.getShoppingDetails_BookQuantity();
				chooseFoodId = sd.getProductListingFood_ID();
				chooseFoodQty = sd.getShoppingDetails_FoodQuantity();

				pstmt3.setInt(1, chooseBookId);
				pstmt5.setInt(1, chooseFoodId);
				rs = pstmt3.executeQuery();
				rs2 = pstmt5.executeQuery();
				
				int bookId = 0;
				int bookQty = 0;
				int foodId = 0;
				int foodQty = 0;
				
				while (rs.next())
				{
					bookId = rs.getInt(1);
					bookQty = rs.getInt(2);
				}
				
				while (rs2.next())
				{
					foodId = rs2.getInt(1);
					foodQty = rs2.getInt(2);
				}
				
				int newBookQty = bookQty - chooseBookQty;
				int newFoodQty = foodQty = chooseFoodQty;
				
				pstmt4 = conn.prepareStatement(updateBookList);
				pstmt4.setInt(1, newBookQty);
				pstmt4.setInt(2, bookId);
				pstmt4.executeUpdate();
				
				pstmt6 = conn.prepareStatement(updateFoodList);
				pstmt6.setInt(1, newFoodQty);
				pstmt6.setInt(2, foodId);
				pstmt6.executeUpdate();
				
				pstmt2.executeUpdate();
				
				//Clears the current parameter values immediately. 
				pstmt2.clearParameters();
			}
			conn.commit();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
			System.out.println("資料還原");
			if (conn != null)
			{
				conn.rollback();
			}
		}
		finally
		{
			if (pstmt != null)
			{
				pstmt.close();
			}
			if (pstmt2 != null)
			{
				pstmt2.close();
			}
			if (conn != null)
			{
				conn.setAutoCommit(true);
			}
			if (conn != null)
			{
				conn.close();
			}
		}
	}
	
	public OrderListsVO getOrder(int OrderLists_ID) throws SQLException
	{
		String sqlOrder = "SELECT * FROM OrderLists WHERE OrderLists_ID = ?";
		
		//缺食物的部分
		String sqlDetails = "SELECT s.ShoppingDetails_ID,s.Members_ID,s.OrderLists_ID,s.ProductListingBook_ID,s.ProductListingFood_ID,s.ShoppingDetails_BookQuantity,"
				+ "s.ShoppingDetails_FoodQuantity,s.ShoppingDetails_Date,s.ShoppingDetails_BookPrice,s.ShoppingDetails_FoodPrice,s.ShoppingDetails_isShipments,"
				+ "p.ProductListingBook_Name,p.ProductListingBook_Discount "
				+ "FROM ShoppingDetails s JOIN ProductListingBook p "
				+ "ON s.ProductListingBook_ID = p.ProductListingBook_ID "
				+ "WHERE s.OrderLists_ID = ?";
		List<ShoppingDetailsVO> details = new ArrayList<ShoppingDetailsVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		OrderListsVO olv = null;
		
		try
		{
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sqlOrder);
			pstmt.setInt(1, OrderLists_ID);
			rs = pstmt.executeQuery();
			
			if (rs.next())
			{
				olv = new OrderListsVO();
				olv.setOrderLists_ID(rs.getInt(1));
				olv.setMembers_ID(rs.getInt(2));
				olv.setOrderLists_Date(rs.getDate(3));
				olv.setOrderLists_Address(rs.getString(4));
				olv.setOrderLists_PaymentMethod(rs.getString(5));
				olv.setOrderLists_TotalAmount(rs.getDouble(6));
			}
			
			if (olv == null)
			{
				throw new SQLException("資料庫邏輯錯誤：無此紀錄, 訂單編號=" + OrderLists_ID);
			}
			else 
			{
				pstmt2 = conn.prepareStatement(sqlDetails);
				pstmt2.setInt(1, OrderLists_ID);
				rs2 = pstmt2.executeQuery();
				
				ShoppingDetailsVO sdv = null;
				
				while (rs2.next())
				{
					sdv = new ShoppingDetailsVO();
					sdv.setShoppingDetails_ID(rs2.getInt(1));
					sdv.setMembers_ID(rs2.getInt(2));
					sdv.setOrderLists_ID(rs2.getInt(3));
					sdv.setProductListingBook_ID(rs2.getInt(4));
					sdv.setProductListingFood_ID(rs2.getInt(5));
					sdv.setShoppingDetails_BookQuantity(rs2.getInt(6));
					sdv.setShoppingDetails_FoodQuantity(rs2.getInt(7));
					sdv.setShoppingDetails_Date(rs2.getDate(8));
					sdv.setShoppingDetails_BookPrice(rs2.getDouble(9));
					sdv.setShoppingDetails_FoodPrice(rs2.getDouble(10));
					sdv.setShoppingDetails_isShipments(rs2.getString(11));
					sdv.setProductListingBook_Name(rs2.getString(12));
					sdv.setProductListingBook_Discount(rs2.getDouble(13));
//					System.out.println(rs2.getString(4));
					details.add(sdv);
				}
			}
			olv.setDetails(details);
		} 
		finally
		{
			if (rs != null)
			{
				rs.close();
			}
			if (rs2 != null)
			{
				rs2.close();
			}
			if (pstmt != null)
			{
				pstmt.close();
			}
			if (pstmt2 != null)
			{
				pstmt2.close();
			}
			if (conn != null)
			{
				conn.close();
			}
		}
		
		return olv;
	}

	public Collection<OrderListsVO> getAllOrders() throws SQLException
	{
		Collection<OrderListsVO> coll = new ArrayList<OrderListsVO>();
		String sqlOrder = "SELECT * FROM OrderLists ORDER BY OrderLists_Date DESC, OrderLists_ID DESC";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		OrderListsVO olv = null;
		
		try
		{
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sqlOrder);
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				olv = new OrderListsVO();
				olv.setOrderLists_ID(rs.getInt(1));
				olv.setMembers_ID(rs.getInt(2));
				olv.setOrderLists_Date(rs.getDate(3));
				olv.setOrderLists_Address(rs.getString(4));
				olv.setOrderLists_PaymentMethod(rs.getString(5));
				olv.setOrderLists_TotalAmount(rs.getDouble(6));
				coll.add(olv);
			}
		} 
		finally
		{
			if (rs != null)
			{
				rs.close();
			}
			if (pstmt != null)
			{
				pstmt.close();
			}
			if (conn != null)
			{
				conn.close();
			}
		}
		return coll;	
	}
	
	//用在哪還要確定 , 參考OrderDAO
	public Collection<OrderListsVO> getMemberOrders() throws SQLException
	{
		Collection<OrderListsVO> coll = new ArrayList<OrderListsVO>();
		String sqlOrder = "SELECT * FROM OrderLists Order by orderDate desc where Members_ID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		OrderListsVO olv = null;
		try
		{
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sqlOrder);
			pstmt.setInt(1, memberId);
			rs = pstmt.executeQuery();

			while (rs.next())
			{
				olv = new OrderListsVO();
				olv.setOrderLists_ID(rs.getInt(1));
				olv.setMembers_ID(rs.getInt(2));
				olv.setOrderLists_Date(rs.getDate(3));
				olv.setOrderLists_Address(rs.getString(4));
				olv.setOrderLists_PaymentMethod(rs.getString(5));
				olv.setOrderLists_TotalAmount(rs.getDouble(6));
				coll.add(olv);
			}
		}
		finally
		{
			if (rs != null)
			{
				rs.close();
			}
			if (pstmt != null)
			{
				pstmt.close();
			}
			if (conn != null)
			{
				conn.close();
			}
		}
		
		return coll;
	}

	public int getMemberId()
	{
		return memberId;
	}

	public void setMemberId(int memberId)
	{
		this.memberId = memberId;
	}

}
