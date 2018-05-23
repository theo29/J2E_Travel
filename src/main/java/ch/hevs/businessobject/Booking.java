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
	private Date date;

	// relations
    @ManyToOne
	@JoinColumn(name = "FK_PASSENGER")
	private Passenger owner;
	
	@ManyToOne
	@JoinColumn(name = "FK_FLIGHT")
	private Flight fkFlight;
	
	
	// constructors
	public Booking() {
	}

	public Booking(Date date) {

		this.date = date;
	}
}
