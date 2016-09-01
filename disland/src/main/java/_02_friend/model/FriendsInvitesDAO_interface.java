package _02_friend.model;

import java.sql.SQLException;

public interface FriendsInvitesDAO_interface
{
	public void insert(FriendsInvitesVO friendsInvitesVO) throws SQLException;
	public void delete(Integer friendsInvites_ID) throws SQLException;
}
