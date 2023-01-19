package com.servlets;

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
@WebServlet("/fruit.do")
public class FruitServlet extends ViewBaseServlet {
    private FruitService fruitService = new FruitService();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String operate = request.getParameter("operate");
        if (StringUtil.isEmpty(operate)) {
            operate = "index";
        }
        switch (operate) {
            case "index":
                index(request, response);
                break;
            case "add":
                add(request, response);
                break;
            case "del":
                del(request, response);
                break;
            case "edit":
                edit(request, response);
                break;
            case "update":
                update(request, response);
                break;
            default:
                throw new RuntimeException("operate值非法!");
        }
    }

    //主页
    private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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

        List<Fruit> fruitList = fruitService.getFruitList(keyword, pageNo);
        session.setAttribute("fruitList", fruitList);
        session.setAttribute("pageNo", pageNo);
        session.setAttribute("pageCount", pageCount);

        super.processTemplate("index", request, response);
    }

    //添加新记录
    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fname = request.getParameter("fname");
        String priceStr = request.getParameter("price");
        int price = Integer.parseInt(priceStr);
        String fcountStr = request.getParameter("fcount");
        int fcount = Integer.parseInt(fcountStr);
        String remark = request.getParameter("remark");

        fruitService.addFruit(fname, price, fcount, remark);

        response.sendRedirect("fruit.do");
    }

    //删除记录
    private void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fidStr = request.getParameter("fid");
        int fid = Integer.parseInt(fidStr);

        fruitService.delFruitById(fid);

        response.sendRedirect("fruit.do");
    }

    //编辑记录
    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fidStr = request.getParameter("fid");
        int fid = Integer.parseInt(fidStr);

        Fruit fruit = fruitService.getFruitById(fid);
        request.setAttribute("fruit", fruit);

        super.processTemplate("edit", request, response);
    }

    //修改记录
    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数
        String fidStr = request.getParameter("fid");
        int fid = Integer.parseInt(fidStr);
        String fname = request.getParameter("fname");
        String priceStr = request.getParameter("price");
        int price = Integer.parseInt(priceStr);
        String fcountStr = request.getParameter("fcount");
        int fcount = Integer.parseInt(fcountStr);
        String remark = request.getParameter("remark");

        //执行更新
        fruitService.updateFruit(fname, price, fcount, remark, fid);

        //资源跳转
        //super.processTemplate("index",request,response);
        //request.getRequestDispatcher("index.html").forward(request,response);
        //此处需要重定向，目的是重新给IndexServlet发请求，重新获取furitList，然后覆盖到session中，
        //这样index.html页面上显示的session中的数据才是最新的
        response.sendRedirect("fruit.do");
    }
}
