package _02_friend.model;

import java.sql.SQLException;

import javax.naming.NamingException;

public class FriendsInvitesService
{
	private FriendsInvitesDAO_interface dao;
	
	public FriendsInvitesService() throws NamingException
	{
		dao = new FriendsInvitesDAO();
	}
	
	public void insertFriendsInvites(FriendsInvitesVO friendsInvitesVO) throws SQLException
	{
		dao.insert(friendsInvitesVO);
	}
	
	public void deleteFriendsInvites(Integer friendsInvites_ID) throws SQLException
	{
		dao.delete(friendsInvites_ID);
	}
}
