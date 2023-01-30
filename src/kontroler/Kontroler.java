package kontroler;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;


import broker.DBKomunikacija;
import domen.Autor;
import domen.Korisnik;
import domen.Pozoriste;
import domen.Predstava;
import domen.Rezervacija;
import domen.Zanr;




public class Kontroler {
	public static Kontroler instanca;
	private ArrayList<Predstava>alPredstava=new ArrayList<>();
	private ArrayList<Korisnik>alKorsisnik=new ArrayList<>();
	private ArrayList<Autor>alAutor=new ArrayList<>();
	private ArrayList<Pozoriste>alPozoriste=new ArrayList<>();
	private ArrayList<Rezervacija>alRezervacija=new ArrayList<>();
	private ArrayList<Zanr>alZanr=new ArrayList<>();
	
	public static Kontroler getInstanca() {
		if(instanca==null) {
			instanca=new Kontroler();
		}
		return instanca;
	}


	public boolean vratiKorisnika(String user, String pass) {
		// TODO Auto-generated method stub
		DBKomunikacija.getBroker().otvoriKonekciju();
		boolean vrednost=DBKomunikacija.getBroker().vratiKorisnika(user, pass);
		DBKomunikacija.getBroker().zatvoriKonekciju();;
		
		return vrednost;
	}


	public ArrayList<Predstava> vratiPredstavu() {
		// TODO Auto-generated method stub
				DBKomunikacija.getBroker().otvoriKonekciju();
				alPredstava=DBKomunikacija.getBroker().vratiPredstavu();
				DBKomunikacija.getBroker().zatvoriKonekciju();
				
				return alPredstava;
		
	}


	public void izmeniPredstavu(int brojKarata, int rezervisanKarte,int id) {
		// TODO Auto-generated method stub
		DBKomunikacija.getBroker().otvoriKonekciju();
		DBKomunikacija.getBroker().izmeniPredstavu(brojKarata,rezervisanKarte,id );
		DBKomunikacija.getBroker().zatvoriKonekciju();
	}


	public ArrayList<Predstava>getAl() {
		// TODO Auto-generated method stub
		return alPredstava;
	}


	public void upisi( int rezervisanKarte,int id,int idk,double cenak,double ucena,Date datum,Time vreme) {
		// TODO Auto-generated method stub
		DBKomunikacija.getBroker().otvoriKonekciju();
		DBKomunikacija.getBroker().upisi(rezervisanKarte,id,idk,cenak,ucena,datum,vreme);
		DBKomunikacija.getBroker().zatvoriKonekciju();
	}


	public ArrayList<Autor> vratiAutora() {
		// TODO Auto-generated method stub
		DBKomunikacija.getBroker().otvoriKonekciju();
		alAutor=DBKomunikacija.getBroker().vratiAutora();
		DBKomunikacija.getBroker().zatvoriKonekciju();
		
		return alAutor;
	}


	public void dodajAutora(String imeAutora) {
		// TODO Auto-generated method stub
		DBKomunikacija.getBroker().otvoriKonekciju();
		DBKomunikacija.getBroker().dodajAutora(imeAutora);
		DBKomunikacija.getBroker().zatvoriKonekciju();
		
	}


	public void izmeniAutora(int id, String ime) {
		// TODO Auto-generated method stub
		DBKomunikacija.getBroker().otvoriKonekciju();
		DBKomunikacija.getBroker().izmeniAutora(id,ime);
		DBKomunikacija.getBroker().zatvoriKonekciju();
		
	}


	public void izbrisiAutora(int id) {
		// TODO Auto-generated method stub
		DBKomunikacija.getBroker().otvoriKonekciju();
		DBKomunikacija.getBroker().izbrisiAutora(id);
		DBKomunikacija.getBroker().zatvoriKonekciju();
		
	}


	public ArrayList<Pozoriste> vratiPozoriste() {
		// TODO Auto-generated method stub
		DBKomunikacija.getBroker().otvoriKonekciju();
		alPozoriste=DBKomunikacija.getBroker().vratiPozoriste();
		DBKomunikacija.getBroker().zatvoriKonekciju();
		
		return alPozoriste;
	}


	public void izmenPozoriste(int id, String naziv, String adresa) {
		// TODO Auto-generated method stub
		DBKomunikacija.getBroker().otvoriKonekciju();
		DBKomunikacija.getBroker().izmeniPozoriste(id,naziv,adresa);
		DBKomunikacija.getBroker().zatvoriKonekciju();
		
	}


	public void dodajPozoriste(String imePozorista, String adresaPozorista) {
		// TODO Auto-generated method stub
		DBKomunikacija.getBroker().otvoriKonekciju();
		DBKomunikacija.getBroker().dodajPozoriste(imePozorista,adresaPozorista);
		DBKomunikacija.getBroker().zatvoriKonekciju();
		
	}


	public void izbrisiPozoriste(int id) {
		// TODO Auto-generated method stub
		DBKomunikacija.getBroker().otvoriKonekciju();
		DBKomunikacija.getBroker().izbrisiPozoriste(id);
		DBKomunikacija.getBroker().zatvoriKonekciju();
	}


