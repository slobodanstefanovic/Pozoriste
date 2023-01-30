package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlerKI.ControlerKI;
import domen.User;
import kontroler.Kontroler;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class RegistracijaForma extends JFrame {

	private JPanel contentPane;
	private JTextField tfIme;
	private JTextField tfPrezime;
	private JTextField tfUsername;
	private JTextField tfEmail;
	private boolean provera, provera2, pomocna3;
	private String Username;
	private int brojac;
	private JPasswordField pfPassword;
	private JPasswordField pfPassword2;
	private JTextField tfMobilni;
	private JLabel lblSee1, lblSee2, lblDontSee1, lblDontSee2;
	

	public RegistracijaForma() {
		setTitle("REGISTRATION FORM");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 469, 521);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Ime");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		lblNewLabel.setBounds(39, 41, 46, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Prezime");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		lblNewLabel_1.setBounds(28, 88, 77, 17);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		lblNewLabel_2.setBounds(39, 140, 77, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		lblNewLabel_3.setBounds(39, 190, 77, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		lblNewLabel_4.setBounds(39, 238, 77, 14);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("E-mail");
		lblNewLabel_5.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		lblNewLabel_5.setBounds(39, 287, 46, 14);
		contentPane.add(lblNewLabel_5);

		tfIme = new JTextField();
		tfIme.setHorizontalAlignment(SwingConstants.CENTER);
		tfIme.setBounds(139, 39, 86, 23);
		contentPane.add(tfIme);
		tfIme.setColumns(10);

		tfPrezime = new JTextField();
		tfPrezime.setHorizontalAlignment(SwingConstants.CENTER);
		tfPrezime.setBounds(126, 87, 117, 23);
		contentPane.add(tfPrezime);
		tfPrezime.setColumns(10);

		tfUsername = new JTextField();
		tfUsername.setHorizontalAlignment(SwingConstants.CENTER);
		tfUsername.setBounds(139, 138, 86, 23);
		contentPane.add(tfUsername);
		tfUsername.setColumns(10);

		tfEmail = new JTextField();
		tfEmail.setHorizontalAlignment(SwingConstants.CENTER);
		tfEmail.setBounds(126, 284, 117, 23);
		contentPane.add(tfEmail);
		tfEmail.setColumns(10);

		JButton btnRegistracija = new JButton("Registruj Se");
		btnRegistracija.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 14));
		btnRegistracija.setBackground(new Color(30, 144, 255));
		btnRegistracija.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ime = tfIme.getText().toString();
				String prezime = tfPrezime.getText().toString();
				String username = tfUsername.getText().toString();
				char[]pass = pfPassword.getPassword();
				String password = String.copyValueOf(pass);
				char[]pass2	= pfPassword2.getPassword();
				String password2 = String.copyValueOf(pass2);
				String emial = tfEmail.getText().toString();
				String mobilni = tfMobilni.getText();
				int status = 0;
				
				User user = new User();
				user.setIme(ime);
				user.setPrezime(prezime);
				user.setUsername(username);
				user.setPassword(password);
				user.setEmail(emial);
				user.setMobilni(mobilni);
				user.setStatus(status);
				
				if (password.equals(password2)) {
					provera = true;

				} else {
					provera = false;
					JOptionPane.showMessageDialog(null, "Passwordi nisu isti");
				}
				if (emial.contains("@")) {
					provera2 = true;

				} else {
					provera2 = false;
					JOptionPane.showMessageDialog(null, "Email nije unet ispravno");
				}
				if (ime.equals("") || emial.equals("") || password.equals("") || password2.equals("")
						|| username.equals("")) {
					JOptionPane.showMessageDialog(null, "Nisu Uneti svi podaci");
				} else if (provera == true && provera2 == true) {
					
					ControlerKI.getInstanca().registracija(user);   
					JOptionPane.showMessageDialog(null, "Registracija Uspesna");
					Logovanje lf = new Logovanje();
					lf.setVisible(true);//DO OVDE
				}
			
				}

			}
		);
		btnRegistracija.setBounds(126, 390, 112, 23);
		contentPane.add(btnRegistracija);
		
		pfPassword = new JPasswordField();
		pfPassword.setHorizontalAlignment(SwingConstants.CENTER);
		pfPassword.setBounds(126, 188, 117, 23);
		contentPane.add(pfPassword);
		
		pfPassword2 = new JPasswordField();
		pfPassword2.setHorizontalAlignment(SwingConstants.CENTER);
		pfPassword2.setBounds(126, 236, 117, 23);
		contentPane.add(pfPassword2);
		
		JLabel lblNewLabel_5_1 = new JLabel("Mobile");
		lblNewLabel_5_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		lblNewLabel_5_1.setBounds(39, 336, 46, 14);
		contentPane.add(lblNewLabel_5_1);
		
		tfMobilni = new JTextField();
		tfMobilni.setHorizontalAlignment(SwingConstants.CENTER);
		tfMobilni.setColumns(10);
		tfMobilni.setBounds(139, 331, 86, 23);
		contentPane.add(tfMobilni);
		
		JLabel lblDontSee1 = new JLabel("");
		lblDontSee1.setIcon(new ImageIcon("C:\\Users\\SS\\Desktop\\Pozoriste 16.6\\Pozoriste16.6\\eye4.png"));
		lblDontSee1.setBounds(351, 166, 46, 38);
		contentPane.add(lblDontSee1);
		lblDontSee1.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				lblDontSee1.setVisible(false);
				lblSee1.setVisible(true);
				pfPassword.setEchoChar((char)0);
			}
		});
		JLabel lblSee1 = new JLabel("");
		lblSee1.setIcon(new ImageIcon("C:\\Users\\SS\\Desktop\\Pozoriste 16.6\\Pozoriste16.6\\eye3.png"));
		lblSee1.setBounds(275, 166, 46, 38);
		contentPane.add(lblSee1);
		lblSee1.addMouseListener(new MouseAdapter() {
		
			@Override
			public void mousePressed(MouseEvent e) {
				lblSee1.setVisible(false);
				lblDontSee1.setVisible(true);
				pfPassword.setEchoChar('*');
			}
		});
		
		
		JLabel lblDontSee2 = new JLabel("");
		lblDontSee2.setIcon(new ImageIcon("C:\\Users\\SS\\Desktop\\Pozoriste 16.6\\Pozoriste16.6\\eye3.png"));
		lblDontSee2.setBounds(275, 215, 46, 38);
		contentPane.add(lblDontSee2);
		lblDontSee2.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				lblDontSee2.setVisible(false);
				lblSee2.setVisible(true);
				pfPassword2.setEchoChar('*');
			}
		});
		
		
		JLabel lblSee2 = new JLabel("");
		lblSee2.setIcon(new ImageIcon("C:\\Users\\SS\\Desktop\\Pozoriste 16.6\\Pozoriste16.6\\eye4.png"));
		lblSee2.setBounds(351, 214, 46, 38);
		contentPane.add(lblSee2);
		lblSee2.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				lblSee2.setVisible(false);
				lblDontSee2.setVisible(true);
				pfPassword2.setEchoChar((char)0);
			}
		});
		

	}
}