package com.helpezee.interceptors;

import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

public class I18NInterceptor implements HandlerInterceptor  {

		  public static final String DEFAULT_PARAM_NAME = "locale";
		  private String paramName = DEFAULT_PARAM_NAME;
		   
		  public void setParamName(String paramName) {
		    this.paramName = paramName;
		  }
		 
		  public String getParamName() {
		    return this.paramName;
		  }
		   
		  @Override
		  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		      throws ServletException {
		    System.out.println("Pre-Handle");
		   return true;
		  }
		   
		  
		   
		 

		@Override
		public void afterCompletion(HttpServletRequest arg0,
				HttpServletResponse arg1, Object arg2, Exception arg3)
				throws Exception {
		System.out.println("afterCompletion");
			
		}

		@Override
		public void postHandle(HttpServletRequest arg0,
				HttpServletResponse arg1, Object arg2, ModelAndView arg3)
				throws Exception {
			System.out.println("postHandle");
			
		}
		}

/*
 Each interceptor you define must implement org.springframework.web.servlet.HandlerInterceptor interface. There are three methods that need to be implemented.

preHandle(..) is called before the actual handler is executed;

The preHandle(..) method returns a boolean value. You can use this method to break or continue the processing of the execution chain. When this method returns true, the handler execution chain will continue; when it returns false, the DispatcherServlet assumes the interceptor itself has taken care of requests (and, for example, rendered an appropriate view) and does not continue executing the other interceptors and the actual handler in the execution chain.

postHandle(..) is called after the handler is executed;

afterCompletion(..) is called after the complete request has finished.

These three methods should provide enough flexibility to do all kinds of preprocessing and postprocessing.
*/