package _05_shoppingCart.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import _05_shoppingCart.model.ShoppingCart;

@WebServlet("/_05_shoppingCart/abort.do")
public class AbortServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		System.out.println("123");
		ShoppingCart cart = (ShoppingCart) session.getAttribute("ShoppingCart");
		if (cart != null)
		{
			// 由session物件中移除ShoppingCart物件
			session.removeAttribute("ShoppingCart");
		}
		response.sendRedirect(response.encodeRedirectURL("../index.jsp"));
		return;
	}

}
