package westbahn.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@NamedQueries({
	@NamedQuery(name="getAllReservations",query="SELECT b FROM benutzer WHERE b.eMail = $1")
	})

@Entity
public class Benutzer {

	@Id
	private Long ID;
	private String vorName;
	private String nachName;
	private String eMail;
	private String passwort;
	private String smsNummer;
	private Long verbuchtePraemienMeilen;
	@OneToOne(optional=false)
	private Ticket tickets;
	@OneToMany(mappedBy="benutzer")
	private Collection<Reservierung> reservierungen;
 
	public Benutzer(){
		
	}
	
	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getVorName() {
		return vorName;
	}

	public void setVorName(String vorName) {
		this.vorName = vorName;
	}

	public String getNachName() {
		return nachName;
	}

	public void setNachName(String nachName) {
		this.nachName = nachName;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	public String getSmsNummer() {
		return smsNummer;
	}

	public void setSmsNummer(String smsNummer) {
		this.smsNummer = smsNummer;
	}

	public Long getVerbuchtePraemienMeilen() {
		return verbuchtePraemienMeilen;
	}

	public void setVerbuchtePraemienMeilen(Long verbuchtePraemienMeilen) {
		this.verbuchtePraemienMeilen = verbuchtePraemienMeilen;
	}

	public Ticket getTickets() {
		return tickets;
	}

	public void setTickets(Ticket tickets) {
		this.tickets = tickets;
	}

	public Collection<Reservierung> getReservierungen() {
		return reservierungen;
	}

	public void setReservierungen(Collection<Reservierung> reservierungen) {
		this.reservierungen = reservierungen;
	}
}
