package westbahn.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Zeitkarte extends Ticket {

	@Temporal(TemporalType.DATE)
	private Date gueltigAb;
	
	@Temporal(TemporalType.DATE)
	private transient Date gueltigBis;

	
	private ZeitkartenTyp typ;

	
	public Date getGueltigBis() {
		return gueltigBis;
	}

	public void setGueltigBis(Date gueltigBis) {
		this.gueltigBis = gueltigBis;
	}

	public Date getGueltigAb() {
		return gueltigAb;
	}

	public Zeitkarte() {
		
	}

	public void setGueltigAb(Date gueltigAb) {
		this.gueltigAb = gueltigAb;
	}
	
	@Column(name="ZeitkartenTyp") 
	@Enumerated(EnumType.ORDINAL)
	public ZeitkartenTyp getTyp() {
		return typ;
	}

	public void setTyp(ZeitkartenTyp typ) {
		this.typ = typ;
	}

}
