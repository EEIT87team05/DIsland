package _02_friend.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import _02_friend.model.FriendsInvitesDAO;
import _02_friend.model.FriendsInvitesService;
import _02_friend.model.FriendsInvitesVO;

@WebServlet(urlPatterns = {"/_07_game/AddFriendInvites.do","/_02_friend/AddFriendInvites.do"})
public class AddFriendInvitesServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		
		/*******接收資料*******/
		String addStr = request.getParameter("add"); //加的
		String addedStr = request.getParameter("added");  //被加的
		
		/*******進行必要的型態轉換*******/
		int add = Integer.valueOf(addStr);
		int added = Integer.valueOf(addedStr);
		
		try
		{
			FriendsInvitesVO fiv = new FriendsInvitesVO(add,added);
			FriendsInvitesService fi = new FriendsInvitesService();
			fi.insertFriendsInvites(fiv);
			RequestDispatcher rd = request.getRequestDispatcher("Result.jsp");
			rd.forward(request, response);
			return;	
		} catch (NamingException e)
		{
			e.printStackTrace();
		} catch (SQLException e)
		{
			e.printStackTrace();
		} 
		
		
		
	}

}
