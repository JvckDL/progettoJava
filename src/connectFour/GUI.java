package connectFour;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;

import javax.swing.*;

public class GUI extends JFrame {
	
	int rows = 7;
	int columns = 6;
	//int width = 100;
	//int height = 100;
	
	private String imgEmptyFileName = "images/empty.png";
	private String imgRedFileName = "images/red.png";
	private String imgYellowName = "images/yellow.png";
	
	public GUI() {
		ImageIcon iconEmpty = null;
		ImageIcon iconRed = null;
		ImageIcon iconYellow = null;
		
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
		
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		for (int row = 0; row < rows; row ++) {
			for (int col = 0; col < columns; col ++) {
				JButton button = new JButton();
				button.setIcon(iconEmpty);
				button.setPreferredSize(new Dimension(100,100));
				cp.add(button);
			}
		}
	}

}
