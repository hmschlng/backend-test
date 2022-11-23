//package com.ssafy.backtest.Interceptor;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import com.ssafy.backtest.member.util.JwtUtil;
//
//@Component
//public class JwtInterceptor implements HandlerInterceptor{
//	
//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//			throws Exception {
//		final String token = request.getParameter("emailId");
//				
//		if(token != null && JwtUtil.isValid(token)){
//			return true;
//		} else{
//			throw new UnAuthorizedException();
//		}
//	}
//	
//	
//}
