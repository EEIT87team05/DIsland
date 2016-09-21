package _02_friend.model;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.Collection;

public interface FriendsListDAO_interface
{
	
	//public void update(FriendsListVO friendsListVO);
	public void delete(Integer Members_ID);
	public FriendsListVO findByPrimaryKey(Integer FriendsList_ID);
	public Collection<FriendsListVO> getAllFriends(Integer Members_ID);
	void insert(FriendsListVO friendsListVO, InputStream is, long size, String filename) throws SQLException;
	void update(FriendsListVO friendsListVO, InputStream is, long size, String filename);
}
