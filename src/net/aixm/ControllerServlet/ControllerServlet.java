package net.aixm.ControllerServlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet(urlPatterns="/",loadOnStartup = 1)
public class ControllerServlet extends HttpServlet {

    private static final String SAVE_DIR = "uploads";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        try {
        	System.out.println("constrollerservlet");
        	ArrayList files = new ArrayList();
            String appPath = request.getServletContext().getRealPath("");                       
            File fileFolder = new File(appPath+ File.separator+ SAVE_DIR);
        	
        	response.setContentType("application/json");
        	response.setCharacterEncoding("UTF-8");
        	//files.add(fileFolder);

            for (File f : fileFolder.listFiles()) { // Line 27
                files.add(f.getName());
                System.out.println(f.getName());
            }
            request.setAttribute("uploadedFiles",files);
            request.setAttribute("uploadDir",fileFolder);

        	request.getRequestDispatcher("/main.jsp").forward(request, response);

        	
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

    	try {

            request.getRequestDispatcher("/main.jsp").forward(request, response);
         } catch (Exception ex) {
             ex.printStackTrace();
         }
    }

}