package com.servlets;

import com.fruit.dao.FruitDAO;
import com.fruit.domain.Fruit;
import com.fruit.service.FruitService;
import com.fruit.utils.StringUtil;

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

@WebServlet("/index")
public class IndexServlet extends ViewBaseServlet {
    private FruitService fruitService = new FruitService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        Integer pageNo = 1;

        String oper = request.getParameter("oper");
        String keyword = "";
        if (StringUtil.isNotEmpty(oper) && "search".equals(oper)) {
            //说明是点击表单查询发送过来的请求
            //此时，pageNo应该还原为1 ，keyword应该从请求参数中获取
            pageNo = 1;
            keyword = request.getParameter("keyword");
            if (StringUtil.isEmpty(keyword)) {
                keyword = "";
            }
            session.setAttribute("keyword", keyword);
        } else {
            //说明不是点击表单查询发送过来的请求（比如点击下面的上一页下一页或者直接在地址栏输入网址）
            //此时，keyword应该从session作用域获取
            String pageNoStr = request.getParameter("pageNo");
            if (StringUtil.isNotEmpty(pageNoStr)) {
                pageNo = Integer.parseInt(pageNoStr);
            }
            Object keywordObj = session.getAttribute("keyword");
            if (keywordObj == null) {
                keyword = "";
            } else {
                keyword = (String) keywordObj;
            }
        }

        int fruitCount = fruitService.getFruitCount(keyword);
        int pageCount = (fruitCount + 4) / 5;

        List<Fruit> fruitList = fruitService.listFruit(keyword, pageNo);
        session.setAttribute("fruitList", fruitList);
        session.setAttribute("pageNo", pageNo);
        session.setAttribute("pageCount", pageCount);

        super.processTemplate("index", request, response);
    }
}
