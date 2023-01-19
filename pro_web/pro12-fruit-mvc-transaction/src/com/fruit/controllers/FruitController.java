package com.fruit.controllers;

import com.fruit.domain.Fruit;
import com.fruit.service.FruitService;
import com.myssm.utils.StringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author LiJing
 * @version 1.0
 */

public class FruitController {
    private FruitService fruitService = null;

    //主页
    private String index(Integer pageNo, String oper, String keyword, HttpServletRequest request) {

        HttpSession session = request.getSession();
        if (pageNo == null) {
            pageNo = 1;
        }
        if (StringUtil.isNotEmpty(oper) && "search".equals(oper)) {
            //说明是点击表单查询发送过来的请求
            //此时，pageNo应该还原为1 ，keyword应该从请求参数中获取
            pageNo = 1;
            if (StringUtil.isEmpty(keyword)) {
                keyword = "";
            }
            session.setAttribute("keyword", keyword);
        } else {
            //说明不是点击表单查询发送过来的请求（比如点击下面的上一页下一页或者直接在地址栏输入网址）
            //此时，keyword应该从session作用域获取
            Object keywordObj = session.getAttribute("keyword");
            if (keywordObj == null) {
                keyword = "";
            } else {
                keyword = (String) keywordObj;
            }
        }

        int pageCount = fruitService.getPageCount(keyword);

        List<Fruit> fruitList = fruitService.getFruitList(keyword, pageNo);
        session.setAttribute("fruitList", fruitList);
        session.setAttribute("pageNo", pageNo);
        session.setAttribute("pageCount", pageCount);

//        super.processTemplate("index", request, response);
        return "index";
    }

    //添加新记录
    private String add(String fname, Integer price, Integer fcount, String remark) {
        fruitService.addFruit(fname, price, fcount, remark);

//        response.sendRedirect("fruit.do");
        return "redirect:fruit.do";
    }

    //删除记录
    private String del(Integer fid) {
        fruitService.delFruitById(fid);

        return "redirect:fruit.do";
    }

    //编辑记录
    private String edit(Integer fid, HttpServletRequest request) {
        Fruit fruit = fruitService.getFruitById(fid);
        request.setAttribute("fruit", fruit);

        return "edit";
    }

    //修改记录
    private String update(Integer fid, String fname, Integer price, Integer fcount, String remark) {
        fruitService.updateFruit(fname, price, fcount, remark, fid);

        return "redirect:fruit.do";
    }
}
