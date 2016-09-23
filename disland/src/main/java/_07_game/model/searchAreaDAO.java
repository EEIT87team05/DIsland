package _07_game.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import _00_init.GlobalService;
import _02_friend.model.FriendsListDAO;

public class searchAreaDAO
{
	private static final long serialVersionUID = 1L;
	private DataSource ds = null;

	public searchAreaDAO() throws NamingException
	{
		Context ctx = new InitialContext();
		ds = (DataSource) ctx.lookup(GlobalService.JNDI_DB_NAME);
	}

	public searchArea getSearchAreaResult(String county, String district, String gen, int memberId)
			throws NamingException, SQLException
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		Set<Integer> friendsIdSet = new HashSet<Integer>();
		Set<searchArea> matchAndFriends = new HashSet<searchArea>();  //符合條件且是好友
		Set<searchArea> match = new HashSet<searchArea>();  //符合條件
		searchArea sa = null;
		String sql = "SELECT * FROM Members WHERE Members_City = ? AND Members_Area = ? AND Members_Gender = ?";
		String sql2 = "SELECT * FROM FriendsList WHERE Members_ID = ?";
		Integer[] friendsId = null;

		try
		{
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			pstmt.setString(1, county);
			pstmt.setString(2, district);
			pstmt.setString(3, gen);
			rs = pstmt.executeQuery(); // 符合搜尋條件的人選

			pstmt2 = conn.prepareStatement(sql2);
			pstmt2.setInt(1, memberId);
			rs2 = pstmt2.executeQuery(); // 好友的名單

			//找出所有的好友的id,然後存在集合裡
			while (rs2.next())
			{
				int x = rs2.getInt(3); // 好友的ID
				friendsIdSet.add(x);
			}
			
			//找出所有好友的id然後轉成陣列
			friendsId = friendsIdSet.toArray(new Integer[friendsIdSet.size()]);

			//符合條件且是好友的人,存放在matchAndFriends集合中
			for (int i = 0; i < friendsId.length; i++)
			{
				while (rs.next())
				{
					//好友的id 跟  符合條件的人的id 一樣時
					if (friendsId[i] == rs.getInt("Members_ID"))
					{
						sa = new searchArea();
						sa.setMembers_ID(rs.getInt("Members_ID")); // 符合地區搜尋的人選
						sa.setMembers_Name(rs.getString("Members_Name"));
						sa.setMembers_Area(rs.getString("Members_Area"));
						sa.setMembers_City(rs.getString("Members_City"));
						sa.setMembers_Gender(rs.getString("Members_Gender"));
						sa.setMembers_Account(rs.getString("Members_Account"));
						sa.setMembers_Job(rs.getString("Members_Job"));
						sa.setMembers_MainPicture(rs.getBlob("Members_MainPicture"));

						matchAndFriends.add(sa);
					}
				}

				rs.beforeFirst();  //把指標放回第一個的前一個
			}

			//所有符合條件的人,存放在集合 match中
			while (rs.next())
			{
				sa = new searchArea();
				sa.setMembers_ID(rs.getInt("Members_ID")); // 符合地區搜尋的人選
				sa.setMembers_Name(rs.getString("Members_Name"));
				sa.setMembers_Area(rs.getString("Members_Area"));
				sa.setMembers_City(rs.getString("Members_City"));
				sa.setMembers_Gender(rs.getString("Members_Gender"));
				sa.setMembers_Account(rs.getString("Members_Account"));
				sa.setMembers_Job(rs.getString("Members_Job"));
				sa.setMembers_MainPicture(rs.getBlob("Members_MainPicture"));

				match.add(sa);
			}
			
			//利用差集
			Set xx = DIFF(matchAndFriends, match);

			sa.setResultset(xx);

		} catch (SQLException e)
		{
			e.printStackTrace();
		}finally
		{
			if (rs2 != null)
			{
				rs2.close();
			}
			if (pstmt2 != null)
			{
				pstmt2.close();
			}
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
		return sa;
	}

	public Set DIFF(Set sa, Set sb)
	{
		Set s1 = UNION(sa, sb);
		Set s2 = INTERSECT(sa, sb);
		s1.removeAll(s2);
		return s1;
	}

	public Set COMPLEMENT(Set sa, Set sb)
	{
		return DIFF(sa, sb);
	}

	public Set UNION(Set sa, Set sb)
	{
		Set s = new HashSet();
		if (sa.size() > sb.size())
		{
			s.addAll(sa);
			s.addAll(sb);
		} else
		{
			s.addAll(sb);
			s.addAll(sa);
		}
		return s;
	}
	
	 public Set INTERSECT(Set sa, Set sb)  
	    {  
	        Set s =  new HashSet();         
	        if(sa.size()>sb.size())  
	        {  
	            s.addAll(sa);  
	            s.retainAll(sb);  
	        }  
	        else  
	        {  
	            s.addAll(sb);  
	            s.retainAll(sa);  
	        }  
	        return s;  
	    }  
}
