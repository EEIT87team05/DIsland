package _04_product.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import _00_init.GlobalService;

public class ProductListingBookDAO implements ProductListingBookDAO_interface
{
	// 一個應用程式中,針對一個資料庫 ,共用一個DataSource即可
	private static DataSource ds = null;
	static
	{
		try
		{
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup(GlobalService.JNDI_DB_NAME);
		} catch (NamingException e)
		{
			e.printStackTrace();
		}
	}
	private static final String INSERT_STMT = "INSERT INTO ProductListingBook (ProductListingBook_Name,ProductListingBook_Price,ProductListingBook_Discount,ProductListingBook_Quantity,ProductListingBook_Publishedate,ProductListingBook_Publisher,ProductListingBook_Picture,ProductListingBook_Authors,ProductListingBook_Des) VALUES (?,?,?,?,?,?,?,?,?) ";
	private static final String UPDATE_STMT = "UPDATE ProductListingBook set ProductListingBook_Name=?, ProductListingBook_Price=?, ProductListingBook_Discount=?, ProductListingBook_Quantity=?, ProductListingBook_Publishedate=?, ProductListingBook_Publisher=?, ProductListingBook_Picture=?, ProductListingBook_Authors=?, ProductListingBook_Des=? where ProductListingBook_ID = ?";
	private static final String DELETE_STMT = "DELETE FROM ProductListingBook where ProductListingBook_ID = ?";
	private static final String GET_ONE_STMT = "SELECT ProductListingBook_ID,ProductListingBook_Name,ProductListingBook_Price,ProductListingBook_Discount,ProductListingBook_Quantity,ProductListingBook_Publishedate,ProductListingBook_Publisher,ProductListingBook_Picture,ProductListingBook_Authors,ProductListingBook_Des where ProductListingBook_ID = ?";
	private static final String GET_ALL_STMT = "SELECT ProductListingBook_ID,ProductListingBook_Name,ProductListingBook_Price,ProductListingBook_Discount,ProductListingBook_Quantity,ProductListingBook_Publishedate,ProductListingBook_Publisher,ProductListingBook_Picture,ProductListingBook_Authors,ProductListingBook_Des order by ProductListingBook_ID = ?";
	private static final String GET_COUNTS = "SELECT count(*) FROM ProductListingBook";

	@Override
	public void insert(ProductListingBookVO productListingBookVO) throws SQLException
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		int i = 0;

