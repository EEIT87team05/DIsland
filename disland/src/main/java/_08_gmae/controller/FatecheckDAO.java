package _08_gmae.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.metamodel.relational.Size;

import _00_init.GlobalService;
import _01_register.model.LoginServiceDB;
import _01_register.model.MembersVO;
import _08_game.model.SecondStepDAO;
import _08_game.model.SecondStepVO;

public class FatecheckDAO {
    private int lowerBound;
    private int upperBound;
    private int ballNumber;  //自己有多少人有緣點，所以應該要是ballNuber.size()
    
    
    private DataSource ds = null;
    private static final String select1 = "SELECT Members_ID,Members_ID2 FROM SecondStep where Members_ID = ?";
    private static final String select2 = "select * from (SELECT ROW_NUMBER() OVER (ORDER BY Members_ID DESC) AS RowNum, Members_ID,Members_ID2 from SecondStep where Members_ID =?) as tmp where tmp.RowNum between 1 and 2";
	
    
	public FatecheckDAO() throws NamingException {
		Context ctx = new InitialContext();
		ds = (DataSource) ctx.lookup(GlobalService.JNDI_DB_NAME);
	}
	
	
	public void setLowerBound(int lowerBound) {
		this.lowerBound = lowerBound;
	}
	public void setUpperBound(int upperBound) {
		this.upperBound = upperBound;
	}
	public void setBallNumber(int ballNumber) {
		this.ballNumber = ballNumber;
	}
    
	public Collection<SecondStepVO> getFateNumbers(Integer Member_ID) throws SQLException
	{
		Collection<SecondStepVO> coll = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		conn = ds.getConnection();
		pstmt = conn.prepareStatement(select2);
		pstmt.setInt(1, Member_ID);
		rs = pstmt.executeQuery();
		coll  = new Vector<>();
		while (rs.next()){
			SecondStepVO vovo1 = new SecondStepVO();
			vovo1.setMembers_ID(rs.getInt("Members_ID"));
			vovo1.setMembers_ID(rs.getInt("Members_ID2"));
			coll.add(vovo1);
		}
		return coll;
	}
	
	
	public Collection<Integer> getdfdgfdsr() throws NamingException {
	    Set<Integer> set = new TreeSet<Integer>();
	    SecondStepDAO getmemid = new SecondStepDAO();
	    
	    while (set.size() < ballNumber ) {
	    	int num = (int)(Math.random()* (upperBound-lowerBound+1) + lowerBound);
	    	
	    	set.add(num);
	    }
		return set;
	}
	public Collection<Integer> getFourStars() throws NamingException, SQLException {
	    List<Integer> list = new ArrayList<Integer>();
	    /*LoginServiceDB ldDb = new LoginServiceDB();
	    int max1 = ldDb.getMemberList().size();*/
	    while (list.size() < ballNumber ) {
	    	int num = (int)(Math.random()* (upperBound-lowerBound+1) + lowerBound);
	    	list.add(num);
	    }
		return list;
	}
}
