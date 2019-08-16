import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

class UserBean{
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

public class Scenario7 {

	public static void main(String[] args) throws Exception {
		
		UserBean user= new UserBean();
		user.setId("HG1007");
		user.setName("Harsh");
		user.setPassword("hg1007");
		user.setStatus(1);
		user.setAttempts(0);
		user.setuserType("Admin");
		
		String s=addUser(user);
		System.out.println(s);
	}
	public static String addUser(UserBean bean) throws Exception{
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("insert into user (userId,password,name,incorrectAttempts,lockStatus,userType) values ('"+bean.getId()+"','"+bean.getPassword()+"','"+bean.getName()+"','"+bean.getAttempts()+"','"+bean.getStatus()+"','"+bean.getuserType()+"')");
			int result= statement.executeUpdate();
			if(result==1)
				return "Success";
			else
				return "Fail";
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