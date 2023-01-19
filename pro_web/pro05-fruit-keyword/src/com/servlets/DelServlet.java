package com.servlets;

import com.fruit.dao.FruitDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author LiJing
 * @version 1.0
 */
@WebServlet("/del.do")
public class DelServlet extends ViewBaseServlet {
    private FruitDAO fruitDAO = new FruitDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fidStr = request.getParameter("fid");
        int fid = Integer.parseInt(fidStr);

        fruitDAO.update("delete from fruit where fid=?", fid);

        response.sendRedirect("index");
    }
}
