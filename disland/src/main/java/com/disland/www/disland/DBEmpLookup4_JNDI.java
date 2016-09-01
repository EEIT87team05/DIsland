package com.disland.www.disland;

import java.io.*;
import java.sql.*;
import javax.naming.Context;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.DataSource;

@WebServlet("/DBEmpLookup4_JNDI")
public class DBEmpLookup4_JNDI extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out = res.getWriter();

		try
		{
			Context ctx = new javax.naming.InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/disland");
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("select empno, ename from EMP2");

			out.println("<HTML><HEAD><TITLE>Phonebook</TITLE></HEAD>");
			out.println("<BODY>");
			out.println("<UL>");
			while (rs.next())
			{
				out.println("<LI>" + rs.getString("empno") + " " + rs.getString("ename"));
			}
			out.println("</UL>");
			out.println("</BODY></HTML>");
		} catch (Exception e)
		{
			out.println("Exception caught: " + e.getMessage());
		} finally
		{
			try
			{
				if (con != null)
					con.close();
			} catch (SQLException ignored)
			{
			}
		}
	}
}
