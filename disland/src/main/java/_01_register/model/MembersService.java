package _01_register.model;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.Collection;

import javax.naming.NamingException;

public class MembersService
{
	private MembersDAO_interface dao;
	
	public MembersService() throws NamingException
	{
		dao = new MembersDAO();
	}
	
	public void insertMember(MembersVO memberVO, InputStream is, long size, String filename) throws SQLException
	{
		dao.insert(memberVO, is, size, filename);
	}
	
	public void updateMember(MembersVO memberVO, InputStream is, long size, String filename) throws SQLException
	{
		dao.update(memberVO, is, size, filename);
	}
	
	public void deleteMember(Integer members_ID) throws SQLException
	{
		dao.delete(members_ID);
	}
	
	public MembersVO getOneMember(Integer members_ID) throws SQLException
	{
		return dao.findByPrimaryKey(members_ID);
	}
	
	public Collection<MembersVO> getAllMember()
	{
		return dao.getAllMembers();
	}
}
