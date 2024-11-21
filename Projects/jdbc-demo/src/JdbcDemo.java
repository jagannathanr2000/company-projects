import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo {

	private static  String url = "jdbc:mysql://localhost:3306/demodb";
	private static  String username = "root";
	private static  String password = "root";
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=null;
		try {
			con = DriverManager.getConnection(url,username,password);
			System.out.println("Connected...");
			
			
			
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Error in connecting...");
		}
		
		
		
		if(con != null) {
			Statement st = con.createStatement();
			int row = st.executeUpdate("UPDATE dept SET dname='DEVELOPMENT' WHERE deptno=10");
			if(row > 0) {
				System.out.println("Record updated...");
			} else {
				System.out.println("No changes...");
			}
		}
		
		
//		if(con != null) {
//			Statement st = con.createStatement();
//			int row = st.executeUpdate("INSERT INTO DEPT VALUES(50,'ACCOUNTS','CALIFORNIA');");
//			if(row > 0) {
//				System.out.println("Record inserted");
//			} else {
//				System.out.println("Record not inserted");
//			}
//		}
		
		
		if(con != null) {
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT * FROM dept;");
			
			while(rs.next()) {
				System.out.println(" DEPT NO-"+rs.getInt(1)+" DEPT NAME-"+rs.getString(2)+" Location-"+rs.getString(3));
				
			}
			
					
		}
		
		
//		if(con != null) {
//			PreparedStatement st = con.prepareStatement("INSERT INTO DEPT VALUES(?,?,?);");
//			st.setInt(1,60);
//			st.setString(2,"ABC");
//			st.setString(3,"XYZ");
//			int row = st.executeUpdate();
//			if(row > 0) {
//				System.out.println("Record inserted");
//			} else {
//				System.out.println("Record not inserted");
//			}
//		
//		
//	}
		
		
		if(con != null) {
			PreparedStatement ps = con.prepareStatement("UPDATE dept SET dname=? WHERE deptno=?");
			ps.setString(1,"YYY");
			ps.setInt(2,60);
			int row = ps.executeUpdate();
			if(row > 0) {
				System.out.println("Record updated...");
			} else {
				System.out.println("No changes...");
			}
		}

}
}
