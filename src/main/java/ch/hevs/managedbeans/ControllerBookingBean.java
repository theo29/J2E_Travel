package ch.hevs.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import ch.hevs.businessobject.Passenger;
import ch.hevs.businessobject.Destination;
import ch.hevs.businessobject.Flight;
import ch.hevs.travelservice.Travel;
import ch.hevs.businessobject.DestinationArrival;
import ch.hevs.businessobject.DestinationDeparture;

// To addapt to our program
public class ControllerBookingBean {
	// General
	private Travel travel;

	// homepage.xhtml
	private List<String> bigImages;

	// Destinations.xhtml
	private List<Destination> destinations;
	private Destination selectedDestination;

	// bookingForm.xhtml
	private List<Flight> flightList;
	private Flight selectedFlight;

	// profile.xhtml
	private Passenger currentPassenger;

	// administration.xhtml
	private List<DestinationArrival> arrivalList;
	private List<DestinationDeparture> departureList;
	private List<Passenger> PassengerList;
	private int nbTravelers;
	private int nbDeparture;
	private int nbArrival;
	private int nbFlight;

	@PostConstruct
	public void initialize() throws NamingException {

		// use JNDI to inject reference to bank EJB
		InitialContext ctx = new InitialContext();
		travel = (Travel) ctx.lookup("java:app/TravelTD-0.0.1-SNAPSHOT/TravelBean");

		// Create and populate a list of flight objects
		setFlightList(new ArrayList<Flight>());
		setFlightList(travel.getAllFlights());

		// Create and populate a list of destination objects
		setDestinations(new ArrayList<Destination>());
		setDestinations(travel.getDestinations());

		// Create and populate a list of DestinationArrival objects
		setArrivalList(new ArrayList<DestinationArrival>());
		setArrivalList(travel.getDestinationsArrival());

		// Create and populate a list of DestinationDeparture objects
		setDepartureList(new ArrayList<DestinationDeparture>());
		setDepartureList(travel.getDestinationsDeparture());

		// Create and populate a list of DestinationDeparture objects
		setPassengerList(new ArrayList<Passenger>());
		setPassengerList(travel.getPassengers());

		// Get Passenger N°3 to simulate a logged in Passenger in the profile
		// page
		setCurrentPassenger(PassengerList.get(0));

		// Get numbers for the admin panel stat
		setNbTravelers(travel.getTotalPassengers());
		setNbFlight(travel.getAmountFlights());

		//populateDatabase();

	}

	public void populateDatabase() {
		travel.populateDatabase();
	}

	public List<Flight> getFlightList() {
		return flightList;
	}

	public void setFlightList(List<Flight> flightList) {
		this.flightList = flightList;
	}

	public Travel getTravel() {
		return travel;
	}

	public void setTravel(Travel travel) {
		this.travel = travel;
	}

	public List<Destination> getDestinations() {
		return destinations;
	}

	public void setDestinations(List<Destination> destinations) {
		this.destinations = destinations;
	}

	public Destination getSelectedDestination() {
		return selectedDestination;
	}

	public void setSelectedDestination(Destination selectedDestination) {
		this.selectedDestination = selectedDestination;
	}

	public List<String> getBigImages() {
		return bigImages;
	}

	public void setBigImages(List<String> bigImages) {
		this.bigImages = bigImages;
	}

	public Flight getSelectedFlight() {
		return selectedFlight;
	}

	public void setSelectedFlight(Flight selectedFlight) {
		this.selectedFlight = selectedFlight;
	}

	public List<DestinationArrival> getArrivalList() {
		return arrivalList;
	}

	public void setArrivalList(List<DestinationArrival> arrivalList) {
		this.arrivalList = arrivalList;
	}

	public List<DestinationDeparture> getDepartureList() {
		return departureList;
	}

	public void setDepartureList(List<DestinationDeparture> departureList) {
		this.departureList = departureList;
	}

	public List<Passenger> getPassengerList() {
		return PassengerList;
	}

	public void setPassengerList(List<Passenger> list) {
		this.PassengerList = list;
	}

	public int getNbDeparture() {
		return nbDeparture;
	}

	public void setNbDeparture(int nbDeparture) {
		this.nbDeparture = nbDeparture;
	}

	public int getNbArrival() {
		return nbArrival;
	}

	public void setNbArrival(int nbArrival) {
		this.nbArrival = nbArrival;
	}

	public int getNbFlight() {
		return nbFlight;
	}

	public void setNbFlight(int nbFlight) {
		this.nbFlight = nbFlight;
	}

	public int getNbTravelers() {
		return nbTravelers;
	}

	public void setNbTravelers(int nbTravelers) {
		this.nbTravelers = nbTravelers;
	}

	public Passenger getCurrentPassenger() {
		return currentPassenger;
	}

	public void setCurrentPassenger(Passenger currentPassenger) {
		this.currentPassenger = currentPassenger;
	}
}