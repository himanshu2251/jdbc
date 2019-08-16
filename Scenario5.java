import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Scenario5 {

	public static void main(String[] args) throws Exception {
		String s=getIncorrectAttempts("RS1003");
		System.out.println(s);
	}
	public static String getIncorrectAttempts(String s) throws Exception{
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("update user set name = 'Himanshu' where userId='"+s + "'");
			int result= statement.executeUpdate();
			if(result==1)
				return "Success";
			else
				return "Failed";
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