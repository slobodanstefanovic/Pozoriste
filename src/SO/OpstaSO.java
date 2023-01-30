package SO;

import konekcija.Konekcija;

public abstract class OpstaSO {
	public void izvrsiSistemskuOperaciju(Object object) {
		try {
			pokreniTransakciju();
			izvrsiKonkretnuSO(object);
			potvrdiTransakciju();
			
		} catch (Exception e) {
			ponistiTransakciju();
		}finally {
			zatvoriKonekciju();
		}
		
	}
	public void zatvoriKonekciju() {
		Konekcija.getInstanca().zatvoriKonekciju();
	}
	public void ponistiTransakciju() {
		Konekcija.getInstanca().ponistiTransakciju();
	}
	public void pokreniTransakciju() {
		Konekcija.getInstanca().pokreniTransakciju();
	}
	public void potvrdiTransakciju(){
		Konekcija.getInstanca().potvrdiTransakciju();
	}
	public abstract void izvrsiKonkretnuSO(Object object);				

}


