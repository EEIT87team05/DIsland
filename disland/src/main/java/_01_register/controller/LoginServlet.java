package _01_register.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import _01_register.model.LoginServiceDB;
import _01_register.model.MembersVO;
import _02_friend.model.FriendsListDAO;
import _02_friend.model.FriendsListVO;


@WebServlet("/_01_register/login.do")
public class LoginServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		Map<String, String> errorMsgMap = new HashMap<String, String>();
		
		request.setAttribute("ErrorMsgKey", errorMsgMap);
		
		String userId = request.getParameter("userId");
		String password = request.getParameter("pswd");
		String rm = request.getParameter("rememberMe");
		String requestURI = (String) session.getAttribute("requestURI");
		
		if (userId == null || userId.trim().length() == 0)
		{
			errorMsgMap.put("AccountEmptyError", "帳號欄必須輸入");
		}
		
		if (password == null || password.trim().length() == 0)
		{
			errorMsgMap.put("PasswordEmptyError", "密碼欄必須輸入");
		}
		
		if (!errorMsgMap.isEmpty())
		{
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
			return;
		}
		
		LoginServiceDB lsdb;
		FriendsListDAO fd;
		try
		{
			lsdb = new LoginServiceDB();
			fd = new FriendsListDAO();
			
			MembersVO mv = lsdb.checkIDPassword(userId, password);
			
			if (mv != null)
			{
				session.setAttribute("LoginOK", mv);
			} else
			{
				
				errorMsgMap.put("LoginError", "該帳號不存在或密碼錯誤");
			}
			
		} catch (NamingException e)
		{
			errorMsgMap.put("LoginError", "LoginServlet->NamingException:" + e.getMessage());
		} catch (SQLException e)
		{
			errorMsgMap.put("LoginError", "LoginServlet->SQLException:" + e.getMessage());
			e.printStackTrace();
		}
		
		if (errorMsgMap.isEmpty())
		{
			// 此時不要用下面兩個敘述，因為網址列的URL不會改變
			// RequestDispatcher rd = request.getRequestDispatcher("...");
			// rd.forward(request, response);
			if (requestURI != null)
			{
				requestURI = (requestURI.length() == 0 ? request.getContextPath() : requestURI);
				response.sendRedirect(response.encodeRedirectURL(requestURI));
				return;
			} else
			{
				response.sendRedirect(response.encodeRedirectURL(request.getContextPath()));
				System.out.println(request.getContextPath());
				return;
			}
		} else
		{
			// 如果errorMsgMap不是空的，表示有錯誤，交棒給login.jsp
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
			return;
		}
	}
}
