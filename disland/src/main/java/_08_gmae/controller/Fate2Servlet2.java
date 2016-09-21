package _08_gmae.controller;


import java.io.IOException;



import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Collection;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import _01_register.controller.LoginServlet;
import _01_register.model.LoginServiceDB;
import _01_register.model.MembersDAO;
import _01_register.model.MembersVO;
import _08_game.model.SecondStepDAO;
import _08_game.model.SecondStepVO;

@WebServlet("/_08_game/controller/Fate2Servlet2.java")
public class Fate2Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
			doPost(request, response);
		 
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  request.setCharacterEncoding("UTF-8");
		  String myid = request.getParameter("id");
		  String fateid = request.getParameter("name");
		  
		  System.out.println("id = " + myid);

		  System.out.println("name = " + fateid);
		  int myidafter = Integer.parseInt(myid);
		  int fateidafter = Integer.parseInt(fateid);
		  
		  
		  
		  
		  
		  MembersDAO in1 =null;
		  try {
                   in1= new MembersDAO();
                   in1.insertfate(myidafter, fateidafter);
                   
                   RequestDispatcher rd =request.getRequestDispatcher("/_08_gameFate/fate.jsp");
                   rd.forward(request, response);
                   return;
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		  
//		    FateService s1 = new FateService();
//		  	LoginServiceDB getmems = null;
//		  	MembersDAO getbg = null;     //到時候改成只撈異性
//			try {
//				getmems = new LoginServiceDB();
//				getbg = new MembersDAO();
//			} catch (NamingException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			int max1 = getmems.getMemberList().size();
//			
//			s1.setLowerBound(1); // 設定LotteryBean所需的必要參數
//			s1.setUpperBound(max1);
//			System.out.println("總共多少人 = "+max1);
//			s1.setBallNumber(1);
//			Collection coll = s1.getLuckyNumbers(); // 請LotteryBean產生所需的結果
//			Collection coll2= s1.getLuckyNumbers();
//			String var = coll.toString().replace("[", "").replace("]", "");
//			String var2 = coll2.toString().replace("[", "").replace("]", "");
//			System.out.println("當前隨機的號碼是: "+ var);
//			System.out.println("當前隨機的號碼是: "+ var2);
//			
//			
////			if(var!=var2){         //如果兩筆隨機不一樣的話
////				if(var.equals(id)||var2.equals(id)){      //如果其中一筆等於登入ID
////					doPost(request, response);
////					System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
////				}else{
////					request.setAttribute("fateNumber", var);
////					request.setAttribute("fateNumber2", var2);
////					RequestDispatcher rd =request.getRequestDispatcher("/_08_gameFate/fate-1.jsp");
////					rd.forward(request, response);
////					return;
////				}
////				
////			}else if (var==var2) {
////				doPost(request, response);
////				System.out.println("yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
////			}
//			
//			
//			
//			
//			
//			
//			if(var.equals(var2)){         //如果兩筆隨機不一樣的話
//				doPost(request, response);
//				System.out.println("yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
//				return;
//				
//			}else if (var!=var2) {
//				if(var.equals(id)||var2.equals(id)){      //如果其中一筆等於登入ID
//					doPost(request, response);
//					System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
//					return;
//				}else{
//					request.setAttribute("fateNumber", var);
//					request.setAttribute("fateNumber2", var2);
//					RequestDispatcher rd =request.getRequestDispatcher("/_08_gameFate/fate-1.jsp");
//					rd.forward(request, response);
//					return;
//				}
//			}
			
			
			
			
			
//			if(var.equals(id)){
//				doPost(request, response);
//				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
//				
//			}else {
//				request.setAttribute("luckyNumber", var); // 將第二項資訊放入request物件內
//				RequestDispatcher rd = // 準備將移轉程式的執行順序
//						request.getRequestDispatcher("/_08_gameFate/fate-1.jsp");
//				rd.forward(request, response); // 移轉程式的執行順序
//				return; // forward()之後會有一個return敘述
//			}
			
			
		  
	}


}