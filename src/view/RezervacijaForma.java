package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import domen.Korisnik;
import domen.Predstava;
import domen.Rezervacija;
import kontroler.Kontroler;

import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Time;
import java.sql.Date;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RezervacijaForma extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField tfNazivP;
	private JTextField tfBrojK;
	private DefaultTableModel dtm=new DefaultTableModel();
	private DefaultTableModel dtm1=new DefaultTableModel();
	private JTextField tfOdabranaP;
	private int BrojKarata,idr;
	private int RezervisanKarte,rezkarte,rezkarte2;
	private int id,Idkorisnik,idpr,id1,ns;
	private JTable table_1;
	private double CenaK,ucena;
	private String Nazivp;
	private Date Datum;
	private Time Vreme;
	private JTextField tfUkupanIznos;
	private JTextField tfRezervisaneKarte;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RezervacijaForma frame = new RezervacijaForma();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param iDKorisnik2 
	 */
	public RezervacijaForma() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 946, 796);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 149, 237));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(47, 148, 685, 255);
		contentPane.add(panel);
		table = new JTable(dtm);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setViewportView(table);
		scrollPane.setBounds(10, 11, 665, 233);
		panel.add(scrollPane);
		
		
		
		
		JLabel lblNewLabel = new JLabel("Pretrazivanje");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(10, 55, 125, 14);
		contentPane.add(lblNewLabel);
		
		tfNazivP = new JTextField();
		tfNazivP.setBounds(115, 54, 163, 20);
		contentPane.add(tfNazivP);
		tfNazivP.setColumns(10);
		
		JButton btnNewButton = new JButton("Pretrazi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pretraziPodatke();
			}

		
		});
		btnNewButton.setBackground(new Color(255, 255, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(310, 51, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Broj Karata");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1.setBounds(452, 430, 87, 14);
		contentPane.add(lblNewLabel_1);
		
		tfBrojK = new JTextField();
		tfBrojK.setBounds(556, 429, 54, 20);
		contentPane.add(tfBrojK);
		tfBrojK.setColumns(10);

	   
	    
		
		JButton btnNewButton_1 = new JButton("Rezervisi");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String bk=null;
				bk=tfBrojK.getText();
				RezervisanKarte=Integer.parseInt(bk);
				//Idkorisnik=Logovanje.getIDKorisnik2();
				int tk=BrojKarata-RezervisanKarte;
				ucena=RezervisanKarte*CenaK;
				if(tk>=0) {
				Kontroler.getInstanca().izmeniPredstavu(BrojKarata,RezervisanKarte,id);
				srediPodatke();
				//srediPodatke1();
				
				Kontroler.getInstanca().upisi(RezervisanKarte,id,Idkorisnik,CenaK,ucena,Datum,Vreme);
				srediPodatke3();
				}
				else {
					JOptionPane.showMessageDialog(null, "Ne postoji Dovoljno Karata");
				}
			}

		

			
		});
		btnNewButton_1.setBackground(new Color(46, 139, 87));
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(651, 426, 104, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblOdabranapredstava = new JLabel("OdabranaPredstava:");
		lblOdabranapredstava.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblOdabranapredstava.setBounds(72, 430, 153, 14);
		contentPane.add(lblOdabranapredstava);
		
		tfOdabranaP = new JTextField();
		tfOdabranaP.setBounds(235, 429, 169, 20);
		contentPane.add(tfOdabranaP);
		tfOdabranaP.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(223, 488, 685, 207);
		contentPane.add(panel_1);
		table_1 = new JTable(dtm1);
		JScrollPane scrollPane_1 = new JScrollPane(table_1);
		scrollPane_1.setBounds(10, 11, 665, 185);
		scrollPane_1.setViewportView(table_1);
		panel_1.add(scrollPane_1);
		
		
		
		
		JLabel lblRezervisnaeKarte = new JLabel("Moje Rezervacije");
		lblRezervisnaeKarte.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblRezervisnaeKarte.setBounds(72, 517, 141, 14);
		contentPane.add(lblRezervisnaeKarte);
		
		JLabel lblNewLabel_2 = new JLabel("Ukupan Iznos:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(651, 714, 117, 14);
		contentPane.add(lblNewLabel_2);
		
		tfUkupanIznos = new JTextField();
		tfUkupanIznos.setBounds(777, 713, 131, 20);
		contentPane.add(tfUkupanIznos);
		tfUkupanIznos.setColumns(10);
		
		JButton btnIzmeniRez = new JButton("IzmeniRezervaciju");
		btnIzmeniRez.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String NovaRezervacija=tfRezervisaneKarte.getText().toString();
				rezkarte2=Integer.parseInt(NovaRezervacija);
				 if(rezkarte2==0) {
					 JOptionPane.showMessageDialog(null, "Broj Rezervisanih karata ne moze biti 0,Ako zelite da izbrisete podatke idite na dugme izbrisi" );
				 }else if(BrojKarata-rezkarte2<0) {
					 JOptionPane.showMessageDialog(null, "Nema dovoljno Karata" );
				 }else {
				
					
				Kontroler.getInstanca().izmeniPredstavu3(idpr,BrojKarata,rezkarte,rezkarte2);
				srediPodatke();
				Kontroler.getInstanca().izmeniRezervaciju2(idr,rezkarte2);
				srediPodatke3();
					
				 }
				
				
			}
		});
		btnIzmeniRez.setBackground(new Color(218, 165, 32));
		btnIzmeniRez.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnIzmeniRez.setBounds(10, 710, 163, 23);
		contentPane.add(btnIzmeniRez);
		
		JButton btnObrisiRez = new JButton("ObrisiRezervaciju");
		btnObrisiRez.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String NovaRezervacija=tfRezervisaneKarte.getText().toString();
				rezkarte2=Integer.parseInt(NovaRezervacija);
			    
				Kontroler.getInstanca().izmeniPredstavu2(rezkarte2,idpr,BrojKarata);
				srediPodatke();
				
				Kontroler.getInstanca().izbrisiRezervaciju(idr,rezkarte);
				srediPodatke3();
				
				
				
				
				JOptionPane.showMessageDialog(null, "Izbrisani podaci !!");
				
				
			}
		});
		btnObrisiRez.setBackground(new Color(220, 20, 60));
		btnObrisiRez.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnObrisiRez.setBounds(452, 710, 176, 23);
		contentPane.add(btnObrisiRez);
		
		tfRezervisaneKarte = new JTextField();
		tfRezervisaneKarte.setBounds(351, 713, 86, 20);
		contentPane.add(tfRezervisaneKarte);
		tfRezervisaneKarte.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Rezervisane Karte");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(190, 716, 141, 14);
		contentPane.add(lblNewLabel_3);
		