		try
		{
			conn = ds.getConnection();
			conn.setAutoCommit(false);// 關閉自動交易，交易在還沒commit或rollback之前，變更的資料是置於一暫存區。

			pstmt = conn.prepareStatement(INSERT_STMT);
			pstmt.setString(1, productListingBookVO.getProductListingBook_Name());
			pstmt.setDouble(2, productListingBookVO.getProductListingBook_Price());
			pstmt.setFloat(3, productListingBookVO.getProductListingBook_Discount());
			pstmt.setInt(4, productListingBookVO.getProductListingBook_Quantity());
			pstmt.setDate(5, productListingBookVO.getProductListingBook_Publishedate());
			pstmt.setString(6, productListingBookVO.getProductListingBook_Publisher());
			pstmt.setBlob(7, productListingBookVO.getProductListingBook_Picture());
			pstmt.setString(8, productListingBookVO.getProductListingBook_Authors());
			pstmt.setString(9, productListingBookVO.getProductListingBook_Des());

			i = pstmt.executeUpdate(); // 用於SQL的insert、update、delete指令， 回傳型別int
										// executeUpdate()會傳回成功更新的資料列數目
										// //用於SQL的select指令，
										// ResultSet是"集合"，回傳型別ResultSet
										// executeQuery()傳回所有符合條件的資料列。
			System.out.println("insert count = " + i);

			if (i >= 1)
			{
				System.out.println("新增成功");
			} else
			{
				throw new SQLException("新增記錄數 : 0");
			}

			conn.commit();// 若所有敘述運作良好，則對資料庫做確認(commit)處理=>結束目前的交易，並將執行結果從暫存區寫入資料庫
			conn.setAutoCommit(true); // 開啟自動交易

		} catch (SQLException se)
		{ // Handle any SQL errors
			conn.rollback(); // 若其中有任何敘述發生錯誤，則回復(rollback)交易前的狀態
								// =>結束目前的交易，並將暫存區刪除。
			throw new RuntimeException("A database error occured. " + se.getMessage());

		} finally // Clean up JDBC resources
		{
			if (pstmt != null)
			{
				try
				{
					pstmt.close();
				} catch (SQLException se)
				{
					se.printStackTrace(System.err);
				}
			}
			if (conn != null)
			{
				try
				{
					conn.close();
				} catch (Exception e)
				{
					e.printStackTrace(System.err);
				}
			}
		}
	}

	@Override
	public void update(ProductListingBookVO productListingBookVO) throws SQLException
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		int i = 0;

		try
		{
			conn = ds.getConnection();
			conn.setAutoCommit(false);// 關閉自動交易，交易在還沒commit或rollback之前，變更的資料是置於一暫存區。

			pstmt = conn.prepareStatement(UPDATE_STMT);
			pstmt.setString(1, productListingBookVO.getProductListingBook_Name());
			pstmt.setDouble(2, productListingBookVO.getProductListingBook_Price());
			pstmt.setFloat(3, productListingBookVO.getProductListingBook_Discount());
			pstmt.setInt(4, productListingBookVO.getProductListingBook_Quantity());
			pstmt.setDate(5, productListingBookVO.getProductListingBook_Publishedate());
			pstmt.setString(6, productListingBookVO.getProductListingBook_Publisher());
			pstmt.setBlob(7, productListingBookVO.getProductListingBook_Picture());
			pstmt.setString(8, productListingBookVO.getProductListingBook_Authors());
			pstmt.setString(9, productListingBookVO.getProductListingBook_Des());
			pstmt.setInt(10, productListingBookVO.getProductListingBook_ID());

			i = pstmt.executeUpdate(); // 用於SQL的insert、update、delete指令， 回傳型別int
										// executeUpdate()會傳回成功更新的資料列數目
			System.out.println("update count = " + i);

			if (i >= 1)
			{
				System.out.println("更新成功");
			} else
			{
				throw new SQLException("更新記錄數 : 0");
			}

			conn.commit();// 若所有敘述運作良好，則對資料庫做確認(commit)處理=>結束目前的交易，並將執行結果從暫存區寫入資料庫
			conn.setAutoCommit(true); // 開啟自動交易

		} catch (SQLException se)
		{ // Handle any SQL errors
			conn.rollback(); // 若其中有任何敘述發生錯誤，則回復(rollback)交易前的狀態
								// =>結束目前的交易，並將暫存區刪除。
			throw new RuntimeException("A database error occured. " + se.getMessage());

		} finally // Clean up JDBC resources
		{
			if (pstmt != null)
			{
				try
				{
					pstmt.close();
				} catch (SQLException se)
				{
					se.printStackTrace(System.err);
				}
			}
			if (conn != null)
			{
				try
				{
					conn.close();
				} catch (Exception e)
				{
					e.printStackTrace(System.err);
				}
			}
		}
	}

	@Override
	public void delete(Integer ProductListingBook_ID) throws SQLException
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		int i = 0;

		try
		{
			conn = ds.getConnection();
			conn.setAutoCommit(false);// 關閉自動交易，交易在還沒commit或rollback之前，變更的資料是置於一暫存區。

			pstmt = conn.prepareStatement(DELETE_STMT);
			pstmt.setInt(1, ProductListingBook_ID);

			i = pstmt.executeUpdate(); // 用於SQL的insert、update、delete指令， 回傳型別int
										// executeUpdate()會傳回成功更新的資料列數目
			System.out.println("delete count = " + i);

			if (i >= 1)
			{
				System.out.println("刪除成功");
			} else
			{
				throw new SQLException("刪除記錄數 : 0");
			}

			conn.commit();// 若所有敘述運作良好，則對資料庫做確認(commit)處理=>結束目前的交易，並將執行結果從暫存區寫入資料庫
			conn.setAutoCommit(true); // 開啟自動交易

		} catch (SQLException se)
		{ // Handle any SQL errors
			conn.rollback(); // 若其中有任何敘述發生錯誤，則回復(rollback)交易前的狀態
								// =>結束目前的交易，並將暫存區刪除。
			throw new RuntimeException("A database error occured. " + se.getMessage());

		} finally // Clean up JDBC resources
		{
			if (pstmt != null)
			{
				try
				{
					pstmt.close();
				} catch (SQLException se)
				{
					se.printStackTrace(System.err);
				}
			}
			if (conn != null)
			{
				try
				{
					conn.close();
				} catch (Exception e)
				{
					e.printStackTrace(System.err);
				}
			}
		}
	}

	@Override
	public ProductListingBookVO findByPrimaryKey(Integer ProductListingBook_ID) throws SQLException
	{
		ProductListingBookVO productListingBookVO = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try
		{

			conn = ds.getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, ProductListingBook_ID);

			rs = pstmt.executeQuery(); // 用於SQL的select指令，
										// ResultSet是"集合"，回傳型別ResultSet
										// executeQuery()傳回所有符合條件的資料列。

			while (rs.next())
			{ // 取得每筆資料列的每個欄位值的方法，1.type getType(String columnLabel)、2.type
				// getType(int columnIndex)
				// 。=>index從1開始，一般來說用index較有效率。=>index，Java是從0開始，資料庫是從1開始。
				// productListingBookVO 也稱為 Domain objects
				productListingBookVO = new ProductListingBookVO();
				productListingBookVO.setProductListingBook_ID(rs.getInt(1));// 也可以用productListingBookVO.setProductListingBook_ID(rs.getInt("ProductListingBook_Name"));
				productListingBookVO.setProductListingBook_Name(rs.getString(2));
				productListingBookVO.setProductListingBook_Price(rs.getDouble(3));
				productListingBookVO.setProductListingBook_Discount(rs.getFloat(4));
				productListingBookVO.setProductListingBook_Quantity(rs.getInt(5));
				productListingBookVO.setProductListingBook_Publishedate(rs.getDate(6));
				productListingBookVO.setProductListingBook_Publisher(rs.getString(7));
				productListingBookVO.setProductListingBook_Picture(rs.getBlob(8));
				productListingBookVO.setProductListingBook_Authors(rs.getString(9));
				productListingBookVO.setProductListingBook_Des(rs.getString(10));
			}
			conn.commit();
			conn.setAutoCommit(true);

			// Handle any driver errors
		} catch (SQLException se)
		{
			conn.rollback();
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally
		{
			if (rs != null)
			{
				try
				{
					rs.close();
				} catch (SQLException se)
				{
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null)
			{
				try
				{
					pstmt.close();
				} catch (SQLException se)
				{
					se.printStackTrace(System.err);
				}
			}
			if (conn != null)
			{
				try
				{
					conn.close();
				} catch (Exception e)
				{
					e.printStackTrace(System.err);
				}
			}
		}
		return productListingBookVO;
	}

	@Override
	public List<ProductListingBookVO> getAll() throws SQLException
	{
		List<ProductListingBookVO> list = new ArrayList<ProductListingBookVO>();
		ProductListingBookVO productListingBookVO = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try
		{

			conn = ds.getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(GET_ONE_STMT);

			rs = pstmt.executeQuery(); // 用於SQL的select指令，
										// ResultSet是"集合"，回傳型別ResultSet
										// executeQuery()傳回所有符合條件的資料列。

			while (rs.next())
			{ // 取得每筆資料列的每個欄位值的方法，1.type getType(String columnLabel)、2.type
				// getType(int columnIndex)
				// 。=>index從1開始，一般來說用index較有效率。=>index，Java是從0開始，資料庫是從1開始。
				// productListingBookVO 也稱為 Domain objects
				productListingBookVO = new ProductListingBookVO();
				productListingBookVO.setProductListingBook_ID(rs.getInt(1));// 也可以用productListingBookVO.setProductListingBook_ID(rs.getInt("ProductListingBook_Name"));
				productListingBookVO.setProductListingBook_Name(rs.getString(2));
				productListingBookVO.setProductListingBook_Price(rs.getDouble(3));
				productListingBookVO.setProductListingBook_Discount(rs.getFloat(4));
				productListingBookVO.setProductListingBook_Quantity(rs.getInt(5));
				productListingBookVO.setProductListingBook_Publishedate(rs.getDate(6));
				productListingBookVO.setProductListingBook_Publisher(rs.getString(7));
				productListingBookVO.setProductListingBook_Picture(rs.getBlob(8));
				productListingBookVO.setProductListingBook_Authors(rs.getString(9));
				productListingBookVO.setProductListingBook_Des(rs.getString(10));
				list.add(productListingBookVO); // Store the row in the list
			}
			conn.commit();
			conn.setAutoCommit(true);

			// Handle any driver errors
		} catch (SQLException se)
		{
			conn.rollback();
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally
		{
			if (rs != null)
			{
				try
				{
					rs.close();
				} catch (SQLException se)
				{
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null)
			{
				try
				{
					pstmt.close();
				} catch (SQLException se)
				{
					se.printStackTrace(System.err);
				}
			}
			if (conn != null)
			{
				try
				{
					conn.close();
				} catch (Exception e)
				{
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}

	// 從資料庫ProductListingBook表格計算總共有幾本書
	@Override
	public int getRecordCounts() throws SQLException
	{
		// ProductListingBookVO productListingBookVO = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;

		try
		{
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(GET_COUNTS);

			rs = pstmt.executeQuery(); // 用於SQL的select指令，
										// ResultSet是"集合"，回傳型別ResultSet
										// executeQuery()傳回所有符合條件的資料列。
			if (rs.next())
			{ // 取得每筆資料列的每個欄位值的方法，1.type getType(String columnLabel)、2.type
				// getType(int columnIndex)
				// 。=>index從1開始，一般來說用index較有效率。=>index，Java是從0開始，資料庫是從1開始。
				result = rs.getInt(1);

			}
			conn.commit();
			conn.setAutoCommit(true);

			// Handle any driver errors
		} catch (SQLException se)
		{
			conn.rollback();
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally
		{
			if (rs != null)
			{
				try
				{
					rs.close();
				} catch (SQLException se)
				{
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null)
			{
				try
				{
					pstmt.close();
				} catch (SQLException se)
				{
					se.printStackTrace(System.err);
				}
			}
			if (conn != null)
			{
				try
				{
					conn.close();
				} catch (Exception e)
				{
					e.printStackTrace(System.err);
				}
			}
		}
		return result;
	}
}
