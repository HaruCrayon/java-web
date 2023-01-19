package com.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * @author LiJing
 * @version 1.0
 */

/*
@WebServlet(urlPatterns = {"/demo01"} ,
        initParams = {
                @WebInitParam(name="hello",value="world"),
                @WebInitParam(name="uname",value="jim")
        }
)
*/
public class Demo01Servlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        ServletConfig servletConfig = getServletConfig();
        String initParamValue = servletConfig.getInitParameter("hello");
        System.out.println("initParamValue= " + initParamValue);

        ServletContext servletContext = getServletContext();
        String contextConfigLocation = servletContext.getInitParameter("contextConfigLocation");
        System.out.println("contextConfigLocation= " + contextConfigLocation);
    }
}
