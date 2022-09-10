package connectFour;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;



public class StartingWindow implements ActionListener{

	protected JFrame frmConnect;
	protected JTextField NamePlayer1;
	protected JTextField NamePlayer2;
	protected static String NamePla1;
	protected static String NamePla2;
	protected JButton StartGameBtn;
	protected JMenuItem aboutItem;
	
	
	private String imgBackGround = "images/sfondo.jpeg";
	
	private ImageIcon iconBackground = null;
	
	/**
	 * Create the application.
	 */
	public StartingWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmConnect = new JFrame();
		frmConnect.setBackground(SystemColor.text);
		//frmConnect.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Eclipse\\Workspace\\Connect4\\img\\sfondo.jpeg"));
		frmConnect.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\matti\\git\\progettoJava\\src\\images\\sfondo.jpeg"));
		//frmConnect.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\paffo\\git\\Connect4\\Connect4\\img\\sfondo.jpeg"));
		frmConnect.setTitle("Connect4");
		frmConnect.setBounds(100, 100, 560, 706);
		frmConnect.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConnect.getContentPane().setLayout(null);
		frmConnect.setLocationRelativeTo( null );
		frmConnect.setBackground(Color.YELLOW);
		

		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		JButton loadGameButton = new JButton("Load Game");
		loadGameButton.setBounds(294, 489, 122, 45);
		panel.add(loadGameButton);
		loadGameButton.setFocusable(false);
		
		StartGameBtn = new JButton("New Game");
		StartGameBtn.setBounds(136, 489, 122, 45);
		panel.add(StartGameBtn);
		StartGameBtn.setFocusable(false);
		StartGameBtn.addActionListener(this);
		
		JLabel Player1Label = new JLabel("Player 1:");
		Player1Label.setBounds(173, 145, 59, 14);
		panel.add(Player1Label);
		Player1Label.setFont(new Font("Tahoma", Font.BOLD, 13));
		Player1Label.setForeground(new Color(255, 0, 0));
		
				
				
		JLabel Player2Label = new JLabel("Player 2:");
		Player2Label.setBounds(173, 193, 59, 14);
		panel.add(Player2Label);
		Player2Label.setForeground(new Color(255, 255, 0));
		Player2Label.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		NamePlayer1 = new JTextField();
		NamePlayer1.setBounds(242, 143, 139, 20);
		panel.add(NamePlayer1);
		NamePlayer1.setColumns(10);
		
		
		NamePlayer2 = new JTextField();
		NamePlayer2.setBounds(242, 191, 139, 20);
		panel.add(NamePlayer2);
		NamePlayer2.setColumns(10);
		
		
		
		URL imgURL = getClass().getClassLoader().getResource(imgBackGround);
		if (imgURL != null) {
			iconBackground = new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file" + imgBackGround);
		}
		
		//JLabel label = new JLabel(new ImageIcon("D:\\\\Eclipse\\\\Workspace\\\\Connect4\\\\img\\\\sfondo.jpeg"));
		JLabel label = new JLabel(new ImageIcon("C:\\Users\\matti\\git\\progettoJava\\src\\images\\sfondo.jpeg"));
		//JLabel label = new JLabel(new ImageIcon("C:\\Users\\paffo\\git\\Connect4\\Connect4\\img\\sfondo.jpeg"));
		label.setBounds(0, 0, 544, 644);
		panel.add(label);
		panel.setBounds(0, 0, 544, 644);
		frmConnect.getContentPane().add(panel);
		
		
		//menu bar
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.menu);
		menuBar.setForeground(new Color(255, 255, 255));
		JMenu help = new JMenu("Help");
		aboutItem = new JMenuItem("About");
		
		menuBar.add(help);
		help.add(aboutItem);
		
		
		aboutItem.addActionListener(this);
		
		
		frmConnect.setJMenuBar(menuBar);
		
	}
	
	
	public String getNamePla2() {
		return NamePla2;
	}
	
	public String getNamePla1() {
		return NamePla1;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		NamePla1 = NamePlayer1.getText();
		
		NamePla2 = NamePlayer2.getText();
		
		if(e.getSource()==aboutItem) {
			JOptionPane.showMessageDialog(null, "Connect4 Game: v.1.0 \nMade by: JvckDL & MattiaGio", "About", JOptionPane.INFORMATION_MESSAGE);
		}
		
		if(e.getSource()==StartGameBtn) {
			
			GUI myGUI = new GUI();
			frmConnect.dispose();
		}
		
	}
}
