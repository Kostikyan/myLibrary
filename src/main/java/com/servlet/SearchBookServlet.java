package com.servlet;

import com.manager.BookManager;
import com.model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/searchBook")
public class SearchBookServlet extends HttpServlet {
    private BookManager bookManager = new BookManager();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String searchText = req.getParameter("searchText");
        List<Book> searched = bookManager.search(searchText);
        req.setAttribute("bookList", searched);
        req.getRequestDispatcher("WEB-INF/searchBook.jsp").forward(req, resp);
    }

}
