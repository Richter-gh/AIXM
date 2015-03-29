package net.aixm.FileUploadServlet;

import java.io.File;
import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.aixm.FileFetcher.FileFetcher;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/upload")
@MultipartConfig(fileSizeThreshold = 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50)
// 50MB
public class UploadServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	/**
	 * Name of the directory where uploaded files will be saved, relative to the
	 * web application directory.
	 */
	private static final String SAVE_DIR = "uploads";

	/**
	 * handles file upload
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		try
		{
			System.out.println("uploadservlet get getting files list");
			FileFetcher ftch = new FileFetcher(request, response);
			request.setAttribute("uploadedFiles", ftch.GetFiles());
			System.out.println("uploadservlet redirecting to main");
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// gets absolute path of the web application
		if (ServletFileUpload.isMultipartContent(request))
		{
			try
			{
				System.out.println("uploadservlet post");

				List<FileItem> multiparts = new ServletFileUpload(
						new DiskFileItemFactory()).parseRequest(request);

				for (FileItem item : multiparts)
				{
					if (!item.isFormField())
					{
						String name = new File(item.getName()).getName();
						String appPath = request.getServletContext()
								.getRealPath("");
						File fileSaveDir = new File(appPath + File.separator
								+ SAVE_DIR);
						if (!fileSaveDir.exists())
						{
							fileSaveDir.mkdir();
						}
						System.out.println("uploadservlet file saved");
						item.write(new File(fileSaveDir + File.separator + name));
					}
				}

				// File uploaded successfully
				request.setAttribute("message",
						"File Uploaded Successfully to "
								+ request.getServletContext().getRealPath(""));
			}
			catch (Exception ex)
			{
				request.setAttribute("message", "File Upload Failed due to "
						+ ex);
			}

		}
		else
		{
			request.setAttribute("message",
					"Sorry this Servlet only handles file upload request");
		}
		System.out.println("uploadservlet getting file list");
		FileFetcher ftch = new FileFetcher(request, response);
		request.setAttribute("uploadedFiles", ftch.GetFiles());
		System.out.println("uploadservlet redirecting to main");
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}

}