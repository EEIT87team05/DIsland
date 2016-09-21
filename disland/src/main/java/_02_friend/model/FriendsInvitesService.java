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
		dao.insertFriendsInvites(friendsInvitesVO);
	}
	
	public void deleteFriendsInvites(int addId,int addedId) throws SQLException
	{
		dao.deleteFriendsInvites(addId, addedId);
	}
}
