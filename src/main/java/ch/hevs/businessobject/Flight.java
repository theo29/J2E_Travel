package ch.hevs.businessobject;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Flight")

public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	@Column(name = "airCompany")
	private String airCompany;

	@Column(name = "flightNumber")
	private String flightNumber;

	@Column(name = "departureTime")
	private double departureTime;

	@Column(name = "arrivalTime")
	private double arrivalTime;

	@Column(name = "duration")
	private double duration;

	// relations
	/* cascade = CascadeType.REMOVE
	 * When flight is deleted, its destination departure/arrival
	 * must also be deleted
	 */
	@ManyToOne(cascade = CascadeType.REMOVE)
	private DestinationDeparture fkDestinationDeparture;

	@ManyToOne(cascade = CascadeType.REMOVE)
	private DestinationArrival fkDestinationArrival;


	
	// constructors
	public Flight() {
	}

	public Flight(String airCompany, String flightNumber, double departureTime, double arrivalTime, double duration,
			DestinationDeparture fkDestinationDeparture, DestinationArrival fkDestinationArrival) {
		this.flightNumber = flightNumber;
		this.duration = duration;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.airCompany = airCompany;
		this.fkDestinationDeparture = fkDestinationDeparture;
		this.fkDestinationArrival = fkDestinationArrival;
	}

}
