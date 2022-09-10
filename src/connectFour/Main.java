package connectFour;

import java.awt.EventQueue;
import java.util.Scanner;

import javax.swing.SwingUtilities;

import connectFour.StartingWindow;

public class Main {
	
	public static String player1;
	public static String player2;

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartingWindow window = new StartingWindow();
					window.frmConnect.setVisible(true);
					//player1 = window.getNamePla1();
					//player2 = window.getNamePla2();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		/*SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new StartingWindow();
			}
		});
			
		
		System.out.println("Enter the name of the first player:");
		Scanner in = new Scanner(System.in);
		player1 = in.next();
		
		//System.out.println(player1.getClass().getSimpleName());
		
		System.out.println("Enter the name of the second player: ");
		Scanner in2 = new Scanner(System.in);
		player2 = in2.next();
		*/
	}

}
