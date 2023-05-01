package com.servlet;

import com.constants.ProfilePicturesConstant;
import com.manager.AuthorManager;
import com.manager.BookManager;
import com.manager.UserManager;
import com.model.Author;
import com.model.Book;
import com.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.List;

@WebServlet("/editBook")
@MultipartConfig(
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 10,
        fileSizeThreshold = 1024 * 1024 * 1
)
public class EditBookServlet extends HttpServlet {
    private BookManager bookManager = new BookManager();
    private AuthorManager authorManager = new AuthorManager();
    private UserManager userManager = new UserManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Book book = bookManager.getById(id);
        List<Author> allAuthors = authorManager.getAll();
        req.setAttribute("allAuthors", allAuthors);
        req.setAttribute("book", book);
        req.getRequestDispatcher("WEB-INF/editBook.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        int userId = (int) req.getSession().getAttribute("userId");
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        String price = req.getParameter("price");
        int authorId = Integer.parseInt(req.getParameter("authorId"));
        Author author = authorManager.getById(authorId);
        User user = userManager.getById(userId);

        Part picture = req.getPart("picture");
        String picName = null;
        if (picture != null && picture.getSize() > 0) {
            picName = System.nanoTime() + "_" + picture.getSubmittedFileName();
            picture.write(ProfilePicturesConstant.UPLOAD_FOLDER + picName);
        }

        Book book = new Book(id, picName, title, description, Integer.parseInt(price), author, user);
        bookManager.update(book);
        resp.sendRedirect("/books");

    }
}