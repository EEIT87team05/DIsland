package _01_register.model;

import java.sql.SQLException;

import javax.naming.NamingException;

public class InterestsService
{
	private InterestsDAO_interface dao;
	
	public InterestsService() throws NamingException
	{
		dao = new InterestsDAO();
	}
	
	public void insertInterest(InterestsVO interestsVO) throws SQLException
	{
		dao.insert(interestsVO);
	}
	
	public void updateInterest(InterestsVO interestsVO) throws SQLException
	{
		dao.update(interestsVO);
	}
	
	public void deleteInterest(Integer interests_ID) throws SQLException
	{
		dao.delete(interests_ID);
	}
	
	public InterestsVO getOneInterest(Integer interests_ID) throws SQLException
	{
		return dao.findByPrimaryKey(interests_ID);
	}

}
