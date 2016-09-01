package _02_friend.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import _00_init.GlobalService;

public class FriendsInvitesDAO implements FriendsInvitesDAO_interface
{
	private DataSource ds = null;
	private static final String insert_stmt = "insert into FriendsInvites (Members_ID) values (?)";
	private static final String delete_stmt = "delete from FriendsInvites where Members_ID = ?";

	public FriendsInvitesDAO() throws NamingException
	{
		Context ctx = new InitialContext();
		ds = (DataSource)ctx.lookup(GlobalService.JNDI_DB_NAME);
	}
	
	@Override
	public void insert(FriendsInvitesVO friendsInvitesVO) throws SQLException
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		int i = 0;
		
		try
		{
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(insert_stmt);
			pstmt.setInt(1, friendsInvitesVO.getFriendsInvites_ID());
			
			i = pstmt.executeUpdate();
			System.out.println("新增資料筆數 = " + i);
			
			conn.commit();
			conn.setAutoCommit(true);
		} catch (SQLException e)
		{
			conn.rollback();
			throw new RuntimeException("A database error occured. " + e.getMessage());
		}finally
		{
			if (pstmt != null)
			{
				try
				{
					pstmt.close();
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			
			if (conn != null)
			{
				try
				{
					conn.close();
				} catch (Exception e)
				{
					System.err.println("關閉相關物件時發生例外: " + e);
				}
			}
		}
		
	}

	@Override
	public void delete(Integer friendsInvites_ID) throws SQLException
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		int i = 0;
		
		try
		{
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(delete_stmt);		
			pstmt.setInt(1, friendsInvites_ID);
			
			i = pstmt.executeUpdate();
			System.out.println("刪除資料筆數 = " + i);
			
			conn.commit();
			conn.setAutoCommit(true);
			
		} catch (SQLException e)
		{
			conn.rollback();
			throw new RuntimeException("A database error occured. " + e.getMessage());	
		}finally
		{
			if (pstmt != null)
			{
				try
				{
					pstmt.close();
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			
			if (conn != null)
			{
				try
				{
					conn.close();
				} catch (Exception e)
				{
					System.err.println("關閉相關物件時發生例外: " + e);
				}
			}
		}
		
	}

}
