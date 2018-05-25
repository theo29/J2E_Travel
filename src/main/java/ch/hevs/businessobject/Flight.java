package ch.hevs.businessobject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	
	@Column(name = "flightDate")
	private String flightDate;

	
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


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAirCompany() {
		return airCompany;
	}

	public void setAirCompany(String airCompany) {
		this.airCompany = airCompany;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}



	public String getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(String flightDate) {
		this.flightDate = flightDate;
	}

	public double getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(double departureTime) {
		this.departureTime = departureTime;
	}

	public double getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(double arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public DestinationDeparture getFkDestinationDeparture() {
		return fkDestinationDeparture;
	}

	public void setFkDestinationDeparture(DestinationDeparture fkDestinationDeparture) {
		this.fkDestinationDeparture = fkDestinationDeparture;
	}

	public DestinationArrival getFkDestinationArrival() {
		return fkDestinationArrival;
	}

	public void setFkDestinationArrival(DestinationArrival fkDestinationArrival) {
		this.fkDestinationArrival = fkDestinationArrival;
	}
	
	
	
	// constructors
	public Flight() {
	}

	public Flight(String airCompany, String flightNumber, String flightDate, double departureTime, double arrivalTime, double duration,
			DestinationDeparture fkDestinationDeparture, DestinationArrival fkDestinationArrival) {
		this.flightNumber = flightNumber;
		this.flightDate = flightDate;
		this.duration = duration;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.airCompany = airCompany;
		this.fkDestinationDeparture = fkDestinationDeparture;
		this.fkDestinationArrival = fkDestinationArrival;
	}

}
