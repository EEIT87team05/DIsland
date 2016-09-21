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
import _02_friend.model.FriendsListDAO;

@WebServlet("/CheckInvitesServlet.do")
public class CheckInvitesServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public CheckInvitesServlet()
	{
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String addedIdStr = request.getParameter("addedId");
		System.out.println("addedIdStr = " + addedIdStr);
		int addedId = Integer.parseInt(addedIdStr);
		System.out.println("addedId = " + addedId);
		String addIdStr = request.getParameter("addId");
		System.out.println("addIdStr = " + addIdStr);
		int addId = Integer.parseInt(addIdStr);
		System.out.println("addId = " + addId);
		String type = request.getParameter("type");
		
		if (type.equals("add"))
		{
			try
			{
				FriendsListDAO fldao = new FriendsListDAO();
				fldao.insertFriendsList(addId, addedId);
				FriendsInvitesDAO fidao = new FriendsInvitesDAO();
				fidao.deleteFriendsInvites(addId,addedId);
				RequestDispatcher rd = request.getRequestDispatcher("/_02_friend/test.jsp");
				rd.forward(request, response);
				return;
				
			} catch (NamingException e)
			{
				e.printStackTrace();
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		}else 
		{
			try
			{
				FriendsInvitesDAO fidao = new FriendsInvitesDAO();
				fidao.deleteFriendsInvites(addId, addedId);
				RequestDispatcher rd = request.getRequestDispatcher("/_02_friend/test.jsp");
				rd.forward(request, response);
				return;
				
			} catch (SQLException e)
			{
				e.printStackTrace();
			} catch (NamingException e)
			{
				e.printStackTrace();
			}
			
		}
	}

}
