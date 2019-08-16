import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Scenario6 {

	public static void main(String[] args) throws Exception {
		String s=changePassword("rs1007");
		System.out.println(s);
	}
	public static String changePassword(String password) throws Exception{
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("update user set password = 'RS1008' where password='"+password + "'");
			int result= statement.executeUpdate();
			if(result==1)
				return "Password changed";
			else
				return "Not Changed";
		}catch (Exception e) {
			System.out.println(e);
		}
		return null;
		
	}
	
	public static Connection getConnection()throws Exception{
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url="jdbc:mysql://localhost:3306/himanshu";
			String username="root";
			String password="root";
			Class.forName(driver);
			//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Connection conn= DriverManager.getConnection(url, username, password);
			System.out.println("connected");
			return conn;
		}catch(Exception e) {
			System.out.println(e);
		}
	return null;
	}
	}