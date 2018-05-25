package ch.hevs.businessobject;

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

	// relations
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(nullable = false)
	private Passenger fkPassenger;

	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(nullable = false)
	private Flight fkFlight;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Booking(Passenger fkPassenger, Flight fkFlight) {
		this.fkFlight = fkFlight;
		this.fkPassenger = fkPassenger;

	}
}
