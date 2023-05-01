package com.servlet;

import com.manager.BookManager;
import com.manager.UserManager;
import com.model.Book;
import com.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/books")
public class BooksServlet extends HttpServlet {

    private BookManager bookManager = new BookManager();
    private UserManager userManager = new UserManager();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> all = bookManager.getAll();
        req.setAttribute("books", all);
        req.getRequestDispatcher("WEB-INF/books.jsp").forward(req, resp);
    }
}