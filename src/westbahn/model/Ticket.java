package westbahn.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public abstract class Ticket {

	@Id
	protected Long ID;
	protected Strecke strecke;
	protected Zahlung zahlung;

	public Ticket(){
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
