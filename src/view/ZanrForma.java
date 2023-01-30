package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import domen.Pozoriste;
import domen.Zanr;
import kontroler.Kontroler;

import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ZanrForma extends JFrame {

	private JPanel contentPane;
	private JTextField tfNaziv;
	private DefaultTableModel dtm=new DefaultTableModel();
	private int id;
	private String Naziv;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZanrForma frame = new ZanrForma();
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
	public ZanrForma() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 562, 485);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(33, 130, 288, 194);
		contentPane.add(panel);
		table = new JTable(dtm);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 11, 268, 172);
		panel.add(scrollPane);
table.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
			int red=table.getSelectedRow();//selektovani red u tabeli
			
	         String idz, imez; 
	         
			idz = (table.getModel().getValueAt(red, 0).toString());
			id=Integer.valueOf(idz);
			imez = (table.getModel().getValueAt(red, 1).toString());
			Naziv=imez;
			
			
			tfNaziv.setText(Naziv);
			
			}
		});
Object[]kolone=new Object[2];
kolone[0]="ID";
kolone[1]="Naziv Zanra";
dtm.addColumn(kolone[0]);
dtm.addColumn(kolone[1]);
table.removeColumn(table.getColumnModel().getColumn(0));
srediPodatke();
		
		
		
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDodaj.setBackground(new Color(124, 252, 0));
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String imeZanra=tfNaziv.getText().toString();
				
				if(imeZanra.equals("")) {
					JOptionPane.showMessageDialog(null, "Nisu Uneti Podaci");
				}
				else {
				Kontroler.getInstanca().dodajZanr(imeZanra);
				JOptionPane.showMessageDialog(null, "Upisani podaci :)");
				srediPodatke();
				}
				
			}
		});
		btnDodaj.setBounds(64, 374, 89, 23);
		contentPane.add(btnDodaj);
		
		JButton btnIzmeni = new JButton("Izmeni");
		btnIzmeni.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnIzmeni.setBackground(new Color(173, 255, 47));
		btnIzmeni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Kontroler.getInstanca().izmenZanr(id,tfNaziv.getText());
				srediPodatke();
			}
		});
		btnIzmeni.setBounds(245, 374, 89, 23);
		contentPane.add(btnIzmeni);
		
		JButton btnIzbrisi = new JButton("Izbrisi");
		btnIzbrisi.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnIzbrisi.setBackground(new Color(124, 252, 0));
		btnIzbrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Kontroler.getInstanca().izbrisiZanr(id);
				tfNaziv.setText("");
				
				srediPodatke();
				JOptionPane.showMessageDialog(null, "Izbrisani podaci !!");
			}
		});
		btnIzbrisi.setBounds(411, 374, 89, 23);
		contentPane.add(btnIzbrisi);
		
		JLabel lblNewLabel = new JLabel("Naziv");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(64, 46, 77, 14);
		contentPane.add(lblNewLabel);
		
		tfNaziv = new JTextField();
		tfNaziv.setBounds(151, 43, 86, 20);
		contentPane.add(tfNaziv);
		tfNaziv.setColumns(10);
	}

	private void srediPodatke() {
		// TODO Auto-generated method stub
		Object[]redovi=new Object[2];
		dtm.setRowCount(0);
		for(Zanr a:Kontroler.getInstanca().VratiZanr()) {
			redovi[0]=a.getId();
			redovi[1]=a.getNaziv();
			dtm.addRow(redovi);
		}
		
	}
}
