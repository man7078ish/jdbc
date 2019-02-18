package jdbcProject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.cg.ems.util.dbutil;

public class TestUpdate {
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
			String updateQry="UPDATE emp1 SET emp_name=(?),emp_sal=(?) WHERE emp_id=(?)";
					
			
			PreparedStatement pst=con.
					prepareStatement(updateQry);
			pst.setInt(3, eid);
			pst.setString(1,enm);
			pst.setFloat(2, esal);
			int data=pst.executeUpdate();
			System.out.println("Data updated is"+data);
		} catch (SQLException | IOException e) {
			
			e.printStackTrace();
		}
}
}
