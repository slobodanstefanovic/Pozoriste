package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import domen.Autor;
import domen.Pozoriste;
import kontroler.Kontroler;

import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class PozoristeForma extends JFrame {

	private JPanel contentPane;
	private JTextField tfNaziv;
	private JTextField tfAdresa;
	private DefaultTableModel dtm=new DefaultTableModel();
	private int id;
	private String Naziv,Adresa;
	private JTable table;

	
	public PozoristeForma() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 639, 449);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setLayout(null);
		panel.setBounds(39, 116, 512, 194);
		contentPane.add(panel);
		table = new JTable(dtm);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 11, 492, 172);
		panel.add(scrollPane);
		
table.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
			int red=table.getSelectedRow();//selektovani red u tabeli
			
	         String idp, imep,adresap; 
	         
			idp = (table.getModel().getValueAt(red, 0).toString());
			id=Integer.valueOf(idp);
			imep = (table.getModel().getValueAt(red, 1).toString());
			Naziv=imep;
			adresap = (table.getModel().getValueAt(red, 2).toString());
			Adresa=adresap;
			
			
			tfNaziv.setText(Naziv);
			tfAdresa.setText(Adresa);
			
			}
		});
		
		
		Object[]kolone=new Object[3];
		kolone[0]="ID";
		kolone[1]="Naziv Pozorista";
		kolone[2]="Adresa";
		dtm.addColumn(kolone[0]);
		dtm.addColumn(kolone[1]);
		dtm.addColumn(kolone[2]);
		table.removeColumn(table.getColumnModel().getColumn(0));
		srediPodatke();
		
		
		
		
		JLabel lblNewLabel = new JLabel("Naziv Pozori\u0161ta :");
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(49, 42, 165, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Adresa Pozori\u0161ta:");
		lblNewLabel_1.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1.setBounds(358, 42, 165, 14);
		contentPane.add(lblNewLabel_1);
		
		tfNaziv = new JTextField();
		tfNaziv.setBounds(48, 67, 182, 20);
		contentPane.add(tfNaziv);
		tfNaziv.setColumns(10);
		
		tfAdresa = new JTextField();
		tfAdresa.setBounds(358, 67, 182, 20);
		contentPane.add(tfAdresa);
		tfAdresa.setColumns(10);
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnDodaj.setBackground(new Color(50, 205, 50));
		btnDodaj.setBorder(null);
		btnDodaj.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String imePozorista=tfNaziv.getText().toString();
				String adresaPozorista=tfAdresa.getText().toString();
				if(imePozorista.equals("") || adresaPozorista.equals("")) {
					JOptionPane.showMessageDialog(null, "Nisu Uneti Podaci");
				}
				else {
				Kontroler.getInstanca().dodajPozoriste(imePozorista,adresaPozorista);
				JOptionPane.showMessageDialog(null, "Upisani podaci :)");
				srediPodatke();
				}
			}
		});
		btnDodaj.setBounds(49, 342, 89, 23);
		contentPane.add(btnDodaj);
		
		JButton btnIzmeni = new JButton("Izmeni");
		btnIzmeni.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnIzmeni.setBackground(new Color(255, 140, 0));
		btnIzmeni.setBorder(null);
		btnIzmeni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Kontroler.getInstanca().izmenPozoriste(id,tfNaziv.getText(),tfAdresa.getText());
				srediPodatke();
			}
		});
		btnIzmeni.setBounds(263, 342, 89, 23);
		contentPane.add(btnIzmeni);
		
		JButton btnIzbrisi = new JButton("Izbrisi");
		btnIzbrisi.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnIzbrisi.setBackground(new Color(255, 0, 0));
		btnIzbrisi.setBorder(null);
		btnIzbrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Kontroler.getInstanca().izbrisiPozoriste(id);
				tfAdresa.setText("");
				tfNaziv.setText("");
				
				srediPodatke();
				JOptionPane.showMessageDialog(null, "Izbrisani podaci !!");
			}
		});
		btnIzbrisi.setBounds(462, 342, 89, 23);
		contentPane.add(btnIzbrisi);
		
	}

	private void srediPodatke() {
		// TODO Auto-generated method stub
		Object[]redovi=new Object[3];
		dtm.setRowCount(0);
		for(Pozoriste a:Kontroler.getInstanca().vratiPozoriste()) {
			redovi[0]=a.getId();
			redovi[1]=a.getNaziv();
			redovi[2]=a.getAdresa();
			dtm.addRow(redovi);
		}
	}

}
