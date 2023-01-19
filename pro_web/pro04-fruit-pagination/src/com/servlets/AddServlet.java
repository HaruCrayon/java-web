package com.servlets;

import com.fruit.dao.FruitDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author LiJing
 * @version 1.0
 */
@WebServlet("/add.do")
public class AddServlet extends HttpServlet {
    private FruitDAO fruitDAO = new FruitDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String fname = request.getParameter("fname");
        String priceStr = request.getParameter("price");
        int price = Integer.parseInt(priceStr);
        String fcountStr = request.getParameter("fcount");
        int fcount = Integer.parseInt(fcountStr);
        String remark = request.getParameter("remark");

        fruitDAO.update("insert into fruit values(null,?,?,?,?)", fname, price, fcount, remark);

        response.sendRedirect("index");
    }
}
