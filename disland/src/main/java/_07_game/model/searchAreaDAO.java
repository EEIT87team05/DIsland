package _07_game.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import _00_init.GlobalService;

public class searchAreaDAO
{
	private static final long serialVersionUID = 1L;
	private DataSource ds = null;
	
	public searchAreaDAO() throws NamingException
	{
		Context ctx = new InitialContext();
		ds = (DataSource) ctx.lookup(GlobalService.JNDI_DB_NAME);
	}
	
	public searchArea getSearchAreaResult(String county)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		searchArea sa = null;
		List<searchArea> list = new ArrayList<searchArea>();
		
		try
		{
			String sql = "SELECT * FROM Members WHERE Members_City = ?";
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, county);
			rs = pstmt.executeQuery();
			
			while (rs.next())
			{
				sa = new searchArea();
				sa.setMembers_ID(rs.getInt("Members_ID"));
				sa.setMembers_Name(rs.getString("Members_Name"));
				sa.setMembers_Area(rs.getString("Members_Area"));
				sa.setMembers_City(rs.getString("Members_City"));
				sa.setMembers_Gender(rs.getString("Members_Gender"));
				sa.setMembers_Account(rs.getString("Members_Account"));
				sa.setMembers_Job(rs.getString("Members_Job"));
				list.add(sa);
			}
			sa.setResult(list);
			
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return sa;
	}
	
}
