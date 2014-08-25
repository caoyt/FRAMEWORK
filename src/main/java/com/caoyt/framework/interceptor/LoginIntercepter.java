package com.caoyt.framework.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;


/**
 * @author caoyt(曹颖桐)
 * @email caoyingtong@41zone.cc
 * @date 2014-7-31 下午9:57:55
 * 
 * 登录拦截器
 * 
 */
public class LoginIntercepter extends AbstractInterceptor{

	private static final long serialVersionUID = 1L;

	private static final String REDIRECT_PATH = "/index.jsp";
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		
		//获取request对象
		HttpServletRequest request = (HttpServletRequest) invocation.getInvocationContext().get(StrutsStatics.HTTP_REQUEST);
		
		//获取session对象
		HttpSession session = request.getSession();
		
		//获取response对象
		HttpServletResponse response = (HttpServletResponse) invocation.getInvocationContext().get(StrutsStatics.HTTP_RESPONSE);
		
		
		
		/*System.out.println("getContextPath--->"+request.getContextPath());
		System.out.println("getRequestURI--->"+request.getRequestURI());*/
		
		
//		response.sendRedirect(request.getContextPath() + REDIRECT_PATH);
		
		
		invocation.invoke();
		
		return null;
	}

	
	

}
