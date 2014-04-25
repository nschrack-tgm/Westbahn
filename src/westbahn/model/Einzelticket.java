package westbahn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Einzelticket extends Ticket {

	private TicketOption ticketOption;
	
	public Einzelticket() {
		
	}

	@Column(name="TicketOption") 
	@Enumerated(EnumType.ORDINAL)
	public TicketOption getTicketOption() {
		return ticketOption;
	}

	public void setTicketOption(TicketOption ticketOption) {
		this.ticketOption = ticketOption;
	}

}
