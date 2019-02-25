package online.nigam.pocketpay;

import javax.xml.bind.annotation.XmlRootElement;


public class User {
	private int Id;
	private String Name;
	private String MobileNumber;
	private String City;
	private String Password;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getMobileNumber() {
		return MobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		MobileNumber = mobileNumber;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	@Override
	public String toString() {
		return "User [Id=" + Id + ", MobileNumber=" + MobileNumber + ", City=" + City + ", Password=" + Password + "]";
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	
}
