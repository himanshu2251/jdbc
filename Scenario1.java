import java.sql.*;

public class Scenario1 {

	public static void main(String[] args) throws Exception {
		String s =getUserType("RS1003");
		System.out.println(s);
	}
	public static String getUserType(String s) throws Exception{
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("select userType from user where userId='"+s + "'");
			ResultSet result= statement.executeQuery();
			String s1=null;
			if(result.next()){
				   s1 = result.getString(1);
				}
			return s1;		
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