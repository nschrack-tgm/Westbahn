package westbahn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Strecke {

	@Id
	private Long ID;

	@Column(unique=true)
	@OneToOne(optional=false)
	private Bahnhof start;

	//Keine Plan
	private Bahnhof bahnhof;

	@Column(unique=true)
	@OneToOne(optional=false)
	private Bahnhof ende;
	
	public Strecke(){
		
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public Bahnhof getStart() {
		return start;
	}

	public void setStart(Bahnhof start) {
		this.start = start;
	}

	public Bahnhof getBahnhof() {
		return bahnhof;
	}

	public void setBahnhof(Bahnhof bahnhof) {
		this.bahnhof = bahnhof;
	}

	public Bahnhof getEnde() {
		return ende;
	}

	public void setEnde(Bahnhof ende) {
		this.ende = ende;
	}

}
