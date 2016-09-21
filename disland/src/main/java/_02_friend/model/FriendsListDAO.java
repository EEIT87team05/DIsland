package _02_friend.model;


import java.io.*;
import java.sql.*;
import java.util.*;
import javax.naming.*;
import javax.sql.*;


import _00_init.GlobalService;

public class FriendsListDAO implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	private int member = 0;
	private DataSource ds = null;
	
	public FriendsListDAO() throws NamingException
	{
		Context ctx = new InitialContext();
		ds = (DataSource) ctx.lookup(GlobalService.JNDI_DB_NAME);
	}
	
	public Collection<FriendsListVO> getAllFriend() throws SQLException
	{
		System.out.println("allfriend");
		String sqlfriend = " SELECT f.Members_ID, f.Mem_Members_ID2,m.Members_Name FROM dbo.Members m JOIN dbo.FriendsList f  ON f.Mem_Members_ID2 = m.Members_ID ";
		Collection<FriendsListVO> coll = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		FriendsListVO flv = null;
		
		try
		{
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sqlfriend);
			rs = pstmt.executeQuery();
			
			while (rs.next())
			{
				flv = new FriendsListVO();
				flv.setMembers_ID(rs.getInt(1));
				flv.setMem_Members_ID2(rs.getInt(2));
				flv.setName(rs.getString(3));
				coll.add(flv);
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

	public void insertFriendsList(int addId,int addedId) throws SQLException
	{
		String insert_stmt = "insert into FriendsList (Members_ID,Mem_Members_ID2) values (?,?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try
		{
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(insert_stmt);
			pstmt.setInt(1, addId);
			pstmt.setInt(2, addedId);
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement(insert_stmt);
			pstmt.setInt(1, addedId);
			pstmt.setInt(2, addId);
			pstmt.executeUpdate();
			
			conn.commit();
			conn.setAutoCommit(true);
			
		} catch (SQLException e)
		{
			conn.rollback();
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
	
	public int getMember()
	{
		return member;
	}
	public void setMember(int member)
	{
		this.member = member;
	}
}
