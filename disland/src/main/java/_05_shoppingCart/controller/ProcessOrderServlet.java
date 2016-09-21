package _05_shoppingCart.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import _01_register.model.MembersVO;
import _05_shoppingCart.model.OrderBookShowBean;
import _05_shoppingCart.model.OrderFoodShowBean;
import _05_shoppingCart.model.OrderListsDAO;
import _05_shoppingCart.model.OrderListsVO;
import _05_shoppingCart.model.ShoppingCart;
import _05_shoppingCart.model.ShoppingDetailsVO;

@WebServlet("/_05_shoppingCart/ProcessOrder.do")
public class ProcessOrderServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			//編碼
			request.setCharacterEncoding("UTF-8");
			// 準備存放錯誤訊息的Map物件
			Map<String, String> errorMsg = new HashMap<String, String>();
			request.setAttribute("MsgMap", errorMsg); // 顯示錯誤訊息
			
			//finalDecision的值,是CANCEL或是ORDER(如果是CANCEL就remove掉購物車)
			String finalDecision = request.getParameter("finalDecision");
			
			//找session,找不到不要建新的(整合時開啟false)=======================
			HttpSession session = request.getSession(false);
//			HttpSession session = request.getSession();
			//===========================================================
			
			// 使用逾時
			if (session == null)
			{ 
				response.sendRedirect(getServletContext().getContextPath() + "/index.jsp");
				return;
			}
			
			MembersVO mv = (MembersVO) session.getAttribute("LoginOK");
			
			if (mv == null)
			{
				response.sendRedirect(getServletContext().getContextPath() + "/index.jsp");
				return;
			}
			
			ShoppingCart sc = (ShoppingCart) session.getAttribute("ShoppingCart");
			
			//整合時開啟=====================================================
			if (sc == null)
			{
				// 如果找不到購物車(通常是Session逾時)，沒有必要往下執行
				// 導向首頁
				response.sendRedirect(getServletContext().getContextPath() + "/index.jsp");
				return;
			}
			//=============================================================
			
			if (finalDecision.equals("CANCEL"))
			{
				session.removeAttribute("ShoppingCart");
				response.sendRedirect(response.encodeRedirectURL(request.getContextPath()));
				return; // 一定要記得 return
			}
			
			//要存到OrderLists的東西
			//整合時開啟=====================================================
			int userId = mv.getMembers_ID(); //客戶編號
			double totalAmount = Math.round(sc.getSubtotal()); //無條件捨去
			//=============================================================
			
			
			Date today = (Date) session.getAttribute("today"); //訂單日期
			String shippingAddress = request.getParameter("ShippingAddress"); //出貨地址
			String paymentMethod = request.getParameter("PaymentMethod");  //付款方式
			
			if (shippingAddress == null || shippingAddress.trim().length() == 0)
			{
				errorMsg.put("errorAddressEmpty", "寄送地址必須輸入");
			}
			
			if (!errorMsg.isEmpty())
			{
				// 導向原來輸入資料的畫面，這次會顯示錯誤訊息
				RequestDispatcher rd = request.getRequestDispatcher("OrderConfirm.jsp");
				rd.forward(request, response);
				return;
			}
			
			
			String prepare = "準備中";
			List<ShoppingDetailsVO> details = new ArrayList<ShoppingDetailsVO>();
			
			//整合時開啟=======================================================================
			
			Map<Integer, OrderBookShowBean> bookcart = sc.getBookContent();
			Map<Integer, OrderFoodShowBean> foodcart = sc.getFoodContent();
			Set<Integer> bset = bookcart.keySet();
			Set<Integer> fset = foodcart.keySet();
			
			for (Integer k : bset)
			{
				OrderBookShowBean obsb = bookcart.get(k);
				
				ShoppingDetailsVO sdv = new ShoppingDetailsVO(0,0,obsb.getProductListingBook_ID(),
						1,obsb.getBqty(),0,today,obsb.getProductListingBook_Price(),
						0,prepare,obsb.getProductListingBook_Name(),null,obsb.getProductListingBook_Discount(),0);
				
				details.add(sdv);
			}
			
			for (Integer k : fset)
			{
				OrderFoodShowBean ofsb = foodcart.get(k);
				
				ShoppingDetailsVO sdv = new ShoppingDetailsVO();
				details.add(sdv);
			}
			
			//==================================================================================
			
			OrderListsVO olv = new OrderListsVO(userId,today,shippingAddress,paymentMethod,totalAmount,details);
			
			OrderListsDAO orderListsDAO = new OrderListsDAO();
			orderListsDAO.insertOrderLists(olv);
			
			session.removeAttribute("ShoppingCart");
			
			//*******************************************************************
			response.sendRedirect(response.encodeRedirectURL("Thanks.jsp"));
			//*******************************************************************		
		}
		catch (NamingException e)
		{
			throw new ServletException();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
			throw new ServletException();
		}
	}

}
