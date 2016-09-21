package _02_friend.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.json.simple.JSONValue;

import _00_init.GlobalService;

public class FriendsInvitesDAO implements FriendsInvitesDAO_interface
{
	private DataSource ds = null;
	private static final String add_friend_stmt = "insert into FriendsInvites (Members_ID,Members_ID2) values (?,?)";
	private static final String get_friend_invites = "SELECT f.Members_ID2,m.Members_ID,m.Members_Name "
			+ "FROM Members m JOIN FriendsInvites f "
			+ "ON f.Members_ID = m.Members_ID "
			+ "WHERE f.Members_ID2 = ?";
	
	public FriendsInvitesDAO() throws NamingException
	{
		Context ctx = new InitialContext();
		ds = (DataSource) ctx.lookup(GlobalService.JNDI_DB_NAME);
	}
	
	
	public void insertFriendsInvites(FriendsInvitesVO fiv) throws SQLException
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try
		{
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(add_friend_stmt);
			pstmt.setInt(1, fiv.getMembers_ID());
			pstmt.setInt(2, fiv.getMembers_ID2());
			pstmt.executeUpdate();
			
		} catch (SQLException e)
		{
			e.printStackTrace();
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

	
	public void deleteFriendsInvites(int addId,int addedId) throws SQLException
	{
		String delete_stmt = "delete from FriendsInvites where Members_ID = ? AND Members_ID2 = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try
		{
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(delete_stmt);
			pstmt.setInt(1, addId);
			pstmt.setInt(2, addedId);
			pstmt.executeUpdate();	
		} catch (SQLException e)
		{
			e.printStackTrace();
		}finally 
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

	public String getFriendsInvites(int memberId)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List invite = new LinkedList();
		String jsonString = null;
		
		try
		{
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(get_friend_invites);
			pstmt.setInt(1, memberId);
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				Map m1 = new HashMap();
				m1.put("addedId", rs.getString(1));
				m1.put("addId", rs.getString(2));
				m1.put("addName", rs.getString(3));
				invite.add(m1);
			}
			
				jsonString = JSONValue.toJSONString(invite);
			
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonString;
	}
}
