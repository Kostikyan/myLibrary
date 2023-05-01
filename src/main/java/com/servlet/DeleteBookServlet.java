package com.servlet;

import com.constants.ProfilePicturesConstant;
import com.manager.AuthorManager;
import com.manager.BookManager;
import com.model.Author;
import com.model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet("/deleteBook")
public class DeleteBookServlet extends HttpServlet {
    private BookManager bookManager = new BookManager();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Book book = bookManager.getById(id);
        if(book != null){
            File file = new File(ProfilePicturesConstant.UPLOAD_FOLDER + book.getPicName());
            if (file.exists()) {
                file.delete();
            }
            bookManager.removeById(id);
        }
        resp.sendRedirect("/books");
    }
}
