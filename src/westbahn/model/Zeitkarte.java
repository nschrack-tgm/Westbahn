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
	@Enumerated(value=EnumType.STRING)
	private ZeitkartenTyp typ;
	
	public Zeitkarte(){}
	
	public Date getGueltigAb() {
		return gueltigAb;
	}
	public void setGueltigAb(Date gueltigAb) {
		this.gueltigAb = gueltigAb;
	}

	@Column(name="Zeitkartentyp") 
	public ZeitkartenTyp getTyp() {
		return typ;
	}

	public void setTyp(ZeitkartenTyp typ) {
		this.typ = typ;
	}
	
}
