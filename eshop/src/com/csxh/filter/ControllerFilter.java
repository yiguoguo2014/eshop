package com.csxh.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.csxh.action.CartAction;
import com.csxh.action.CategoryAction;
import com.csxh.action.IndexAction;
import com.csxh.action.ProductAction;
import com.csxh.action.RequestAware;
import com.csxh.action.SubcategoryAction;
import com.csxh.model.ActionContext;
import com.csxh.model.CartItem;
import com.csxh.util.Log4jUtil;

/**
 * Servlet Filter implementation class ControllerFilter
 */
@WebFilter(dispatcherTypes = { DispatcherType.REQUEST, DispatcherType.ERROR }, urlPatterns = { "*.jsp" })
public class ControllerFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public ControllerFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;

		String path = req.getServletPath();
		path = path.substring(1);

		// 此时PathInfo在request传给servlet之前还没有被解析出来，只能手工解析
		// path = req.getRequestURI();
		// String[] ss = path.split("[?]");
		// ss = ss[0].split("/");
		// path = ss[ss.length - 1];

		// 派发业务逻辑（action）
		if ("index.jsp".equals(path)) {

			Log4jUtil.info("转向首页Action处理");
			IndexAction action = new IndexAction();
			Log4jUtil.info("转入JSP页中使用的内置对象");
			action.setRequest(req);
			action.setSession(req.getSession());
			// action.setApplication(this.getServletContext());
			action.setParams(req.getParameterMap());
			Log4jUtil.info("处理业务数据及逻辑操作");
			String result = action.handle();
			if ("success".equals(result)) {

				Log4jUtil.info("转向JSP页显示");

				request.getRequestDispatcher(path).forward(request, response);

			} else if ("fail".equals(result)) {

			}

		}

		if ("category.jsp".equals(path)) {

			ActionContext ctx = new ActionContext();
			ctx.setRequest(req);
			ctx.setSession(req.getSession());

			CategoryAction action = new CategoryAction();

			action.setActionContext(ctx);

			Log4jUtil.info("转向首页Action处理");
			Log4jUtil.info("转入JSP页中使用的内置对象");

			// action.setApplication(this.getServletContext());

			// 如果使用框架，则一般是使用反射自动地将请求参数传给Action对象的属性
			String s = req.getParameter("id");

			action.setId(Integer.parseInt(s));

			Log4jUtil.info("处理业务数据及逻辑操作");
			String result = action.handle();
			if ("success".equals(result)) {

				Log4jUtil.info("转向JSP页显示");

				request.getRequestDispatcher(path).forward(request, response);

			} else if ("fail".equals(result)) {

			}

		}

		if ("subcategory.jsp".equals(path)) {

			SubcategoryAction action = new SubcategoryAction();

			Log4jUtil.info("转向首页Action处理");
			Log4jUtil.info("转入JSP页中使用的内置对象");
			action.setRequest(req);
			action.setSession(req.getSession());
			// action.setApplication(this.getServletContext());

			// 如果使用框架，则一般是使用反射自动地将请求参数传给Action对象的属性
			String s = req.getParameter("id");

			action.setId(Integer.parseInt(s));

			s = req.getParameter("currentPage");

			action.setCurrentPage(s == null ? 1 : Integer.parseInt(s));

			Log4jUtil.info("处理业务数据及逻辑操作");
			String result = action.handle();
			if ("success".equals(result)) {

				Log4jUtil.info("转向JSP页显示");

				request.getRequestDispatcher(path).forward(request, response);

			} else if ("fail".equals(result)) {

			}
		}

		if ("product.jsp".equals(path)) {

			ProductAction action = new ProductAction();

			if (action instanceof RequestAware) {
				RequestAware aware = (RequestAware) action;
				aware.setRequest(req);
			}

			// 如果使用框架，则一般是使用反射自动地将请求参数传给Action对象的属性
			String s = req.getParameter("id");

			action.setId(s);

			s = req.getParameter("currentPage");

			action.setCurrentPage(s == null ? 1 : Integer.parseInt(s));

			Log4jUtil.info("处理业务数据及逻辑操作");
			String result = action.handle();
			if ("success".equals(result)) {

				Log4jUtil.info("转向JSP页显示");

				request.getRequestDispatcher(path).forward(request, response);

			} else if ("fail".equals(result)) {

			}

		}

		if ("cart.jsp".equals(path)) {

			CartAction action = new CartAction();

			action.setRequest(req);

			CartItem item = new CartItem();
			
			String s = req.getParameter("productId");
			if(s!=null){				
				item.setProductId(s);
			}
			s = req.getParameter("productName");
			if(s!=null){				
				item.setProductName(new String( s.getBytes("iso-8859-1"),"gb2312" ));
			}
			s = req.getParameter("productPrice");
			if(s!=null){
				
				item.setProductPrice(Double.parseDouble(s));
			}
			s = req.getParameter("productCount");
			if(s!=null){				
				item.setProductCount(Integer.parseInt(s));
			}

			action.setItem(item);
			
			//Log4jUtil.info(item.toString());
			
			//操作
			s=req.getParameter("op");
			
			action.setOp(s==null ? CartAction.Add : s);

			
			String result = action.handle();
			if ("success".equals(result)) {

				Log4jUtil.info("转向JSP页显示");

				request.getRequestDispatcher(path).forward(request, response);

			} else if ("fail".equals(result)) {

			}

		}

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
