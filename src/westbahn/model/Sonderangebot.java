package westbahn.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Sonderangebot {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ID;

	private int kontingent = 999;

	@Temporal(TemporalType.DATE)
	private Date startZeit;

	private int dauer = 12;

	private float preisNachlass = 0.5f;

	@OneToOne(optional=false)
	private Ticket tickets;

	
	
	public Sonderangebot() {

	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public int getKontingent() {
		return kontingent;
	}

	public void setKontingent(int kontingent) {
		this.kontingent = kontingent;
	}

	public Date getStartZeit() {
		return startZeit;
	}

	public void setStartZeit(Date startZeit) {
		this.startZeit = startZeit;
	}

	public int getDauer() {
		return dauer;
	}

	public void setDauer(int dauer) {
		this.dauer = dauer;
	}

	public float getPreisNachlass() {
		return preisNachlass;
	}

	public void setPreisNachlass(float preisNachlass) {
		this.preisNachlass = preisNachlass;
	}

	public Ticket getTickets() {
		return tickets;
	}

	public void setTickets(Ticket tickets) {
		this.tickets = tickets;
	}
	
	
}
