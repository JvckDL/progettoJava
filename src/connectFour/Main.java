package connectFour;

import java.awt.EventQueue;

import javax.swing.SwingUtilities;

import connectFour.StartingWindow;

public class Main {
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartingWindow window = new StartingWindow();
					window.frmConnect.setVisible(true);					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

}
