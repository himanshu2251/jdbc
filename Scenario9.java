import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

class UserBean3{
	String userId;
	String password;
	String name;
	int incorrectAttempts;
	int lockStatus;
	String userType;
	
	public void setId(String userId)
	{
		this.userId= userId;
	}
	
	public String getId()
	{
		return userId;
	}
	
	public void setPassword(String password)
	{
		this.password= password;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setName(String name)
	{
		this.name= name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setAttempts(int incorrectAttempts)
	{
		this.incorrectAttempts= incorrectAttempts;
	}
	
	public int getAttempts()
	{
		return incorrectAttempts;
	}
	
	public void setStatus(int lockStatus)
	{
		this.lockStatus= lockStatus;
	}
	
	public int getStatus()
	{
		return lockStatus;
	}
	
	public void setuserType(String userType)
	{
		this.userType= userType;
	}
	
	public String getuserType()
	{
		return userType;
	}
}

public class Scenario9 {

	public static void main(String[] args) throws Exception {
		
		UserBean3 user= new UserBean3();
		user.setId("SS1007");
		user.setName("Swati");
		user.setPassword("ss1007");
		user.setStatus(0);
		user.setAttempts(0);
		user.setuserType("Employee");
		
		getUsers("Employee");
		//System.out.println(s);
	}
	public static ArrayList<UserBean3> getUsers(String userType) throws Exception{
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("select * from user where userType='"+userType+"'");
			ResultSet result = statement.executeQuery();
			//ArrayList<UserBean3> array= new ArrayList<UserBean3>();
			
			while(result.next())
			{
				System.out.print(result.getString("userId"));
				System.out.print(" ");
				System.out.print(result.getString("name"));
				System.out.print(" ");
				System.out.print(result.getString("password"));
				System.out.print(" ");
				System.out.print(result.getString("lockStatus"));
				System.out.print(" ");
				System.out.print(result.getString("userType"));
				System.out.print(" ");
				System.out.print(result.getString("incorrectAttempts"));
				System.out.println(" ");
				
			}
			
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