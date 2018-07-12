package pers.vicxu.integrate.servlet;

import pers.vicxu.integrate.annotation.RequestMethod;
import pers.vicxu.integrate.pojo.Book;
import pers.vicxu.integrate.util.PojoParamUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Create by BookServlet on 7/12/2018
 */
public class BookServlet extends BaseServlet {

    private static final long serialVersionUID = 2418927940460181098L;

    @RequestMethod(mathod = "query")
    public void query(HttpServletRequest req, HttpServletResponse resp) {
        Book book = PojoParamUtil.getObject(req, Book.class);
        System.out.println(book.toString());
    }

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Book book = PojoParamUtil.getObject(req, Book.class);
//        System.out.println(book.toString());
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Book book = PojoParamUtil.getObject(req, Book.class);
//        System.out.println("输出:" + book.toString());
//    }
}
