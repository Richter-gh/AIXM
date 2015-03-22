package com.aixm.parser;

public class AIXMParser {
	private String FileName=null;

	/**
	 * @return the fIleName
	 */
	public String getFileName() {
		return FileName;
	}

	/**
	 * @param fIleName the fIleName to set
	 */
	private void setFileName(String fileName) {
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
