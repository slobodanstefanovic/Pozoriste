package proxy;

import javax.swing.JOptionPane;

import view.MedjuForma;

public class ProxyLogin implements Proxy{

	@Override
	public int login(int status) {
		if(status == 1) {
			
			MedjuForma forma = new MedjuForma();
			forma.setVisible(true);
			
		}else if (status == 0){
					
		}else {
			
			JOptionPane.showMessageDialog(null, "Ne postojis");
		
		}
		return status;
	}

}
