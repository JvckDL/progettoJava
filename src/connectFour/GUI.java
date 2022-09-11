package connectFour;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

import javax.swing.*;

public class GUI extends JFrame implements ActionListener{
	
	int ROWS = 7;
	int COLUMNS = 6;
	int WINDOWWIDTH = 616;
	int WINDOWHEIGHT = 760;

	
	private String IMGEMPTYFILENAME = "images/empty.png";
	private String IMGREDFILENAME = "images/red.jpeg";
	private String IMGYELLOWFILENAME = "images/yellow.jpeg";
	private String IMGBACKGROUND = "images/sfondo.jpeg";
	
	private ImageIcon iconBackground = null;
	private ImageIcon iconEmpty = null;
	private ImageIcon iconRed = null;
	private ImageIcon iconYellow = null;
	
	private String TITLE = "Connect Four - ";
	
	private Container cp;
	
	protected JMenuItem aboutItem;
	protected JMenuItem loadItem;
	protected JMenuItem saveItem;
	protected JMenuItem exitItem;

	
	private final String player1 = StartingWindow.namePla1;
	
	private String player2 = StartingWindow.namePla2;
	
	private ConnectLogic game;
	
	private Board board;
	
	
	public GUI(){
		/**
		 * creates the game GUI
		 */
		game = new ConnectLogic(player1, player2);
		
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
		exitItem.addActionListener(this);
		saveItem.addActionListener(this);
		
		
		this.setJMenuBar(menuBar);
		
		//setting up images
		URL imgURLIcon = getClass().getClassLoader().getResource(IMGBACKGROUND);
		if (imgURLIcon != null) {
			iconBackground = new ImageIcon(imgURLIcon);
		} else {
			System.err.println("Couldn't find file" + IMGBACKGROUND);
		}
		
		URL imgURL = getClass().getClassLoader().getResource(IMGEMPTYFILENAME);
		if (imgURL != null) {
			iconEmpty = new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file" + IMGEMPTYFILENAME);
		}
		//RED
		imgURL = getClass().getClassLoader().getResource(IMGREDFILENAME);
		if (imgURL != null) {
			iconRed = new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file" + IMGREDFILENAME);
		}
		//YELLOW
		imgURL = getClass().getClassLoader().getResource(IMGYELLOWFILENAME);
		if (imgURL != null) {
			iconYellow = new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file" + IMGYELLOWFILENAME);
		}
		
		cp = getContentPane();
		cp.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
		
		//creating button array grid
		for (int row = 0; row < ROWS; row ++) {
			for (int col = 0; col < COLUMNS; col ++) {
				JButton button = new JButton();
				button.setIcon(iconEmpty);
				button.setPreferredSize(new Dimension(100, 100));
				button.setName(Integer.toString(row * 10 + col));



				button.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
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
			setTitle(TITLE + player2 + ": Yellow");
		}else {
			setTitle(TITLE + player1 + ": Red");
		}


		setSize(WINDOWWIDTH, WINDOWHEIGHT);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		

		boolean playersTurn = game.getPlayer1Turn();
		if(!playersTurn) {

			setTitle(TITLE + player2+ ": Yellow");
		}else{
			setTitle(TITLE + player1+": Red");
		}
	}
	//updating image on button
	/**
	 * Updates the checkers on the button
	 * @param button
	 */
	private void updateOnButton(JButton button) {
		int row10plusCol = Integer.parseInt(button.getName());
		int col = row10plusCol % 10;
		String winnerPlayer;
		

		boolean playersTurn = game.getPlayer1Turn();
		if(playersTurn) {
			setTitle(TITLE + player2 + ": Yellow");
		}else{
			setTitle(TITLE + player1 + ": Red");
		}

		int addedRow = game.round(col);
		
		if(addedRow != -1) {
			

			JButton buttonToUpdate = ((JButton)(cp.getComponent(COLUMNS * addedRow + col)));
			
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
			getToolkit().beep();
			JOptionPane.showMessageDialog(null, "Please enter a valid position", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==saveItem) { 
			if (JOptionPane.showOptionDialog(this, "Click yes to save and close the game.\nPress no to return to the game", "Save Game", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null) == JOptionPane.YES_OPTION) {
				this.dispose();
			} else {
			
			}
			saveGameActionPerformed(e);
		
		}
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
	
	private void saveGameActionPerformed(java.awt.event.ActionEvent evt) {
        String toSave = "";
        int[][] grid = null;
        for (int k = 0; k < COLUMNS; k++) {
			for (int i = 0; i < grid[0][COLUMNS]; i++) {
                toSave += grid[k][i];
            }
        }
        
        // prova
        String s = JOptionPane.showInputDialog(null,"Enter the file name you want to save as");
        
        BufferedWriter writer = null;
		try {
            writer = new BufferedWriter(new FileWriter(s+".txt"));
            writer.write(toSave);
        } catch (IOException e) {
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
            }
        }
        
     
    }

}
