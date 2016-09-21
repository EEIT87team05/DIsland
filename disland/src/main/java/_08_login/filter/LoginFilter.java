package _08_login.filter;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.*;

import _01_register.model.MembersVO;


@WebFilter(urlPatterns = {"/*"},
initParams = {@WebInitParam(name = "mustLogin1", value="/_01_register/members.jsp"),
			  @WebInitParam(name = "mustLogin2", value="/_02_friend/*"),
			  @WebInitParam(name = "mustLogin3", value="/_03_board/*"),
			  @WebInitParam(name = "mustLogin4", value="/_04_product/*"),
			  @WebInitParam(name = "mustLogin5", value="/_05_shoppingCart/*"),
			  @WebInitParam(name = "mustLogin7", value="/_07_game/*"),
              @WebInitParam(name = "mustLogin8", value="/_08_game/*"),})
             
public class LoginFilter implements Filter
{
	Collection<String> url = new ArrayList<String>();
	String servletPath;
	String contextPath;
	String requestURI;

	@Override
	public void init(FilterConfig fConfig) throws ServletException
	{
		Enumeration<String> e = fConfig.getInitParameterNames();
		while (e.hasMoreElements())
		{
			String path = e.nextElement();
			url.add(fConfig.getInitParameter(path));
		}
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException
	{
		boolean isRequestedSessionIdValid = false;
		if (request instanceof HttpServletRequest && response instanceof HttpServletResponse)
		{
			HttpServletRequest req = (HttpServletRequest) request;
			HttpServletResponse resp = (HttpServletResponse) response;
			servletPath = req.getServletPath();
			contextPath = req.getContextPath();
			requestURI = req.getRequestURI();
			isRequestedSessionIdValid = req.isRequestedSessionIdValid();

			if (mustLogin())
			{
				if (checkLogin(req))
				{ // 需要登入，已經登入
					chain.doFilter(request, response);
				} else
				{ // 需要登入，尚未登入
					HttpSession session = req.getSession();
					session.setAttribute("requestURI", requestURI);
					if (!isRequestedSessionIdValid)
					{
						session.setAttribute("timeOut", "使用逾時，請重新登入");
					}
					//******************************************************
					resp.sendRedirect(contextPath + "/_01_register/login.jsp");
					//******************************************************
					return;
				}
			} else
			{ // 不需要登入
				chain.doFilter(request, response);
			}
		} else
		{
			throw new ServletException("Request / Response 型態錯誤");
		}
	}

	private boolean mustLogin()
	{
		boolean login = false;
		for (String sURL : url)
		{
			if (sURL.endsWith("*"))
			{
				sURL = sURL.substring(0, sURL.length() - 1);
				if (servletPath.startsWith(sURL))
				{
					login = true;
					break;
				}
			} else
			{
				if (servletPath.equals(sURL))
				{
					login = true;
					break;
				}
			}
		}
		return login;
	}
	
	private boolean checkLogin(HttpServletRequest req)
	{
		HttpSession session = req.getSession();
		MembersVO loginToken = (MembersVO) session.getAttribute("LoginOK");
		if (loginToken == null)
		{
			return false;
		} else
		{
			return true;
		}
	}

	@Override
	public void destroy()
	{
	}
}
