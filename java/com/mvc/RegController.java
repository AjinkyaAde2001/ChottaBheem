package com.mvc;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/RegController")
public class RegController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RegController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String name = request.getParameter("name");
//        String email = request.getParameter("email");
//        String password = request.getParameter("password");
//        String mob = request.getParameter("mob");
//        String dob = request.getParameter("dob");
//        String[] course = request.getParameterValues("course");
//
//        String c = "";
//        if (course != null) {
//            for (int i = 0; i < course.length; i++) {
//                c = c + course[i] + " ";
//            }
//        }
//
//        String gender = request.getParameter("gender");
//        String address = request.getParameter("address");
//        String country = request.getParameter("country");
//
//        String region = request.getParameter("region");
//        String pinst = request.getParameter("pin");
//        int pin = 0;
//
//        try {
//            pin = Integer.parseInt(pinst);
//        } catch (NumberFormatException e) {
//            // Handle the case where 'pin' is not a valid integer
//            e.printStackTrace();
//        }
//
//        RegModel rm = new RegModel();
//
//        rm.setName(name);
//        rm.setEmail(email);
//        rm.setPassword(password);
//        rm.setMob(mob);
//        rm.setDob(dob);
//        rm.setCourse(c);
//        rm.setGender(gender);
//        rm.setAddress(address);
//        rm.setCountry(country);
//
//        rm.setRegion(region);
//        rm.setPin(pin);
//
//        int status = MainDao.save(rm);
//
//        if (status > 0) {
//            HttpSession session = request.getSession();
//            session.setAttribute("sesreg", "success");
//            response.sendRedirect("login.jsp");
//        }
//        
        try {
            if (!ServletFileUpload.isMultipartContent(request)) {
                response.getWriter().println("Error: Form must have enctype=multipart/form-data.");
                return;
            }

            // Directory to save uploaded files
            String uploadPath = "D:\\upload"; // Change this path as needed

            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            // File upload logic
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            List<FileItem> formItems = upload.parseRequest(request);

            for (FileItem item : formItems) {
                if (!item.isFormField()) { // Process only file fields
                    String fileName = new File(item.getName()).getName();
                    File file = new File(uploadPath + File.separator + fileName);
                    
                    try (InputStream input = item.getInputStream();
                         FileOutputStream output = new FileOutputStream(file)) {
                        byte[] buffer = new byte[1024];
                        int bytesRead;
                        while ((bytesRead = input.read(buffer)) != -1) {
                            output.write(buffer, 0, bytesRead);
                        }
                    }

                    response.getWriter().println("File uploaded successfully: " + fileName);
                }
            }
        } catch (Exception ex) {
            response.getWriter().println("Error: " + ex.getMessage());
        }
        
        
    }
    
}
