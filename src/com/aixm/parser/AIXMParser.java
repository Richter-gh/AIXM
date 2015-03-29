package com.aixm.parser;

public class AIXMParser
{
	private String FileName = null;

	public String getFileName()
	{
		return FileName;
	}

	private void setFileName(String fileName)
	{
		FileName = fileName;
	}

	public AIXMParser(String file)
	{
		this.setFileName(file);
	}

	public void Process()
	{

	}
}
