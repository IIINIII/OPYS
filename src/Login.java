import javax.swing.JFrame;
import javax.swing.JTextField;

import com.alee.laf.WebLookAndFeel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Login extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6932287921063358986L;
	public static Login ekran;
	public JTextField txtUsername;
	public JPasswordField pwdPassword;
	public static JButton btnLogin;
	public static DBUser user = null;

	public static void main(String[] args) {
		WebLookAndFeel.install();
		ekran = new Login();
		VT.setInfo("localhost", "opys_db", "ibrokhim", "150408");
		if(VT.startConnection())
			btnLogin.doClick();
	}
	
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(480, 660);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.decode("#FFFFFF"));
		
		txtUsername = new JTextField("247839");
		txtUsername.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsername.setBounds(105, 280, 264, 32);
		txtUsername.setColumns(32);
		txtUsername.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pwdPassword.requestFocus();
			}
		});
		getContentPane().add(txtUsername);

		btnLogin = new JButton("Login");
		
		pwdPassword = new JPasswordField("247839");
		pwdPassword.setHorizontalAlignment(SwingConstants.CENTER);
		pwdPassword.setBounds(105, 330, 264, 32);
		pwdPassword.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnLogin.doClick();
			}
		});
		getContentPane().add(pwdPassword);
		
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(VT.dbConnection==null) {
					VT.startConnection();
					return;
				}
				String query = "SELECT * FROM `personel` WHERE `sicil`='"+txtUsername.getText()+"'";
				ResultSet rs = VT.veriAl(query);
				try {
					if (rs.next())
					{
						String[] userInfo = new String[]{rs.getString("sicil"), rs.getString("ad"), rs.getString("soyad"), rs.getString("sifre"), rs.getString("yetki")};
						user = new DBUser(userInfo);
						if(user.password.equals(pwdPassword.getText())) {
							Login.ekran.setVisible(false);
							Manager.parent = Login.this;
							if(Manager.ekran!=null) {
								Manager.ekran.dispose();
								SharedClasses.JMenuBtn.idCounter=0;
							}
							Manager.ekran = new Manager();
						}
					} else {
						JOptionPane.showMessageDialog(Login.ekran, "Yanlış kullanıcı adı veya şifre!", "Hatalı giriş", JOptionPane.ERROR_MESSAGE);
					}
					pwdPassword.setText("");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnLogin.setBounds(105, 380, 264, 32);
		getContentPane().add(btnLogin);
		
		JLabel logo = null;
		try {
			logo = new JLabel(new ImageIcon(ImageIO.read(Login.class.getResourceAsStream("/images/logo.png"))));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		logo.setBounds(12, 85, 450, 183);
		getContentPane().add(logo);
		
		setVisible(true);
	}
}