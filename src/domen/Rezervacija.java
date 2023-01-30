package domen;

import java.sql.Date;
import java.sql.Time;

public class Rezervacija {
private int idkorisnik,brojkarata,idRezervacija,idPredstava2;
private double cenakrte,ukupnacena;
/**
 * @return the idPredstava2
 */
public int getIdPredstava2() {
	return idPredstava2;
}
/**
 * @param idPredstava2 the idPredstava2 to set
 */
public void setIdPredstava2(int idPredstava2) {
	this.idPredstava2 = idPredstava2;
}
private String idpredsatva;
/**
 * @return the idRezervacija
 */
public int getIdRezervacija() {
	return idRezervacija;
}
/**
 * @param idRezervacija the idRezervacija to set
 */
public void setIdRezervacija(int idRezervacija) {
	this.idRezervacija = idRezervacija;
}
/**
 * @return the datumpredstave
 */
public Date getDatumpredstave() {
	return Datumpredstave;
}
/**
 * @param datumpredstave the datumpredstave to set
 */
public void setDatumpredstave(Date datumpredstave) {
	Datumpredstave = datumpredstave;
}
/**
 * @return the vremePredstave
 */
public Time getVremePredstave() {
	return VremePredstave;
}
/**
 * @param vremePredstave the vremePredstave to set
 */
public void setVremePredstave(Time vremePredstave) {
	VremePredstave = vremePredstave;
}
private Date Datumpredstave;
private Time VremePredstave;
/**
 * @return the idkorisnik
 */
public int getIdkorisnik() {
	return idkorisnik;
}
/**
 * @param idkorisnik the idkorisnik to set
 */
public void setIdkorisnik(int idkorisnik) {
	this.idkorisnik = idkorisnik;
}
/**
 * @return the brojkarata
 */
public int getBrojkarata() {
	return brojkarata;
}
/**
 * @param brojkarata the brojkarata to set
 */
public void setBrojkarata(int brojkarata) {
	this.brojkarata = brojkarata;
}
/**
 * @return the cenakrte
 */
public double getCenakrte() {
	return cenakrte;
}
/**
 * @param cenakrte the cenakrte to set
 */
public void setCenakrte(double cenakrte) {
	this.cenakrte = cenakrte;
}
/**
 * @return the ukupnacena
 */
public double getUkupnacena() {
	return ukupnacena;
}
/**
 * @param ukupnacena the ukupnacena to set
 */
public void setUkupnacena(double ukupnacena) {
	this.ukupnacena = ukupnacena;
}
/**
 * @return the idpredsatva
 */
public String getIdpredsatva() {
	return idpredsatva;
}
/**
 * @param idpredsatva the idpredsatva to set
 */
public void setIdpredsatva(String idpredsatva) {
	this.idpredsatva = idpredsatva;
}

}
