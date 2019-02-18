package com.cg.ems.util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;


public class dbutil {
	private static String url=null;
	private static String userName=null;
	private static String password=null;
	private static Connection con=null;
	private static String driver=null;
	public static Connection getCon() throws SQLException, IOException
	{
		Properties myProps=getProps();
		url=myProps.getProperty("dburl");
		userName=myProps.getProperty("dbunm");
		password=myProps.getProperty("dbpwd");
		if(con==null)
		{
			 con=DriverManager.getConnection(url, userName, password);

		}
		return con;
	}
	public static Properties getProps() throws IOException
	{
		Properties dbProps=new Properties();
		FileReader fr=new FileReader("dbinfo.properties");
		dbProps.load(fr);
		return dbProps;
	}
}
