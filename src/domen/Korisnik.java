package domen;

public class Korisnik {
private int IDkorisnika;
private String Ime,Prezime,Username,Password,email;

/**
 * @return the ime
 */
public String getIme() {
	return Ime;
}

/**
 * @param ime the ime to set
 */
public void setIme(String ime) {
	Ime = ime;
}

/**
 * @return the prezime
 */
public String getPrezime() {
	return Prezime;
}

/**
 * @param prezime the prezime to set
 */
public void setPrezime(String prezime) {
	Prezime = prezime;
}

/**
 * @return the username
 */
public String getUsername() {
	return Username;
}

/**
 * @param username the username to set
 */
public void setUsername(String username) {
	Username = username;
}

/**
 * @return the password
 */
public String getPassword() {
	return Password;
}

/**
 * @param password the password to set
 */
public void setPassword(String password) {
	Password = password;
}

/**
 * @return the email
 */
public String getEmail() {
	return email;
}

/**
 * @param email the email to set
 */
public void setEmail(String email) {
	this.email = email;
}

/**
 * @return the iDkorisnika
 */
public int getIDkorisnika() {
	return IDkorisnika;
}

/**
 * @param iDkorisnika the iDkorisnika to set
 */
public void setIDkorisnika(int iDkorisnika) {
	IDkorisnika = iDkorisnika;
}
}
