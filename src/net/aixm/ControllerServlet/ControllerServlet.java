package net.aixm.ControllerServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.aixm.FileFetcher.*;

@WebServlet(urlPatterns={"/","/display"},loadOnStartup = 1)
public class ControllerServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        try 
        {
        	System.out.println("constrollerservlet getting files list");
        	FileFetcher ftch= new FileFetcher(request,response);
            request.setAttribute("uploadedFiles",ftch.GetFiles());
            System.out.println("constrollerservlet redirecting to main");
        	request.getRequestDispatcher("main.jsp").forward(request, response);
        }	
        catch (Exception ex) 
        {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
    	try 
    	{
    		System.out.println("constrollerservlet post getting files list");
        	FileFetcher ftch= new FileFetcher(request,response);
            request.setAttribute("uploadedFiles",ftch.GetFiles());
            System.out.println("constrollerservlet post redirecting to main");
            request.getRequestDispatcher("main.jsp").forward(request, response);
         } 
    	catch (Exception ex) 
    	{
             ex.printStackTrace();
         }
    }

}