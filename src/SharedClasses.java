import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public abstract class SharedClasses {
	
	public static class JMenuBtn extends JPanel implements FocusListener,MouseListener {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 7332033887685992331L;
		public JLabel text;
		public int id;
		public static int idCounter = 0;
		public Color bg,fg;
		public static JMenuBtn selectedBtn = null;
		public static JMenuBtn focusedBtn = null;
		
		public JMenuBtn(String text, int w, int h, Color bg, Color fg) {
			this.id = idCounter++;
			this.bg = bg;
			this.fg = fg;
			this.setLayout(new BorderLayout());
			this.text = new JLabel("  "+text);
			this.add(this.text,BorderLayout.CENTER);
			this.setFocusable(true);
			this.setBounds(0, 0, w, h);
			this.setBackground(bg);
			this.text.setForeground(fg);
			this.text.setFont(new Font("Montserrat Light", Font.PLAIN, 16));
			this.addFocusListener(this);
			this.addMouseListener(this);
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			if(JMenuBtn.this.text.getText().trim().equals("Çıkış")) {
				JMenuBtn.this.setBackground(Color.decode("#E91E63"));
				JMenuBtn.this.text.setForeground(Color.white);
				if(JOptionPane.showConfirmDialog(Manager.ekran, "Exit OPYS?", "Exit?", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
					System.exit(0);
				}
				else {
					JMenuBtn.this.setBackground(bg);
					JMenuBtn.this.text.setForeground(fg);
				}
				return;
			}
			Manager.pnlReports.setVisible(false);
			Manager.pnlProfile.setVisible(false);
			Manager.pnlRegisterObstacle.setVisible(false);
			Manager.pnlSearchObstacle.setVisible(false);
			Manager.pnlSearchResult.setVisible(false);
			Manager.pnlRegisterProject.setVisible(false);
			Manager.pnlSearchProject.setVisible(false);
			if(JMenuBtn.this.text.getText().trim().equals("Profil")) {
				Manager.pnlProfile.setLocation(250, 10);
				Manager.pnlProfile.setVisible(true);
			} else if(JMenuBtn.this.text.getText().trim().equals("Raporlar")) {
				Manager.comboBox.setSelectedIndex(0);
				Manager.pnlReports.setLocation(250, 10);
				Manager.pnlReports.setVisible(true);
			} else if(JMenuBtn.this.text.getText().trim().equals("Engel Kayıt")) {
				Manager.pnlRegisterObstacle.setLocation(250, 10);
				Manager.pnlRegisterObstacle.setVisible(true);
			} else if(JMenuBtn.this.text.getText().trim().equals("Engel Sorgula")) {
				Manager.pnlSearchObstacle.setLocation(250, 10);
				Manager.pnlSearchObstacle.setVisible(true);
			} else if(JMenuBtn.this.text.getText().trim().equals("Proje Kayıt")) {
				Manager.pnlRegisterProject.setLocation(250, 10);
				Manager.pnlRegisterProject.setVisible(true);
			} else if(JMenuBtn.this.text.getText().trim().equals("Proje Sorgula")) {
				Manager.pnlSearchProject.setLocation(250, 10);
				Manager.pnlSearchProject.setVisible(true);
			}
			if(selectedBtn!=null) {
				selectedBtn.setBackground(bg);
				selectedBtn.text.setForeground(fg);
			}
			selectedBtn = JMenuBtn.this;
			selectedBtn.setBackground(Color.decode("#40A4F3"));
			selectedBtn.text.setForeground(Color.white);
			//System.out.println("Clicked "+JMenuBtn.this.text.getText());
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			if(selectedBtn != JMenuBtn.this) {
				JMenuBtn.this.setBackground(bg);
				JMenuBtn.this.text.setForeground(fg);
			} else {
				selectedBtn.setBackground(Color.decode("#2196F3"));
				selectedBtn.text.setForeground(Color.decode("#EEEEEE"));
			}
			JMenuBtn.this.text.setText("  "+JMenuBtn.this.text.getText().trim());
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			if(focusedBtn!=null) {
				focusedBtn.setBackground(bg);
				focusedBtn.text.setForeground(fg);
				focusedBtn.text.setText("  "+focusedBtn.text.getText().trim());
				focusedBtn = null;
			}
			if(selectedBtn != JMenuBtn.this) {
				JMenuBtn.this.setBackground(Color.decode("#0B0C0F"));
				JMenuBtn.this.text.setForeground(Color.white);
			} else {
				selectedBtn.setBackground(Color.decode("#40A4F3"));
				selectedBtn.text.setForeground(Color.white);
			}
			JMenuBtn.this.text.setText("   "+JMenuBtn.this.text.getText().trim());
		}

		@Override
		public void focusLost(FocusEvent e) {
			JMenuBtn.this.setBackground(bg);
			JMenuBtn.this.text.setForeground(fg);
			JMenuBtn.this.text.setText("  "+JMenuBtn.this.text.getText().trim());
		}
		
		@Override
		public void focusGained(FocusEvent e) {
			if(focusedBtn!=null) {
				focusedBtn.setBackground(bg);
				focusedBtn.text.setForeground(fg);
				focusedBtn.text.setText("  "+focusedBtn.text.getText().trim());
				focusedBtn = null;
			}
			JMenuBtn.this.setBackground(Color.decode("#0B0C0F"));
			JMenuBtn.this.text.setForeground(Color.white);
			JMenuBtn.this.text.setText("   "+JMenuBtn.this.text.getText().trim());
			focusedBtn = JMenuBtn.this;
		}
		
	}
	
}
