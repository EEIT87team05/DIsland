package _00_init;

public class GlobalService
{
	public static final int    RECORDS_PER_PAGE = 3;
	public static final String host = "127.0.0.1";
	public static final String USERID = "sa";
	public static final String PASSWORD = "sa123456";
	public static final String JNDI_DB_NAME = "java:comp/env/jdbc/D_island";
	public static final int IMAGE_FILENAME_LENGTH = 20;
	public static final String DB_URL = "jdbc:sqlserver://" + GlobalService.host + ":1433;databaseName=JSPDB" ;	
	public static final String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	
	

}
