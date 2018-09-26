import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.border.MatteBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JEditorPane;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.imageio.ImageIO;
import javax.swing.AbstractListModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

import java.util.Calendar;
import javax.swing.SpinnerNumberModel;

public class Manager extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2307957506224957874L;
	public static Manager ekran;
	public static JFrame parent;
	public static int MBWidth, MBHeight = 32, LineBetweenHeight=2;
	public static boolean LineBetweenBtns = true;
	private JTextField txtName;
	private JTextField txtSurname;
	private JTextField txtAuthority;
	private JPasswordField pwdOldPwd;
	private JPasswordField pwdNewPwd1;
	private JPasswordField pwdNewPwd2;
	private JTextField txtUsername;
	public static JPanel pnlSearchProject, pnlProfile, pnlReports, pnlRegisterObstacle, pnlSearchObstacle, pnlSearchResult, pnlRegisterProject;
	public int mbcounter = 0;
	public static JScrollPane tablePanel = null;
	private JTextField textField;
	private JTextField textField_2;
    public static JComboBox<TableRequest> comboBox;
    public static JButton btnEngelToExcel, btnShow;
    private JTextField textField_1;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;
    private JTextField textField_8;
    private JTextField textField_9;
    private JTextField textField_10;
    public static String[] takimlar,daireler,mudurlukler;
	
	@SuppressWarnings("unchecked")
	public Manager() {
		SharedFunctions.esneklikHazirla();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1282, 702);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);
		getContentPane().setBackground(Color.decode("#2196F3"));
		getContentPane().setLayout(null);
		
		JPanel viewPanel = new JPanel();
		viewPanel.setBackground(Color.decode("#FFFFFF"));
		viewPanel.setBounds(1, 1, 1280, 700);
		getContentPane().add(viewPanel);
		viewPanel.addMouseMotionListener(new MouseMotionListener() {
			
			int mx=-1,my=-1;
			
			@Override
			public void mouseMoved(MouseEvent e) {
				mx=e.getX();
				my=e.getY();
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				if(mx==-1)mx=e.getX();
				if(my==-1)my=e.getY();
				int dx = e.getX()-mx, dy = e.getY()-my;
				Manager.ekran.setLocation(Manager.ekran.getLocation().x+dx, Manager.ekran.getLocation().y+dy);
			}
		});
		viewPanel.requestFocus();
		viewPanel.setLayout(null);
		
		JPanel pnlSideBar = new JPanel();
		pnlSideBar.setBounds(0, 0, 240, 700);
		pnlSideBar.setBackground(Color.decode("#303641"));
		pnlSideBar.setLayout(new BoxLayout(pnlSideBar, BoxLayout.Y_AXIS));
		pnlSideBar.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, pnlSideBar.getBackground()));
		viewPanel.add(pnlSideBar);
		
		ImageIcon logo = null;
		try {
			logo = new ImageIcon(ImageIO.read(Login.class.getResourceAsStream("/images/logo64.png")));
		} catch (IOException e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
		}
		JLabel logoHolder = new JLabel(logo);
		logoHolder.setAlignmentX(Component.CENTER_ALIGNMENT);
		logoHolder.setBounds(0, 0, 256, logo.getIconHeight());
		logoHolder.setText("OPYS");
		logoHolder.setHorizontalTextPosition(JLabel.CENTER);
		logoHolder.setVerticalTextPosition(JLabel.BOTTOM);
		logoHolder.setFont(new Font("Montserrat Semi Bold", Font.PLAIN, 32));
		logoHolder.setForeground(Color.white);
		logoHolder.setFocusable(true);
		pnlSideBar.add(Box.createRigidArea(new Dimension(0,24)));
		pnlSideBar.add(logoHolder);
		pnlSideBar.add(Box.createRigidArea(new Dimension(0,24)));
		
		//if(LineBetweenBtns)panel.add(Box.createRigidArea(new Dimension(0,LineBetweenHeight)));
		SharedClasses.JMenuBtn btnProfile = new SharedClasses.JMenuBtn("Profil", 0, MBHeight, pnlSideBar.getBackground(), Color.decode("#AAABAE"));
		mbcounter ++;
		pnlSideBar.add(btnProfile);
		if(LineBetweenBtns)pnlSideBar.add(Box.createRigidArea(new Dimension(0,LineBetweenHeight)));
		SharedClasses.JMenuBtn btnReports = new SharedClasses.JMenuBtn("Raporlar", 0, MBHeight, pnlSideBar.getBackground(), Color.decode("#AAABAE"));
		mbcounter ++;
		pnlSideBar.add(btnReports);
		if(LineBetweenBtns)pnlSideBar.add(Box.createRigidArea(new Dimension(0,LineBetweenHeight)));
		SharedClasses.JMenuBtn btnSearchProject = new SharedClasses.JMenuBtn("Proje Sorgula", 0, MBHeight, pnlSideBar.getBackground(), Color.decode("#AAABAE"));
		mbcounter ++;
		pnlSideBar.add(btnSearchProject);
		if(LineBetweenBtns)pnlSideBar.add(Box.createRigidArea(new Dimension(0,LineBetweenHeight)));
		SharedClasses.JMenuBtn btnRegisterProject = new SharedClasses.JMenuBtn("Proje Kayıt", 0, MBHeight, pnlSideBar.getBackground(), Color.decode("#AAABAE"));
		mbcounter ++;
		pnlSideBar.add(btnRegisterProject);
		if(LineBetweenBtns)pnlSideBar.add(Box.createRigidArea(new Dimension(0,LineBetweenHeight)));
		SharedClasses.JMenuBtn btnSearchObstacle = new SharedClasses.JMenuBtn("Engel Sorgula", 0, MBHeight, pnlSideBar.getBackground(), Color.decode("#AAABAE"));
		mbcounter ++;
		pnlSideBar.add(btnSearchObstacle);
		if(LineBetweenBtns)pnlSideBar.add(Box.createRigidArea(new Dimension(0,LineBetweenHeight)));
		SharedClasses.JMenuBtn btnRegisterObstacle = new SharedClasses.JMenuBtn("Engel Kayıt", 0, MBHeight, pnlSideBar.getBackground(), Color.decode("#AAABAE"));
		mbcounter ++;
		pnlSideBar.add(btnRegisterObstacle);
		if(LineBetweenBtns)pnlSideBar.add(Box.createRigidArea(new Dimension(0,LineBetweenHeight)));
		SharedClasses.JMenuBtn btnExit = new SharedClasses.JMenuBtn("Çıkış", 0, MBHeight, pnlSideBar.getBackground(), Color.decode("#AAABAE"));
		mbcounter ++;
		pnlSideBar.add(btnExit);
		if(LineBetweenBtns)pnlSideBar.add(Box.createRigidArea(new Dimension(0,LineBetweenHeight)));
		
		pnlSideBar.add(Box.createRigidArea(new Dimension(0,(int) (700-mbcounter*(MBHeight+LineBetweenHeight)-200))));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.decode("#040707"));
		panel_1.setBounds(240, 999999, 1040, 150);
		panel_1.setVisible(false);
		viewPanel.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		Component horizontalGlue = Box.createHorizontalGlue();
		panel_1.add(horizontalGlue);
		
		JLabel devPic = new JLabel("");
		try {
			devPic.setIcon(new ImageIcon(ImageIO.read(Login.class.getResourceAsStream("/images/logo.png"))));
		} catch (IOException e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
		}
		panel_1.add(devPic);
		
		pnlProfile = new JPanel();
		pnlProfile.setVisible(false);
		pnlProfile.setBackground(Color.WHITE);
		pnlProfile.setBounds(999999, 10, 1020, 678);
		viewPanel.add(pnlProfile);
		pnlProfile.setLayout(null);
		
		JPanel pnlPicture = new JPanel();
		pnlPicture.setBounds(30, 96, 356, 554);
		pnlPicture.setBackground(Color.decode("#F0F0F0"));
		pnlPicture.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 0, Color.decode("#2196F3")));
		pnlProfile.add(pnlPicture);
		pnlPicture.setLayout(null);
		
		JLabel lblProfilPic = new JLabel("");
		lblProfilPic.setHorizontalAlignment(SwingConstants.CENTER);
		try {
			lblProfilPic.setIcon(new ImageIcon(ImageIO.read(Login.class.getResourceAsStream("/images/usericon.png"))));
		} catch (IOException e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
		}
		lblProfilPic.setBounds(10, 11, 336, 322);
		pnlPicture.add(lblProfilPic);
		
		JLabel lblUsername = new JLabel("Sicil :");
		lblUsername.setFont(new Font("Montserrat", Font.PLAIN, 16));
		lblUsername.setBounds(20, 344, 320, 26);
		pnlPicture.add(lblUsername);
		
		txtUsername = new JTextField(Login.user.username);
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtUsername.setEditable(false);
		txtUsername.setColumns(10);
		txtUsername.setBounds(20, 381, 320, 32);
		pnlPicture.add(txtUsername);
		
		JButton btnLogOut = new JButton("Oturumu Kapat");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ekran.setVisible(false);
				parent.setVisible(true);
			}
		});
		btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLogOut.setBounds(40, 450, 280, 64);
		pnlPicture.add(btnLogOut);
		
		JPanel pnlAboutMe = new JPanel();
		pnlAboutMe.setBorder(new MatteBorder(0, 5, 0, 0, Color.decode("#4CAF50")));
		pnlAboutMe.setBackground(SystemColor.menu);
		pnlAboutMe.setBounds(415, 96, 573, 338);
		pnlProfile.add(pnlAboutMe);
		pnlAboutMe.setLayout(null);
		
		JLabel lblAboutMe = new JLabel("Bilgilerim");
		lblAboutMe.setForeground(Color.decode("#4CAF50"));
		lblAboutMe.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAboutMe.setBounds(20, 11, 543, 26);
		pnlAboutMe.add(lblAboutMe);
		
		JLabel lblName = new JLabel("Ad :");
		lblName.setFont(new Font("Montserrat", Font.PLAIN, 16));
		lblName.setBounds(30, 66, 525, 26);
		pnlAboutMe.add(lblName);
		
		txtName = new JTextField();
		txtName.setEditable(false);
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtName.setText(Login.user.name);
		txtName.setBounds(30, 103, 525, 32);
		pnlAboutMe.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblSurname = new JLabel("Soyad :");
		lblSurname.setFont(new Font("Montserrat", Font.PLAIN, 16));
		lblSurname.setBounds(30, 146, 525, 26);
		pnlAboutMe.add(lblSurname);
		
		txtSurname = new JTextField();
		txtSurname.setEditable(false);
		txtSurname.setText(Login.user.surname);
		txtSurname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSurname.setColumns(10);
		txtSurname.setBounds(30, 183, 525, 32);
		pnlAboutMe.add(txtSurname);
		
		JLabel lblAuthority = new JLabel("Yetki :");
		lblAuthority.setFont(new Font("Montserrat", Font.PLAIN, 16));
		lblAuthority.setBounds(30, 226, 525, 26);
		pnlAboutMe.add(lblAuthority);
		
		txtAuthority = new JTextField();
		txtAuthority.setText(Login.user.authority);
		txtAuthority.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtAuthority.setEditable(false);
		txtAuthority.setColumns(10);
		txtAuthority.setBounds(30, 263, 525, 32);
		pnlAboutMe.add(txtAuthority);
		
		JPanel pnlPwdChange = new JPanel();
		pnlPwdChange.setBorder(new MatteBorder(0, 5, 0, 0, Color.decode("#F44336")));
		pnlPwdChange.setBackground(SystemColor.menu);
		pnlPwdChange.setBounds(415, 464, 573, 186);
		pnlProfile.add(pnlPwdChange);
		pnlPwdChange.setLayout(null);
		
		JLabel lblChangePassword = new JLabel("Şifre Değiştirme");
		lblChangePassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblChangePassword.setForeground(Color.decode("#F44336"));
		lblChangePassword.setBounds(20, 11, 543, 26);
		pnlPwdChange.add(lblChangePassword);
		
		JLabel lblOldPwd = new JLabel("Eski Şifre :");
		lblOldPwd.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOldPwd.setFont(new Font("Montserrat", Font.PLAIN, 16));
		lblOldPwd.setBounds(30, 48, 111, 32);
		pnlPwdChange.add(lblOldPwd);
		
		JLabel lblNewPwd1 = new JLabel("Yeni Şifre :");
		lblNewPwd1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewPwd1.setFont(new Font("Montserrat", Font.PLAIN, 16));
		lblNewPwd1.setBounds(30, 91, 111, 32);
		pnlPwdChange.add(lblNewPwd1);
		
		JLabel lblNewPwd2 = new JLabel("Yeni Tekrar :");
		lblNewPwd2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewPwd2.setFont(new Font("Montserrat", Font.PLAIN, 16));
		lblNewPwd2.setBounds(30, 134, 111, 32);
		pnlPwdChange.add(lblNewPwd2);
		
		JButton btnChangePwd = new JButton("Değiştir");
		btnChangePwd.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(!pwdOldPwd.getText().equals("")&&!pwdNewPwd1.getText().equals("")&&!pwdNewPwd2.getText().equals("")&&pwdOldPwd.getText().equals(Login.user.password)&&!pwdNewPwd1.getText().equals(pwdOldPwd.getText())&&pwdNewPwd1.getText().equals(pwdNewPwd2.getText())) {
					String query = "UPDATE `personel` SET `sifre`='"+pwdNewPwd1.getText()+"' WHERE `sicil`='"+Login.user.username+"'";
					if (VT.veriEkle(query)==1)
					{
						Login.user.password=pwdNewPwd1.getText();
						JOptionPane.showMessageDialog(Manager.ekran, "Şifreniz değiştirildi!");
					} else {
						JOptionPane.showMessageDialog(Manager.ekran, "Hata oluştu! Şifre değiştirilemedi!");
					}
				} else {
					JOptionPane.showMessageDialog(Manager.ekran, "Şifreniz ya da yeni şifre geçerli değildir!");
				}
				pwdOldPwd.setText("");
				pwdNewPwd1.setText("");
				pwdNewPwd2.setText("");
			}
		});
		btnChangePwd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnChangePwd.setBounds(406, 134, 122, 32);
		pnlPwdChange.add(btnChangePwd);
		
		pwdOldPwd = new JPasswordField();
		pwdOldPwd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pwdOldPwd.setBounds(151, 48, 377, 32);
		pwdOldPwd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pwdNewPwd1.requestFocus();
			}
		});
		pnlPwdChange.add(pwdOldPwd);
		
		pwdNewPwd1 = new JPasswordField();
		pwdNewPwd1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pwdNewPwd1.setBounds(151, 91, 377, 32);
		pwdNewPwd1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pwdNewPwd2.requestFocus();
			}
		});
		pnlPwdChange.add(pwdNewPwd1);
		
		pwdNewPwd2 = new JPasswordField();
		pwdNewPwd2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pwdNewPwd2.setBounds(151, 134, 245, 32);
		pwdNewPwd2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnChangePwd.doClick();
			}
		});
		pnlPwdChange.add(pwdNewPwd2);
		
		JLabel lblProfil = new JLabel("   Profil");
		lblProfil.setForeground(Color.decode("#2196F3"));
		lblProfil.setFont(new Font("Montserrat Light", Font.PLAIN, 48));
		lblProfil.setBounds(10, 10, 1000, 64);
		lblProfil.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode("#2196F3")));
		pnlProfile.add(lblProfil);
		
		pnlReports = new JPanel();
		pnlReports.setBackground(Color.WHITE);
		pnlReports.setBounds(99999, 10, 1018, 679);
		pnlReports.setVisible(false);
		viewPanel.add(pnlReports);
		pnlReports.setLayout(null);
		
		comboBox = new JComboBox<TableRequest>();
		comboBox.setBounds(12, 12, 834, 32);
		
		for(int i=0;i<TableRequest.tblNum;i++) {
			comboBox.addItem(new TableRequest(i));
		}
		comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TableRequest tr = (TableRequest) ((JComboBox<TableRequest>)e.getSource()).getSelectedItem();
				SharedFunctions.createTable(pnlReports, 12, 56, 994, tr.query, tr.headers, tr.rightSum, tr.bottomSum);
			}
		});
		pnlReports.add(comboBox);
		comboBox.setSelectedIndex(0);
		
		JButton btnExport = new JButton("Excel'e Aktar");
		btnExport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//SharedFunctions.toExcel(new File());
				JFileChooser fc = new JFileChooser();
				fc.setAcceptAllFileFilterUsed(false);
				fc.setFileFilter(new FileFilter() {
					
					@Override
					public String getDescription() {
						return null;
					}
					
					@Override
					public boolean accept(File f) {
						String s = SharedFunctions.getExtension(f);
						if(f.isDirectory())return true;
						if(s!=null && s.equals("xls"))return true;
						return false;
					}
				});
				if(fc.showSaveDialog(Manager.ekran)==JFileChooser.APPROVE_OPTION) {
					String s=fc.getSelectedFile().toString(),ext=SharedFunctions.getExtension(fc.getSelectedFile());
					if(ext==null||ext!="xls") {
						if(ext!=null)s=s.substring(0, s.lastIndexOf('.')-1);
						//fc.setSelectedFile(new File(s+".xls"));
					}
					SharedFunctions.toExcel(new File(s+".xls"));
				}
			}
		});
		btnExport.setBounds(857, 12, 150, 32);
		pnlReports.add(btnExport);
		
		pnlRegisterObstacle = new JPanel();
		pnlRegisterObstacle.setBackground(Color.WHITE);
		pnlRegisterObstacle.setBounds(999999, 10, 1018, 678);
		pnlRegisterObstacle.setLayout(null);
		pnlRegisterObstacle.setVisible(false);
		viewPanel.add(pnlRegisterObstacle);
		
		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox_1.setBounds(279, 106, 557, 32);
		comboBox_1.addItem("Seçiniz");
		SharedFunctions.DBtoCombo(comboBox_1, takimlar);
		pnlRegisterObstacle.add(comboBox_1);
		
		JLabel lblEngelKayt = new JLabel("   Engel Kayıt");
		lblEngelKayt.setForeground(new Color(33, 150, 243));
		lblEngelKayt.setFont(new Font("Montserrat Light", Font.PLAIN, 48));
		lblEngelKayt.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode("#2196F3")));
		lblEngelKayt.setBounds(10, 10, 1000, 64);
		pnlRegisterObstacle.add(lblEngelKayt);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setBounds(279, 150, 557, 32);
		pnlRegisterObstacle.add(textField);
		textField.setColumns(10);
		
		JEditorPane dtrpnEngel = new JEditorPane();
		dtrpnEngel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		dtrpnEngel.setBounds(279, 238, 557, 136);
		dtrpnEngel.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
		pnlRegisterObstacle.add(dtrpnEngel);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_2.setColumns(10);
		textField_2.setBounds(279, 386, 557, 32);
		pnlRegisterObstacle.add(textField_2);
		
		JComboBox<String> comboBox_2 = new JComboBox<String>();
		comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox_2.setBounds(279, 518, 557, 32);
		comboBox_2.addItem("Seçiniz");
		comboBox_2.addItem("Açık");
		comboBox_2.addItem("Kapalı");
		pnlRegisterObstacle.add(comboBox_2);
		
		JComboBox<String> comboBox_3 = new JComboBox<String>();
		comboBox_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox_3.setBounds(279, 562, 557, 32);
		comboBox_3.addItem("Seçiniz");
		comboBox_3.addItem("Başka Birim Bekleme");
		comboBox_3.addItem("Bilgi Eksikliği");
		comboBox_3.addItem("Diğer");
		comboBox_3.addItem("Eğitim");
		comboBox_3.addItem("Eksik Analiz");
		comboBox_3.addItem("Farklı İş");
		comboBox_3.addItem("Hata Giderme");
		comboBox_3.addItem("İzin Rapor");
		comboBox_3.addItem("Planlama Hatası");
		comboBox_3.addItem("Teknik Sorun");
		comboBox_3.addItem("Test Dönüş Düzeltme");
		comboBox_3.addItem("Toplantı");
		pnlRegisterObstacle.add(comboBox_3);
		
		JLabel lblTakimAdi = new JLabel("Takımı :");
		lblTakimAdi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTakimAdi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTakimAdi.setBounds(12, 106, 249, 32);
		pnlRegisterObstacle.add(lblTakimAdi);
		
		JLabel lblBildiren = new JLabel("Bildiren :");
		lblBildiren.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBildiren.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBildiren.setBounds(12, 150, 249, 32);
		pnlRegisterObstacle.add(lblBildiren);
		
		JLabel lblAlTarihi = new JLabel("Açılış Tarihi :");
		lblAlTarihi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAlTarihi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAlTarihi.setBounds(12, 194, 249, 32);
		pnlRegisterObstacle.add(lblAlTarihi);
		
		JLabel lblEngel = new JLabel("Engel :");
		lblEngel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEngel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEngel.setBounds(12, 238, 249, 32);
		pnlRegisterObstacle.add(lblEngel);
		
		JLabel lblzmSorumlusu = new JLabel("Çözüm Sorumlusu :");
		lblzmSorumlusu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblzmSorumlusu.setHorizontalAlignment(SwingConstants.RIGHT);
		lblzmSorumlusu.setBounds(12, 386, 249, 32);
		pnlRegisterObstacle.add(lblzmSorumlusu);
		
		JLabel lblHedefzmTarihi = new JLabel("Hedef Çözüm Tarihi :");
		lblHedefzmTarihi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHedefzmTarihi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHedefzmTarihi.setBounds(12, 430, 249, 32);
		pnlRegisterObstacle.add(lblHedefzmTarihi);
		
		JLabel lblGerekleenzmTarihi = new JLabel("Gerçekleşen Çözüm Tarihi :");
		lblGerekleenzmTarihi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGerekleenzmTarihi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGerekleenzmTarihi.setBounds(12, 474, 249, 32);
		pnlRegisterObstacle.add(lblGerekleenzmTarihi);
		
		JLabel lblDurumu = new JLabel("Durumu :");
		lblDurumu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDurumu.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDurumu.setBounds(12, 518, 249, 32);
		pnlRegisterObstacle.add(lblDurumu);
		
		JLabel lblKategori = new JLabel("Kategori :");
		lblKategori.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblKategori.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKategori.setBounds(12, 562, 249, 32);
		pnlRegisterObstacle.add(lblKategori);
		
		JButton btnTemzle_1 = new JButton("Temizle");
		btnTemzle_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(Object o : pnlRegisterObstacle.getComponents()) {
					try {
						JTextField txtBox = (JTextField) o;
						txtBox.setText("");
					} catch(Exception e1) {
						try {
							JEditorPane editBox = (JEditorPane) o;
							editBox.setText("");
						} catch(Exception e2) {
							try {
								JComboBox<?> cmbBox = (JComboBox<?>) o;
								cmbBox.setSelectedIndex(0);
							} catch(Exception e3) {
								// bi bok yapma
							}
						}
					}
				}
			}
		});
		
		JSpinner spinner_4 = new JSpinner(new SpinnerDateModel(Calendar.getInstance().getTime(), null, null, Calendar.DAY_OF_YEAR));
		spinner_4.setEditor(new JSpinner.DateEditor(spinner_4, "yyyy-MM-dd"));
		spinner_4.setBounds(279, 194, 557, 32);
		pnlRegisterObstacle.add(spinner_4);
		
		JSpinner spinner_5 = new JSpinner(new SpinnerDateModel(Calendar.getInstance().getTime(), null, null, Calendar.DAY_OF_YEAR));
		spinner_5.setEditor(new JSpinner.DateEditor(spinner_5, "yyyy-MM-dd"));
		spinner_5.setBounds(279, 430, 557, 32);
		pnlRegisterObstacle.add(spinner_5);
		
		JSpinner spinner_6 = new JSpinner(new SpinnerDateModel(Calendar.getInstance().getTime(), null, null, Calendar.DAY_OF_YEAR));
		spinner_6.setEditor(new JSpinner.DateEditor(spinner_6, "yyyy-MM-dd"));
		spinner_6.setBounds(279, 474, 557, 32);
		pnlRegisterObstacle.add(spinner_6);
		btnTemzle_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnTemzle_1.setBounds(566, 605, 270, 48);
		pnlRegisterObstacle.add(btnTemzle_1);
		
		JButton btnKaydet = new JButton("Kaydet");
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String takim = comboBox_1.getSelectedItem().toString();
				String bildiren = textField.getText();
				String aTarih = ((JSpinner.DateEditor)spinner_4.getEditor()).getTextField().getText();
				String engel = dtrpnEngel.getText();
				String sorumlu = textField_2.getText();
				String hTarih = ((JSpinner.DateEditor)spinner_5.getEditor()).getTextField().getText();
				String gTarih = ((JSpinner.DateEditor)spinner_6.getEditor()).getTextField().getText();
				String durum = comboBox_2.getSelectedItem().toString();
				String kategori = comboBox_3.getSelectedItem().toString();
				if(durum.charAt(0) == 'A') {
					durum = "acik";
				} else if(durum.charAt(0) == 'K') {
					durum = "kapali";
				} else {
					durum = "";
				}
				if(takim == "Seçiniz") {
					takim = "";
				}
				if(kategori == "Seçiniz") {
					kategori = "";
				}
				// Bilgileri dogrula
				String query = "INSERT INTO engeller SET takimi='"+takim+"',bildiren='"+bildiren+"',acilis_tarihi='"+aTarih+"',aciklama='"+engel+"',cozum_sorumlusu='"+sorumlu+"',hedef_cozum_tarihi='"+hTarih+"',gerceklesen_cozum_tarihi='"+gTarih+"',durumu='"+durum+"',kategori='"+kategori+"',kaydeden_ad='"+Login.user.name+"',kaydeden_soyad='"+Login.user.surname+"'";
				//System.out.println(query);
				//query = query.replaceAll("\\", "\\\\");
				int sonuc = VT.veriEkle(query);
				if(sonuc>0) {
					JOptionPane.showMessageDialog(Manager.ekran, "Engel kaydedildi!", "Engel Kayıt", JOptionPane.INFORMATION_MESSAGE);
					btnTemzle_1.doClick();
				} else {
					JOptionPane.showMessageDialog(Manager.ekran, "Engel kaydedilmedi!", "Engel Kayıt", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnKaydet.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnKaydet.setBounds(279, 605, 270, 48);
		pnlRegisterObstacle.add(btnKaydet);
		
		pnlSearchObstacle = new JPanel();
		pnlSearchObstacle.setVisible(false);
		pnlSearchObstacle.setBackground(Color.WHITE);
		pnlSearchObstacle.setBounds(250, 9999999, 1016, 678);
		viewPanel.add(pnlSearchObstacle);
		pnlSearchObstacle.setLayout(null);
		
		JLabel lblEngelSorgula = new JLabel("   Engel Sorgula");
		lblEngelSorgula.setForeground(new Color(33, 150, 243));
		lblEngelSorgula.setFont(new Font("Montserrat Light", Font.PLAIN, 48));
		lblEngelSorgula.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode("#2196F3")));
		lblEngelSorgula.setBounds(10, 10, 1000, 64);
		pnlSearchObstacle.add(lblEngelSorgula);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new MatteBorder(0, 5, 0, 0, (Color) new Color(33, 150, 243)));
		panel_2.setBackground(SystemColor.menu);
		panel_2.setBounds(12, 110, 302, 485);
		pnlSearchObstacle.add(panel_2);
		
		JLabel lblTmEngeller = new JLabel("Tüm Engeller :");
		lblTmEngeller.setForeground(new Color(33, 150, 243));
		lblTmEngeller.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTmEngeller.setBounds(20, 11, 270, 26);
		panel_2.add(lblTmEngeller);
		
		JLabel lblEngelDurumunaGre = new JLabel("Engel Durumuna Göre :");
		lblEngelDurumunaGre.setForeground(new Color(33, 150, 243));
		lblEngelDurumunaGre.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEngelDurumunaGre.setBounds(20, 105, 270, 26);
		panel_2.add(lblEngelDurumunaGre);
		
		JCheckBox chckbxTumu = new JCheckBox("Tüm Engeller");
		chckbxTumu.setBounds(30, 48, 260, 26);
		panel_2.add(chckbxTumu);
		
		JCheckBox chckbxEvet = new JCheckBox("Açık");
		chckbxEvet.setBounds(30, 142, 260, 26);
		panel_2.add(chckbxEvet);
		
		JCheckBox chckbxKapal = new JCheckBox("Kapalı");
		chckbxKapal.setBounds(30, 179, 260, 26);
		panel_2.add(chckbxKapal);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new MatteBorder(0, 5, 0, 0, Color.decode("#4CAF50")));
		panel_3.setBackground(SystemColor.menu);
		panel_3.setBounds(326, 110, 686, 485);
		pnlSearchObstacle.add(panel_3);
		
		JLabel lblTakmlaraGre = new JLabel("Takımlara Göre :");
		lblTakmlaraGre.setForeground(new Color(76, 175, 80));
		lblTakmlaraGre.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTakmlaraGre.setBounds(20, 11, 654, 26);
		panel_3.add(lblTakmlaraGre);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(30, 49, 644, 424);
		panel_3.add(scrollPane_3);
		
		JList<String> list_3 = new JList<String>();
		list_3.setFixedCellHeight(32);
		list_3.setModel(new AbstractListModel<String>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			String[] values = takimlar;
			public int getSize() {
				return values.length;
			}
			public String getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane_3.setViewportView(list_3);
		
		JButton btnTemzle = new JButton("Temizle");
		btnTemzle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list_3.clearSelection();
				for(Object o : panel_2.getComponents()) {
					try {
						JCheckBox chb = (JCheckBox) o;
						chb.setSelected(false);
					} catch(Exception e1) {
						//Bi bok yapma
					}
				}
				for(Object o : panel_3.getComponents()) {
					try {
						JCheckBox chb = (JCheckBox) o;
						chb.setSelected(false);
					} catch(Exception e1) {
						//Bi bok yapma
					}
				}
			}
		});
		btnTemzle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTemzle.setBounds(579, 619, 207, 48);
		pnlSearchObstacle.add(btnTemzle);
		
		JButton button = new JButton("Sorgula");
		button.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(true) {
					String query = "SELECT id, takimi, bildiren, acilis_tarihi, aciklama, cozum_sorumlusu, hedef_cozum_tarihi, gerceklesen_cozum_tarihi, durumu, kategori FROM engeller ORDER BY id";
					String[] headers = {"ID","Takımı","Bildiren","Açılış Tarihi","Açıklama","Çözüm Sorumlusu","Hedef Çözüm Tarihi","Gerçekleşen Çözüm Tarihi","Durumu","Kategori"};
					pnlSearchResult.removeAll();
					JLabel lbl = new JLabel("Engel Sorgula Sonucu");
					lbl.setFont(new Font("Montserrat Light", Font.PLAIN, 32));
					lbl.setForeground((Color) new Color(33, 150, 243));
					lbl.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, (Color) new Color(33, 150, 243)));
					lbl.setBounds(12, 12, 992, 48);
					pnlSearchResult.add(lbl);
					SharedFunctions.createTable(pnlSearchResult, 12, 64, 992, query, headers, false, false);
					pnlSearchObstacle.setVisible(false);

					btnEngelToExcel = new JButton("Excel'e Aktar");
					btnEngelToExcel.setFont(new Font("Tahoma", Font.PLAIN, 16));
					btnEngelToExcel.setBounds(846, 20, 160, 32);
					btnEngelToExcel.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							btnExport.doClick();
						}
					});
					pnlSearchResult.add(btnEngelToExcel);
					
					btnShow = new JButton("Ayrıntılı Göster");
					btnShow.setEnabled(false);
					btnShow.setFont(new Font("Tahoma", Font.PLAIN, 16));
					btnShow.setBounds(676, 20, 160, 32);
					btnShow.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							
						}
					});
					pnlSearchResult.add(btnShow);

					pnlSearchResult.setLocation(250,10);
				}
				if(chckbxTumu.isSelected()) {
					pnlSearchResult.setVisible(true);
				}
				else {
					String data1 = "";
					for (Object o : list_3.getSelectedValues()) {
						try {
							String chb = (String) o;
							if(data1.length()!=0)
								data1 = data1+",";
							data1 = data1 + "'"+chb+"'";
						} catch(Exception e1) {
							// bi bok yapma
						}
					}
					//System.out.println(data1);
					if(data1.length()>0)
						data1 = "takimi IN("+data1+")";
					String data2 = "";
					if(chckbxEvet.isSelected())
						data2 = "'acik'";
					if(chckbxKapal.isSelected())
						if(data1.length()==0)
							data2 = "'kapali'";
						else
							data2 = data2 + ",'kapali'";
					if(data2.length()>0)
						data2 = "durumu IN("+data2+")";
					String query = "SELECT id, takimi, bildiren, acilis_tarihi, aciklama, cozum_sorumlusu, hedef_cozum_tarihi, gerceklesen_cozum_tarihi, durumu, kategori FROM engeller ORDER BY id";
					if(data1.length()>0) {
						query = query + " WHERE " + data1;
						if(data2.length()>0)
							query = query + " AND " + data2;
					} else if(data2.length()>0)
						query = query + " WHERE " + data2;
					//System.out.println(data1);
					String[] headers = {"ID","Takımı","Bildiren","Açılış Tarihi","Açıklama","Çözüm Sorumlusu","Hedef Çözüm Tarihi","Gerçekleşen Çözüm Tarihi","Durumu","Kategori"};
					pnlSearchResult.removeAll();
					JLabel lbl = new JLabel("Engel Sorgula Sonucu");
					lbl.setFont(new Font("Montserrat Light", Font.PLAIN, 32));
					lbl.setForeground((Color) new Color(33, 150, 243));
					lbl.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, (Color) new Color(33, 150, 243)));
					lbl.setBounds(12, 12, 992, 48);
					pnlSearchResult.add(lbl);
					SharedFunctions.createTable(pnlSearchResult, 12, 64, 992, query, headers, false, false);
					pnlSearchObstacle.setVisible(false);
					
					btnEngelToExcel = new JButton("Excel'e Aktar");
					btnEngelToExcel.setFont(new Font("Tahoma", Font.PLAIN, 16));
					btnEngelToExcel.setBounds(846, 20, 160, 32);
					btnEngelToExcel.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							btnExport.doClick();
						}
					});
					pnlSearchResult.add(btnEngelToExcel);
					
					btnShow = new JButton("Ayrıntılı Göster");
					btnShow.setEnabled(false);
					btnShow.setFont(new Font("Tahoma", Font.PLAIN, 16));
					btnShow.setBounds(676, 20, 160, 32);
					btnShow.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							Details.ekran = new Details("engel");
							Details.ekran.setVisible(true);
						}
					});
					pnlSearchResult.add(btnShow);
					
					pnlSearchResult.setVisible(true);
				}
				btnTemzle.doClick();
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button.setBounds(805, 619, 207, 48);
		pnlSearchObstacle.add(button);
		
		pnlSearchResult = new JPanel();
		pnlSearchResult.setBackground(Color.WHITE);
		pnlSearchResult.setBounds(99999, 11, 1016, 678);
		pnlSearchResult.setVisible(false);
		viewPanel.add(pnlSearchResult);
		pnlSearchResult.setLayout(null);
		//(12, 72, 994, 595);
		//SharedFunctions.createTable(pnlReports, 12, 56, 994, "SELECT talep_eden_daire,SUM(kalan_kaynak_ihtiyaci) AS kalan_kaynak_ihtiyaci FROM proje GROUP BY talep_eden_daire ORDER BY talep_eden_daire", new String[]{"A","B"}, false, true);
		//SharedFunctions.createTable(pnlReports, 12, 56, 994, "SELECT takimi AS 'Takim Adi',SUM(if(talep_durumu = 'baslamadi',1,0)) AS 'Baslamadi',SUM(if(talep_durumu = 'beklemede',1,0)) AS 'Beklemede',SUM(if(talep_durumu = 'devam_ediyor',1,0)) AS 'Devam Ediyor',SUM(if(talep_durumu = 'devrede',1,0)) AS 'Devrede',SUM(if(talep_durumu = 'iptal_edildi',1,0)) AS 'Iptal Edildi',SUM(if(talep_durumu = 'tamamlandi',1,0)) AS 'Tamamlandi',SUM(if(talep_durumu = 'testte',1,0)) AS 'Testte' FROM proje GROUP BY takimi ORDER BY takimi", new String[]{"A","B","A","B","A","B","A","B"}, false, true);
		
		pnlRegisterProject = new JPanel();
		pnlRegisterProject.setBackground(Color.WHITE);
		pnlRegisterProject.setBounds(99999, 10, 1016, 678);
		pnlRegisterProject.setVisible(false);
		viewPanel.add(pnlRegisterProject);
		pnlRegisterProject.setLayout(null);
		
		JLabel lblProjeKayt = new JLabel("   Proje Kayıt");
		lblProjeKayt.setForeground(new Color(33, 150, 243));
		lblProjeKayt.setFont(new Font("Montserrat Light", Font.PLAIN, 48));
		lblProjeKayt.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode("#2196F3")));
		lblProjeKayt.setBounds(10, 10, 1000, 64);
		pnlRegisterProject.add(lblProjeKayt);
		
		JComboBox<String> comboBox_4 = new JComboBox<String>();
		comboBox_4.setBounds(210, 97, 270, 25);
		comboBox_4.addItem("Seçiniz");
		comboBox_4.addItem("EBYS");
		comboBox_4.addItem("MAİL");
		comboBox_4.addItem("SÖZLÜ");
		comboBox_4.addItem("TOPLANTI TUTANAĞI");
		pnlRegisterProject.add(comboBox_4);
		
		textField_1 = new JTextField();
		textField_1.setBounds(210, 171, 270, 25);
		pnlRegisterProject.add(textField_1);
		textField_1.setColumns(10);
		
		JComboBox<String> comboBox_5 = new JComboBox<String>();
		comboBox_5.setBounds(210, 208, 270, 25);
		comboBox_5.addItem("Seçiniz");
		SharedFunctions.DBtoCombo(comboBox_5,daireler);
		
		pnlRegisterProject.add(comboBox_5);
		
		JComboBox<String> comboBox_6 = new JComboBox<String>();
		comboBox_6.setBounds(210, 245, 270, 25);
		comboBox_6.addItem("Seçiniz");
		SharedFunctions.DBtoCombo(comboBox_6, mudurlukler);
		pnlRegisterProject.add(comboBox_6);
		
		JComboBox<String> comboBox_7 = new JComboBox<String>();
		comboBox_7.setBounds(210, 282, 270, 25);
		comboBox_7.addItem("Seçiniz");
		comboBox_7.addItem("İlave İstek");
		comboBox_7.addItem("Yeni Proje");
		comboBox_7.addItem("Arıza");
		pnlRegisterProject.add(comboBox_7);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(210, 319, 270, 25);
		pnlRegisterProject.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(210, 356, 270, 25);
		pnlRegisterProject.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(210, 393, 270, 25);
		pnlRegisterProject.add(textField_5);
		
		JComboBox<String> comboBox_8 = new JComboBox<String>();
		comboBox_8.setBounds(210, 430, 270, 25);
		comboBox_8.addItem("Seçiniz");
		comboBox_8.addItem("Hata");
		comboBox_8.addItem("Talep");
		pnlRegisterProject.add(comboBox_8);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setFont(new Font("Tahoma", Font.PLAIN, 16));
		editorPane.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
		editorPane.setBounds(210, 467, 270, 120);
		pnlRegisterProject.add(editorPane);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(210, 599, 270, 25);
		pnlRegisterProject.add(textField_6);
		
		JEditorPane editorPane_1 = new JEditorPane();
		editorPane_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		editorPane_1.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
		editorPane_1.setBounds(734, 97, 270, 91);
		pnlRegisterProject.add(editorPane_1);
		
		JComboBox<String> comboBox_9 = new JComboBox<String>();
		comboBox_9.setBounds(734, 200, 270, 25);
		comboBox_9.addItem("Seçiniz");
		comboBox_9.addItem("Başlamadı");
		comboBox_9.addItem("Beklemede");
		comboBox_9.addItem("Devam Ediyor");
		comboBox_9.addItem("Pilotta");
		comboBox_9.addItem("Testte");
		comboBox_9.addItem("Devrede");
		comboBox_9.addItem("Tamamlandı");
		comboBox_9.addItem("İptal Edildi");
		pnlRegisterProject.add(comboBox_9);
		
		JEditorPane editorPane_2 = new JEditorPane();
		editorPane_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		editorPane_2.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
		editorPane_2.setBounds(734, 237, 270, 91);
		pnlRegisterProject.add(editorPane_2);
		
		JComboBox<String> comboBox_10 = new JComboBox<String>();
		comboBox_10.setBounds(734, 340, 270, 25);
		comboBox_10.addItem("Seçiniz");
		SharedFunctions.DBtoCombo(comboBox_10, takimlar);
		pnlRegisterProject.add(comboBox_10);
		
		JComboBox<String> comboBox_11 = new JComboBox<String>();
		comboBox_11.setBounds(734, 377, 270, 25);
		comboBox_11.addItem("Seçiniz");
		comboBox_11.addItem("Ocak");
		comboBox_11.addItem("Şubat");
		comboBox_11.addItem("Mart");
		comboBox_11.addItem("Nisan");
		comboBox_11.addItem("Mayıs");
		comboBox_11.addItem("Haziran");
		comboBox_11.addItem("Temmuz");
		comboBox_11.addItem("Ağustos");
		comboBox_11.addItem("Eylül");
		comboBox_11.addItem("Ekim");
		comboBox_11.addItem("Kasım");
		comboBox_11.addItem("Aralık");
		pnlRegisterProject.add(comboBox_11);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(734, 414, 270, 25);
		pnlRegisterProject.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(734, 451, 270, 25);
		pnlRegisterProject.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(734, 488, 270, 25);
		pnlRegisterProject.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(734, 525, 270, 25);
		pnlRegisterProject.add(textField_10);
		
		JLabel lblNewLabel = new JLabel("İşin Geliş Şekli :");
		lblNewLabel.setBounds(10, 97, 182, 25);
		pnlRegisterProject.add(lblNewLabel);
		
		JLabel lblEvrakTarihi = new JLabel("Evrak Tarihi :");
		lblEvrakTarihi.setBounds(10, 134, 182, 25);
		pnlRegisterProject.add(lblEvrakTarihi);
		
		JLabel lblEvrakSays = new JLabel("Evrak Sayısı :");
		lblEvrakSays.setBounds(10, 171, 182, 25);
		pnlRegisterProject.add(lblEvrakSays);
		
		JLabel lblTalepEdenDaire = new JLabel("Talep Eden Daire :");
		lblTalepEdenDaire.setBounds(10, 208, 182, 25);
		pnlRegisterProject.add(lblTalepEdenDaire);
		
		JLabel lblIlgiliYazlmMdrl = new JLabel("İlgili Yazılım Müdürlüğü :");
		lblIlgiliYazlmMdrl.setBounds(10, 245, 182, 25);
		pnlRegisterProject.add(lblIlgiliYazlmMdrl);
		
		JLabel lblIinTr = new JLabel("İşin Türü :");
		lblIinTr.setBounds(10, 282, 182, 25);
		pnlRegisterProject.add(lblIinTr);
		
		JLabel lblIlaveIstekSebebi = new JLabel("İlave İstek Sebebi :");
		lblIlaveIstekSebebi.setBounds(10, 319, 182, 25);
		pnlRegisterProject.add(lblIlaveIstekSebebi);
		
		JLabel lblIlgiliUygulama = new JLabel("İlgili Uygulama :");
		lblIlgiliUygulama.setBounds(10, 356, 182, 25);
		pnlRegisterProject.add(lblIlgiliUygulama);
		
		JLabel lblIlgiliModl = new JLabel("İlgili Modül :");
		lblIlgiliModl.setBounds(10, 393, 182, 25);
		pnlRegisterProject.add(lblIlgiliModl);
		
		JLabel lblHatatalep = new JLabel("Hata/Talep :");
		lblHatatalep.setBounds(10, 430, 182, 25);
		pnlRegisterProject.add(lblHatatalep);
		
		JLabel lblTalepAd = new JLabel("Talep Adı :");
		lblTalepAd.setBounds(10, 467, 182, 25);
		pnlRegisterProject.add(lblTalepAd);
		
		JLabel lblTalepNo = new JLabel("Talep No :");
		lblTalepNo.setBounds(10, 599, 182, 25);
		pnlRegisterProject.add(lblTalepNo);
		
		JLabel lblTalepKonusu = new JLabel("Talep Konusu :");
		lblTalepKonusu.setBounds(498, 97, 218, 25);
		pnlRegisterProject.add(lblTalepKonusu);
		
		JLabel lblTalebinDurumu = new JLabel("Talebin Durumu :");
		lblTalebinDurumu.setBounds(498, 200, 218, 25);
		pnlRegisterProject.add(lblTalebinDurumu);
		
		JLabel lblAklama = new JLabel("Açıklama :");
		lblAklama.setBounds(498, 237, 218, 25);
		pnlRegisterProject.add(lblAklama);
		
		JLabel lblTakm = new JLabel("Takımı :");
		lblTakm.setBounds(498, 340, 218, 25);
		pnlRegisterProject.add(lblTakm);
		
		JLabel lblIlgiliSprint = new JLabel("İlgili Sprint :");
		lblIlgiliSprint.setBounds(498, 377, 218, 25);
		pnlRegisterProject.add(lblIlgiliSprint);
		
		JLabel lblTakmKiiSays = new JLabel("Takım Kişi Sayısı :");
		lblTakmKiiSays.setBounds(498, 414, 218, 25);
		pnlRegisterProject.add(lblTakmKiiSays);
		
		JLabel lblSorumlu = new JLabel("Sorumlu :");
		lblSorumlu.setBounds(498, 451, 218, 25);
		pnlRegisterProject.add(lblSorumlu);
		
		JLabel lblncelikSrasi = new JLabel("Öncelik Sırasi :");
		lblncelikSrasi.setBounds(498, 488, 218, 25);
		pnlRegisterProject.add(lblncelikSrasi);
		
		JLabel lblngrlenKaynakIhtiyacadamgn = new JLabel("Öngörülen Kaynak İhtiyacı(adam*gün) :");
		lblngrlenKaynakIhtiyacadamgn.setBounds(498, 525, 218, 25);
		pnlRegisterProject.add(lblngrlenKaynakIhtiyacadamgn);
		
		JLabel lblBalangTarihi = new JLabel("Başlangıç Tarihi :");
		lblBalangTarihi.setBounds(498, 562, 218, 25);
		pnlRegisterProject.add(lblBalangTarihi);
		
		JLabel lblBitiTarihi = new JLabel("Bitiş Tarihi :");
		lblBitiTarihi.setBounds(498, 599, 218, 25);
		pnlRegisterProject.add(lblBitiTarihi);
		
		JButton btnTemizle = new JButton("Temizle");
		btnTemizle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(Object o : pnlRegisterProject.getComponents()) {
					try {
						JTextField txtBox = (JTextField) o;
						txtBox.setText("");
					} catch(Exception e1) {
						try {
							JEditorPane editBox = (JEditorPane) o;
							editBox.setText("");
						} catch(Exception e2) {
							try {
								JComboBox<?> cmbBox = (JComboBox<?>) o;
								cmbBox.setSelectedIndex(0);
							} catch(Exception e3) {
								// bi bok yapma
							}
						}
					}
				}
			}
		});
		
		JSpinner spinner_1 = new JSpinner(new SpinnerDateModel(Calendar.getInstance().getTime(), null, null, Calendar.DAY_OF_YEAR));
		spinner_1.setEditor(new JSpinner.DateEditor(spinner_1, "yyyy-MM-dd"));
		spinner_1.setBounds(210, 134, 270, 25);
		
		JSpinner spinner_2 = new JSpinner(new SpinnerDateModel(Calendar.getInstance().getTime(), null, null, Calendar.DAY_OF_YEAR));
		spinner_2.setEditor(new JSpinner.DateEditor(spinner_2, "yyyy-MM-dd"));
		spinner_2.setBounds(734, 562, 270, 25);
		
		JSpinner spinner_3 = new JSpinner(new SpinnerDateModel(Calendar.getInstance().getTime(), null, null, Calendar.DAY_OF_YEAR));
		spinner_3.setEditor(new JSpinner.DateEditor(spinner_3, "yyyy-MM-dd"));
		spinner_3.setBounds(734, 598, 270, 25);
		
		pnlRegisterProject.add(spinner_1);
		pnlRegisterProject.add(spinner_2);
		pnlRegisterProject.add(spinner_3);
		
		btnTemizle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTemizle.setBounds(629, 635, 182, 32);
		pnlRegisterProject.add(btnTemizle);
		
		JButton btnKaydet_1 = new JButton("Kaydet");
		btnKaydet_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnKaydet_1.setBounds(822, 635, 182, 32);
		btnKaydet_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String s="evet";
				if(comboBox_7.getSelectedIndex()==0 || textField_4.getText().trim().equals("") || comboBox_10.getSelectedIndex()==0 || textField_10.getText().trim().equals(""))
					s="hayir";
				String query = "INSERT INTO proje SET isin_gelis_sekli='"+comboBox_4.getSelectedItem().toString()+"',evrak_tarihi='"+((JSpinner.DateEditor)spinner_1.getEditor()).getTextField().getText()+"',evrak_sayisi='"+textField_1.getText()+"',talep_eden_daire='"+comboBox_5.getSelectedItem().toString()+"',ilgili_mudurluk='"+comboBox_6.getSelectedItem().toString()+"',isin_turu='"+comboBox_7.getSelectedItem().toString()+"',ilave_istek_sebebi='"+textField_3.getText()+"',ilgili_uygulama='"+textField_4.getText()+"',ilgili_modul='"+textField_5.getText()+"',hata_talep='"+comboBox_8.getSelectedItem().toString()+"',talep_adi='"+editorPane.getText()+"',talep_no= '"+textField_6.getText()+"',talep_konusu='"+editorPane_1.getText()+"',talep_durumu='"+comboBox_9.getSelectedItem().toString()+"',talep_durum_tarih='"+((JSpinner.DateEditor)spinner_1.getEditor()).getTextField().getText()+"',aciklama='"+editorPane_2.getText()+"',takimi='"+comboBox_10.getSelectedItem().toString()+"',ilgili_sprint='"+comboBox_11.getSelectedItem().toString()+" "+Calendar.getInstance().get(Calendar.YEAR)+"',takim_kisi_sayisi='"+textField_7.getText()+"',sorumlu='"+textField_8.getText()+"',oncelik_sirasi='"+textField_9.getText()+"',kaynak_ihtiyaci='"+textField_10.getText()+"',kalan_kaynak_ihtiyaci='"+textField_10.getText()+"',baslangic_tarihi='"+((JSpinner.DateEditor)spinner_2.getEditor()).getTextField().getText()+"',bitis_tarihi='"+((JSpinner.DateEditor)spinner_3.getEditor()).getTextField().getText()+"',kayit_saat='"+(new SimpleDateFormat("HH:mm")).format(new Date())+"',kayit_tarih='"+(new SimpleDateFormat("dd.MM.yyyy")).format(new Date())+"',kaydeden_ad='"+Login.user.name+"',kaydeden_soyad='"+Login.user.surname+"',tamamlandi='"+s+"'";
				query = query.replaceAll("Seçiniz", "");
				int sonuc = VT.veriEkle(query);
				if(sonuc>0) {
					JOptionPane.showMessageDialog(Manager.ekran, "Proje kaydedildi!", "Proje Kayıt", JOptionPane.INFORMATION_MESSAGE);
					btnTemizle.doClick();
				} else {
					JOptionPane.showMessageDialog(Manager.ekran, "Proje kaydedilmedi!", "Proje Kayıt", JOptionPane.ERROR_MESSAGE);
				}
				//System.out.println((new SimpleDateFormat("dd.MM.yyyy")).format(new Date()));
			}
		});
		pnlRegisterProject.add(btnKaydet_1);
		
		pnlSearchProject = new JPanel();
		pnlSearchProject.setBackground(Color.WHITE);
		pnlSearchProject.setBounds(99999, 10, 1016, 678);
		pnlSearchProject.setVisible(false);
		viewPanel.add(pnlSearchProject);
		
		JButton btnTmnGster = new JButton("Tümünü Göster");
		btnTmnGster.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTmnGster.setBounds(473, 630, 170, 44);
		btnTmnGster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query = "SELECT  "
						+ "id,"
						+ "isin_gelis_sekli,"
						+ "evrak_tarihi,"
						+ "evrak_sayisi,"
						+ "talep_eden_daire,"
						+ "ilgili_mudurluk,"
						+ "isin_turu,"
						+ "ilave_istek_sebebi,"
						+ "ilgili_uygulama,"
						+ "ilgili_modul,"
						+ "hata_talep,"
						+ "talep_adi,"
						+ "talep_no,"
						+ "talep_konusu,"
						+ "talep_durumu,"
						+ "talep_durum_tarih,"
						+ "aciklama,"
						+ "takimi,"
						+ "ilgili_sprint,"
						+ "takim_kisi_sayisi,"
						+ "sorumlu,"
						+ "oncelik_sirasi,"
						+ "kaynak_ihtiyaci,"
						+ "kalan_kaynak_ihtiyaci,"
						+ "gerceklesen_kaynak_ihtiyaci,"
						+ "ilave_kaynak_ihtiyaci "
						+ "FROM proje ORDER BY id";
				String[] headers = {
						"ID",
						"İşin Geliş Şekli",
						"Evrak Tarihi",
						"Evrak Sayısı",
						"Talep Eden Daire",
						"İlgili Müdürlük",
						"İşin Türü",
						"İlave İstek Sebebi",
						"İlgili Uygulama",
						"İlgili Modül",
						"Hata Talep",
						"Talep Adı",
						"Talep No",
						"Talep Konusu",
						"Talep Durumu",
						"Son Değiştirilme Tarihi",
						"Açıklama",
						"Takımı",
						"İlgili Sprint",
						"Takım Kişi Sayısı",
						"Sorumlu",
						"Öncelik Sırası",
						"Öngörülen Kaynak İhtiyacı (adam*gün)",
						"Kalan Kaynak İhtiyacı (adam*gün)",
						"Gerçekleşen Kaynak İhtiyacı (adam*gün)",
						"İlave Kaynak İhtiyacı (adam*gün)"};
				//System.out.println(headers.length);
				pnlSearchResult.removeAll();
				JLabel lbl = new JLabel("Proje Sorgula Sonucu");
				lbl.setFont(new Font("Montserrat Light", Font.PLAIN, 32));
				lbl.setForeground((Color) new Color(33, 150, 243));
				lbl.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, (Color) new Color(33, 150, 243)));
				lbl.setBounds(12, 12, 992, 48);
				pnlSearchResult.add(lbl);
				SharedFunctions.createTable1(pnlSearchResult, 12, 64, 992, query, headers, false, false);
				pnlSearchObstacle.setVisible(false);

				btnEngelToExcel = new JButton("Excel'e Aktar");
				btnEngelToExcel.setFont(new Font("Tahoma", Font.PLAIN, 16));
				btnEngelToExcel.setBounds(846, 20, 160, 32);
				btnEngelToExcel.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						btnExport.doClick();
					}
				});
				pnlSearchResult.add(btnEngelToExcel);
				
				btnShow = new JButton("Ayrıntılı Göster");
				btnShow.setEnabled(false);
				btnShow.setFont(new Font("Tahoma", Font.PLAIN, 16));
				btnShow.setBounds(676, 20, 160, 32);
				btnShow.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
					}
				});
				pnlSearchResult.add(btnShow);

				pnlSearchResult.setLocation(250,10);
				pnlSearchProject.setVisible(false);
				pnlSearchResult.setVisible(true);
			}
		});
		pnlSearchProject.setLayout(null);
		pnlSearchProject.add(btnTmnGster);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new MatteBorder(0, 5, 0, 0, (Color) new Color(33, 150, 243)));
		panel.setBackground(SystemColor.menu);
		panel.setBounds(12, 110, 302, 502);
		pnlSearchProject.add(panel);
		
		JLabel lblProjeBilgileriTamamland = new JLabel("Proje Bilgileri Tamamlandı :");
		lblProjeBilgileriTamamland.setForeground(new Color(33, 150, 243));
		lblProjeBilgileriTamamland.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblProjeBilgileriTamamland.setBounds(20, 235, 270, 26);
		panel.add(lblProjeBilgileriTamamland);
		
		JCheckBox chckbxEvet_1 = new JCheckBox("Evet");
		chckbxEvet_1.setBounds(30, 272, 123, 26);
		panel.add(chckbxEvet_1);
		
		JCheckBox chckbxHayr = new JCheckBox("Hayır");
		chckbxHayr.setBounds(167, 272, 123, 26);
		panel.add(chckbxHayr);
		
		JLabel lblIlgiliSprinteGre = new JLabel("İlgili Sprinte Göre :");
		lblIlgiliSprinteGre.setForeground(new Color(33, 150, 243));
		lblIlgiliSprinteGre.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblIlgiliSprinteGre.setBounds(20, 310, 270, 26);
		panel.add(lblIlgiliSprinteGre);
		
		JSpinner spinner = new JSpinner();
		spinner.setEnabled(false);
		spinner.setModel(new SpinnerNumberModel(0, 0, null, 1));
		spinner.setBounds(128, 12, 82, 26);
		panel.add(spinner);
		
		JLabel lblId = new JLabel("ID'ye Göre :");
		lblId.setForeground(new Color(33, 150, 243));
		lblId.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblId.setBounds(20, 12, 270, 26);
		panel.add(lblId);
		
		JLabel lblProjeDurumunaGre = new JLabel("Proje Durumuna Göre :");
		lblProjeDurumunaGre.setForeground(new Color(33, 150, 243));
		lblProjeDurumunaGre.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblProjeDurumunaGre.setBounds(20, 49, 270, 26);
		panel.add(lblProjeDurumunaGre);
		
		JPanel pnlPrjDrm = new JPanel();
		pnlPrjDrm.setBounds(30, 86, 260, 137);
		panel.add(pnlPrjDrm);
		pnlPrjDrm.setLayout(null);
		
		JCheckBox checkBox = new JCheckBox("Pilotta");
		checkBox.setBounds(0, 37, 123, 26);
		pnlPrjDrm.add(checkBox);
		
		JCheckBox checkBox_1 = new JCheckBox("Testte");
		checkBox_1.setBounds(0, 74, 123, 26);
		pnlPrjDrm.add(checkBox_1);
		
		JCheckBox checkBox_2 = new JCheckBox("Tamamlandı");
		checkBox_2.setBounds(0, 111, 123, 26);
		pnlPrjDrm.add(checkBox_2);
		
		JCheckBox checkBox_3 = new JCheckBox("İptal Edildi");
		checkBox_3.setBounds(137, 111, 123, 26);
		pnlPrjDrm.add(checkBox_3);
		
		JCheckBox checkBox_4 = new JCheckBox("Devrede");
		checkBox_4.setBounds(137, 74, 123, 26);
		pnlPrjDrm.add(checkBox_4);
		
		JCheckBox checkBox_5 = new JCheckBox("Beklemede");
		checkBox_5.setBounds(137, 37, 123, 26);
		pnlPrjDrm.add(checkBox_5);
		
		JCheckBox checkBox_6 = new JCheckBox("Devam Ediyor");
		checkBox_6.setBounds(137, 0, 123, 26);
		pnlPrjDrm.add(checkBox_6);
		
		JCheckBox checkBox_7 = new JCheckBox("Başlamadı");
		checkBox_7.setBounds(0, 0, 123, 26);
		pnlPrjDrm.add(checkBox_7);
		
		JPanel pnlSprint = new JPanel();
		pnlSprint.setBounds(30, 348, 260, 136);
		panel.add(pnlSprint);
		pnlSprint.setLayout(null);
		
		JCheckBox checkBox_8 = new JCheckBox("Nisan");
		checkBox_8.setBounds(0, 37, 64, 26);
		pnlSprint.add(checkBox_8);
		
		JCheckBox checkBox_9 = new JCheckBox("Temmuz");
		checkBox_9.setBounds(0, 74, 86, 26);
		pnlSprint.add(checkBox_9);
		
		JCheckBox checkBox_10 = new JCheckBox("Ekim");
		checkBox_10.setBounds(0, 111, 64, 26);
		pnlSprint.add(checkBox_10);
		
		JCheckBox checkBox_11 = new JCheckBox("Kasım");
		checkBox_11.setBounds(98, 111, 64, 26);
		pnlSprint.add(checkBox_11);
		
		JCheckBox checkBox_12 = new JCheckBox("Ağustos");
		checkBox_12.setBounds(98, 74, 75, 26);
		pnlSprint.add(checkBox_12);
		
		JCheckBox checkBox_13 = new JCheckBox("Aralık");
		checkBox_13.setBounds(196, 111, 64, 26);
		pnlSprint.add(checkBox_13);
		
		JCheckBox checkBox_14 = new JCheckBox("Eylül");
		checkBox_14.setBounds(196, 74, 64, 26);
		pnlSprint.add(checkBox_14);
		
		JCheckBox checkBox_15 = new JCheckBox("Haziran");
		checkBox_15.setBounds(196, 37, 64, 26);
		pnlSprint.add(checkBox_15);
		
		JCheckBox checkBox_16 = new JCheckBox("Mart");
		checkBox_16.setBounds(196, 0, 64, 26);
		pnlSprint.add(checkBox_16);
		
		JCheckBox checkBox_17 = new JCheckBox("Şubat");
		checkBox_17.setBounds(98, 0, 64, 26);
		pnlSprint.add(checkBox_17);
		
		JCheckBox checkBox_18 = new JCheckBox("Mayıs");
		checkBox_18.setBounds(98, 37, 64, 26);
		pnlSprint.add(checkBox_18);
		
		JCheckBox checkBox_19 = new JCheckBox("Ocak");
		checkBox_19.setBounds(0, 0, 64, 26);
		pnlSprint.add(checkBox_19);
		
		JCheckBox chckbxAk = new JCheckBox("Açık");
		chckbxAk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxAk.isSelected())
					spinner.setEnabled(true);
				else
					spinner.setEnabled(false);
			}
		});
		chckbxAk.setBounds(222, 12, 80, 26);
		panel.add(chckbxAk);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new MatteBorder(0, 5, 0, 0, Color.decode("#4CAF50")));
		panel_4.setBackground(SystemColor.menu);
		panel_4.setBounds(326, 110, 686, 502);
		pnlSearchProject.add(panel_4);
		
		JLabel label_3 = new JLabel("Takımlara Göre :");
		label_3.setForeground(new Color(76, 175, 80));
		label_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_3.setBounds(20, 11, 304, 26);
		panel_4.add(label_3);
		
		JLabel lblYazlmMdrlneGre = new JLabel("Yazılım Müdürlüğüne Göre :");
		lblYazlmMdrlneGre.setForeground(new Color(76, 175, 80));
		lblYazlmMdrlneGre.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblYazlmMdrlneGre.setBounds(336, 11, 304, 26);
		panel_4.add(lblYazlmMdrlneGre);
		
		JLabel lblTalepEdenDaireye = new JLabel("Talep Eden Daireye Göre :");
		lblTalepEdenDaireye.setForeground(new Color(76, 175, 80));
		lblTalepEdenDaireye.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTalepEdenDaireye.setBounds(336, 239, 304, 26);
		panel_4.add(lblTalepEdenDaireye);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 49, 294, 430);
