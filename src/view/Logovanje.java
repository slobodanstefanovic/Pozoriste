package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlerKI.ControlerKI;
import domen.User;
import proxy.Proxy;
import proxy.ProxyLogin;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;

public class Logovanje extends JFrame {

	private JPanel contentPane;
	private JTextField tfUser;
	public static int IDKorisnik2;
	private JPasswordField pfPass;
	private boolean provera;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Logovanje frame = new Logovanje();
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
	public Logovanje() {
		setBackground(new Color(30, 144, 255));
		setType(Type.POPUP);
		setTitle("LOGIN");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 469, 334);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("");  //LOGIN SLIKA
		lblNewLabel.setIcon(new ImageIcon("Login.png"));
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(85, 43, 48, 54);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel(""); //PASSWORD SLIKA
		lblNewLabel_1.setIcon(new ImageIcon("Pass.png"));
		lblNewLabel_1.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1.setBounds(85, 108, 48, 56);
		contentPane.add(lblNewLabel_1);

		tfUser = new JTextField();
		tfUser.setBackground(new Color(255, 250, 250));
		tfUser.setBounds(171, 57, 100, 20);
		tfUser.setBorder(null);
		contentPane.add(tfUser);
		tfUser.setColumns(10);

		JButton btnLogin = new JButton(""); // LOGIN DUGME
		btnLogin.setIcon(new ImageIcon("Enter Login.png"));
		btnLogin.setBorder(null);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = tfUser.getText();
				char[] pass = pfPass.getPassword();
				String password = String.copyValueOf(pass);
					if(username.equals("") || (password.equals(""))){
						JOptionPane.showMessageDialog(null, "Potrebno je da popunite sva polja");
					}else {
						User user = new User();
						user.setUsername(username);
						user.setPassword(password);
						int status = ControlerKI.getInstanca().login(user);
						Proxy proxy = new ProxyLogin();
						proxy.login(status);
					}
					
			}
		});
		btnLogin.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 18));
		btnLogin.setBackground(new Color(30, 144, 255));
		btnLogin.setBounds(103, 195, 100, 77);
		contentPane.add(btnLogin);

		pfPass = new JPasswordField();
		pfPass.setBounds(171, 126, 100, 20);
		pfPass.setBorder(null);
		contentPane.add(pfPass);

		JCheckBox cbSee = new JCheckBox("Show Password");
		cbSee.setBackground(new Color(30, 144, 255));
		cbSee.setFont(new Font("Tempus Sans ITC", Font.ITALIC, 12));
		cbSee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if (cbSee.isSelected()) {
					pfPass.setEchoChar((char) 0);
				} else {
					pfPass.setEchoChar('*');
				}
			}
		});
		cbSee.setBounds(287, 125, 107, 23);
		contentPane.add(cbSee);

		JButton btnNewButton = new JButton("Registracija");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegistracijaForma rf = new RegistracijaForma();
				rf.setVisible(true);
			}
		});
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(new Color(30, 144, 255));
		btnNewButton.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 18));
		btnNewButton.setBounds(246, 212, 128, 23);
		contentPane.add(btnNewButton);
	}
}
/*if (cbpa1.isSelected()) {
pfPassword.setEchoChar((char) 0);
} else {

pfPassword.setEchoChar('*');
}*/
