package _04_product.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import _05_shoppingCart.model.OrderFoodShowBean;
import _05_shoppingCart.model.ShoppingCart;

@WebServlet("/_05_shoppingCart/BuyFood.do")
public class BuyFoodServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//編碼
		request.setCharacterEncoding("UTF-8");
		
		//找session,找不到不要建新的(整合時開啟false)=======================
		//HttpSession session = request.getSession(false);
		HttpSession session = request.getSession();
		//===========================================================
		
		//使用逾時
		if (session == null)
		{
			request.setAttribute("Errors", "使用逾時,請重新登入");
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
			return;
		}
		
		ShoppingCart cart = (ShoppingCart) session.getAttribute("ShoppingCart");
		
		if (cart == null)
		{
			cart = new ShoppingCart();
			session.setAttribute("ShoppingCart", cart);
		}
		
		//從頁面拿回來的東西,使用者購買了哪些東西
		//都是字串,故命名時後面多加了Str
		//pageNo是為了存頁數用,當使用者按下加入購物車後,可以繼續在原本那頁
		String foodIdStr = request.getParameter("ProductListingFood_ID");
		String fQtyStr = request.getParameter("qty");
		String foodPriceStr = request.getParameter("ProductListingFood_Price");
		String foodDiscountStr = request.getParameter("ProductListingFood_Discount");
		String foodName = request.getParameter("ProductListingFood_Name"); 
		String foodFirm = request.getParameter("ProductListingFood_Firm");
		String pageNo = request.getParameter("pageNo");
		
		if (pageNo == null)
		{
			pageNo = "1";
		}
		
		//為了接資料型態轉換的結果先宣告的變數
		int foodId = 0;
		int fQty = 0;
		int foodPrice = 0;
		int foodDiscount = 0;
		
		try
		{
			//進行資料型態的轉換
			fQty = Integer.parseInt(fQtyStr.trim());
			foodId = Integer.parseInt(foodIdStr.trim());
			foodPrice = Integer.parseInt(foodPriceStr.trim());
			foodDiscount = Integer.parseInt(foodDiscountStr.trim());
		} catch (NumberFormatException e)
		{
			throw new ServletException(e);
		}
		
		//將訂單資料封裝到OrderFoodShowBean內
		//將結果丟到OrderFoodShowBean裡面,有參數的建構子,用this.XXX = XXX把值都設進去
		OrderFoodShowBean ofsb = new OrderFoodShowBean(foodId, fQty, foodPrice, foodDiscount, foodName, foodFirm);
		
		//將OrderFoodShowBean加入ShoppingCart的物件內
		cart.addToFoodCart(foodId, ofsb);
		
		//加入後回到原本購物的那一頁
		//等JSP寫出來再補到哪(參考BuyBookServlet)********************
		RequestDispatcher rd = request.getRequestDispatcher("");
		//******************************************************
		rd.forward(request, response);
		return;
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
