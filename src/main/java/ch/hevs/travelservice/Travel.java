package ch.hevs.travelservice;

import java.util.List;
import javax.ejb.Local;

import ch.hevs.businessobject.Booking;
import ch.hevs.businessobject.Destination;
import ch.hevs.businessobject.DestinationArrival;
import ch.hevs.businessobject.DestinationDeparture;
import ch.hevs.businessobject.Flight;
import ch.hevs.businessobject.Passenger;

//(for access by local clients)
@Local
public interface Travel {

	// to edit profile - passenger
	Passenger getPassenger(long idPassenger);

	// to see the list of all passengers - admin
	List<Passenger> getPassengers();

	// to see all flights - admin
	List<Flight> getAllFlights();

	// to see booking by one passenger
	List<Flight> getFlightsByPassenger(long idPassenger);

	// to see all destinations
	List<Destination> getDestinations();

	// To see destination departure for booking - passenger
	List<DestinationDeparture> getDestinationsDeparture();

	// To see destination arrival for booking - passenger
	List<DestinationArrival> getDestinationsArrival();

	// to book a flight
	void bookFlight (Passenger p, Flight f) throws Exception;

	// for statistics - admin
	int getTotalPassengers();

	int getAmountFlights();

	void populateDatabase();

	// delete flight
	void deleteFlightByPassenger(Flight f);

}
