package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import domen.Autor;
import domen.Predstava;
import kontroler.Kontroler;

import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AutorForma extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel dtm=new DefaultTableModel();
	private JTextField tfIme;
	private int id;
	private String ImeAutora;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AutorForma frame = new AutorForma();
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
	public AutorForma() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 578, 447);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(37, 93, 288, 194);
		contentPane.add(panel);
		table = new JTable(dtm);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 11, 268, 172);
		panel.add(scrollPane);
		
table.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
			int red=table.getSelectedRow();//selektovani red u tabeli
			
	         String ida, imea; 
	         
			ida = (table.getModel().getValueAt(red, 0).toString());
			id=Integer.valueOf(ida);
			imea = (table.getModel().getValueAt(red, 1).toString());
			ImeAutora=imea;
			
			
			tfIme.setText(ImeAutora);
			
			}
		});
		
		Object[]kolone=new Object[2];
		kolone[0]="ID";
		kolone[1]="Ime Autora";
		dtm.addColumn(kolone[0]);
		dtm.addColumn(kolone[1]);
		table.removeColumn(table.getColumnModel().getColumn(0));
		srediPodatke();
		
		
		
		JLabel lblNewLabel = new JLabel("Ime Autora");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(48, 63, 105, 14);
		contentPane.add(lblNewLabel);
		
		tfIme = new JTextField();
		tfIme.setBounds(163, 62, 86, 20);
		contentPane.add(tfIme);
		tfIme.setColumns(10);
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.setBackground(new Color(34, 139, 34));
		btnDodaj.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String imeAutora=tfIme.getText().toString();
				if(imeAutora.equals("")) {
					JOptionPane.showMessageDialog(null, "Nisu Uneti Podaci");
				}
				else {
				Kontroler.getInstanca().dodajAutora(imeAutora);
				JOptionPane.showMessageDialog(null, "Upisani podaci :)");
				srediPodatke();
				}
			}
		});
		btnDodaj.setBounds(10, 319, 89, 23);
		contentPane.add(btnDodaj);
		
		JButton btnIzmeni = new JButton("Izmeni");
		btnIzmeni.setBackground(new Color(218, 165, 32));
		btnIzmeni.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnIzmeni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Kontroler.getInstanca().izmeniAutora(id,tfIme.getText());
				srediPodatke();
			}
		});
		btnIzmeni.setBounds(196, 319, 89, 23);
		contentPane.add(btnIzmeni);
		
		JButton btnIzbrisi = new JButton("Izbrisi");
		btnIzbrisi.setBackground(new Color(255, 0, 0));
		btnIzbrisi.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnIzbrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Kontroler.getInstanca().izbrisiAutora(id);
				tfIme.setText("");
				
				srediPodatke();
				JOptionPane.showMessageDialog(null, "Izbrisani podaci !!");
			}
		});
		btnIzbrisi.setBounds(409, 319, 89, 23);
		contentPane.add(btnIzbrisi);
	}

	private void srediPodatke() {
		// TODO Auto-generated method stub
		Object[]redovi=new Object[2];
		dtm.setRowCount(0);
		for(Autor a:Kontroler.getInstanca().vratiAutora()) {
			redovi[0]=a.getId();
			redovi[1]=a.getIme();
			dtm.addRow(redovi);
		}
	}
}
