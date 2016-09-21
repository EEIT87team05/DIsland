package _07_game.controller;

import java.io.IOException;
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
		
		if (gen.matches("boy"))
		{
			gen = "男生";
		}else 
		{
			gen = "女生";
		}
				
		try
		{
			searchAreaDAO sad = new searchAreaDAO();
			searchArea sa = sad.getSearchAreaResult(county);
			
			/* 
			 * sa裡面有List<searchAera> result = new ArrayList<searchAera>()
			 * 所以把它存到request的Attribute中
			 * 在jsp上用EL的方式+forEach取出(Result.jsp)
			 * 所以在searchArea中一定要有一個List把它存起來
			 * 在DAO裡面也一定要set進去
			 */
			
			request.setAttribute("Result", sa);
			request.setAttribute("County", county);
			request.setAttribute("District", district);
			request.setAttribute("Gen", gen);
			
			RequestDispatcher rd = request.getRequestDispatcher("Result.jsp");
			rd.forward(request, response);
			return;
			
			
		} catch (NamingException e)
		{
			e.printStackTrace();
		}
		
	}

}
