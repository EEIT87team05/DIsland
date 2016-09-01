package _01_register.model;

import java.sql.*;
import javax.naming.*;
import javax.sql.*;

import _00_init.GlobalService;

public class InterestsDAO implements InterestsDAO_interface
{
	private DataSource ds = null;
	private static final String insert_stmt = "insert into Interests (Interests_Name) values (?)";
	private static final String update_stmt = "Update Interests set Interests_Name = ? where Interests_ID = ?";
	private static final String delete_stmt = "Delete from Interests where Interests_ID = ?";
	private static final String get_one_stmt = "Select Interests_Name from Interests where Interests_ID = ?";

	public InterestsDAO() throws NamingException
	{
		Context ctx = new InitialContext();
		ds = (DataSource) ctx.lookup(GlobalService.JNDI_DB_NAME);
	}

	@Override
	public void insert(InterestsVO interestsVO) throws SQLException
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		int i = 0;

		try
		{
			conn = ds.getConnection();
			conn.setAutoCommit(false); // 關閉自動交易

			pstmt = conn.prepareStatement(insert_stmt);
			pstmt.setString(1, interestsVO.getInterests_Name());

			i = pstmt.executeUpdate();

			if (i == 1)
			{
				System.out.println("成功");
			} else
			{
				throw new SQLException("新增記錄數 : 0");
			}

			conn.commit();
			conn.setAutoCommit(true);

		} catch (SQLException e)
		{
			e.printStackTrace();
			conn.rollback();
		} finally
		{
			if (pstmt != null)
			{
				pstmt.close();
			}
			if (conn != null)
			{
				conn.close();
			}
		}

	}

	@Override
	public void update(InterestsVO interestsVO) throws SQLException
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		int i = 0;

		try
		{
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(update_stmt);

			pstmt.setString(1, interestsVO.getInterests_Name());
			pstmt.setInt(2, interestsVO.getInterests_ID());

			i = pstmt.executeUpdate();
			System.out.println("update success count = " + i);

			conn.commit();
			conn.setAutoCommit(true);

		} catch (SQLException e)
		{
			conn.rollback();
			throw new RuntimeException("A database error occured. " + e.getMessage());
		} finally
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
				} catch (SQLException se)
				{
					se.printStackTrace(System.err);
				}
			}
		}
	}

	@Override
	public void delete(Integer interests_ID) throws SQLException
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		int i = 0;

		try
		{
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(delete_stmt);

			pstmt.setInt(1, interests_ID);

			i = pstmt.executeUpdate();
			System.out.println("delete success count = " + i);

			conn.commit();
			conn.setAutoCommit(true);

		} catch (SQLException e)
		{
			conn.rollback();
			throw new RuntimeException("A database error occured. " + e.getMessage());
		} finally
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
				} catch (SQLException se)
				{
					se.printStackTrace(System.err);
				}
			}
		}
	}

	@Override
	public InterestsVO findByPrimaryKey(Integer interests_ID) throws SQLException
	{
		InterestsVO interestsVO = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try
		{
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(get_one_stmt);

			pstmt.setInt(1, interests_ID);

			rs = pstmt.executeQuery();

			while (rs.next())
			{
				interestsVO = new InterestsVO();
				interestsVO.setInterests_ID(rs.getInt("Interests_ID"));
				interestsVO.setInterests_Name(rs.getString("Interests_name"));
			}

			conn.commit();
			conn.setAutoCommit(true);

		} catch (SQLException e)
		{
			conn.rollback();
			throw new RuntimeException("A database error occured. " + e.getMessage());
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
		
		return interestsVO;
	}
	
}
