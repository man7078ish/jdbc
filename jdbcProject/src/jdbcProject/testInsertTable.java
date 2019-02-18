package jdbcProject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.cg.ems.util.dbutil;

public class testInsertTable {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("enter empId");
		int eid=s.nextInt();
		s.nextLine();
		System.out.println("enter empname");
		String enm=s.nextLine();
		System.out.println("enter salary");
		float esal=s.nextFloat();
		try {
			Connection con=dbutil.getCon();
			String insertQry="INSERT INTO emp1"
					+ "(emp_id,emp_name,emp_sal)"+
			"VALUES(?,?,?)";
			System.out.println("con..."+con);
			PreparedStatement pst=con.
					prepareStatement(insertQry);
			pst.setInt(1, eid);
			pst.setString(2,enm);
			pst.setFloat(3, esal);
			int data=pst.executeUpdate();
			System.out.println("Data inserted is"+data);
		} catch (SQLException | IOException e) {
			
			e.printStackTrace();
		}

	}

}
