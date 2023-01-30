package controlerPL;

import SO.OpstaSO;
import SO.user.RegistracijaSO;
import SO.user.UserSO;
import domen.User;

public class ControlerPL {
	private static ControlerPL instanca;
	
	private ControlerPL() {
		
	}
	
	public static ControlerPL getInstanca() {
		if(instanca == null) {
			instanca = new ControlerPL();
		}
		return instanca;
	}
	public int login(User user) {
		OpstaSO operacija = new UserSO();
		operacija.izvrsiSistemskuOperaciju(user);
		return user.getStatus();
		
	}
	public void registracija(User user) {
		OpstaSO operacija = new RegistracijaSO();
		operacija.izvrsiSistemskuOperaciju(user);
		
	}

}