table.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
			int red=table.getSelectedRow();//selektovani red u tabeli
			
	        String BrojK=null,nazivp,idv,cena2=null,datum,vreme;
	         idv = (table.getModel().getValueAt(red, 0).toString());
				id=Integer.valueOf(idv);
	         nazivp = (table.getModel().getValueAt(red, 2).toString());
	         datum=(table.getModel().getValueAt(red, 3).toString());
				Datum=Date.valueOf(datum);
				vreme=(table.getModel().getValueAt(red, 4).toString());
				Vreme=Time.valueOf(vreme);
	         
				cena2=(table.getModel().getValueAt(red, 5).toString());
				CenaK=Double.parseDouble(cena2);
			BrojK = (table.getModel().getValueAt(red, 8).toString()); 
			BrojKarata=Integer.parseInt(BrojK);
			tfOdabranaP.setText(nazivp);
			
			
			
			}
		});
table_1.addMouseListener(new MouseAdapter() {
	
	@Override
	public void mouseClicked(MouseEvent e) {
	int red=table_1.getSelectedRow();//selektovani red u tabeli
	
    String BrojK=null,idv,idp;
     idv = (table_1.getModel().getValueAt(red, 0).toString());
		idr=Integer.valueOf(idv);
      BrojK=(table_1.getModel().getValueAt(red, 4).toString());
      rezkarte=Integer.parseInt(BrojK);
      idp = (table_1.getModel().getValueAt(red, 7).toString());
		idpr=Integer.valueOf(idp);
		tfRezervisaneKarte.setText(BrojK);
		
	
	
	
	}
});
		
		Object[]kolone=new Object[9];
		kolone[0]="IDPredstave";
		kolone[1]="NazivPozorista";
		kolone[2]="NazivPredstave";
		kolone[3]="Datum";
		kolone[4]="Vreme";
		kolone[5]="CenaKarte";
		kolone[6]="Autor";
		kolone[7]="Zanr";
		kolone[8]="BrojKarata";
		dtm.addColumn(kolone[0]);
		dtm.addColumn(kolone[1]);
		dtm.addColumn(kolone[2]);
		dtm.addColumn(kolone[3]);
		dtm.addColumn(kolone[4]);
		dtm.addColumn(kolone[5]);
		dtm.addColumn(kolone[6]);
		dtm.addColumn(kolone[7]);
		dtm.addColumn(kolone[8]);
		table.removeColumn(table.getColumnModel().getColumn(0));
		
		srediPodatke();
		Object[]kolone1=new Object[10];
		kolone1[0]="ID";
		kolone1[1]="NazivPredstave";
		kolone1[2]="Datum";
		kolone1[3]="Vreme";
		kolone1[4]="BrojKarata";
		kolone1[5]="CenaJedneKarte";
		kolone1[6]="Ukupna Cena";
		kolone1[7]="IDp";
		dtm1.addColumn(kolone1[0]);
		dtm1.addColumn(kolone1[1]);
		dtm1.addColumn(kolone1[2]);
		dtm1.addColumn(kolone1[3]);
		dtm1.addColumn(kolone1[4]);
		dtm1.addColumn(kolone1[5]);
		dtm1.addColumn(kolone1[6]);
		dtm1.addColumn(kolone1[7]);
		table_1.removeColumn(table_1.getColumnModel().getColumn(0));
		
		
		srediPodatke3();
	}
	
	private void srediPodatke3() {
		// TODO Auto-generated method stub
		double ukupnaIznos = 0;
		Object[]redovi=new Object[9];
		
		dtm1.setRowCount(0);
		for(Rezervacija r:Kontroler.getInstanca().vratiRezervaciju()) {
			redovi[1]=r.getIdpredsatva();
			redovi[4]=r.getBrojkarata();
			redovi[5]=r.getCenakrte();
			redovi[6]=r.getUkupnacena();
			redovi[0]=r.getIdRezervacija();
			redovi[2]=r.getDatumpredstave();
			redovi[3]=r.getVremePredstave();
			redovi[7]=r.getIdPredstava2();
			double ukupnaCena =r.getCenakrte()*r.getBrojkarata();
			ukupnaIznos += ukupnaCena;
			dtm1.addRow(redovi);
			
			
					
						
		}
		tfUkupanIznos.setText(String.valueOf(ukupnaIznos));
		
	}
