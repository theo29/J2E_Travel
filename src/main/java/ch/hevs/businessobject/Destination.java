package ch.hevs.businessobject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;

//Each class is mapped to a separate table
//DestinationDeparture/DestinationArrival


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Destination {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String airportName;


	// Address
	@Embedded
	private Address address;

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Destination [airportName: " + airportName + "]";
	}

	// constructors
	protected Destination() {
	}

	public Destination(String airportName) {
		this.airportName = airportName;

	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}



}
