import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Scenario4 {

	public static void main(String[] args) throws Exception {
		int s =getLockStatus();
		System.out.println(s);
	}
	public static int getLockStatus() throws Exception{
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("select count(*) from user where lockStatus=0");
			ResultSet result= statement.executeQuery();
			int s1=-1;
			if(result.next()){
				   s1 = result.getShort(1);
				}
			return s1;
		}catch (Exception e) {
			System.out.println(e);
		}
		return 0;
		
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