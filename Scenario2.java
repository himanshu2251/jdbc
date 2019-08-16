import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Scenario2 {

	public static void main(String[] args) throws Exception {
		String s =getIncorrectAttempts("RS1003");
		System.out.println(s);
	}
	public static String getIncorrectAttempts(String s) throws Exception{
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("select incorrectAttempts from user where userId='"+s + "'");
			ResultSet result= statement.executeQuery();
			int s1=-1;
			if(result.next()){
				   s1 = result.getShort(1);
				}
			if(s1==1)
			return "One Time";
			else if(s1==0)
				return "No Incorrect Attempts";
			else
				return "Incorrect Attempts exceeded";
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