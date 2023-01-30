package domen;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class User implements OpstiDomen{
	private int status, id;
	private String ime,prezime,username,password,email,mobilni;
		
	public String getMobilni() {
		return mobilni;
	}
	public void setMobilni(String mobilni) {
		this.mobilni = mobilni;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public PreparedStatement registruj(PreparedStatement ps) {
		try {
			ps.setString(1, ime);
			ps.setString(2, prezime);
			ps.setString(3, username);
			ps.setString(4, password);
			ps.setString(5, email);
			ps.setString(6, mobilni);
			ps.setInt(7, status);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ps;
	}

	
}
