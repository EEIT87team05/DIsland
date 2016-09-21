package _01_register.model;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public interface MembersDAO_interface
{
	public void delete(Integer members_ID);
	public MembersVO findByPrimaryKey(Integer members_ID);
	public Collection<MembersVO> getAllMembers();
	void insert(MembersVO memberVO, InputStream is, long size, String filename) throws SQLException;
	void update(MembersVO memberVO, InputStream is, long size, String filename);
	public List<MembersVO> getAllMembersLeo();
}
