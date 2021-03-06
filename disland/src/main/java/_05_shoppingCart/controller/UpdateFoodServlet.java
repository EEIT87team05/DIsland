package _05_shoppingCart.controller;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import _05_shoppingCart.model.ShoppingCart;



// 本類別可修改購物車內的商品資料，包括刪除某項商品，修改某項商品的數量
@WebServlet("/_05_shoppingCart/UpdateFoodItem.do")
public class UpdateFoodServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	HttpSession session = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException
	{
		request.setCharacterEncoding("UTF-8");
		session = request.getSession(false);
		if (session == null)
		{ // 使用逾時
			response.sendRedirect(getServletContext().getContextPath() + "/index.jsp");
			return;
		}
		// 取出session物件內的ShoppingCart物件
		ShoppingCart sc = (ShoppingCart) session.getAttribute("ShoppingCart");
		if (sc == null)
		{
			// 如果找不到購物車(通常是Session逾時)，沒有必要往下執行
			// 導向首頁
			response.sendRedirect(getServletContext().getContextPath() + "/index.jsp");
			return;
		}
		// cmd可能是DEL或是MOD
		String cmd = request.getParameter("cmd");
		String foodIDStr = request.getParameter("foodID");
		int foodID = Integer.parseInt(foodIDStr.trim());
		if (cmd.equalsIgnoreCase("DEL"))
		{
			sc.deleteBook(foodID); // 刪除購物車內的某項商品
			RequestDispatcher rd = request.getRequestDispatcher("/_05_shoppingCart/ShowCartContent.jsp");
			rd.forward(request, response);
			return;
		} else if (cmd.equalsIgnoreCase("MOD"))
		{
			String newQtyStr = request.getParameter("newQty");
			int newQty = Integer.parseInt(newQtyStr.trim());
			sc.modifyBqty(foodID, newQty);// 修改某項商品的數項
			RequestDispatcher rd = request.getRequestDispatcher("/_05_shoppingCart/ShowCartContent.jsp");
			rd.forward(request, response);
			return;
		}

	}
}