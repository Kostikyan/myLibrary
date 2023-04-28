package com.servlet;

import com.manager.AuthorManager;
import com.manager.BookManager;
import com.model.Author;
import com.model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/editBook")
public class EditBookServlet extends HttpServlet {
    private BookManager bookManager = new BookManager();
    private AuthorManager authorManager = new AuthorManager();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Book book = bookManager.getById(id);
        List<Author> allAuthors = authorManager.getAll();
        req.setAttribute("allAuthors", allAuthors);
        req.setAttribute("book", book);
        req.getRequestDispatcher("WEB-INF/editBook.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        String price = req.getParameter("price");
        int authorId = Integer.parseInt(req.getParameter("authorId"));
        Author author = authorManager.getById(authorId);
        Book book = new Book(id, title, description, Integer.parseInt(price), author);
        bookManager.update(book);
        resp.sendRedirect("/books");

    }
}