package com.servlets;

import com.fruit.dao.FruitDAO;
import com.fruit.domain.Fruit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author LiJing
 * @version 1.0
 */
@WebServlet("/edit.do")
public class EditServlet extends ViewBaseServlet {
    private FruitDAO fruitDAO = new FruitDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fidStr = request.getParameter("fid");
        int fid = Integer.parseInt(fidStr);

        Fruit fruit = fruitDAO.querySingle("select * from fruit where fid=?", Fruit.class, fid);
        request.setAttribute("fruit", fruit);

        super.processTemplate("edit", request, response);
    }
}
