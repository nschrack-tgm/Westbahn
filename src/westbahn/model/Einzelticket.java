package westbahn.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Einzelticket extends Ticket {

	@Enumerated(value=EnumType.STRING)
	private TicketOption ticketOption;
	
	public Einzelticket(){}
}
