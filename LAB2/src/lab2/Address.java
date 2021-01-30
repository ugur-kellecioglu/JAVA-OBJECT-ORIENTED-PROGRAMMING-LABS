package lab2;

public class Address {

	
	
	// Variables
	private String street;
	private String city;
	private String postCode;
	private String country;
	
	// constructor
	public Address(String street, String city, String postCode, String country) {
		this.street = street;
		this.city = city;
		this.postCode = postCode;
		this.country = country;
	}

	//GETTERS AND SETTERS
	
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

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	// to string method 
	
	public String toString() {
		return this.street + ", " + this.city + ", " + this.country + ", (" + this.postCode + ")";
	}
	
}
