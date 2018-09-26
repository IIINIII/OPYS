import java.awt.Color;

import javax.swing.JFrame;

public class Details extends JFrame {
	
	public static Details ekran;
	
	public Details(String name) {
		setResizable(false);
		getContentPane().setLayout(null);
		setSize(1094, 832);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.decode("#303641"));
		
		if(name == "proje") {
			ProjectDetailPanel pnl = new ProjectDetailPanel();
			getContentPane().add(pnl);
		}
		else if(name == "engel") {
			ObstacleDetailPanel pnl = new ObstacleDetailPanel();
			getContentPane().add(pnl);
		}
		
	}

}
