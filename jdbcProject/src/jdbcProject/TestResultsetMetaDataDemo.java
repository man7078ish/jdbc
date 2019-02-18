package jdbcProject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.cg.ems.util.dbutil;

public class TestResultsetMetaDataDemo {

	public static void main(String[] args) {
		try {
			Connection con=dbutil.getCon();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("SELECT * FROM emp1");
			ResultSetMetaData rsmd=rs.getMetaData();
			int colCount=rsmd.getColumnCount();
			System.out.println("no. of columns:"+colCount);
			for(int i=1;i<=colCount;i++)
			{
				System.out.println(i+": column Name:"+ rsmd.getColumnName(i)+"Column Type:"+rsmd.getColumnTypeName(i));
			}
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	

	}

}