//		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		panel_4.add(scrollPane);
		
		JList<String> list = new JList<String>();
		scrollPane.setViewportView(list);
		list.setModel(new AbstractListModel<String>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			String[] values = takimlar;
			public int getSize() {
				return values.length;
			}
			public String getElementAt(int index) {
				return values[index];
			}
		});
		list.setValueIsAdjusting(true);
		list.setFixedCellHeight(32);
		list.setBackground(Color.WHITE);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(346, 49, 328, 178);
//		scrollPane_1.setBorder(BorderFactory.createEmptyBorder());
		panel_4.add(scrollPane_1);
		
		JList<String> list_1 = new JList<String>();
		list_1.setModel(new AbstractListModel<String>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			String[] values = mudurlukler;
			public int getSize() {
				return values.length;
			}
			public String getElementAt(int index) {
				return values[index];
			}
		});
		list_1.setValueIsAdjusting(true);
		list_1.setFixedCellHeight(32);
		list_1.setBackground(Color.WHITE);
		scrollPane_1.setViewportView(list_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(346, 277, 328, 202);
//		scrollPane_2.setBorder(BorderFactory.createEmptyBorder());
		panel_4.add(scrollPane_2);
		
		JList<String> list_2 = new JList<String>();
		list_2.setModel(new AbstractListModel<String>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			String[] values = daireler;
			public int getSize() {
				return values.length;
			}
			public String getElementAt(int index) {
				return values[index];
			}
		});
		list_2.setValueIsAdjusting(true);
		list_2.setFixedCellHeight(32);
		list_2.setBackground(Color.WHITE);
		scrollPane_2.setViewportView(list_2);
		
		JLabel lblProjeSorgula = new JLabel("   Proje Sorgula");
		lblProjeSorgula.setForeground(new Color(33, 150, 243));
		lblProjeSorgula.setFont(new Font("Montserrat Light", Font.PLAIN, 48));
		lblProjeSorgula.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode("#2196F3")));
		lblProjeSorgula.setBounds(10, 10, 1000, 64);
		pnlSearchProject.add(lblProjeSorgula);
		
		JButton btnTemizle_1 = new JButton("Temizle");
		btnTemizle_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list.clearSelection();
				list_1.clearSelection();
				list_2.clearSelection();
				spinner.setValue(0);
				spinner.setEnabled(false);
				for (Object o : panel.getComponents()) {
					try {
						JCheckBox c = (JCheckBox) o;
						c.setSelected(false);
					} catch(Exception e1) {
						// bi bok yapma
					}
				}
			}
		});
		btnTemizle_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTemizle_1.setBounds(654, 630, 170, 44);
		pnlSearchProject.add(btnTemizle_1);
		
		JButton btnSorgula = new JButton("Sorgula");
		btnSorgula.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String query = "SELECT  "
						+ "id,"
						+ "isin_gelis_sekli,"
						+ "evrak_tarihi,"
						+ "evrak_sayisi,"
						+ "talep_eden_daire,"
						+ "ilgili_mudurluk,"
						+ "isin_turu,"
						+ "ilave_istek_sebebi,"
						+ "ilgili_uygulama,"
						+ "ilgili_modul,"
						+ "hata_talep,"
						+ "talep_adi,"
						+ "talep_no,"
						+ "talep_konusu,"
						+ "talep_durumu,"
						+ "talep_durum_tarih,"
						+ "aciklama,"
						+ "takimi,"
						+ "ilgili_sprint,"
						+ "takim_kisi_sayisi,"
						+ "sorumlu,"
						+ "oncelik_sirasi,"
						+ "kaynak_ihtiyaci,"
						+ "kalan_kaynak_ihtiyaci,"
						+ "gerceklesen_kaynak_ihtiyaci,"
						+ "ilave_kaynak_ihtiyaci "
						+ "FROM proje";
				String tmpData = "",data = "";
				for(Object o : list.getSelectedValues()) {
					try {
						String s = (String) o;
						if(!tmpData.equals(""))
							tmpData+=',';
						tmpData+="'"+s+"'";
					} catch(Exception e1) {
						//Bi bok yapma
					}
				}
				if(!tmpData.equals("")) {
					tmpData = "takimi IN("+tmpData+")";
					data += tmpData;
				}
				tmpData = "";
				for(Object o : list_1.getSelectedValues()) {
					try {
						String s = (String) o;
						if(!tmpData.equals(""))
							tmpData+=',';
						tmpData+="'"+s+"'";
					} catch(Exception e1) {
						//Bi bok yapma
					}
				}
				if(!tmpData.equals("")) {
					tmpData = "ilgili_mudurluk IN("+tmpData+")";
					if(!data.equals(""))
						data += " AND "+tmpData;
					else
						data += tmpData;
				}
				tmpData = "";
				for(Object o : list_2.getSelectedValues()) {
					try {
						String s = (String) o;
						if(!tmpData.equals(""))
							tmpData+=',';
						tmpData+="'"+s+"'";
					} catch(Exception e1) {
						//Bi bok yapma
					}
				}
				if(!tmpData.equals("")) {
					tmpData = "talep_eden_daire IN("+tmpData+")";
					if(!data.equals(""))
						data += " AND "+tmpData;
					else
						data += tmpData;
				}
				tmpData = "";
				if(spinner.isEnabled())
					tmpData = "id = '"+spinner.getValue()+"'";
				if(!tmpData.equals("")) {
					if(!data.equals(""))
						data += " AND "+tmpData;
					else
						data += tmpData;
				}
				tmpData = "";
				if(chckbxEvet_1.isSelected())
					tmpData = "'evet'";
				if(chckbxHayr.isSelected())
					if(!tmpData.equals(""))
						tmpData += ",'"+"hayir"+"'";
					else
						tmpData = "hayir";
				if(!tmpData.equals("")) {
					tmpData = "tamamlandi IN("+tmpData+")";
					if(!data.equals(""))
						data += " AND "+tmpData;
					else
						data += tmpData;
				}
				tmpData = "";
				for(Object o : pnlPrjDrm.getComponents()) {
					try {
						if(((JCheckBox)o).isSelected()) {
							String s = SharedFunctions.convertToDB(((JCheckBox)o).getText());
							if(!tmpData.equals(""))
								tmpData+=',';
							tmpData+="'"+s+"'";
						}
					} catch(Exception e1) {
						//Bi bok yapma
					}
				}
				if(!tmpData.equals("")) {
					tmpData = "talep_durumu IN("+tmpData+")";
					if(!data.equals(""))
						data += " AND "+tmpData;
					else
						data += tmpData;
				}
				tmpData = "";
				for(Object o : pnlSprint.getComponents()) {
					try {
						if(((JCheckBox)o).isSelected()) {
							String s = ((JCheckBox)o).getText();
							if(!tmpData.equals(""))
								tmpData+=" OR ";
							tmpData+="ilgili_sprint LIKE CONCAT('%','"+s+"','%')";
						}
					} catch(Exception e1) {
						//Bi bok yapma
					}
				}
				if(!tmpData.equals("")) {
					tmpData = "("+tmpData+")";
					if(!data.equals(""))
						data += " AND "+tmpData;
					else
						data += tmpData;
				}
				if(!data.equals(""))
					query += " WHERE "+data;
				//System.out.println(query);
				query += " ORDER BY id";
				String[] headers = {
						"ID",
						"İşin Geliş Şekli",
						"Evrak Tarihi",
						"Evrak Sayısı",
						"Talep Eden Daire",
						"İlgili Müdürlük",
						"İşin Türü",
						"İlave İstek Sebebi",
						"İlgili Uygulama",
						"İlgili Modül",
						"Hata Talep",
						"Talep Adı",
						"Talep No",
						"Talep Konusu",
						"Talep Durumu",
						"Son Değiştirilme Tarihi",
						"Açıklama",
						"Takımı",
						"İlgili Sprint",
						"Takım Kişi Sayısı",
						"Sorumlu",
						"Öncelik Sırası",
						"Öngörülen Kaynak İhtiyacı (adam*gün)",
						"Kalan Kaynak İhtiyacı (adam*gün)",
						"Gerçekleşen Kaynak İhtiyacı (adam*gün)",
						"İlave Kaynak İhtiyacı (adam*gün)"};
				//System.out.println(headers.length);
				pnlSearchResult.removeAll();
				JLabel lbl = new JLabel("Proje Sorgula Sonucu");
				lbl.setFont(new Font("Montserrat Light", Font.PLAIN, 32));
				lbl.setForeground((Color) new Color(33, 150, 243));
				lbl.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, (Color) new Color(33, 150, 243)));
				lbl.setBounds(12, 12, 992, 48);
				pnlSearchResult.add(lbl);
				SharedFunctions.createTable1(pnlSearchResult, 12, 64, 992, query, headers, false, false);
				pnlSearchObstacle.setVisible(false);

				btnEngelToExcel = new JButton("Excel'e Aktar");
				btnEngelToExcel.setFont(new Font("Tahoma", Font.PLAIN, 16));
				btnEngelToExcel.setBounds(846, 20, 160, 32);
				btnEngelToExcel.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						btnExport.doClick();
					}
				});
				pnlSearchResult.add(btnEngelToExcel);
				
				btnShow = new JButton("Ayrıntılı Göster");
				btnShow.setEnabled(false);
				btnShow.setFont(new Font("Tahoma", Font.PLAIN, 16));
				btnShow.setBounds(676, 20, 160, 32);
				btnShow.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						Details.ekran = new Details("proje");
						Details.ekran.setVisible(true);
					}
				});
				pnlSearchResult.add(btnShow);

				pnlSearchResult.setLocation(250,10);
				pnlSearchProject.setVisible(false);
				pnlSearchResult.setVisible(true);
				
				btnTemizle_1.doClick();
			}
		});
		btnSorgula.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSorgula.setBounds(835, 630, 170, 44);
		pnlSearchProject.add(btnSorgula);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(Manager.class.getResource("/images/logo512.png")));
		label.setBounds(250, 32, 1020, 512);
		viewPanel.add(label);
		
		JLabel lblNewLabel_1 = new JLabel("OPYS");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Montserrat Light", Font.PLAIN, 99));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(250, 564, 1020, 128);
		viewPanel.add(lblNewLabel_1);
		
		setVisible(true);
		this.repaint();
	}
}
