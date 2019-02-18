package jdbcProject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.cg.ems.util.dbutil;

public class TestTransactionDemo {

	public static void main(String[] args) {
		Connection con=null;
		try {
			con=dbutil.getCon();
			con.setAutoCommit(false);
			String update1="UPDATE emp1 set emp_name='VaishaliS' where emp_id=111";
			String update2="UPDATE emp1 set emp_sal=3000,emp_name='varsha' where emp_id=666";
			Statement st=con.createStatement();
			st.addBatch(update1);
			st.addBatch(update2);
			int arr[]=st.executeBatch();
			con.commit();
			System.out.println("updated");
		} catch (SQLException | IOException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

	}

}
