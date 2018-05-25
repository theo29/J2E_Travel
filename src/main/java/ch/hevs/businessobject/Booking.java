package ch.hevs.businessobject;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Booking")
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String bookingDate;

	// relations
	@ManyToOne(cascade = CascadeType.REMOVE)
	private Passenger fkPassenger;

	@ManyToOne(cascade = CascadeType.REMOVE)
	private Flight fkFlight;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Passenger getFkPassenger() {
		return fkPassenger;
	}

	public void setFkPassenger(Passenger fkPassenger) {
		this.fkPassenger = fkPassenger;
	}

	public Flight getFkFlight() {
		return fkFlight;
	}

	public void setFkFlight(Flight fkFlight) {
		this.fkFlight = fkFlight;
	}

	// constructors
	public Booking() {
	}

	public Booking(String date, Passenger fkPassenger, Flight fkFlight) {
		this.bookingDate = date;
		this.fkFlight = fkFlight;
		this.fkPassenger = fkPassenger;
	}
}
