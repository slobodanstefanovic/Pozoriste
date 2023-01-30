package konekcija;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Konekcija {
	private static Konekcija instanca;
	private Connection connection;
	
	public Connection getConnection() {
		return connection;
	}
	
	public Konekcija() {
		ucitajDriver();
	}
	private void ucitajDriver() {
			
	}
	public static Konekcija getInstanca() {
		if(instanca == null) {
			instanca = new Konekcija();
		}
		return instanca;
	}
	public void pokreniTransakciju() {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pozoriste", "root" ,"");
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void potvrdiTransakciju() {
		try {
			connection.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void zatvoriKonekciju() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void ponistiTransakciju() {
		try {
			connection.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}