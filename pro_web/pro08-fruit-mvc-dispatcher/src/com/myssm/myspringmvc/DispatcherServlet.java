package com.myssm.myspringmvc;

import com.myssm.utils.StringUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author LiJing
 * @version 1.0
 */
@WebServlet("*.do")
public class DispatcherServlet extends ViewBaseServlet {
    private Map<String, Object> beanMap = new HashMap<>();

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("applicationContext.xml");
            //1.创建DocumentBuilderFactory
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            //2.创建DocumentBuilder对象
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            //3.创建Document对象
            Document document = documentBuilder.parse(inputStream);
            //4.获取所有的bean节点
            NodeList beanNodeList = document.getElementsByTagName("bean");
            for (int i = 0; i < beanNodeList.getLength(); i++) {
                Node beanNode = beanNodeList.item(i);
                if (beanNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element beanElement = (Element) beanNode;
                    String beanId = beanElement.getAttribute("id");
                    String className = beanElement.getAttribute("class");
                    Class beanClazz = Class.forName(className);
                    Object beanObj = beanClazz.newInstance();
                    beanMap.put(beanId, beanObj);
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //设置编码
        request.setCharacterEncoding("UTF-8");

        //假设url是：http://localhost:8080/pro08/hello.do
        //那么servletPath是：/hello.do
        // 第1步： /hello.do -> hello   或者  /fruit.do  -> fruit
        // 第2步： hello -> HelloController 或者 fruit -> FruitController
        String servletPath = request.getServletPath();
        servletPath = servletPath.substring(1);
        int lastDotIndex = servletPath.lastIndexOf(".do");
        servletPath = servletPath.substring(0, lastDotIndex);

        //定位到controller
        Object controllerObj = beanMap.get(servletPath);

        //定位到controller中的方法
        String operate = request.getParameter("operate");
        if (StringUtil.isEmpty(operate)) {
            operate = "index";
        }
        Method[] methods = controllerObj.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (operate.equals(method.getName())) {
                //1.统一获取请求参数
                //获取当前方法的形参
                Parameter[] parameters = method.getParameters();
                //parameterValues 用来承载参数的值
                Object[] parameterValues = new Object[parameters.length];
                for (int i = 0; i < parameters.length; i++) {
                    Parameter parameter = parameters[i];
                    String parameterName = parameter.getName();//形参名称
                    String parameterType = parameter.getType().getName();//形参类型

                    //如果形参名是request,response,session 则不是从请求中获取参数值
                    if ("request".equals(parameterName)) {
                        parameterValues[i] = request;
                    } else if ("response".equals(parameterName)) {
                        parameterValues[i] = response;
                    } else if ("session".equals(parameterName)) {
                        parameterValues[i] = request.getSession();
                    } else {
                        //从请求中获取参数值
                        String parameterValueStr = request.getParameter(parameterName);
                        Object parameterValueObj = parameterValueStr;
                        if (parameterValueObj != null) {
                            if ("java.lang.Integer".equals(parameterType)) {
                                parameterValueObj = Integer.parseInt(parameterValueStr);
                            }
                        }
                        parameterValues[i] = parameterValueObj;
                    }
                }
                //2.controller组件中的方法调用
                method.setAccessible(true);
                Object methodReturnObj = null;
                try {
                    methodReturnObj = method.invoke(controllerObj, parameterValues);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                //3.视图处理
                String methodReturnStr = (String) methodReturnObj;
                if (methodReturnStr.startsWith("redirect:")) {//比如：redirect:fruit.do
                    String redirectStr = methodReturnStr.substring("redirect:".length());
                    response.sendRedirect(redirectStr);
                } else {// 比如："edit"
                    super.processTemplate(methodReturnStr, request, response);
                }
                return;
            }
        }

    }
}
