package controlerKI;

import controlerPL.ControlerPL;
import domen.User;

public class ControlerKI {
	private static ControlerKI instanca;
	
	private ControlerKI() {
		
	}
	public static ControlerKI getInstanca() {
		if(instanca == null) {
			instanca = new ControlerKI();
		}
		return instanca;
	}
	public int login(User user) {
		return ControlerPL.getInstanca().login(user);
	}


	public void registracija(User user) {
		ControlerPL.getInstanca().registracija(user);
		
	
	}

}
