package online.nigam.pocketpay;

import java.awt.JobAttributes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class UserRepository {
	List<User> users = null;
	Connection con;
	Gson gson;
	public UserRepository() {
		gson=new Gson();
		users = new ArrayList<User>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pocketpay", "root", "");
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from user");
			User user;
			while (resultSet.next()) {
				user = new User();
				user.setId(resultSet.getInt("Id"));
				user.setMobileNumber(resultSet.getString("MobileNumber"));
				user.setCity(resultSet.getString("City"));
				user.setPassword(resultSet.getString("Password"));
				user.setName(resultSet.getString("Name"));
				users.add(user);
			}
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
	public List<User> getUsers()
	{
		
		return  users ;
	}
	public String addUser(User user) {
		String Flag="false";
		try {
			PreparedStatement preparedStatement = con.prepareStatement("insert into user(MobileNumber,City,Password,Name) values(?,?,?,?)");
			preparedStatement.setString(1, user.getMobileNumber());
			preparedStatement.setString(2, user.getCity());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setString(4, user.getName());
			preparedStatement.executeUpdate();
			return Flag="true";
		} catch (SQLException e) {
			System.out.println("Error :"+e);
			return Flag="false";
		}
	}
	
	public User getUser() {
		User user=new User();
		user.setId(1);
		user.setName("nigaam");
		return user;
	}
	public String isAuthenticated(String mobileNumber, String password) {
		String Flag="false";
		for(User user :users)
		{
			if(user.getMobileNumber().equals(mobileNumber)&&user.getPassword().equals(password))
			{
				return Flag="true" ;
			}
		}
		return Flag="false";
		
	}
}
