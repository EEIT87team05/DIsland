package _05_shoppingCart.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import _05_shoppingCart.model.ShoppingCart;

/**
 * Servlet implementation class CheckoutServlet
 */
@WebServlet("/_05_shoppingCart/checkout.do")
public class CheckoutServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//找session,找不到不要建新的(整合時開啟false)=======================
		HttpSession session = request.getSession(false);
//		HttpSession session = request.getSession();
		//===========================================================
		
		//使用逾時
		if (session == null)
		{
			request.setAttribute("Errors", "使用逾時,請重新登入");
			//路徑再改**********************************************************
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			//*****************************************************************
			rd.forward(request, response);
			return;
		}
		
		ShoppingCart sc = (ShoppingCart) session.getAttribute("ShoppingCart");
		
		if (sc == null)
		{
			// 如果找不到購物車(通常是Session逾時)，沒有必要往下執行
			// 導向首頁
			response.sendRedirect(getServletContext().getContextPath() + "/index.jsp");
			return;
		}
		
		// 結帳
		//到哪再改***************************************************************
		RequestDispatcher rd = request.getRequestDispatcher("OrderConfirm.jsp");
		//*********************************************************************
		rd.forward(request, response);
		return;
		
	}

}
