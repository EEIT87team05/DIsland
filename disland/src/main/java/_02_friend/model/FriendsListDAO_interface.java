package _02_friend.model;

import java.util.Collection;

public interface FriendsListDAO_interface
{
	public void insert(FriendsListVO friendsListVO);
	public void update(FriendsListVO friendsListVO);
	public void delete(Integer Members_ID);
	public FriendsListVO findByPrimaryKey(Integer Members_ID);
	public Collection<FriendsListVO> getAllFriends(Integer Members_ID);
}
