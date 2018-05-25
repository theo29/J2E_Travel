package ch.hevs.businessobject;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.mapping.Array;

@Entity
@Table(name = "Passenger")
public class Passenger {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	@Column(name = "lastname")
	private String lastname;
	@Column(name = "firstname")
	private String firstname;

	// relations
	@OneToMany(mappedBy = "fkPassenger", cascade = CascadeType.ALL)//@JoinColumn(name = "FK_PASSENGER")
	private List<Booking> bookings;

	// constructors
	public Passenger() {
	}

	public Passenger(String firstname, String lastname) {
		this.lastname = lastname;
		this.firstname = firstname;
		//instatiation - to be able to make add booking
		bookings = new ArrayList<Booking>();
		
	}

	
	// Getters&Setters
	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Passenger [lastname: " + lastname + ", firstname: " + firstname + "]";
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	//relation booking - passenger
	public void addBooking(Booking b) {
		this.bookings.add(b);
		b.setFkPassenger(this);
	}

}
