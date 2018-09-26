import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class ProjectDetailPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8727208097425547519L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	public ProjectDetailPanel() {
		setSize(1086, 800);
		setLayout(null);
		setBackground(Color.decode("#303641"));
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItem("Seçiniz");
		comboBox.addItem("EBYS");
		comboBox.addItem("MAİL");
		comboBox.addItem("SÖZLÜ");
		comboBox.addItem("TOPLANTI TUTANAĞI");
		comboBox.setBounds(188, 67, 294, 32);
		add(comboBox);
		
		JSpinner spinner = new JSpinner();
		spinner.setEnabled(false);
		spinner.setBounds(188, 24, 294, 32);
		add(spinner);
		
		JSpinner spinner_1 = new JSpinner(new SpinnerDateModel(Calendar.getInstance().getTime(), null, null, Calendar.DAY_OF_YEAR));
		spinner_1.setEditor(new JSpinner.DateEditor(spinner_1, "yyyy-MM-dd"));
		spinner_1.setBounds(188, 110, 294, 32);
		add(spinner_1);
		
		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.addItem("Seçiniz");
		SharedFunctions.DBtoCombo(comboBox_1, Manager.daireler);
		comboBox_1.setBounds(188, 196, 294, 32);
		add(comboBox_1);
		
		JComboBox<String> comboBox_2 = new JComboBox<String>();
		comboBox_2.addItem("Seçiniz");
		SharedFunctions.DBtoCombo(comboBox_2, Manager.mudurlukler);
		comboBox_2.setBounds(188, 239, 294, 32);
		add(comboBox_2);
		
		JComboBox<String> comboBox_3 = new JComboBox<String>();
		comboBox_3.addItem("Seçiniz");
		comboBox_3.addItem("İlave İstek");
		comboBox_3.addItem("Yeni Proje");
		comboBox_3.addItem("Arıza");
		comboBox_3.setBounds(188, 282, 294, 32);
		add(comboBox_3);
		
		JComboBox<String> comboBox_4 = new JComboBox<String>();
		comboBox_4.addItem("Seçiniz");
		comboBox_4.addItem("hata");
		comboBox_4.addItem("talep");
		comboBox_4.setBounds(188, 454, 294, 32);
		add(comboBox_4);
		
		JComboBox<String> comboBox_5 = new JComboBox<String>();
		comboBox_5.addItem("Seçiniz");
		SharedFunctions.DBtoCombo(comboBox_5, Manager.takimlar);
		comboBox_5.setBounds(760, 369, 294, 32);
		add(comboBox_5);
		
		JComboBox<String> comboBox_6 = new JComboBox<String>();
		comboBox_6.addItem("Seçiniz");
		comboBox_6.addItem("Ocak");
		comboBox_6.addItem("Şubat");
		comboBox_6.addItem("Mart");
		comboBox_6.addItem("Nisan");
		comboBox_6.addItem("Mayıs");
		comboBox_6.addItem("Haziran");
		comboBox_6.addItem("Temmuz");
		comboBox_6.addItem("Ağustos");
		comboBox_6.addItem("Eylül");
		comboBox_6.addItem("Ekim");
		comboBox_6.addItem("Kasım");
		comboBox_6.addItem("Aralık");
		comboBox_6.setBounds(760, 413, 294, 32);
		add(comboBox_6);
		
		textField = new JTextField();
		textField.setBounds(188, 153, 294, 32);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(188, 325, 294, 32);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(188, 368, 294, 32);
		add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(188, 411, 294, 32);
		add(textField_3);
		
		JComboBox<String> comboBox_7 = new JComboBox<String>();
		comboBox_7.addItem("Seçiniz");
		comboBox_7.addItem("Başlamadı");
		comboBox_7.addItem("Beklemede");
		comboBox_7.addItem("Devam Ediyor");
		comboBox_7.addItem("Pilotta");
		comboBox_7.addItem("Testte");
		comboBox_7.addItem("Devrede");
		comboBox_7.addItem("Tamamlandı");
		comboBox_7.addItem("İptal Edildi");
		comboBox_7.setBounds(760, 153, 294, 32);
		add(comboBox_7);
		
		JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
		textArea.setBounds(188, 498, 294, 80);
		add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setWrapStyleWord(true);
		textArea_1.setLineWrap(true);
		textArea_1.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
		textArea_1.setBounds(760, 24, 294, 117);
		add(textArea_1);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setWrapStyleWord(true);
		textArea_2.setLineWrap(true);
		textArea_2.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
		textArea_2.setBounds(760, 197, 294, 160);
		add(textArea_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(188, 589, 294, 32);
		add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(760, 457, 294, 32);
		add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(760, 501, 294, 32);
		add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(760, 545, 294, 32);
		add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(760, 589, 294, 32);
		add(textField_8);
		
		JLabel lblId = new JLabel("ID :");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblId.setForeground(Color.WHITE);
		lblId.setBounds(-12, 24, 182, 32);
		add(lblId);
		
		JLabel label = new JLabel("İşin Geliş Şekli :");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setForeground(Color.WHITE);
		label.setBounds(-12, 67, 182, 32);
		add(label);
		
		JLabel label_1 = new JLabel("Evrak Tarihi :");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(-12, 111, 182, 32);
		add(label_1);
		
		JLabel label_2 = new JLabel("Evrak Sayısı :");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(-12, 153, 182, 32);
		add(label_2);
		
		JLabel label_3 = new JLabel("Talep Eden Daire :");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_3.setForeground(Color.WHITE);
		label_3.setBounds(-12, 196, 182, 32);
		add(label_3);
		
		JLabel label_4 = new JLabel("İlgili Yazılım Müdürlüğü :");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_4.setForeground(Color.WHITE);
		label_4.setBounds(-12, 239, 182, 32);
		add(label_4);
		
		JLabel label_5 = new JLabel("İşin Türü :");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_5.setForeground(Color.WHITE);
		label_5.setBounds(-12, 282, 182, 32);
		add(label_5);
		
		JLabel label_6 = new JLabel("İlave İstek Sebebi :");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_6.setForeground(Color.WHITE);
		label_6.setBounds(-12, 326, 182, 32);
		add(label_6);
		
		JLabel label_7 = new JLabel("İlgili Uygulama :");
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		label_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_7.setForeground(Color.WHITE);
		label_7.setBounds(-12, 370, 182, 32);
		add(label_7);
		
		JLabel label_8 = new JLabel("İlgili Modül :");
		label_8.setHorizontalAlignment(SwingConstants.RIGHT);
		label_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_8.setForeground(Color.WHITE);
		label_8.setBounds(-12, 411, 182, 32);
		add(label_8);
		
		JLabel label_9 = new JLabel("Hata/Talep :");
		label_9.setHorizontalAlignment(SwingConstants.RIGHT);
		label_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_9.setForeground(Color.WHITE);
		label_9.setBounds(-12, 454, 182, 32);
		add(label_9);
		
		JLabel label_10 = new JLabel("Talep Adı :");
		label_10.setHorizontalAlignment(SwingConstants.RIGHT);
		label_10.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_10.setForeground(Color.WHITE);
		label_10.setBounds(-12, 498, 182, 32);
		add(label_10);
		
		JLabel label_11 = new JLabel("Talep No :");
		label_11.setHorizontalAlignment(SwingConstants.RIGHT);
		label_11.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_11.setForeground(Color.WHITE);
		label_11.setBounds(-12, 588, 182, 32);
		add(label_11);
		
		JLabel label_12 = new JLabel("Talep Konusu :");
		label_12.setHorizontalAlignment(SwingConstants.RIGHT);
		label_12.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_12.setForeground(Color.WHITE);
		label_12.setBounds(524, 23, 218, 32);
		add(label_12);
		
		JLabel label_13 = new JLabel("Talebin Durumu :");
		label_13.setHorizontalAlignment(SwingConstants.RIGHT);
		label_13.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_13.setForeground(Color.WHITE);
		label_13.setBounds(524, 152, 218, 32);
		add(label_13);
		
		JLabel label_14 = new JLabel("Açıklama :");
		label_14.setHorizontalAlignment(SwingConstants.RIGHT);
		label_14.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_14.setForeground(Color.WHITE);
		label_14.setBounds(524, 197, 218, 32);
		add(label_14);
		
		JLabel label_15 = new JLabel("Takımı :");
		label_15.setHorizontalAlignment(SwingConstants.RIGHT);
		label_15.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_15.setForeground(Color.WHITE);
		label_15.setBounds(524, 369, 218, 32);
		add(label_15);
		
		JLabel label_16 = new JLabel("İlgili Sprint :");
		label_16.setHorizontalAlignment(SwingConstants.RIGHT);
		label_16.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_16.setForeground(Color.WHITE);
		label_16.setBounds(524, 413, 218, 32);
		add(label_16);
		
		JLabel label_17 = new JLabel("Takım Kişi Sayısı :");
		label_17.setHorizontalAlignment(SwingConstants.RIGHT);
		label_17.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_17.setForeground(Color.WHITE);
		label_17.setBounds(524, 456, 218, 32);
		add(label_17);
		
		JLabel label_18 = new JLabel("Sorumlu :");
		label_18.setHorizontalAlignment(SwingConstants.RIGHT);
		label_18.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_18.setForeground(Color.WHITE);
		label_18.setBounds(524, 500, 218, 32);
		add(label_18);
		
		JLabel label_19 = new JLabel("Öncelik Sırasi :");
		label_19.setHorizontalAlignment(SwingConstants.RIGHT);
		label_19.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_19.setForeground(Color.WHITE);
		label_19.setBounds(524, 544, 218, 32);
		add(label_19);
		
		JLabel label_20 = new JLabel("Öngörülen Kaynak İhtiyacı(adam*gün) :");
		label_20.setHorizontalAlignment(SwingConstants.RIGHT);
		label_20.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_20.setForeground(Color.WHITE);
		label_20.setBounds(486, 588, 256, 32);
		add(label_20);

		try {
			JTable t = (JTable) ((JPanel) ((JScrollPane) Manager.tablePanel).getViewport().getComponent(0)).getComponent(1);
			int sri = ((JTable) ((JPanel) ((JScrollPane) Manager.tablePanel).getViewport().getComponent(0)).getComponent(1)).getSelectedRow();
			spinner.setValue(t.getModel().getValueAt(sri, 0));
			comboBox.setSelectedItem(t.getModel().getValueAt(sri, 1));
			((JSpinner.DateEditor)spinner_1.getEditor()).getTextField().setText((String) t.getModel().getValueAt(sri, 2));
			textField.setText((String) t.getModel().getValueAt(sri, 3));
			comboBox_1.setSelectedItem(t.getModel().getValueAt(sri, 4));
			comboBox_2.setSelectedItem(t.getModel().getValueAt(sri, 5));
			comboBox_3.setSelectedItem(t.getModel().getValueAt(sri, 6));
			textField_1.setText((String) t.getModel().getValueAt(sri, 7));
			textField_2.setText((String) t.getModel().getValueAt(sri, 8));
			textField_3.setText((String) t.getModel().getValueAt(sri, 9));
			comboBox_4.setSelectedItem(t.getModel().getValueAt(sri, 10));
			textArea.setText((String) t.getModel().getValueAt(sri, 11));
			textField_4.setText((String) t.getModel().getValueAt(sri, 12));
			textArea_1.setText((String) t.getModel().getValueAt(sri, 13));
			//System.out.println(SharedFunctions.convertToCombo((String) t.getModel().getValueAt(sri, 14)));
			//System.out.println((String) t.getModel().getValueAt(sri, 14));
			comboBox_7.setSelectedItem(SharedFunctions.convertToCombo((String) t.getModel().getValueAt(sri, 14)));
			textArea_2.setText((String) t.getModel().getValueAt(sri, 16));
			comboBox_5.setSelectedItem(t.getModel().getValueAt(sri, 17));
			String s=(String) t.getModel().getValueAt(sri, 18);
			try {
				comboBox_6.setSelectedItem(s.substring(0, s.indexOf(' ')));
			} catch(Exception e1) {
				
			}
			textField_5.setText((String) t.getModel().getValueAt(sri, 19));
			textField_6.setText((String) t.getModel().getValueAt(sri, 20));
			textField_7.setText((String) t.getModel().getValueAt(sri, 21));
			textField_8.setText((String) t.getModel().getValueAt(sri, 22));
		} catch(Exception e) {
			
		}
		String tmpQuery = "SELECT talep_id,baslamadi,beklemede,devam_ediyor,pilotta,testte,devrede,tamamlandi,iptal_edildi FROM talep_durum_tarih WHERE talep_id='"+spinner.getValue()+"'";
		SharedFunctions.xasd = 32;
		SharedFunctions.createTable2(this, 188, 616, 866, tmpQuery, new String[]{"Talep ID","Talep Geliş","Beklemede","Devam Ediyor","Pilotta","Testte","Devrede","Tamamlandı","İptal Edildi"}, false, false);
		for(Object o : getComponents()) {
			try {
				JScrollPane sp = (JScrollPane) o;
				sp.setBounds(sp.getBounds().x, sp.getBounds().y, sp.getBounds().width, 80);
			} catch(Exception e) {
				//a asd
			}
		}
		
		JButton btnGuncelle = new JButton("Güncelle");
		btnGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(Details.ekran, "Proje bilgileri güncellensin mi?","Proje Güncelleme",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
					if(comboBox_4.getSelectedItem()==null)
						comboBox_4.setSelectedIndex(0);
					String query = "UPDATE proje SET isin_gelis_sekli='"+comboBox.getSelectedItem().toString()+"',evrak_tarihi='"+((JSpinner.DateEditor)spinner_1.getEditor()).getTextField().getText()+"',evrak_sayisi='"+textField.getText()+"',talep_eden_daire='"+comboBox_1.getSelectedItem().toString()+"',ilgili_mudurluk='"+comboBox_2.getSelectedItem().toString()+"',isin_turu='"+comboBox_3.getSelectedItem().toString()+"',ilave_istek_sebebi='"+textField_1.getText()+"',ilgili_uygulama='"+textField_2.getText()+"',ilgili_modul='"+textField_3.getText()+"',hata_talep='"+comboBox_4.getSelectedItem().toString()+"',talep_adi='"+textArea.getText()+"',talep_no='"+textField_4.getText()+"',talep_konusu='"+textArea_1.getText()+"',talep_durumu='"+SharedFunctions.convertToDB(comboBox_7.getSelectedItem().toString())+"',aciklama='"+textArea_2.getText()+"',takimi='"+comboBox_5.getSelectedItem().toString()+"',ilgili_sprint='"+comboBox_6.getSelectedItem().toString()+" "+Calendar.getInstance().get(Calendar.YEAR)+"',takim_kisi_sayisi='"+textField_5.getText()+"',sorumlu='"+textField_6.getText()+"',oncelik_sirasi='"+textField_7.getText()+"',kaynak_ihtiyaci='"+textField_8.getText()+"' WHERE id='"+spinner.getValue()+"'";
					query = query.replaceAll("Seçiniz", "");
					int rs = VT.veriEkle(query);
					if(rs>0) {
						query = "UPDATE talep_durum_tarih SET "+SharedFunctions.convertToDB(comboBox_7.getSelectedItem().toString())+"='"+(new SimpleDateFormat("yyyy-MM-dd")).format(new Date())+"' WHERE talep_id='"+spinner.getValue()+"'";
						rs = VT.veriEkle(query);
						if(rs>0) {
							JOptionPane.showMessageDialog(Details.ekran, "Proje bilgileri güncellendi!");
						}
					}
					Details.ekran.setVisible(false);
				}
			}
		});
		btnGuncelle.setBounds(897, 748, 157, 41);
		add(btnGuncelle);
		
		JButton btnSil = new JButton("Sil");
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(Details.ekran, "Bu proje silinsin mi?","Silme",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					String query = "DELETE proje,talep_durum_tarih FROM proje INNER JOIN talep_durum_tarih WHERE proje.id= talep_durum_tarih.talep_id and proje.id = '"+spinner.getValue()+"'";
					int rs = VT.veriEkle(query);
					if(rs>0) {
						JOptionPane.showMessageDialog(Details.ekran, "Proje silindi!", "Silme Sonucu", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(Details.ekran, "Proje silinemedi!", "Silme Sonucu", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnSil.setBounds(729, 748, 157, 41);
		add(btnSil);
	}
}
