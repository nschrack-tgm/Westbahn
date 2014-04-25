package westbahn;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

<<<<<<< HEAD
import westbahn.model.Bahnhof;
import westbahn.model.Benutzer;
import westbahn.model.Einzelticket;
import westbahn.model.Reservierung;
import westbahn.model.Sonderangebot;
import westbahn.model.StatusInfo;
import westbahn.model.Strecke;
import westbahn.model.TicketOption;
import westbahn.model.Zeitkarte;
import westbahn.model.ZeitkartenTyp;
import westbahn.model.Zug;
import westbahn.query.Queries;

import java.util.Date;

=======
import westbahn.query.Queries;
>>>>>>> 629e7bcef21b616156814324bb9dcbbba5c17cc7


public class Main {

	private static final Logger log = Logger.getLogger(Main.class);
	
	static SimpleDateFormat dateForm = new SimpleDateFormat("dd.MM.yyyy");
	static SimpleDateFormat timeForm = new SimpleDateFormat("dd.MM.yyyy mm:hh");

	private static Queries query;
	private static EntityManager entityManager;
	
	private Main() {
		super();
	}

	public static void main(String[] args) {
		
		EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("westbahn");
		entityManager = entitymanagerfactory.createEntityManager();
		
		query = new Queries(entityManager);
		
		log.setLevel(Level.ALL);
		fillDB(entityManager);
		try {
			log.info("Starting \"Mapping Perstistent Classes and Associations\" (task1)");
			task01();
			log.info("Starting \"Working with JPA-QL and the Hibernate Criteria API\" (task2)");
			task02a();
			task02b();
			task02c();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void fillDB(EntityManager em){
		int count = 10;
		em.getTransaction().begin();
		
		//Bahnhof
		//Zug, Strecke, Benutzer, Reservierung, Sonderangebot, Einzelticket, Zeitkarte
		
		Bahnhof[] bh = new Bahnhof[count];
		for (int i = 0; i < count+1; i++) {
			Bahnhof bh1 = new Bahnhof();
			bh1.setName("hallo");
			bh1.setAbsPreisEntfernung(i*i+1);
			bh1.setAbsKmEntfernung(i+i+1);
			bh1.setAbsZeitEntfernung(i*i^2);
			bh1.setKopfBahnhof(i%2==0);
			bh[i] = bh1;
			em.persist(bh1);	
		}
		
		Zug[] zug = new Zug[count];
		for (int i = 0; i < count; i++) {
			Zug zug1 = new Zug();
			zug1.setEnde(bh[i+1]);
			zug1.setFahrradStellplaetze(i*i+1);
			zug1.setID(i+i+1L);
			zug1.setRollStuhlPlaetze(i*i+2);
			zug1.setSitzPlaetze(i+67);
			zug1.setStart(bh[i]);
			zug1.setStartZeit(new Date());
			zug[i] = zug1;
			em.persist(zug1);
		}
		
		Strecke[] st = new Strecke[count];
		for (int i = 0; i < count; i++) {
			Strecke st1 = new Strecke();
			st1.setEnde(bh[i+1]);
			st1.setID(i+i+1L);
			st1.setStart(bh[i]);
			st[i] = st1;
			em.persist(st1);
		}
		
		Benutzer[] bz = new Benutzer[count];
		for (int i = 0; i < count; i++) {
			Benutzer bz1 = new Benutzer();
			bz1.seteMail(i+"@hotmail.com");
			bz1.setNachName(i*i+i+"Maier");
			bz1.setPasswort("passowrt"+i);
			bz1.setSmsNummer("0660 204"+i+(i^2));
			bz1.setVerbuchtePraemienMeilen(i+1234L);
			bz1.setVorName("Herbert"+i);
			bz[i] = bz1;
			em.persist(bz1);
		}
		
		
		Reservierung[] rv = new Reservierung[count];
		for (int i = 0; i < count; i++) {
			Reservierung rv1 = new Reservierung();
			rv1.setBenutzer(bz[i]);
			rv1.setDatum(new Date(i));
			rv1.setID(i+1L);
			rv1.setPraemienMeilenBonus(i*i+2);
			rv1.setPreis(30+i);
			rv1.setStatus(StatusInfo.ONTIME);
			rv1.setStrecke(new Strecke());
			rv1.setZug(new Zug());
			rv[i] = rv1;
			em.persist(rv1);
		}
	    
	    Sonderangebot[] sa = new Sonderangebot[count];
	    for (int i = 0; i < count; i++) {
	    	Sonderangebot sa1 = new Sonderangebot();
	    	sa1.setDauer(i+23);
	    	sa1.setKontingent(134+i*2);
	    	sa1.setPreisNachlass(i*i+3f);
	    	sa1.setStartZeit(new Date(i));
	    	sa1.setTickets(new Einzelticket());
	    	sa[i] = sa1;
	    	em.persist(sa1);
	    }
	    
		Einzelticket[] et = new Einzelticket[count];
		for (int i = 0; i < count; i++) {
			Einzelticket et1 = new Einzelticket();
			et1.setTicketOption(TicketOption.FAHRRAD);
			et[i] = et1;
			em.persist(et1);
		}
		
		Zeitkarte[] zk = new Zeitkarte[count];
		for (int i = 0; i < count; i++) {
			Zeitkarte zk1 = new Zeitkarte();
			zk1.setGueltigAb(new Date(i));
			zk1.setGueltigBis(new Date(i+1));
			zk1.setTyp(ZeitkartenTyp.MONATSKARTE);
			zk[i] = zk1;
			em.persist(zk1);
		}
		em.getTransaction().commit();
	}

	public static void task01() throws ParseException, InterruptedException {
		
	}

	public static void task02a() throws ParseException {
//		query.getAllBenutzer(emailAdress);
	}

	public static void task02b() throws ParseException {
//		query.getAllReservations(emailAdress);
	}

	public static void task02c() throws ParseException {
//		query.getTicketByStartEnd(start, end);
	}

}
