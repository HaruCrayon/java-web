package com.servlets;

import com.fruit.dao.FruitDAO;
import com.fruit.domain.Fruit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author LiJing
 * @version 1.0
 */

//Servlet从3.0版本开始支持注解方式的注册
@WebServlet("/index")
public class IndexServlet extends ViewBaseServlet {
    private FruitDAO fruitDAO = new FruitDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Fruit> fruitList = fruitDAO.queryMulti("select * from fruit", Fruit.class);

        //保存到session作用域
        HttpSession session = request.getSession();
        session.setAttribute("fruitList", fruitList);

        //根据逻辑视图名称 得到 物理视图名称
        //此处的视图名称是 index
        //那么thymeleaf会将这个 逻辑视图名称 对应到 物理视图 名称上去
        //逻辑视图名称 ：   index
        //物理视图名称 ：   view-prefix + 逻辑视图名称 + view-suffix
        //所以真实的视图名称是：      /       index       .html
        super.processTemplate("index", request, response);
    }
}
