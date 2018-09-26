import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public abstract class Listeners {
	
	public static MouseListener btnMouseListener = new MouseListener() {
		
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
													   																										
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			if(((SharedClasses.JMenuBtn)e.getSource()).text.getText().trim().equals("Exit")) {
				System.exit(0);
			}            
		}
	};

}
