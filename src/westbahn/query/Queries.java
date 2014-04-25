package westbahn.query;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.Query;


import westbahn.model.Benutzer;
import westbahn.model.Ticket;

/*
 * a) Finde alle Reservierungen f��r einen bestimmten Benutzer, der durch die eMail-Adresse definiert wird.
 * b) Liste alle Benutzer auf, die eine Monatskarte besitzen.
 * c) Liste alle Tickets f��r eine bestimmte Strecke aus (durch Anfangs- und Endbahnhof definiert), wo keine Reservierungen durchgef��hrt wurden.
 */


public class Queries {

	EntityManager em;
	public Queries(EntityManager em){
		this.em = em;
	}


	    
	@SuppressWarnings("unchecked")
	public Collection<Benutzer> getAllReservations(String emailAdress){
		Query query = em.createNamedQuery("Benutzer.getAllReservation")
	            .setParameter("emailAdress",emailAdress);
		return (Collection<Benutzer>)query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public Collection<Benutzer> getAllBenutzer(){
		Query query = em.createNamedQuery("Benutzer.getAllBenutzer");
		return (Collection<Benutzer>)query.getResultList();
	}	
	
	@SuppressWarnings("unchecked")
	public Collection<Ticket> getTicketByStartEnd(String start, String end){
		Query query = em.createNamedQuery("Ticket.getTicketByStartEnd")
	            .setParameter("start",start)
				.setParameter("end",end);
		return (Collection<Ticket>)query.getResultList();
	}
}
