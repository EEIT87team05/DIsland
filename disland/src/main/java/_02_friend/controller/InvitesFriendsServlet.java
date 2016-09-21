package _02_friend.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import _02_friend.model.FriendsInvitesDAO;

@WebServlet("/_02_friend/InvitesFriendsServlet")
public class InvitesFriendsServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		String memberIdStr = request.getParameter("memberId");  //登入的人的id
		int memberId = Integer.parseInt(memberIdStr);
		String result = null;
		
		FriendsInvitesDAO fidao;
		try
		{
			fidao = new FriendsInvitesDAO();
			result = fidao.getFriendsInvites(memberId);
			
		} catch (NamingException e)
		{
			e.printStackTrace();
		}
		
		out.println(result);
			
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