	public ArrayList<Zanr>  VratiZanr() {
		// TODO Auto-generated method stub
		DBKomunikacija.getBroker().otvoriKonekciju();
		alZanr=DBKomunikacija.getBroker().vratiZanr();
		DBKomunikacija.getBroker().zatvoriKonekciju();
		
		return alZanr;
	}


	public void dodajZanr(String imeZanra) {
		DBKomunikacija.getBroker().otvoriKonekciju();
		DBKomunikacija.getBroker().dodajZanr(imeZanra);
		DBKomunikacija.getBroker().zatvoriKonekciju();
		
		
	}


	public void izmenZanr(int id, String naziv) {
		// TODO Auto-generated method stub
		DBKomunikacija.getBroker().otvoriKonekciju();
		DBKomunikacija.getBroker().izmeniZanr(id,naziv);
		DBKomunikacija.getBroker().zatvoriKonekciju();
	}


	public void izbrisiZanr(int id) {
		// TODO Auto-generated method stub
		DBKomunikacija.getBroker().otvoriKonekciju();
		DBKomunikacija.getBroker().izbrisiZanr(id);
		DBKomunikacija.getBroker().zatvoriKonekciju();
		
	}


	public void dodajPredstavu(String imePredstave, int idAutora, int iDPozoriste, int iDZanr, Date datum, Time vreme,
			double cenaKarte, int brojKarata) {
		// TODO Auto-generated method stub
		DBKomunikacija.getBroker().otvoriKonekciju();
		DBKomunikacija.getBroker().dodajPredstava(imePredstave, idAutora, iDPozoriste,  iDZanr, datum,  vreme,
				 cenaKarte,  brojKarata);
		DBKomunikacija.getBroker().zatvoriKonekciju();
	}


	public void izmenPredstavu(int idpred, int idAutora, int iDPozoriste, int iDZanr, String brojk, String naziv,
			String cena, String datum, String vreme) {
		// TODO Auto-generated method stub
		DBKomunikacija.getBroker().otvoriKonekciju();
		DBKomunikacija.getBroker().izmeniPredstavu(idpred,  idAutora,  iDPozoriste,  iDZanr,  brojk,  naziv,
				 cena,  datum,  vreme);
		DBKomunikacija.getBroker().zatvoriKonekciju();
		
	}


	public ArrayList<Korisnik> vratiKorisnika2() {
		// TODO Auto-generated method stub
		DBKomunikacija.getBroker().otvoriKonekciju();
		alKorsisnik=DBKomunikacija.getBroker().vratiKorisnika2();
		DBKomunikacija.getBroker().zatvoriKonekciju();
		
		return alKorsisnik;
	}


	public void dodajKorisnika(String imekorisnika, String prezimekorisnika, String usernamekorisnika, String password,
			String emial) {
		// TODO Auto-generated method stub
		DBKomunikacija.getBroker().otvoriKonekciju();
		DBKomunikacija.getBroker().dodajKorisnika(imekorisnika,  prezimekorisnika,  usernamekorisnika,  password,
		emial);
		DBKomunikacija.getBroker().zatvoriKonekciju();
	}


	public void izbrisiPredstavu(int idpred) {
		// TODO Auto-generated method stub
		DBKomunikacija.getBroker().otvoriKonekciju();
		DBKomunikacija.getBroker().izbrisiPredstavu(idpred);
		DBKomunikacija.getBroker().zatvoriKonekciju();
	}


	public ArrayList<Rezervacija> vratiRezervaciju() {
		// TODO Auto-generated method stub
		DBKomunikacija.getBroker().otvoriKonekciju();
		alRezervacija=DBKomunikacija.getBroker().vratiRezervaziju();
		DBKomunikacija.getBroker().zatvoriKonekciju();
		
		return alRezervacija;
	}


	public void izbrisiRezervaciju(int idr, int rezkarte) {
		// TODO Auto-generated method stub
		DBKomunikacija.getBroker().otvoriKonekciju();
		DBKomunikacija.getBroker().izbrisiRezervaciju(idr,rezkarte);
		DBKomunikacija.getBroker().zatvoriKonekciju();
		
	}


	public void izmeniPredstavu2(int rezkarte2, int idpr,int Brjk) {
		// TODO Auto-generated method stub
		DBKomunikacija.getBroker().otvoriKonekciju();
		DBKomunikacija.getBroker().izmeniPredstavu2(rezkarte2,idpr,Brjk);
		DBKomunikacija.getBroker().zatvoriKonekciju();
	}


	public void izmeniRezervaciju2(int idr, int rezkarte2) {
		DBKomunikacija.getBroker().otvoriKonekciju();
		DBKomunikacija.getBroker().izmeniRezervaciju2(idr,rezkarte2);
		DBKomunikacija.getBroker().zatvoriKonekciju();
		
		
	}


	public void izmeniPredstavu3(int idpr, int brojKarata, int rezkarte, int rezkarte2) {
		// TODO Auto-generated method stub
		DBKomunikacija.getBroker().otvoriKonekciju();
		DBKomunikacija.getBroker().izmeniPredstavu3(idpr,brojKarata,rezkarte,rezkarte2);
		DBKomunikacija.getBroker().zatvoriKonekciju();
	}






	


	


	
	}



	




