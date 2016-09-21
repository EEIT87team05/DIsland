package _05_shoppingCart.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import _05_shoppingCart.model.OrderBookShowBean;
import _05_shoppingCart.model.OrderListsDAO;
import _05_shoppingCart.model.OrderListsService;
import _05_shoppingCart.model.OrderListsVO;
import _05_shoppingCart.model.ShoppingDetailsVO;

@WebServlet("/_05_shoppingCart/ShoppingDetailsServlet.do")
public class ShoppingDetailsServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String OrderLists_ID = request.getParameter("OrderLists_ID");
		int no = Integer.parseInt(OrderLists_ID.trim());
		try
		{
			OrderListsDAO old = new OrderListsDAO();
			OrderListsVO olv = old.getOrder(no);
			
			request.setAttribute("OrderListsVO", olv);
//			System.out.println(OrderLists_ID);
			
			RequestDispatcher rd = request.getRequestDispatcher("ShowOrderDetail.jsp");
			rd.forward(request, response);
			return;
		} 
		catch (SQLException e)
		{
			throw new ServletException(e);
		}
		catch (NamingException e)
		{
			throw new ServletException(e);
		}
	}
	
	public void displayOrderListsVO(OrderListsVO olv)
	{
		System.out.println("olv.getOrderLists_ID() = " + olv.getOrderLists_ID());
		System.out.println("olv.getMembers_ID() = " + olv.getMembers_ID());
		System.out.println("olv.getOrderLists_Date() = " + olv.getOrderLists_Date());
		System.out.println("olv.getOrderLists_TotalAmount() = " + olv.getOrderLists_TotalAmount());
		System.out.println("==============訂單明細=================");
		List<ShoppingDetailsVO> details = olv.getDetails();
		for (ShoppingDetailsVO sdv : details)
		{
			System.out.println("sdv.getShoppingDetails_ID() = " + sdv.getShoppingDetails_ID());
			System.out.println("sdv.getMembers_ID() = " + sdv.getMembers_ID());
			System.out.println("sdv.getOrderLists_ID() = " + sdv.getOrderLists_ID());
			System.out.println("sdv.getProductListingBook_ID() = " + sdv.getProductListingBook_ID());
			System.out.println("sdv.getProductListingFood_ID() = " + sdv.getProductListingFood_ID());
			System.out.println("sdv.getShoppingDetails_BookQuantity() = " + sdv.getShoppingDetails_BookQuantity());
			System.out.println("sdv.getShoppingDetails_FoodQuantity() = " + sdv.getShoppingDetails_FoodQuantity());	
			System.out.println("sdv.getShoppingDetails_Date() = " + sdv.getShoppingDetails_Date());
			System.out.println("sdv.getShoppingDetails_BookPrice() = " + sdv.getShoppingDetails_BookPrice());
			System.out.println("sdv.getShoppingDetails_FoodPrice() = " + sdv.getShoppingDetails_FoodPrice());
			System.out.println("sdv.getShoppingDetails_isShipments() = " + sdv.getShoppingDetails_isShipments());
		}		
	}

}
