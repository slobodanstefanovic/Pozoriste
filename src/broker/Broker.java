package broker;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domen.User;
import konekcija.Konekcija;

public class Broker {
	
	public int vratiUsera(User user) { // BRIDGE DESIGN PATTERN
		String sql = "select * from korisnik where username = ? and password = ?";
		int status = -1;
		try {
			PreparedStatement preparedStatement = Konekcija.getInstanca().getConnection().prepareStatement(sql);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				status = resultSet.getInt("status");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	public void registracija(User user) {
		String sql = "Insert INTO korisnik(ime,prezime,username,password,email,mobilni,status) VALUES (?,?,?,?,?,?,?) ";
		try {
			PreparedStatement ps = Konekcija.getInstanca().getConnection().prepareStatement(sql);
			ps.setString(1, user.getIme());
			ps.setString(2, user.getPrezime());
			ps.setString(3, user.getUsername());
			ps.setString(4, user.getPassword());
			ps.setString(5, user.getEmail());
			ps.setString(6, user.getMobilni());
			ps.setInt(7, user.getStatus());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
