package ch.hevs.travelservice;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateful;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import ch.hevs.businessobject.Address;
import ch.hevs.businessobject.Booking;
import ch.hevs.businessobject.Client;
import ch.hevs.businessobject.Destination;
import ch.hevs.businessobject.DestinationArrival;
import ch.hevs.businessobject.DestinationDeparture;
import ch.hevs.businessobject.Flight;
import ch.hevs.businessobject.Passenger;

// we implement here methods from interface Travel
// getFlightsByPassenger to be checked !!!!
@Stateful
public class TravelBean implements Travel {

	@PersistenceContext(name = "TravelPU", type = PersistenceContextType.EXTENDED)
	private EntityManager em;

	// --------------------- METHODS ----------------------
	@Override
	public List<Passenger> getPassengers() {
		return em.createQuery("FROM Flight").getResultList();
	}

	@Override
	public List<Destination> getDestinations() {
		return em.createQuery("FROM Destination").getResultList();
	}

	@Override
	public List<DestinationDeparture> getDestinationsDeparture() {
		return em.createQuery("FROM DestinationDeparture").getResultList();

	}

	@Override
	public List<DestinationArrival> getDestinationsArrival() {
		return em.createQuery("FROM DestinationArrival").getResultList();

	}

	@Override
	public int getTotalPassengers() {
		int nb = ((Number) em.createQuery("Select Count(p) from Passenger p").getSingleResult()).intValue();
		return nb;
	}

	@Override
	public int getAmountFlights() {
		int nb = ((Number) em.createQuery("Select Count(f) from Flight f").getSingleResult()).intValue();
		return nb;
	}

	// to get the profile
	@Override
	public Passenger getPassenger(long idPassenger) {
		return (Passenger) em.createQuery("FROM Passenger p where p.id=:id").setParameter("id", idPassenger)
				.getSingleResult();

	}

	@Override
	public List<Flight> getAllFlights() {
		return em.createQuery("FROM Flight").getResultList();
	}

	// to be checked
	@Override
	public List<Flight> getFlightsByPassenger(long idPassenger) {
		return em.createQuery("FROM Flight f INNER JOIN booking b ON f.idFlight=b.idFlight WHERE b.idPassenger=id")
				.setParameter("id", idPassenger).getResultList();

	}

	// to add
	@Override
	public void bookFlight(long passengerId, long flightId) throws Exception {

	}

	// to add
	@Override
	public void deleteFlightByUser(long idPassenger, long idFlight) {
		// TODO Auto-generated method stub

	}

	@Override
	public void populateDatabase() {

		// --------------------- PASSENGERS ---------------------
		// public Passenger(String firstname, String lastname)
		Passenger passengerTom = new Passenger("Tom", "WHITE");
		Passenger passengerLinda = new Passenger("Linda", "SARRAN");

		// --------------------- Addresses for Destinations/AIRPORT
		// ---------------------
		// public Address(String country, String street, String city, String
		// postalCode)
		Address airportKiev = new Address("UKRAINE", "Kyivska oblast", "Boryspil", "08307");
		Address airportZurich = new Address("SWITZERLAND", "Route de l'Aéroport 21", "Le Grand-Saconnex", "1215");
		Address airportSion = new Address("SWITZERLAND", "Rue Chanoine-Berchtold 10", "Sion", "1950");
		Address airportLondon = new Address("UK", "Crumlin Road N5V 3B6", "London", "1750");

		// --------------------- Departure destinations - Airport
		// ---------------
		// public Destination(String airportName)
		DestinationDeparture ddKiev = new DestinationDeparture();
		ddKiev.setAirportName("Boryspil Airport");
		ddKiev.setAddress(airportKiev);

		DestinationDeparture ddSion = new DestinationDeparture();
		ddKiev.setAirportName("Sion Airport");
		ddKiev.setAddress(airportSion);

		// --------------------- Arrival destinations - Airport
		// ---------------------
		// public Destination(String airportName)
		DestinationArrival daZurich = new DestinationArrival();
		daZurich.setAirportName("Zurich Airport");
		daZurich.setAddress(airportZurich);

		DestinationArrival daLondon = new DestinationArrival();
		daLondon.setAirportName("London Airport");
		daLondon.setAddress(airportLondon);

		// --------------------- Flights ---------------------
		/*
		 * public Flight(String airCompany, String flightDate, String flightNumber, double
		 * departureTime, double arrivalTime, double duration,
		 * DestinationDeparture fkDestinationDeparture, DestinationArrival
		 * fkDestinationArrival)
		 */

		Flight f1 = new Flight("UIA", "28-06-2018", "PS1507", 10.30, 12.30, 3.00, ddKiev, daZurich);
		Flight f2 = new Flight("Swiss Air",  "17-07-2018", "SA907", 14.30, 15.30, 2.00, ddSion, daLondon);
		
		
		// --------------------- Booking ---------------------
		
		// public Booking(String date, Passenger fkPassenger, Flight fkFlight)

		Booking b1 = new Booking("25-05-2018", passengerLinda, f2);
		Booking b2 = new Booking("10-05-2018", passengerTom, f1);
		
		
		//--------------------- Persist objects ---------------------
		em.persist(airportKiev);
		em.persist(airportLondon);
		em.persist(airportSion);
		em.persist(airportZurich);
		em.persist(passengerLinda);
		em.persist(passengerTom);
		
		em.persist(ddKiev);
		em.persist(ddSion);
		
		em.persist(daLondon);
		em.persist(daZurich);
	}

}
