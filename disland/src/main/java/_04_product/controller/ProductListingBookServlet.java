package _04_product.controller;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import _00_init.GlobalService;
import _01_register.model.MembersVO;
import _04_product.model.ProductListingBookService;
import _04_product.model.ProductListingBookVO;

@WebServlet("/_04_product/ProductListingBookServlet")
public class ProductListingBookServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	int pageNo = 1;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// 先取出session物件，第一次登入用才不用寫false
		HttpSession session = request.getSession(false);
		// 紀錄目前請求的RequestURI,以便使用者登入成功後能夠回到原本的畫面
		// 如果session物件不存在
		if (session == null)
		{
			// 請使用者登入
			response.sendRedirect(response.encodeRedirectURL("../_01_register/login.jsp"));
			return;
		}
		MembersVO mb = (MembersVO) session.getAttribute("LoginOK");
		Integer Members_ID = mb.getMembers_ID();

		// 本類別負責讀取資料庫內ProductListingBook表格內某一頁的紀錄，並能新增紀錄、修改紀錄、刪除記錄等
		ProductListingBookService ser = null;
		try
		{
			String pageNoStr = request.getParameter("pageNo"); // 取得<a
																// href="<c:url
																// value='DisplayPageProducts?pageNo=${pageNo+1}'
																// />
			if (pageNoStr == null)
			{ // 第一次登入不會取得，按上一頁下一頁才會將識別字串pageNo傳進來
				pageNo = 1; // 先給定到第一頁
				Cookie[] cookies = request.getCookies(); // Cookie的取出沒有他法，全都只能使用此方式，把所有Cookie都讀出，傳回的一定是陣列
				if (cookies != null)
				{
					for (Cookie c : cookies)
					{
						if (c.getName().equals(Members_ID + "pageNo"))
						{ // Cookie.getName() 便是取得當時Cookie存入時的 索引值
							try
							{ // Cookie.getValue() 便是取得當時Cookie存入時的 資料內容
								pageNo = Integer.parseInt(c.getValue().trim()); // 不同的是return的type，valueOf是Integer，parseInt是int。
							} catch (NumberFormatException e)
							{
								;
							}
							break;
						}
					}
				}
			} else
			{ // 按上一頁下一頁才會將識別字串pageNo傳進來
				try
				{
					pageNo = Integer.parseInt(pageNoStr.trim());
				} catch (NumberFormatException e)
				{
					pageNo = 1;
				}
			}
			ser = new ProductListingBookService();
			ser.setPageNo(pageNo); // 紀錄當前的pageNo是多少
			ser.setRecordsPerPage(GlobalService.RECORDS_PER_PAGE); // 設定每頁3筆
			// ser.getPageBooks():讀取某一頁的所有紀錄
			Collection<ProductListingBookVO> coll = ser.getPageBooks();
			request.setAttribute("pageNo", pageNo);
			request.setAttribute("totalPages", ser.getTotalPages());
			request.setAttribute("recordsPerPage", GlobalService.RECORDS_PER_PAGE);
//			System.out.println(coll.size());
			request.setAttribute("products_DPP", coll); // 某一頁的所有紀錄
			// -----------------------
			// 新增一個Cookie是使用如下的方式，Cookie cookie = new Cookie(索引值, 資料內容);
			// 把cookie透過addCookie加到回應物件，response.addCookie(cookie);
			Cookie pnCookie = new Cookie(Members_ID + "pageNo", String.valueOf(pageNo));
			pnCookie.setMaxAge(30 * 24 * 60 * 60);// 活30天
			pnCookie.setPath(request.getContextPath());
			response.addCookie(pnCookie);
			// -----------------------

			// 交由listBooks.jsp來顯示某頁的書籍資料，同時準備『第一頁』、
			// 『前一頁』、『下一頁』、『最末頁』等資料
			RequestDispatcher rd = request.getRequestDispatcher("ProductListingBook.jsp");
			rd.forward(request, response);
			return;

		} catch (Exception e)
		{
			throw new ServletException(e);
		}

	}

}
