package ch.hevs.businessobject;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

	private String country;
	private String city;
	private String postalCode;
	private String street;

	// constructors
	public Address() {
	}

	public Address(String country, String street, String city, String postalCode) {

		this.country = country;
		this.street = street;
		this.city = city;
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
}
