package _08_gmae.controller;

import java.io.IOException;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.dialect.Ingres10Dialect;

import _01_register.controller.LoginServlet;
import _01_register.model.LoginServiceDB;
import _01_register.model.MembersDAO;
import _01_register.model.MembersVO;
import _08_game.model.SecondStepDAO;
import _08_game.model.SecondStepVO;

@WebServlet("/_08_game/controller/FatecheckServlet.java")
public class FatecheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		int myidafter = Integer.parseInt(id); // 字串轉INT
		String name = request.getParameter("name");
		System.out.println("id = " + id);
		System.out.println("name = " + name);

		try {
			FatecheckDAO getfatemem = new FatecheckDAO();
			Collection<SecondStepVO> co11 = getfatemem.getFateNumbers(myidafter);
			System.out.println("co11.size() = " + co11.size());
			int var1 = co11.size();
            Object[] coll2 = co11.toArray();
            coll2.toString();
            
            System.out.println(" coll2.toString() = "+ coll2.toString());
			if (co11.size() < 2) {
				request.setAttribute("nofate", var1);
				RequestDispatcher rd = request.getRequestDispatcher("/_08_gameFate/fateselect.jsp");
				rd.forward(request, response);
				return;
			}else{
				int i1=0;
				int i2=0;
//				Iterator iterator2 = co11.iterator(); iterator2.hasNext();
//				SecondStepVO secondStepVO2 = (SecondStepVO) iterator2.next();
//				i2=secondStepVO2.getMembers_ID();
				
				Integer[] ii1 = new Integer[co11.size()];
				int a=0;
				for(SecondStepVO secondStepVO:co11){
					ii1[a] = secondStepVO.getMembers_ID();
					a++;
					
				}
				
				request.setAttribute("fate4", ii1);
				RequestDispatcher rd = request.getRequestDispatcher("/_08_gameFate/fateselect.jsp");
				rd.forward(request, response);
				return;
				
				
//			for (Iterator iterator = co11.iterator(); iterator.hasNext();) { // 會把所有你的緣點列出來
//			
//					SecondStepVO secondStepVO = (SecondStepVO) iterator.next();
//					System.out.println(secondStepVO.getMembers_ID());
//					 i1=secondStepVO.getMembers_ID();
//					 
//					
//			}
			
			
//			System.out.println("i1 = "+i1);
//			request.setAttribute("fate2", i1);
//			request.setAttribute("fate3", i2);
//			RequestDispatcher rd = request.getRequestDispatcher("/_08_gameFate/fateselect.jsp");
//			rd.forward(request, response);
//			return;
			
			}
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}