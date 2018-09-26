import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.JEditorPane;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.awt.event.ActionEvent;

public class ObstacleDetailPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	
	public ObstacleDetailPanel() {
		setSize(1086, 800);
		setLayout(null);
		setBackground(Color.decode("#303641"));
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItem("Seçiniz");
		SharedFunctions.DBtoCombo(comboBox, Manager.takimlar);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox.setBounds(373, 91, 557, 32);
		add(comboBox);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setColumns(10);
		textField.setBounds(373, 135, 557, 32);
		add(textField);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setFont(new Font("Tahoma", Font.PLAIN, 16));
		editorPane.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
		editorPane.setBounds(373, 223, 557, 136);
		add(editorPane);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(373, 371, 557, 32);
		add(textField_1);
		
		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.addItem("Seçiniz");
		comboBox_1.addItem("acik");
		comboBox_1.addItem("kapali");
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox_1.setBounds(373, 503, 557, 32);
		add(comboBox_1);
		
		JComboBox<String> comboBox_2 = new JComboBox<String>();
		comboBox_2.addItem("Seçiniz");
		comboBox_2.addItem("Başka Birim Bekleme");
		comboBox_2.addItem("Bilgi Eksikliği");
		comboBox_2.addItem("Diğer");
		comboBox_2.addItem("Eğitim");
		comboBox_2.addItem("Eksik Analiz");
		comboBox_2.addItem("Farklı İş");
		comboBox_2.addItem("Hata Giderme");
		comboBox_2.addItem("İzin Rapor");
		comboBox_2.addItem("Planlama Hatası");
		comboBox_2.addItem("Teknik Sorun");
		comboBox_2.addItem("Test Dönüş Düzeltme");
		comboBox_2.addItem("Toplantı");
		comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox_2.setBounds(373, 547, 557, 32);
		add(comboBox_2);
		
		JLabel label = new JLabel("Takımı :");
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(106, 91, 249, 32);
		add(label);
		
		JLabel label_1 = new JLabel("Bildiren :");
		label_1.setForeground(Color.WHITE);
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(106, 135, 249, 32);
		add(label_1);
		
		JLabel label_2 = new JLabel("Açılış Tarihi :");
		label_2.setForeground(Color.WHITE);
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_2.setBounds(106, 179, 249, 32);
		add(label_2);
		
		JLabel label_3 = new JLabel("Engel :");
		label_3.setForeground(Color.WHITE);
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_3.setBounds(106, 223, 249, 32);
		add(label_3);
		
		JLabel label_4 = new JLabel("Çözüm Sorumlusu :");
		label_4.setForeground(Color.WHITE);
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_4.setBounds(106, 371, 249, 32);
		add(label_4);
		
		JLabel label_5 = new JLabel("Hedef Çözüm Tarihi :");
		label_5.setForeground(Color.WHITE);
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_5.setBounds(106, 415, 249, 32);
		add(label_5);
		
		JLabel label_6 = new JLabel("Gerçekleşen Çözüm Tarihi :");
		label_6.setForeground(Color.WHITE);
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_6.setBounds(106, 459, 249, 32);
		add(label_6);
		
		JLabel label_7 = new JLabel("Durumu :");
		label_7.setForeground(Color.WHITE);
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_7.setBounds(106, 503, 249, 32);
		add(label_7);
		
		JLabel label_8 = new JLabel("Kategori :");
		label_8.setForeground(Color.WHITE);
		label_8.setHorizontalAlignment(SwingConstants.RIGHT);
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_8.setBounds(106, 547, 249, 32);
		add(label_8);
		
		JSpinner spinner = new JSpinner(new SpinnerDateModel(Calendar.getInstance().getTime(), null, null, Calendar.DAY_OF_YEAR));
		spinner.setEditor(new JSpinner.DateEditor(spinner, "yyyy-MM-dd"));
		spinner.setBounds(373, 179, 557, 32);
		add(spinner);
		
		JSpinner spinner_1 = new JSpinner(new SpinnerDateModel(Calendar.getInstance().getTime(), null, null, Calendar.DAY_OF_YEAR));
		spinner_1.setEditor(new JSpinner.DateEditor(spinner_1, "yyyy-MM-dd"));
		spinner_1.setBounds(373, 415, 557, 32);
		add(spinner_1);
		
		JSpinner spinner_2 = new JSpinner(new SpinnerDateModel(Calendar.getInstance().getTime(), null, null, Calendar.DAY_OF_YEAR));
		spinner_2.setEditor(new JSpinner.DateEditor(spinner_2, "yyyy-MM-dd"));
		spinner_2.setBounds(373, 459, 557, 32);
		add(spinner_2);
		
		JSpinner spinner_3 = new JSpinner(new SpinnerNumberModel(0, null, null, 0));
		spinner_3.setEnabled(false);
		spinner_3.setBounds(373, 48, 557, 32);
		add(spinner_3);
		
		try {
			JTable t = (JTable) ((JPanel) ((JScrollPane) Manager.tablePanel).getViewport().getComponent(0)).getComponent(0);
			int sri = ((JTable) ((JPanel) ((JScrollPane) Manager.tablePanel).getViewport().getComponent(0)).getComponent(0)).getSelectedRow();
			spinner_3.setValue(t.getModel().getValueAt(sri, 0));
			comboBox.setSelectedItem(t.getModel().getValueAt(sri, 1));
			textField.setText((String) t.getModel().getValueAt(sri, 2));
			((JSpinner.DateEditor)spinner.getEditor()).getTextField().setText((String) t.getModel().getValueAt(sri, 3));
			editorPane.setText((String) t.getModel().getValueAt(sri, 4));
			textField_1.setText((String) t.getModel().getValueAt(sri, 5));
			((JSpinner.DateEditor)spinner_1.getEditor()).getTextField().setText((String) t.getModel().getValueAt(sri, 6));
			((JSpinner.DateEditor)spinner_2.getEditor()).getTextField().setText((String) t.getModel().getValueAt(sri, 7));
			comboBox_1.setSelectedItem(t.getModel().getValueAt(sri, 8));
			comboBox_2.setSelectedItem(t.getModel().getValueAt(sri, 9));
		} catch(Exception e) {
			
		}
		JButton btnGncelle = new JButton("G\u00FCncelle");
		btnGncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(Details.ekran, "Engel bilgileri güncellensin mi?","Engel Güncelleme",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
					String query = "UPDATE engeller SET takimi='"+comboBox.getSelectedItem().toString()+"',bildiren='"+textField.getText()+"',acilis_tarihi='"+((JSpinner.DateEditor)spinner.getEditor()).getTextField().getText()+"',aciklama='"+editorPane.getText()+"',cozum_sorumlusu='"+textField_1.getText()+"',hedef_cozum_tarihi='"+((JSpinner.DateEditor)spinner_1.getEditor()).getTextField().getText()+"',gerceklesen_cozum_tarihi='"+((JSpinner.DateEditor)spinner_2.getEditor()).getTextField().getText()+"',durumu='"+comboBox_1.getSelectedItem().toString()+"',kategori='"+comboBox_2.getSelectedItem().toString()+"' WHERE id='"+spinner_3.getValue()+"'";
					query = query.replaceAll("Seçiniz", "");
					int rs = VT.veriEkle(query);
					if(rs>0) {
						JOptionPane.showMessageDialog(Details.ekran, "Engel bilgileri güncellendi!");
					}
					Details.ekran.setVisible(false);
				}
			}
		});
		
		JLabel lblId = new JLabel("ID :");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblId.setBounds(106, 48, 249, 32);
		add(lblId);
		btnGncelle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnGncelle.setBounds(660, 590, 270, 48);
		add(btnGncelle);
		
	}
}
