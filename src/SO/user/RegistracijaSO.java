package SO.user;

import SO.OpstaSO;
import broker.Broker;
import domen.User;

public class RegistracijaSO  extends OpstaSO{

	@Override
	public void izvrsiKonkretnuSO(Object object) {
		User user = (User) object;
		Broker broker = new Broker();
		broker.registracija(user);
		
	}

}
