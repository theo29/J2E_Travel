package ch.hevs.travelservice;

import java.util.List;
import javax.ejb.Stateful;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import ch.hevs.businessobject.Address;
import ch.hevs.businessobject.Client;
import ch.hevs.businessobject.Destination;
import ch.hevs.businessobject.DestinationArrival;
import ch.hevs.businessobject.DestinationDeparture;
import ch.hevs.businessobject.Flight;
import ch.hevs.businessobject.Passenger;

// we implement here methods from interface Travel
// getFlightsByPassengerto be checked !!!
@Stateful
public class TravelBean implements Travel {

	@PersistenceContext(name = "TravelPU", type=PersistenceContextType.EXTENDED)
	private EntityManager em;

	
	//--------------------- METHODS ---------------------
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
		int nb = ((Number)em.createQuery("Select Count(p) from 	Passenger p").getSingleResult()).intValue();
		return nb;
	}

	@Override
	public int getAmountFlights() {
		int nb = ((Number)em.createQuery("Select Count(f) from 	Flight f").getSingleResult()).intValue();
		return nb;
	}


	// to get the profile
	@Override
	public Passenger getPassenger(long idPassenger) {
		return (Passenger) em.createQuery("FROM Passenger p where p.id=:id").setParameter("id", idPassenger).getSingleResult();
		
	}


	@Override
	public List<Flight> getAllFlights() {
		return em.createQuery("FROM Flight").getResultList();
	}
	

// to be checked
	@Override
	public List<Flight> getFlightsByPassenger(long idPassenger) {
		return em.createQuery("FROM Flight f INNER JOIN booking b ON f.idFlight=b.idFlight WHERE b.idPassenger=id").setParameter("id", idPassenger).getResultList();

	}

// to add
	@Override
	public void bookFlight(long passengerId, long flightId) throws Exception {

	}

//to add
	@Override
	public void deleteFlightByUser(long idPassenger, long idFlight) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void populateDatabase() {
		// TODO Auto-generated method stub
		
	}


	
	
}
