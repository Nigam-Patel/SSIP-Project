package online.nigam.pocketpay;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

@Path("users")
public class UserResource {
	UserRepository repo = new UserRepository();

	@GET
	@Consumes(MediaType.APPLICATION_XML)
	@Produces("application/json;charset=UTF-8")
	public List<User> getUsers() {
		return repo.getUsers();
		
	}
	
	@Path("user")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getUser(@QueryParam("mobilenumber") String MobileNumber,@QueryParam("password") String Password) {
		
		System.out.println(MobileNumber);
		System.out.println(Password);
		System.out.println(repo.isAuthenticated(MobileNumber, Password));
		JSONObject jsonObject =new JSONObject();
		String Status=repo.isAuthenticated(MobileNumber, Password);
		try {
			return jsonObject.put("Status",Status).toString();
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
		
		
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("create")
	public String addUser(@QueryParam("name") String Name,@QueryParam("city") String City,@QueryParam("mobilenumber") String MobileNumber,@QueryParam("password") String Password) {
		System.out.println(Name+"-"+City+"-"+MobileNumber+"-"+Password);
		User user=new User();
		user.setName(Name);
		user.setCity(City);
		user.setMobileNumber(MobileNumber);
		user.setPassword(Password);
		
		
		JSONObject jsonObject =new JSONObject();
		String Status=repo.addUser(user);
		try {
			return jsonObject.put("Status",Status).toString();
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
	}
}
