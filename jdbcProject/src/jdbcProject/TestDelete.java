package jdbcProject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.cg.ems.util.dbutil;

public class TestDelete {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("enter empId");
		int eid=s.nextInt();
		try {
			Connection con=dbutil.getCon();
			String insertQry="DELETE FROM emp1 WHERE emp_id=(?)";
					
			System.out.println("con..."+con);
			PreparedStatement pst=con.
					prepareStatement(insertQry);
			pst.setInt(1, eid);
			
			int data=pst.executeUpdate();
			System.out.println("Data deleted is"+data);
		} catch (SQLException | IOException e) {
			
			e.printStackTrace();
		}

	}
}
