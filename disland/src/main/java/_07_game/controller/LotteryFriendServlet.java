package _07_game.controller;

import java.io.IOException;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Collection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import javax.swing.plaf.metal.MetalIconFactory.FileIcon16;

import org.hibernate.Session;

import _00_init.GlobalService;
import _01_register.controller.LoginServlet;
import _01_register.model.LoginServiceDB;
import _01_register.model.MembersVO;

@WebServlet("/_07_game/controller/LotteryFriendServlet.java")
public class LotteryFriendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DataSource ds1 = null;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		System.out.println("id = " + id);
		System.out.println("name = " + name);

		LoginServiceDB fmid;

		try {
			fmid = new LoginServiceDB();
			MembersVO var1 = fmid.findrandommemberid(name);
			request.setAttribute("RandomFriend", var1);
			RequestDispatcher rd = // 準備將移轉程式的執行順序
					request.getRequestDispatcher("/_07_game/randomDispay.jsp");
			rd.forward(request, response); // 移轉程式的執行順序
			return;

		} catch (SQLException e) {
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// LotteryBean lottery = new LotteryBean(); // LotteryBean負責程式的邏輯運算
		// LoginServiceDB getmems = null;
		// try {
		// getmems = new LoginServiceDB();
		// } catch (NamingException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (SQLException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// int max1 = getmems.getMemberList().size();
		// lottery.setLowerBound(1); // 設定LotteryBean所需的必要參數
		// lottery.setUpperBound(max1);
		// lottery.setBallNumber(1);
		// Collection coll = lottery.getLuckyNumbers(); // 請LotteryBean產生所需的結果
		//
		// String var = coll.toString().replace("[", "").replace("]", "");
		// System.out.println("當前隨機的號碼是: "+ var);
		//
		// if(var.equals(id)){
		// doPost(request, response);
		// System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		//
		// }else {
		// request.setAttribute("luckyNumber", var); // 將第二項資訊放入request物件內
		// RequestDispatcher rd = // 準備將移轉程式的執行順序
		// request.getRequestDispatcher("/_07_game/random.jsp");
		// rd.forward(request, response); // 移轉程式的執行順序
		// return; // forward()之後會有一個return敘述
		// }

	}

}