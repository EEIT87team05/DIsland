package _04_product.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import _00_init.GlobalService;

//service負責商業邏輯與資料庫無關的操作
//本service負責讀取資料庫內ProductListingBook表格內某一頁的紀錄，並能新增紀錄、修改紀錄、刪除記錄等
//當pageNo=1時，讀取 1, 2, 3筆記錄
//當pageNo=2時，讀取 4, 5, 6筆記錄
//當pageNo=3時，讀取 7, 8, 9筆記錄
public class ProductListingBookService implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	/*
	 * private ProductListingBookDAO_interface dao; public
	 * ProductListingBookService() throws NamingException { dao = new
	 * ProductListingBookDAO(); }
	 */
	private ProductListingBookDAO dao = new ProductListingBookDAO(); // 是不是不需要寫上面幾行?

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
	// private int bookId = 0; // 查詢單筆商品會用到此代號
	private int pageNo = 0;
	private int recordsPerPage = GlobalService.RECORDS_PER_PAGE; // 每頁顯示三筆
	private int totalPages = -1;

	// 一頁三筆資料，計算總共有幾頁
	public int getTotalPages() throws SQLException
	{
		if (totalPages == -1)
		{
			totalPages = (int) (Math.ceil(dao.getRecordCounts() / (double) recordsPerPage));
		}
		return totalPages;
	}

	// 取得某一分頁的三筆資料
	public Collection<ProductListingBookVO> getPageBooks() throws SQLException
	{
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		Collection<ProductListingBookVO> coll = new ArrayList<ProductListingBookVO>(); // coll裡面有三筆資料
		try
		{
			// 分頁(Paging)寫法，假設取第11筆~第20筆資料，使用row_number()函數
			// select * from (select row_number() over (order by id) as
			// RowNum,id,firstName,lastName from dbo.USERS) as NewTable where
			// RowNum >=11 and RowNum<=20
			String queryPageString = "SELECT  * FROM (SELECT  ROW_NUMBER() OVER (ORDER BY ProductListingBook_ID)"
					+ " AS RowNum, ProductListingBook_ID, ProductListingBook_Name, ProductListingBook_Price, ProductListingBook_Discount, ProductListingBook_Quantity, ProductListingBook_Publishedate, ProductListingBook_Publisher, ProductListingBook_Picture, ProductListingBook_Authors, ProductListingBook_Des FROM ProductListingBook)"
					+ " AS NewTable WHERE RowNum >= ? AND RowNum <= ?";
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(queryPageString);
			int startRecordNo = (pageNo - 1) * recordsPerPage + 1;
			int endRecordNo = (pageNo) * recordsPerPage;
			// PreparedStatement物件內所有的問號都要有值，否則執行pStmt.executeQuery()
			// 或pStmt.executeUpdate()時程式一定會掛掉。
			pstmt.setInt(1, startRecordNo);
			pstmt.setInt(2, endRecordNo);
			rs = pstmt.executeQuery();
			// 如果ResultSet內含有未讀取的紀錄
			while (rs.next())
			{
				// 建立一個新的ProductListingBookVO物件
				ProductListingBookVO ProductListingBookVO = new ProductListingBookVO();
				// 將此紀錄內的資料放入ProductListingBookVO物件
				ProductListingBookVO.setProductListingBook_ID(rs.getInt(2));
				ProductListingBookVO.setProductListingBook_Name(rs.getString(3));
				ProductListingBookVO.setProductListingBook_Price(rs.getDouble(4));
				ProductListingBookVO.setProductListingBook_Discount(rs.getFloat(5));
				ProductListingBookVO.setProductListingBook_Quantity(rs.getInt(6));
				ProductListingBookVO.setProductListingBook_Publishedate(rs.getDate(7));
				ProductListingBookVO.setProductListingBook_Publisher(rs.getString(8));
				ProductListingBookVO.setProductListingBook_Picture(rs.getBlob(9));
				ProductListingBookVO.setProductListingBook_Authors(rs.getString(10));
				ProductListingBookVO.setProductListingBook_Des(rs.getString(11));
				// 最後將ProductListingBookVO物件放入大的容器內
				coll.add(ProductListingBookVO);
			}
			conn.commit();
			conn.setAutoCommit(true);
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
		return coll;
	}

	public int getPageNo()
	{
		return pageNo;
	}

	public void setPageNo(int pageNo)
	{
		this.pageNo = pageNo;
	}

	public int getRecordsPerPage()
	{
		return recordsPerPage;
	}

	public void setRecordsPerPage(int recordsPerPage)
	{
		this.recordsPerPage = recordsPerPage;
	}

	public void insertProductListingBook(ProductListingBookVO productListingBookVO) throws SQLException
	{
		dao.insert(productListingBookVO);
	}

	public void updateProductListingBook(ProductListingBookVO productListingBookVO) throws SQLException
	{
		dao.update(productListingBookVO);
	}

	public void deleteProductListingBook(Integer ProductListingBook_ID) throws SQLException
	{
		dao.delete(ProductListingBook_ID);
	}

	public ProductListingBookVO getOneProductListingBook(Integer ProductListingBook_ID) throws SQLException
	{
		return dao.findByPrimaryKey(ProductListingBook_ID);
	}

	public List<ProductListingBookVO> getAll() throws SQLException
	{
		return dao.getAll();
	}

}
