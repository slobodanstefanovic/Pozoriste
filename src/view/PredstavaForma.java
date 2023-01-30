package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;



import domen.Autor;
import domen.Pozoriste;
import domen.Predstava;
import domen.Zanr;
import kontroler.Kontroler;

import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JTable;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.Time;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class PredstavaForma extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel dtm=new DefaultTableModel();
	private int id,BrojKarata,BrojKarata2;
	private int idAutora,IDZanr,IDPozoriste;
	private JComboBox cbAutor,cbZanr,cbPozoriste;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JTextField tfNazivPredstave;
	private JTextField tfDatum;
	private JTextField tfVreme;
	private JTextField tfCenaKarte;
	private JTextField tfBrojKarata;
	private Date Datum,Datum2;
	private Time Vreme,Vreme2;
	private double CenaKarte,Cenak;
	private int idpred;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PredstavaForma frame = new PredstavaForma();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PredstavaForma() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 995, 625);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(135, 294, 685, 255);
		contentPane.add(panel);
		table = new JTable(dtm);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 11, 665, 233);
		panel.add(scrollPane);
table.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
			int red=table.getSelectedRow();//selektovani red u tabeli
			
	        String BrojK=null,nazivp,idv,cena2=null,datum,vreme;
	        Object imeautora,imePozorista,imezanra;
	         idv = (table.getModel().getValueAt(red, 0).toString());
				idpred=Integer.valueOf(idv);
				
	         nazivp = (table.getModel().getValueAt(red, 2).toString());
	         cena2=(table.getModel().getValueAt(red, 5).toString());
				Cenak=Double.parseDouble(cena2);
				 imeautora=(table.getModel().getValueAt(red, 6));
				 cbAutor.setSelectedItem(imeautora);
				 imePozorista=(table.getModel().getValueAt(red, 1));
				 cbPozoriste.setSelectedItem(imePozorista);
				 imezanra=(table.getModel().getValueAt(red, 7));
				 cbZanr.setSelectedItem(imezanra);
			BrojK = (table.getModel().getValueAt(red, 8).toString()); 
			BrojKarata2=Integer.parseInt(BrojK);
			datum=(table.getModel().getValueAt(red, 3).toString());
			Datum2=Date.valueOf(datum);
			vreme=(table.getModel().getValueAt(red, 4).toString());
			Vreme2=Time.valueOf(vreme);
			tfNazivPredstave.setText(nazivp);
			tfBrojKarata.setText(BrojK);
			tfCenaKarte.setText(cena2);
	        tfDatum.setText(datum);
	        tfVreme.setText(vreme);
			
			
			}
		});
		
		
		
		cbAutor = new JComboBox();
		cbAutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String imeAutora = cbAutor.getSelectedItem().toString();
				for (Autor a : Kontroler.getInstanca().vratiAutora()) {

					if (imeAutora.equals(a.getIme())) {

						idAutora = a.getId();

					}

				}
			}
		});
		cbAutor.setBounds(234, 58, 240, 20);
		contentPane.add(cbAutor);
		
		lblNewLabel = new JLabel("Autor");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(135, 61, 46, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Zanr");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(135, 115, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		cbZanr = new JComboBox();
		cbZanr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String imeZanra = cbZanr.getSelectedItem().toString();
				for (Zanr z : Kontroler.getInstanca().VratiZanr()) {

					if (imeZanra.equals(z.getNaziv())) {

						IDZanr = z.getId();

					}

				}
				
			}
		});
		cbZanr.setBounds(234, 112, 240, 20);
		contentPane.add(cbZanr);
		
		lblNewLabel_2 = new JLabel("Pozoriste");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(135, 159, 91, 14);
		contentPane.add(lblNewLabel_2);
		
		cbPozoriste = new JComboBox();
		cbPozoriste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String imePozorista = cbPozoriste.getSelectedItem().toString();
				for (Pozoriste p : Kontroler.getInstanca().vratiPozoriste()) {

					if (imePozorista.equals(p.getNaziv())) {

						IDPozoriste = p.getId();
                        
					}

				}
				
			}
		});
		cbPozoriste.setBounds(234, 158, 247, 20);
		contentPane.add(cbPozoriste);
		
		lblNewLabel_3 = new JLabel("Naziv Predstave");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(128, 209, 121, 14);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Datum");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(135, 261, 91, 14);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Vreme");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(558, 61, 55, 14);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("CenaKarte");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setBounds(558, 117, 86, 14);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Broj Karata");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_7.setBounds(558, 161, 86, 14);
		contentPane.add(lblNewLabel_7);
		
		tfNazivPredstave = new JTextField();
		tfNazivPredstave.setBounds(248, 208, 256, 20);
		contentPane.add(tfNazivPredstave);
		tfNazivPredstave.setColumns(10);
		
		tfDatum = new JTextField();
		tfDatum.setBounds(242, 260, 133, 20);
		contentPane.add(tfDatum);
		tfDatum.setColumns(10);
		
		tfVreme = new JTextField();
		tfVreme.setBounds(666, 58, 86, 20);
		contentPane.add(tfVreme);
		tfVreme.setColumns(10);
		
		tfCenaKarte = new JTextField();
		tfCenaKarte.setBounds(666, 114, 86, 20);
		contentPane.add(tfCenaKarte);
		tfCenaKarte.setColumns(10);
		
		tfBrojKarata = new JTextField();
		tfBrojKarata.setBounds(666, 158, 86, 20);
		contentPane.add(tfBrojKarata);
		tfBrojKarata.setColumns(10);
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.setBackground(new Color(50, 205, 50));
		btnDodaj.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String imePredstave=tfNazivPredstave.getText().toString();
				String datumPredstave=tfDatum.getText().toString();
				Datum=Date.valueOf(datumPredstave);
				String vremePredstave=tfVreme.getText().toString();
				Vreme=Time.valueOf(vremePredstave);
				String cenakartep=tfCenaKarte.getText().toString();
				CenaKarte=Double.parseDouble(cenakartep);
				String brojkaratap=tfBrojKarata.getText().toString();
				BrojKarata=Integer.parseInt(brojkaratap);
				if(imePredstave.equals("") || datumPredstave.equals("") || vremePredstave.equals("") || cenakartep.equals("") || brojkaratap.equals("") ) {
					JOptionPane.showMessageDialog(null, "Nisu Uneti Podaci");
				}
				else {
				Kontroler.getInstanca().dodajPredstavu(imePredstave,idAutora,IDPozoriste,IDZanr,Datum,Vreme,CenaKarte,BrojKarata);
				JOptionPane.showMessageDialog(null, "Upisani podaci :)");
				srediPodatke();
				}
			}
		});
		btnDodaj.setBounds(571, 207, 89, 23);
		contentPane.add(btnDodaj);
		
		JButton btnIzmeni = new JButton("Izmeni");
		btnIzmeni.setBackground(new Color(255, 127, 80));
		btnIzmeni.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnIzmeni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Kontroler.getInstanca().izmenPredstavu(idpred,idAutora,IDPozoriste,IDZanr,tfBrojKarata.getText(),tfNazivPredstave.getText(),tfCenaKarte.getText(),tfDatum.getText(),tfVreme.getText());
				srediPodatke();
			}
		});
		btnIzmeni.setBounds(571, 260, 89, 23);
		contentPane.add(btnIzmeni);
		
		JButton btnIzbrisi = new JButton("Izbrisi");
		btnIzbrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Kontroler.getInstanca().izbrisiPredstavu(idpred);
				tfBrojKarata.setText("");
				tfCenaKarte.setText("");
				tfDatum.setText("");
				tfNazivPredstave.setText("");
				tfVreme.setText("");
				
				srediPodatke();
				JOptionPane.showMessageDialog(null, "Izbrisani podaci !!");
				
				
			}
		});
		btnIzbrisi.setBackground(new Color(255, 0, 0));
		btnIzbrisi.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnIzbrisi.setBounds(731, 207, 89, 23);
		contentPane.add(btnIzbrisi);
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
		srediFormu();
		
		
		
	}

	private void srediFormu() {
		// TODO Auto-generated method stub
		for (Autor a : Kontroler.getInstanca().vratiAutora()) {

			cbAutor.addItem(a.getIme());

		}
		for (Zanr z : Kontroler.getInstanca().VratiZanr()) {

			cbZanr.addItem(z.getNaziv());

		}
		for (Pozoriste p : Kontroler.getInstanca().vratiPozoriste()) {

			cbPozoriste.addItem(p.getNaziv());

		}
	}

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
}
