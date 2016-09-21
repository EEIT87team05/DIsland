package _00_init;

import javax.servlet.http.Part;

public class GlobalService
{
	public static final int    RECORDS_PER_PAGE = 4;
	public static final String host = "127.0.0.1";
	public static final String USERID = "sa";
	public static final String PASSWORD = "sa123456";
	public static final String JNDI_DB_NAME = "java:comp/env/jdbc/disland";
	public static final int IMAGE_FILENAME_LENGTH = 20;
	public static final String DB_URL = "jdbc:sqlserver://" + GlobalService.host + ":1433;databaseName=JSPDB" ;	
	public static final String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public static final String SYSTEM_NAME = "D_Island 購物商城";
	
	public static String adjustFileName(String fileName, int maxLength) {
		  int length = fileName.length();
		  if ( length <= maxLength ) {
			  return fileName ;
		  }
	  int n      = fileName.lastIndexOf(".");
      int sub    = fileName.length() - n - 1;
      fileName = fileName.substring(0, maxLength-1-sub) + "." 
                   + fileName.substring(n+1); 
		return fileName;
	}
	public static String getFileName(final Part part) {
		for (String content : part.getHeader("content-disposition").split(";")) {
			//System.out.println(content);
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim()
						.replace("\"", "");
			}
		}
		return null;
		}
	
	public String getSystemName() {   //  systemName 
		
		return SYSTEM_NAME;
	}
	

}
