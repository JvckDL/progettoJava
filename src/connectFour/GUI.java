package connectFour;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;

import javax.swing.*;

public class GUI extends JFrame {
	
	int rows = 7;
	int columns = 6;
	int windowWidth = 650;
	int windowHeight = 775;
	
	private Container cp;
	private String imgEmptyFileName = "images/empty.png";
	private String imgRedFileName = "images/red.png";
	private String imgYellowName = "images/yellow.png";
	
	private ImageIcon iconEmpty = null;
	private ImageIcon iconRed = null;
	private ImageIcon iconYellow = null;
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new GUI();
			}
		});
		
	}
	
	private void updateOnButton(JButton button) {
		int row10plusCol = Integer.parseInt(button.getName());
		int row = row10plusCol / 10;
		int col = row10plusCol % 10;
		
		button.setIcon(iconRed);
	}
	
	
	public GUI() {
		
		URL imgURL = getClass().getClassLoader().getResource(imgEmptyFileName);
		if (imgURL != null) {
			iconEmpty = new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file" + imgEmptyFileName);
		}
		imgURL = getClass().getClassLoader().getResource(imgEmptyFileName);
		if (imgURL != null) {
			iconRed = new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file" + imgRedFileName);
		}
		
		cp = getContentPane();
		cp.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		for (int row = 0; row < rows; row ++) {
			for (int col = 0; col < columns; col ++) {
				JButton button = new JButton();
				button.setIcon(iconEmpty);
				button.setPreferredSize(new Dimension(100, 100));
				button.setName(Integer.toString(row + 10 + col));
				button.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						updateOnButton(((JButton)(e.getSource())));
					}
				});
				cp.add(button);
			}
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Connect4");
		setLocationRelativeTo(null);
		setSize(windowWidth, windowHeight);
		setVisible(true);
		
		updater();
	}
	
	public void updater() {
		cp.getComponent(1);
	}

}
