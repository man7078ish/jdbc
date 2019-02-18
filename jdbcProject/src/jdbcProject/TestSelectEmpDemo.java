package jdbcProject;
import java.sql.*;
public class TestSelectEmpDemo {
	public static void main(String[] args)
	{
		Connection con=null;
		Statement st=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",
					"system",
					"Capgemini123");
			st=con.createStatement();
			ResultSet rs=st.executeQuery("SELECT * FROM emp1");
			System.out.println("ID\t\tNAME\t\tSALARY\t\tDOJ");
			while(rs.next())
			{
				System.out.println(rs.getInt("emp_id")+
						"\t\t"+rs.getString("emp_name")+
						"\t\t"+rs.getLong("emp_sal")+
						"\t\t"+rs.getDate("emp_doj"));
			}
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	

}
