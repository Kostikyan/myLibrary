package com.servlet;

import com.manager.AuthorManager;
import com.model.Author;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addAuthor")
public class AddAuthorServlet extends HttpServlet {
    private AuthorManager authorManager = new AuthorManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/addAuthor.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        String age = req.getParameter("age");

        Author existsAuthorEmail = authorManager.getByEmail(email);
        if(existsAuthorEmail == null) {
            Author author = Author.builder()
                    .name(name)
                    .surname(surname)
                    .email(email)
                    .age(Integer.parseInt(age))
                    .build();

            authorManager.save(author);
            resp.sendRedirect("/authors");
        }else{
            resp.sendRedirect("/authors");
        }
    }
}
