package resources;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.sql.*;
import java.io.Serializable;

@Named(value = "addressRegistration")
@SessionScoped
public class AddressRegistrationJSFBean implements Serializable {
	private String lastName;
	private String firstName;
	private String mi;
	private String telephone;
	private String email;
	private String street;
	private String city;
	private String state;
	private String zip;
	private String status = "Nothing stored";
	// Use a prepared statement to store a student into the database
	private PreparedStatement pstmt;

	public AddressRegistrationJSFBean() {
		initializeJdbc();
	}

	private void initializeJdbc() {
		// TODO Auto-generated method stub
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMi() {
		return mi;
	}

	public void setMi(String mi) {
		this.mi = mi;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isRequiredFieldsFilled() {
		return !(lastName == null || firstName == null 
				|| lastName.trim().length() == 0 
				|| firstName.trim().length() == 0);
	}
	
	public String processSubmit() {
		if (isRequiredFieldsFilled())
			return "ConfirmAddress";
		else
		return "";
	}
	
	public String getRequiredFields() {
		if (isRequiredFieldsFilled())
			return "";
		else
			return "Last Name and First Name are required";
	}
	
	
}