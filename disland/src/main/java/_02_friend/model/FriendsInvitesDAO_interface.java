package _02_friend.model;

import java.sql.SQLException;

public interface FriendsInvitesDAO_interface
{
	public String getFriendsInvites(int memberId);
	public void deleteFriendsInvites(int addId,int addedId) throws SQLException;
	public void insertFriendsInvites(FriendsInvitesVO fiv) throws SQLException;
}
