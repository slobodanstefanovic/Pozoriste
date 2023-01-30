package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Window.Type;

public class MedjuForma extends JFrame {

	private JPanel contentPane;

	public MedjuForma() {
		setTitle("MENU");
		setType(Type.POPUP);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 545, 413);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnAutor = new JButton("");
		btnAutor.setToolTipText("");
		btnAutor.setIcon(new ImageIcon("C:\\Users\\Vauceri\\Desktop\\Projekat-Rezervisanje-Karata-za-Pozoriste-master\\Pozoriste\\Slike\\6.png"));
		btnAutor.setBackground(new Color(30, 144, 255));
		btnAutor.setBorder(null);
		btnAutor.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 14));
		btnAutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AutorForma af = new AutorForma();
				af.setVisible(true);
			}
		});
		btnAutor.setBounds(72, 65, 145, 120);
		contentPane.add(btnAutor);

		JButton btnPozoriste = new JButton("");
		btnPozoriste.setIcon(new ImageIcon("C:\\Users\\Vauceri\\Desktop\\Projekat-Rezervisanje-Karata-za-Pozoriste-master\\Pozoriste\\Slike\\7.png"));
		btnPozoriste.setBackground(new Color(30, 144, 255));
		btnPozoriste.setBorder(null);
		btnPozoriste.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 14));
		btnPozoriste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PozoristeForma pf = new PozoristeForma();
				pf.setVisible(true);
			}
		});
		btnPozoriste.setBounds(296, 65, 145, 120);
		contentPane.add(btnPozoriste);

		JButton btnZanr = new JButton("");
		btnZanr.setIcon(new ImageIcon("C:\\Users\\Vauceri\\Desktop\\Projekat-Rezervisanje-Karata-za-Pozoriste-master\\Pozoriste\\Slike\\5.png"));
		btnZanr.setBackground(new Color(30, 144, 255));
		btnZanr.setBorder(null);
		btnZanr.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 14));
		btnZanr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ZanrForma zf = new ZanrForma();
				zf.setVisible(true);
			}
		});
		btnZanr.setBounds(72, 196, 154, 120);
		contentPane.add(btnZanr);

		JButton btnPredstava = new JButton("");
		btnPredstava.setIcon(new ImageIcon("C:\\Users\\Vauceri\\Desktop\\Projekat-Rezervisanje-Karata-za-Pozoriste-master\\Pozoriste\\Slike\\32.png"));
		btnPredstava.setBackground(new Color(30, 144, 255));
		btnPredstava.setBorder(null);
		btnPredstava.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 14));
		btnPredstava.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PredstavaForma prf = new PredstavaForma();
				prf.setVisible(true);
			}
		});
		btnPredstava.setBounds(296, 196, 145, 120);
		contentPane.add(btnPredstava);
	}
}
