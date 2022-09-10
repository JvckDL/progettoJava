package connectFour;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;

import javax.swing.*;

public class GUI extends JFrame implements ActionListener {
	
	int rows = 7;
	int columns = 6;
	int windowWidth = 616;
	int windowHeight = 760;
	
	private Container cp;
	
	private String imgEmptyFileName = "images/empty.png";
	private String imgRedFileName = "images/red.jpeg";
	private String imgYellowName = "images/yellow.jpeg";
	private String imgBackGround = "images/sfondo.jpeg";
	
	private ImageIcon iconBackground = null;
	private ImageIcon iconEmpty = null;
	private ImageIcon iconRed = null;
	private ImageIcon iconYellow = null;
	
	protected JMenuItem aboutItem;
	protected JMenuItem loadItem;
	protected JMenuItem saveItem;
	protected JMenuItem exitItem;
	
	private String title = "Connect Four - ";
	
	private final String player1 = StartingWindow.NamePla1;
	
	private String player2 = StartingWindow.NamePla2;
	
	private ConnectLogic game;
	
	
	public GUI(){
		/*		
		loadItem = new JMenuItem("Load");
		saveItem = new JMenuItem("Save");
		exitItem = new JMenuItem("Exit");
		
		aboutItem = new JMenuItem("About");
		

		menuBar.add(gameSettings);
		menuBar.add(help);
		gameSettings.add(loadItem);
		gameSettings.add(saveItem);
		gameSettings.add(exitItem);
		help.add(aboutItem);
		
		loadItem.addActionListener(this);
		saveItem.addActionListener(this);
		exitItem.addActionListener(this);
		aboutItem.addActionListener(this);
		*/
		
		game = new ConnectLogic(player1, player2);
		//game.startGame();
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.menu);
		menuBar.setForeground(new Color(255, 255, 255));
		JMenu help = new JMenu("Help");
		JMenu gameSettings = new JMenu("Game Settings");
		aboutItem = new JMenuItem("About");
		loadItem = new JMenuItem("Load");
		saveItem = new JMenuItem("Save");
		exitItem = new JMenuItem("Exit");
		
		menuBar.add(gameSettings);
		menuBar.add(help);
		gameSettings.add(loadItem);
		gameSettings.add(saveItem);
		gameSettings.add(exitItem);
		help.add(aboutItem);
		
		
		aboutItem.addActionListener(this);
		
		
		this.setJMenuBar(menuBar);
		
		URL imgURLIcon = getClass().getClassLoader().getResource(imgBackGround);
		if (imgURLIcon != null) {
			iconBackground = new ImageIcon(imgURLIcon);
		} else {
			System.err.println("Couldn't find file" + imgBackGround);
		}
		
		URL imgURL = getClass().getClassLoader().getResource(imgEmptyFileName);
		if (imgURL != null) {
			iconEmpty = new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file" + imgEmptyFileName);
		}
		//RED
		imgURL = getClass().getClassLoader().getResource(imgRedFileName);
		if (imgURL != null) {
			iconRed = new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file" + imgRedFileName);
		}
		//YELLOW
		imgURL = getClass().getClassLoader().getResource(imgYellowName);
		if (imgURL != null) {
			iconYellow = new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file" + imgYellowName);
		}
		
		cp = getContentPane();
		cp.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
		
		for (int row = 0; row < rows; row ++) {
			for (int col = 0; col < columns; col ++) {
				JButton button = new JButton();
				button.setIcon(iconEmpty);
				button.setPreferredSize(new Dimension(100, 100));
				button.setName(Integer.toString(row * 10 + col));


				//button.setText("row: " + row + " col: " + col);
				button.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						//System.out.println(((JButton) (e.getSource())).getText());
						updateOnButton(((JButton)(e.getSource())));
						
					}
				});
				cp.add(button);
			}
		}

		
		
		
		setIconImage(new ImageIcon(imgURLIcon).getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		boolean player1turn = game.getPlayer1Turn();
		if(!player1turn) {
			setTitle(title + player2 + ": Yellow");
		}else {
			setTitle(title + player1 + ": Red");
		}


		setSize(windowWidth, windowHeight);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		

		
		
		/*boolean playersTurn = game.getPlayer1Turn();
		if(!playersTurn) {
*/
		boolean playersTurn = game.getPlayer1Turn();
		if(!playersTurn) {

			setTitle(title + player2+ ": Yellow");
		}else{
			setTitle(title + player1+": Red");
		}
		
		updater();
		}
	//}
	
	private void updateOnButton(JButton button) {
		int row10plusCol = Integer.parseInt(button.getName());
		int col = row10plusCol % 10;
		String winnerPlayer;
		
		/*
		boolean player1turn = game.getPlayer1Turn();
		if(player1turn) {
			//setTitle(title + player1);
			setTitle(title + "Yellow");
		}else {
			setTitle(title + "Red");
		}
		*/
		boolean playersTurn = game.getPlayer1Turn();
		if(playersTurn) {
			setTitle(title + player2 + ": Yellow");
		}else{
			//setTitle(title + player2);
			setTitle(title + player1 + ": Red");
		}

		int addedRow = game.round(col);
		
		if(addedRow != 0) {
			

			JButton buttonToUpdate = ((JButton)(cp.getComponent(columns * addedRow + col)));
			if(game.getPlayer1Turn()) {
				buttonToUpdate.setIcon(iconYellow);
			}else {
				buttonToUpdate.setIcon(iconRed);
			}
			if(game.checkWinnerGUI(col)) {
				if(playersTurn == false) {
					winnerPlayer = player2;
				}else {
					winnerPlayer = player1;
				}
				int input = JOptionPane.showOptionDialog(null, winnerPlayer + " has won! Do you want to play again?", "GAME ENDED", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
				if(input == JOptionPane.OK_OPTION)
				{
					this.dispose();
					Main.main(null);
				}else {
					System.exit(0);
				}
			}
		}else {
			JOptionPane.showMessageDialog(null, "Please enter a valid position", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	
	
	public void updater() {
		cp.getComponent(1);
	}
	
	/*
	public void actionPerformed( ActionEvent e ) {
    	if(e.getSource()==aboutItem) {
			JOptionPane.showMessageDialog(null, "Connect4 Game: v.1.0 \nMade by: JvckDL & MattiaGio", "About", JOptionPane.INFORMATION_MESSAGE);
		}
    	if(e.getSource()==exitItem) {
			if (JOptionPane.showOptionDialog(this, "You will exit the game without saving\nDo you want to continue?", "Exit", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null) == JOptionPane.YES_OPTION) {
				this.dispose();
			} else {
			
			}	
    	}
	}*/


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==aboutItem) {
			JOptionPane.showMessageDialog(null, "Connect4 Game: v.1.0 \nMade by: JvckDL & MattiaGio", "About", JOptionPane.INFORMATION_MESSAGE);
		}
    	if(e.getSource()==exitItem) {
			if (JOptionPane.showOptionDialog(this, "You will exit the game without saving\nDo you want to continue?", "Exit", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null) == JOptionPane.YES_OPTION) {
				this.dispose();
			} else {
			
			}	
		
	}

}
