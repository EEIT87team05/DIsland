package _08_game.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import _00_init.GlobalService;
import _01_register.model.MembersVO;

public class SecondStepDAO implements SecondStepDAO_interface
{
	private DataSource ds = null;
	
	private static final String getfate2 = "SELECT Members_ID,Members_ID2 FROM SecondStep where Members_ID = ?";
	
	public  SecondStepDAO() throws NamingException
	{
		Context ctx = new InitialContext();
		ds = (DataSource) ctx.lookup(GlobalService.JNDI_DB_NAME);
	}
	
	
	 
	public SecondStepVO checkfateagain(Integer Member_ID) throws SQLException {
		   SecondStepVO se2 = null;
		   Connection conn = null;
		   PreparedStatement pstmt = null;
		   ResultSet rs = null ;
		   Set<Integer> set = new TreeSet<Integer>();
		   conn = ds.getConnection();	
		   pstmt = conn.prepareStatement(getfate2);
		   pstmt.setInt(1, Member_ID);
		   rs = pstmt.executeQuery();
		   if(rs.next()){
			   se2 = new SecondStepVO();
			   se2.setMembers_ID(rs.getInt("Members_ID"));
			   se2.setMembers_ID2(rs.getInt("Members_ID2"));
			  
		  }
		   return se2;
		}
}
