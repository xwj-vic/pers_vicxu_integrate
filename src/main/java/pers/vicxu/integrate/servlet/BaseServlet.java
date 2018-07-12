package pers.vicxu.integrate.servlet;

import pers.vicxu.integrate.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Create by Vic Xu on 2018/7/12
 */
public class BaseServlet extends HttpServlet {

    private static final long serialVersionUID = -1039532634712700555L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        invoke(req, resp);
    }

    private void invoke(HttpServletRequest req, HttpServletResponse resp) {
        Class<?> c = this.getClass();
        String method = req.getParameter("method");
        Method[] methods = c.getDeclaredMethods();
        for (Method m : methods) {
            if (m.isAnnotationPresent(RequestMethod.class)) {
                RequestMethod annotation = m.getAnnotation(RequestMethod.class);
                if (annotation.mathod().equals(method)) {
                    try {
                        m.invoke(this, req, resp);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        }
    }
}
