package domen;

import java.sql.Date;
import java.sql.Time;

public class Predstava {

	private int idPredstava,BrojKarata;
	private String NazivPozorista,NazivPredstave,Autor,Zanr;
	private  Date datum;
	private Time vreme;
	private double cena;
	/**
	 * @return the idPredstava
	 */
	public int getIdPredstava() {
		return idPredstava;
	}
	/**
	 * @param idPredstava the idPredstava to set
	 */
	public void setIdPredstava(int idPredstava) {
		this.idPredstava = idPredstava;
	}
	/**
	 * @return the brojKarata
	 */
	public int getBrojKarata() {
		return BrojKarata;
	}
	/**
	 * @param brojKarata the brojKarata to set
	 */
	public void setBrojKarata(int brojKarata) {
		BrojKarata = brojKarata;
	}
	/**
	 * @return the nazivPozorista
	 */
	public String getNazivPozorista() {
		return NazivPozorista;
	}
	/**
	 * @param nazivPozorista the nazivPozorista to set
	 */
	public void setNazivPozorista(String nazivPozorista) {
		NazivPozorista = nazivPozorista;
	}
	/**
	 * @return the nazivPredstave
	 */
	public String getNazivPredstave() {
		return NazivPredstave;
	}
	/**
	 * @param nazivPredstave the nazivPredstave to set
	 */
	public void setNazivPredstave(String nazivPredstave) {
		NazivPredstave = nazivPredstave;
	}
	/**
	 * @return the autor
	 */
	public String getAutor() {
		return Autor;
	}
	/**
	 * @param autor the autor to set
	 */
	public void setAutor(String autor) {
		Autor = autor;
	}
	/**
	 * @return the zanr
	 */
	public String getZanr() {
		return Zanr;
	}
	/**
	 * @param zanr the zanr to set
	 */
	public void setZanr(String zanr) {
		Zanr = zanr;
	}
	/**
	 * @return the datum
	 */
	public Date getDatum() {
		return datum;
	}
	/**
	 * @param datum the datum to set
	 */
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	/**
	 * @return the vreme
	 */
	public Time getVreme() {
		return vreme;
	}
	/**
	 * @param vreme the vreme to set
	 */
	public void setVreme(Time vreme) {
		this.vreme = vreme;
	}
	/**
	 * @return the cena
	 */
	public double getCena() {
		return cena;
	}
	/**
	 * @param cena the cena to set
	 */
	public void setCena(double cena) {
		this.cena = cena;
	}
	
}
