package com.servlet;

import com.manager.AuthorManager;
import com.model.Author;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/authors")
public class AuthorsServlet extends HttpServlet {

    AuthorManager authorManager = new AuthorManager();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Author> authors = authorManager.getAll();
        req.setAttribute("authors", authors);
        req.getRequestDispatcher("WEB-INF/authors.jsp").forward(req, resp);
    }
}
