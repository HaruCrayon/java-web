package com.lee.cookies.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author LiJing
 * @version 1.0
 */
@WebServlet("/kaptcha01")
public class KaptchaServletDemo01 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Object kaptchaCodeObj = session.getAttribute("KAPTCHA_SESSION_KEY");
        System.out.println("kaptchaCodeObj= " + kaptchaCodeObj);
    }
}
