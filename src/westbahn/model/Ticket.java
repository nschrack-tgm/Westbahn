package westbahn.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@NamedQueries({
	@NamedQuery(name="Ticket.getTicketByStartEnd",query="FROM Ticket t INNER JOIN t.Strecke s +"
			+ "WHERE s.start = :start "
			+ "AND s.ende = :ende "
			+ "AND 0 = (SELECT COUNT(r) FROM Reservierungen r WHERE r.Strecke = s)"),
})

@Entity
public abstract class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long ID;

	@OneToOne(optional=false)
	protected Strecke strecke;

//	@OneToOne(optional=false)
	protected Zahlung zahlung;

	public Ticket() {
		
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public Strecke getStrecke() {
		return strecke;
	}

	public void setStrecke(Strecke strecke) {
		this.strecke = strecke;
	}

	public Zahlung getZahlung() {
		return zahlung;
	}

	public void setZahlung(Zahlung zahlung) {
		this.zahlung = zahlung;
	}

	
}
