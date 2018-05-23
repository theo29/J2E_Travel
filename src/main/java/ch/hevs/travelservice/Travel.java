package ch.hevs.travelservice;

import java.util.List;

import javax.ejb.Local;

import ch.hevs.businessobject.Account;
import ch.hevs.businessobject.Destination;
import ch.hevs.businessobject.DestinationArrival;
import ch.hevs.businessobject.DestinationDeparture;
import ch.hevs.businessobject.Flight;
import ch.hevs.businessobject.Passenger;

//(for access by local clients)
@Local
public interface Travel {

	//to edit profile - passenger
	Passenger getPassenger(long idPassenger);
	
	//to see the list of all passengers - admin
	List<Passenger> getPassengers();
	
	//to see all flights - admin
	List<Flight> getAllFlights();
	
	//to see booking by one passenger
	List<Flight> getFlightsByPassenger(long idPassenger);
	
	//to see all destinations
	List<Destination> getDestinations();
	
	//To see destination departure for booking - passenger
	List<DestinationDeparture> getDestinationsDeparture();
	
	//To see destination arrival for booking - passenger
	List<DestinationArrival> getDestinationsArrival();	
	
	//to book a flight
	void bookFlight(long passengerId, long flightId) throws Exception;
    
	
	//to delete a flight
	void deleteFlightByUser(long idPassenger, long idFlight);  
	
	
	//for statistics - admin
	int getTotalPassengers();
	int getAmountFlights();

	void populateDatabase();
	
	//to fill in the data
	
	
	
}
