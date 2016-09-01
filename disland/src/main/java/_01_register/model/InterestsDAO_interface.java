package _01_register.model;

import java.sql.SQLException;

public interface InterestsDAO_interface
{
	public void insert(InterestsVO interestsVO) throws SQLException;
	public void update(InterestsVO interestsVO) throws SQLException;
	public void delete(Integer interests_ID) throws SQLException;
	public InterestsVO findByPrimaryKey(Integer interests_ID) throws SQLException;

}
