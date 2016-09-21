package _04_product.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import _05_shoppingCart.model.OrderBookShowBean;
import _05_shoppingCart.model.ShoppingCart;

@WebServlet("/_04_product/BuyBook.do")
public class BuyBookServlet extends HttpServlet
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
		HttpSession session = request.getSession(false);
//		HttpSession session = request.getSession();
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
		String bookIdStr = request.getParameter("ProductListingBook_ID");
		String bookName = request.getParameter("ProductListingBook_Name"); 
		String bookAuthors = request.getParameter("ProductListingBook_Authors");
		String bookPriceStr = request.getParameter("ProductListingBook_Price");
		String bookDiscountStr = request.getParameter("ProductListingBook_Discount");
		String pageNo = request.getParameter("pageNo");
		String bQtyStr = request.getParameter("qty");
		
		if (pageNo == null)
		{
			pageNo = "1";
		}
		
		//為了接資料型態轉換的結果先宣告的變數
		int bookId = 0;
		int bQty = 0;
		int bookPrice = 0;
		double bookDiscount = 0;
		
		try
		{
			//進行資料型態的轉換
			bQty = Integer.parseInt(bQtyStr.trim());
			bookId = Integer.parseInt(bookIdStr.trim());
			bookPrice = (int) Double.parseDouble(bookPriceStr.trim());
			bookDiscount = (double) Float.parseFloat(bookDiscountStr.trim());
			System.out.println("book = " + bookDiscount);
		} catch (NumberFormatException e)
		{
			throw new ServletException(e);
		}
		
		//將訂單資料封裝到OrderBookShowBean內
		//將結果丟到OrderBookShowBean裡面,有參數的建構子,用this.XXX = XXX把值都設進去
		OrderBookShowBean obsb = new OrderBookShowBean(bookId, bQty, bookPrice, bookDiscount, bookName, bookAuthors);
		
		//將OrderBookShowBean加入ShoppingCart的物件內
		cart.addToBookCart(bookId, obsb);
		
		//加入後回到原本購物的那一頁
		//等JSP寫出來再補到哪(參考BuyBookServlet)********************
		RequestDispatcher rd = request.getRequestDispatcher("/_04_product/ProductListingBookServlet?pageNo=" + pageNo);
		//******************************************************
		rd.forward(request, response);
		return;

	}
}
