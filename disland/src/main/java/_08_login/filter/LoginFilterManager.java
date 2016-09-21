package _08_login.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import _06_backStage.model.ManagerVO;

@WebFilter(urlPatterns = { "/*" }, 
initParams = {@WebInitParam(name = "backStage", value = "/_06_backStage/tttttttt.jsp") })
public class LoginFilterManager implements Filter
{
	Collection<String> url = new ArrayList<String>();
	String servletPath;
	String contextPath;
	String requestURI;

	public LoginFilterManager()
	{
	}

	public void destroy()
	{
	}

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
				{
					chain.doFilter(request, response);
				} else
				{
					HttpSession session = req.getSession();
					session.setAttribute("requestURI", requestURI);
					if (!isRequestedSessionIdValid)
					{
						session.setAttribute("timeOut", "請重新登入");
					}
					resp.sendRedirect(contextPath + "/_06_backStage/login.jsp");

					return;
				}
			}else 
			{
				chain.doFilter(request, response);
			}
		}else 
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
		ManagerVO loginTokenManager = (ManagerVO) session.getAttribute("MLoginOK");
		if (loginTokenManager == null)
		{
			return false;
		} else
		{
			return true;
		}
	}

	public void init(FilterConfig fConfig) throws ServletException
	{
		Enumeration<String> e = fConfig.getInitParameterNames();
		while (e.hasMoreElements())
		{
			String path = e.nextElement();
			url.add(fConfig.getInitParameter(path));
		}
	}

}