//
	private void srediPodatke() {
		// TODO Auto-generated method stub
		Object[]redovi=new Object[9];
		
		dtm.setRowCount(0);
		for(Predstava p:Kontroler.getInstanca().vratiPredstavu()) {
			
			redovi[0]=p.getIdPredstava();
			redovi[1]=p.getNazivPozorista();
			redovi[2]=p.getNazivPredstave();
			redovi[3]=p.getDatum();
			redovi[4]=p.getVreme();
			redovi[5]=p.getCena();
			redovi[6]=p.getAutor();
			redovi[7]=p.getZanr();
			redovi[8]=p.getBrojKarata();
			
			
			dtm.addRow(redovi);
		}
		
	}

	
	private void pretraziPodatke() {
		// TODO Auto-generated method stub
		dtm.setNumRows(0);
		String naziv=tfNazivP.getText();
		
				for(Predstava p:Kontroler.getInstanca().getAl()) {
					
					if (p.getNazivPredstave().toLowerCase().contains(naziv.toLowerCase())) {
				int idp=p.getIdPredstava();
				String nazivpo=p.getNazivPozorista();
				String nazivpr=p.getNazivPredstave();
				Date datum1=p.getDatum();
				Time vreme1=p.getVreme();
				double cenaka=p.getCena();
				String aut=p.getAutor();
				String zan=p.getZanr();
				int brk=p.getBrojKarata();
				Object[]niz= {idp,nazivpo,nazivpr,datum1,vreme1,cenaka,aut,zan,brk};
				dtm.addRow(niz);
			}
		
	}
}
	private void srediPodatke1() {
		// TODO Auto-generated method stub
		
		String naziv=tfOdabranaP.getText();
		
		
		for(Predstava p:Kontroler.getInstanca().getAl()) {
			
			if (p.getNazivPredstave().toLowerCase().contains(naziv.toLowerCase())) {
		
		
		String nazivpr=p.getNazivPredstave();
		double cenaka=p.getCena();
		String brk=tfBrojK.getText().toString();
		double uc=RezervisanKarte*CenaK;
		
		Object[]niz= {nazivpr,brk,cenaka,uc};
		dtm1.addRow(niz);
	}

}
	}
}