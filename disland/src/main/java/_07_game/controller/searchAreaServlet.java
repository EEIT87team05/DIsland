package _07_game.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import _02_friend.model.FriendsListDAO;
import _07_game.model.searchArea;
import _07_game.model.searchAreaDAO;

@WebServlet("/_07_game/Search.do")
public class searchAreaServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		String county = request.getParameter("county");
		String district = request.getParameter("district");
		String gen = request.getParameter("gen");
		String memberIdStr = request.getParameter("memberId");
		int memberId = Integer.parseInt(memberIdStr);
		
		if (gen.matches("boy"))
		{
			gen = "男生";
		}
		else {
			gen = "女生";
		}
		
		try
		{
			searchAreaDAO sadao = new searchAreaDAO();
			searchArea sa = sadao.getSearchAreaResult(county, district, gen, memberId);
			
			request.setAttribute("Result", sa);

			RequestDispatcher rd = request.getRequestDispatcher("Result.jsp");
			rd.forward(request, response);
			return;
			
		} catch (NamingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
