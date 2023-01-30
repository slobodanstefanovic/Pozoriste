package broker;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import domen.Autor;
import domen.Korisnik;
import domen.Pozoriste;
import domen.Predstava;
import domen.Rezervacija;
import domen.Zanr;
import view.Logovanje;

public class DBKomunikacija {
	public static DBKomunikacija broker;
	private Connection con;
	private int IDkorisnik;
	
	public static DBKomunikacija getBroker() {
		if(broker==null) {
			broker=new DBKomunikacija();
		}
		return broker;
	}
	
	private DBKomunikacija() {
		ucitajDriver();
	}

	private void ucitajDriver() {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void otvoriKonekciju() {
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost/pozoriste", "root", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void zatvoriKonekciju() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean vratiKorisnika(String user, String pass) {
		// TODO Auto-generated method stub
				ResultSet rs=null;
				Statement st=null;
				boolean pomocna=false;
				String korisnik=null;
				
				String sql="SELECT * FROM korisnik WHERE username='" +user+ "'AND password='" +pass+ "'";
				try {
					st=con.createStatement();
					rs=st.executeQuery(sql);
					
					if (rs.next()==false) {
						korisnik="";		
					}else {
					 korisnik = rs.getString("username");
					}
						
					if(korisnik.isEmpty() || korisnik==null) {
						pomocna=false;}
					else {
						pomocna=true;
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					if(korisnik==null) {
						pomocna=false;
					}
				}
				return pomocna;
		
		
		
	}

	public ArrayList<Predstava> vratiPredstavu() {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		Statement st = null;
		ArrayList<Predstava> al = new ArrayList<>();
		String sql="SELECT * FROM `predstava` INNER JOIN pozoriste ON pozoriste.IDPozoriste=predstava.IDPozoriste INNER JOIN autor on autor.IDAutor=predstava.IDAutor INNER JOIN zanr ON zanr.IDZanr=predstava.IDZanr";
				
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
		 
		    
			while (rs.next()) {
				Predstava p = new Predstava();
				p.setIdPredstava(rs.getInt("IDPredstava"));
				p.setNazivPozorista(rs.getString("NazivPoz"));
				p.setNazivPredstave(rs.getString("Naziv"));
				p.setDatum(rs.getDate("Datum"));
				p.setVreme(rs.getTime("Vreme"));
				p.setCena(rs.getDouble("CenaKarte"));
				p.setAutor(rs.getString("Ime"));
				p.setZanr(rs.getString("NazivZanra"));
				p.setBrojKarata(rs.getInt("BrojKarata"));
				al.add(p);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;
		
		
	}

	public void izmeniPredstavu(int brojKarata, int rezervisanKarte,int id) {
		// TODO Auto-generated method stub
		int NovoStanje=brojKarata-rezervisanKarte;
		
		String izmena = "UPDATE predstava SET BrojKarata='" + NovoStanje +  "' where  IDPredstava=" + id + "";
			

		try {

			PreparedStatement ps = con.prepareStatement(izmena);
			ps.execute();
			JOptionPane.showMessageDialog(null, "Uspesna Rezervacija");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
		}
		}
	

	public void upisi( int rezervisanKarte,int id,int idk,double cenak,double ucena,Date datum,Time vreme) {
		// TODO Auto-generated method stub
	String sql="INSERT INTO rezervacija(IDKorisnik,IDPredstava,BrojKarataR,CenaKarte,UkupnaCena,Datump,Vremep,IDPredstava2) VALUES(?,?,?,?,?,?,?,?)";
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, idk);
			ps.setInt(2, id);
			ps.setInt(3, rezervisanKarte);
			ps.setDouble(4, cenak);
			ps.setDouble(5, ucena);
			ps.setDate(6, datum);
			ps.setTime(7, vreme);
			ps.setInt(8, id);
			ps.execute();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<Autor> vratiAutora() {
		// TODO Auto-generated method stub
				ResultSet rs = null;
				Statement st = null;
				ArrayList<Autor> al = new ArrayList<>();
				String sql = "SELECT * from autor";
				try {
					st = con.createStatement();
					rs = st.executeQuery(sql);
					
					while (rs.next()) {
						Autor a = new Autor();
						a.setId(rs.getInt("IDAutor"));
						a.setIme(rs.getString("Ime"));
						al.add(a);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
				
		
		return al;
	}

	public void dodajAutora(String imeAutora) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO autor(Ime)VALUES(?) ";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, imeAutora);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void izmeniAutora(int id, String ime) {
		// TODO Auto-generated method stub
		String izmena = "UPDATE autor SET Ime='" + ime +  "' where  IDAutor=" + id + "";
		try {
			PreparedStatement ps = con.prepareStatement(izmena);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Greska nije promenjena stavka");
		}
	}

	public void izbrisiAutora(int id) {
		// TODO Auto-generated method stub
		PreparedStatement ps;
		String sql = "delete from autor where IDAutor=" + id + "";
		try {
			ps = con.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public ArrayList<Pozoriste> vratiPozoriste() {
		ResultSet rs = null;
		Statement st = null;
		ArrayList<Pozoriste> al = new ArrayList<>();
		String sql = "SELECT * from pozoriste";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			while (rs.next()) {
				Pozoriste p = new Pozoriste();
				p.setId(rs.getInt("IDPozoriste"));
				p.setNaziv(rs.getString("NazivPoz"));
				p.setAdresa(rs.getString("Adresa"));
				al.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		

return al;
	}

	public void izmeniPozoriste(int id, String naziv, String adresa) {
		// TODO Auto-generated method stub
		String izmena = "UPDATE pozoriste SET NazivPoz= ' " + naziv + " ' , Adresa=' " + adresa
				+ " ' where IDPozoriste=  " + id + "  ";
		try {
			PreparedStatement ps = con.prepareStatement(izmena);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Greska nije promenjena stavka");
		}
	}

	public void dodajPozoriste(String imePozorista, String adresaPozorista) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO pozoriste(NazivPoz,Adresa)VALUES(?,?) ";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, imePozorista);
			ps.setString(2, adresaPozorista);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void izbrisiPozoriste(int id) {
		// TODO Auto-generated method stub
		PreparedStatement ps;
		String sql = "delete from pozoriste where IDPozoriste=" + id + "";
		try {
			ps = con.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public ArrayList<Zanr> vratiZanr() {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		Statement st = null;
		ArrayList<Zanr> al = new ArrayList<>();
		String sql = "SELECT * from zanr";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			while (rs.next()) {
				Zanr z = new Zanr();
				z.setId(rs.getInt("IDZanr"));
				z.setNaziv(rs.getString("NazivZanra"));
				al.add(z);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		

return al;
		
	}

	public void dodajZanr(String imeZanra) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO zanr(NazivZanra)VALUES(?) ";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, imeZanra);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void izmeniZanr(int id, String naziv) {
		String izmena = "UPDATE zanr SET NazivZanra='" + naziv +  "' where  IDZanr=" + id + "";
		try {
			PreparedStatement ps = con.prepareStatement(izmena);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Greska nije promenjena stavka");
		}
	
		
		
		
	}

	public void izbrisiZanr(int id) {
		// TODO Auto-generated method stub
		PreparedStatement ps;
		String sql = "delete from zanr where IDZanr=" + id + "";
		try {
			ps = con.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void dodajPredstava(String imePredstave, int idAutora, int iDPozoriste, int iDZanr, Date datum, Time vreme,
			double cenaKarte, int brojKarata) {
		String sql = "INSERT INTO predstava(IDPozoriste,Naziv,Datum,Vreme,CenaKarte,IDAutor,IDZanr,BrojKarata)VALUES(?,?,?,?,?,?,?,?) ";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, iDPozoriste);
			ps.setString(2, imePredstave);
			ps.setDate(3, datum);
			ps.setTime(4,vreme);
			ps.setDouble(5, cenaKarte);
			ps.setInt(6, idAutora);
			ps.setInt(7, iDZanr);
			ps.setInt(8,brojKarata);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	

	public void izmeniPredstavu(int idpred, int idAutora, int iDPozoriste, int iDZanr, String brojk, String naziv,
			String cena, String datum, String vreme) {
		// TODO Auto-generated method stub
		double novacena=Double.valueOf(cena);
		int novibroj= Integer.valueOf(brojk);
		Date novidatum=Date.valueOf(datum);
		Time novovrem=Time.valueOf(vreme);
		String izmena = "UPDATE predstava SET IDPozoriste='" + iDPozoriste +  "',Naziv='" +naziv+"',Datum='" +novidatum+"',Vreme='"+novovrem +"',CenaKarte='"+novacena+"',IDAutor='"+idAutora+"',IDZanr='"+iDZanr+"',BrojKarata='"+novibroj+"' where  IDPredstava=" + idpred + "";
		try {
			PreparedStatement ps = con.prepareStatement(izmena);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Greska nije promenjena stavka");
	}

	

		
	}

	public ArrayList<Korisnik> vratiKorisnika2() {
		ResultSet rs = null;
		Statement st = null;
		ArrayList<Korisnik> al = new ArrayList<>();
		String sql = "SELECT * from korisnik";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			while (rs.next()) {
				Korisnik k = new Korisnik();
				k.setIDkorisnika(rs.getInt("IDKorisnik"));
				k.setIme(rs.getString("Ime"));
				k.setPrezime(rs.getString("Prezime"));
				k.setUsername(rs.getString("Username"));
				k.setPassword(rs.getString("Password"));
				k.setEmail(rs.getString("Email"));
				al.add(k);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		

return al;
		
		
		
	}

	public void dodajKorisnika(String imekorisnika, String prezimekorisnika, String usernamekorisnika, String password,
			String emial) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO korisnik(Ime,Prezime,Username,Password,Email)VALUES(?,?,?,?,?) ";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, imekorisnika);
			ps.setString(2, prezimekorisnika);
			ps.setString(3, usernamekorisnika);
			ps.setString(4, password);
			ps.setString(5, emial);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void izbrisiPredstavu(int idpred) {
		// TODO Auto-generated method stub
		PreparedStatement ps;
		String sql = "delete from predstava where IDPredstava=" + idpred + "";
		try {
			ps = con.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Rezervacija> vratiRezervaziju() {
		//IDkorisnik=Logovanje.getIDKorisnik2();
		ResultSet rs = null;
		Statement st = null;
		ArrayList<Rezervacija> al = new ArrayList<>();
		String sql = "SELECT * FROM `rezervacija` INNER JOIN predstava ON predstava.IDPredstava=rezervacija.IDPredstava where IDKorisnik="+ IDkorisnik  +"";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			while (rs.next()) {
				Rezervacija r = new Rezervacija();
				r.setIdRezervacija(rs.getInt("IDRezervacija"));
				r.setIdkorisnik(rs.getInt("IDKorisnik"));
				r.setIdpredsatva(rs.getString("Naziv"));
				r.setBrojkarata(rs.getInt("BrojKarataR"));
			   r.setCenakrte(rs.getDouble("CenaKarte"));
			   r.setUkupnacena(rs.getDouble("UkupnaCena"));
			   r.setDatumpredstave(rs.getDate("Datum"));
			   r.setVremePredstave(rs.getTime("Vreme"));
			   r.setIdPredstava2(rs.getInt("IDPredstava2"));
				al.add(r);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		

return al;
		
		
		
	}

	public void izbrisiRezervaciju(int idr, int rezkarte) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				PreparedStatement ps;
				String sql = "delete from rezervacija where IDRezervacija=" + idr + "";
				try {
					ps = con.prepareStatement(sql);
					ps.execute();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}

	public void izmeniPredstavu2(int rezkarte2, int idpr,int brjk) {
		// TODO Auto-generated method stub
		
int NovoStanje2=brjk+(rezkarte2);

		
		String izmena = "UPDATE predstava SET BrojKarata='" + NovoStanje2 +  "' where  IDPredstava=" + idpr + "";
			

		try {

			PreparedStatement ps = con.prepareStatement(izmena);
			ps.execute();
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
		}
	}

	public void izmeniRezervaciju2(int idr, int rezkarte2) {
		// TODO Auto-generated method stub
		String izmena = "UPDATE rezervacija SET BrojKarataR='" + rezkarte2 +  "' where  IDRezervacija=" + idr + "";
		

		try {

			PreparedStatement ps = con.prepareStatement(izmena);
			ps.execute();
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
		}
		
	}

	public void izmeniPredstavu3(int idpr, int brojKarata, int rezkarte, int rezkarte2) {
		// TODO Auto-generated method stub
		int ns=rezkarte-rezkarte2;
		int nbk=brojKarata+ns;
		int ns1=rezkarte2-rezkarte;
		int nbk1=brojKarata-ns1;
if(rezkarte>rezkarte2) {
	
	String izmena = "UPDATE predstava SET BrojKarata='" + nbk +  "' where  IDPredstava=" + idpr + "";
	

	try {

		PreparedStatement ps = con.prepareStatement(izmena);
		ps.execute();
		

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
		
	}
}else if(rezkarte<rezkarte2) {
	
String izmena = "UPDATE predstava SET BrojKarata='" + nbk1 +  "' where  IDPredstava=" + idpr + "";
	

	try {

		PreparedStatement ps = con.prepareStatement(izmena);
		ps.execute();
		

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
		
	}
}
		
	
	}
}

	





	

