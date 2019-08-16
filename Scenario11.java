import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

class UserBean5{
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

public class Scenario11 {

	public static void main(String[] args) throws Exception {
		
		UserBean5 user= new UserBean5();
		user.setId("SS1007");
		user.setName("Swati");
		user.setPassword("ss1007");
		user.setStatus(0);
		user.setAttempts(0);
		user.setuserType("Employee");
		
		String []s=getNames();
		int i=-1;
		while(s[++i]!=null)
		{
			System.out.println(s[i]);
			
		}
		
	}
	public static String[] getNames() throws Exception{
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("select name from user");
			//ResultSet result = statement.executeQuery();
			ResultSet result2 = statement.executeQuery();
			ArrayList<String> array= new ArrayList<String>();
		
			while(result2.next())
			{
				array.add(result2.getString("name"));
			}
			
			String[]s= new String[array.size()];
			for(int i=0;i<array.size();i++)
			{
				s[i]=array.get(i).toString();
			}
			
		return s;	
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