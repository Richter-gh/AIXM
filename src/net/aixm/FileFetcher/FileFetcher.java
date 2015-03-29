package net.aixm.FileFetcher;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileFetcher
{

	private static final String SAVE_DIR = "uploads";
	private ArrayList<String> filelist;

	public FileFetcher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			System.out.println("filefetcher working");
			ArrayList<String> files = new ArrayList<String>();
			String appPath = request.getServletContext().getRealPath("");
			File fileFolder = new File(appPath + File.separator + SAVE_DIR);
			for (File f : fileFolder.listFiles())
			{ 
				files.add(f.getName());
			}
			filelist = files;
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	public ArrayList<String> GetFiles()
	{
		return filelist == null ? null : filelist;
	}

}
