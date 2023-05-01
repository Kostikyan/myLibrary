package com.servlet;

import com.constants.ProfilePicturesConstant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet("/getImage")
public class GetImageServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String picName = req.getParameter("picName");
        File picture = new File(ProfilePicturesConstant.UPLOAD_FOLDER + picName);
        if(picture.exists()){
            try(FileInputStream fis = new FileInputStream(picture)){
                resp.setContentType("image/jpeg");
                resp.setContentLength((int) picture.length());
                OutputStream outStream = resp.getOutputStream();

                byte[] bytes = new byte[4096];
                int bytesRead = -1;

                while((bytesRead = fis.read(bytes)) != -1){
                    outStream.write(bytes, 0, bytesRead);
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }
}
