import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.border.SoftBevelBorder;

public class MainMenu extends JFrame implements MouseListener{
	static JPanel panelWelcome = new JPanel();
	JLabel lblWelcome = new JLabel("Welcome");
	static JLabel  lblUser= new JLabel();
	JPanel panelCart = new JPanel();
	JButton btnCart = new JButton("Account");
	JPanel panelGenre = new JPanel();
	JButton btnAction = new JButton("Action");
	JButton btnAdventure = new JButton("Adventure");
	JButton btnRolePlaying = new JButton("Role-Playing");
	JButton btnSimulation = new JButton("Simulation");
	JButton btnStrategy = new JButton("Strategy");
	JButton btnSports = new JButton("Sports");
	JButton btnFighting = new JButton("Fighting Games");
	JLabel lblChooseYourGenre = new JLabel("Choose your Genre");
	JPanel panelView = new JPanel();
	JLabel lblStartup = new JLabel("");
	GamesList games=new GamesList();
	static String user;
	static int bal;
	static JLabel lblBalance;
	private final JLabel bestSeller = new JLabel("");
	private final JPanel panel = new JPanel();
	private final JLabel Close = new JLabel("");
	JLabel Back;

	
public MainMenu() {
	getContentPane().setBackground(Color.WHITE);

	
	setSize(1028, 600);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
	getContentPane().setLayout(null);
	panelWelcome.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	panelWelcome.setBackground(Color.WHITE);
	
	
	panelWelcome.setBounds(12, 60, 228, 80);
	getContentPane().add(panelWelcome);
	panelWelcome.setLayout(null);
	
	
	lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
	lblWelcome.setFont(new Font("Viner Hand ITC", Font.BOLD, 50));
	lblWelcome.setBounds(0, 0, 228, 51);
	panelWelcome.add(lblWelcome);
	
	
	 lblUser.setText(user);
	 lblUser.setBackground(Color.WHITE);
	lblUser.setHorizontalAlignment(SwingConstants.CENTER);
	lblUser.setBounds(0, 51, 228, 29);
	panelWelcome.add(lblUser);
	panelCart.setBackground(Color.WHITE);
	
	
	panelCart.setBounds(12, 153, 228, 36);
	getContentPane().add(panelCart);

	lblBalance=new JLabel();
	
	File wallet=new File("wallet.txt");
	try {
		FileReader fRead=new FileReader(wallet);
		Scanner scan=new Scanner(fRead);
		String use,wal;
		while(scan.hasNext()) {
			use=scan.next();
			wal=scan.next();
			if(use.equals(user)) {
				bal=Integer.parseInt(wal);
				lblBalance.setText("Balance: "+bal);
			}
		}
		scan.close();
	} catch (FileNotFoundException e1) {
		System.out.println(e1.getMessage());
	}
	panelCart.add(lblBalance);
	
	btnCart.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			new Cart();
			dispose();
		}
	});
	
	
	btnCart.setFont(new Font("Rockwell", Font.BOLD, 15));
	btnCart.setToolTipText("Go to Cart");
	panelCart.add(btnCart);
	panelGenre.setBackground(Color.WHITE);
	
	
	panelGenre.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	panelGenre.setBounds(12, 198, 228, 389);
	getContentPane().add(panelGenre);
	panelGenre.setLayout(null);
	
	
	lblChooseYourGenre.setHorizontalAlignment(SwingConstants.CENTER);
	lblChooseYourGenre.setBounds(12, 0, 204, 26);
	panelGenre.add(lblChooseYourGenre);
	panelView.setBackground(Color.WHITE);
	
	
	panelView.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	panelView.setBounds(252, 60, 766, 527);
	getContentPane().add(panelView);
	panelView.setLayout(new CardLayout(0, 0));
	
	
	lblStartup.setIcon(new ImageIcon("images/startup.png"));
	panelView.add(lblStartup);
	
	
	panelView.add(games.scrollAction);
	
	
	btnAction.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			btnAction.setEnabled(false);
			btnAdventure.setEnabled(true);
			btnRolePlaying.setEnabled(true);
			btnSimulation.setEnabled(true);
			btnStrategy.setEnabled(true);
			btnSports.setEnabled(true);
			btnFighting.setEnabled(true);
			panelView.removeAll();
			panelView.add(games.scrollAction);
			
			repaint();
			revalidate();
		
		}
	});
	btnAction.setBounds(12, 32, 204, 38);
	panelGenre.add(btnAction);
	

	btnAdventure.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			btnAdventure.setEnabled(false);
			btnAction.setEnabled(true);
			btnRolePlaying.setEnabled(true);
			btnSimulation.setEnabled(true);
			btnStrategy.setEnabled(true);
			btnSports.setEnabled(true);
			btnFighting.setEnabled(true);
			panelView.removeAll();
			panelView.add(games.scrollAdventure);
			repaint();
			revalidate();
		}
	});
	btnAdventure.setBounds(12, 83, 204, 38);
	panelGenre.add(btnAdventure);
	

	btnRolePlaying.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			btnRolePlaying.setEnabled(false);
			btnAction.setEnabled(true);
			btnAdventure.setEnabled(true);
			btnSimulation.setEnabled(true);
			btnStrategy.setEnabled(true);
			btnSports.setEnabled(true);
			btnFighting.setEnabled(true);
			panelView.removeAll();
			panelView.add(games.scrollRolePlaying);
			repaint();
			revalidate();
		}
	});
	btnRolePlaying.setBounds(12, 134, 204, 38);
	panelGenre.add(btnRolePlaying);
	

	btnSimulation.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			btnSimulation.setEnabled(false);
			btnAction.setEnabled(true);
			btnAdventure.setEnabled(true);
			btnRolePlaying.setEnabled(true);
			btnStrategy.setEnabled(true);
			btnSports.setEnabled(true);
			btnFighting.setEnabled(true);
			panelView.removeAll();
			panelView.add(games.scrollSimulation);
			repaint();
			revalidate();
		}
	});
	btnSimulation.setBounds(12, 185, 204, 38);
	panelGenre.add(btnSimulation);
	

	btnStrategy.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			btnStrategy.setEnabled(false);
			btnAction.setEnabled(true);
			btnAdventure.setEnabled(true);
			btnRolePlaying.setEnabled(true);
			btnSimulation.setEnabled(true);
			btnSports.setEnabled(true);
			btnFighting.setEnabled(true);
			panelView.removeAll();
			panelView.add(games.scrollStrategy);
			repaint();
			revalidate();
		}
	});
	btnStrategy.setBounds(12, 236, 204, 38);
	panelGenre.add(btnStrategy);
	

	btnSports.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			btnSports.setEnabled(false);
			btnAction.setEnabled(true);
			btnAdventure.setEnabled(true);
			btnRolePlaying.setEnabled(true);
			btnSimulation.setEnabled(true);
			btnStrategy.setEnabled(true);
			btnFighting.setEnabled(true);
			panelView.removeAll();
			panelView.add(games.scrollSports);
			repaint();
			revalidate();
		}
	});
	btnSports.setBounds(12, 287, 204, 38);
	panelGenre.add(btnSports);
	

	btnFighting.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			btnFighting.setEnabled(false);
			btnAction.setEnabled(true);
			btnAdventure.setEnabled(true);
			btnRolePlaying.setEnabled(true);
			btnSimulation.setEnabled(true);
			btnStrategy.setEnabled(true);
			btnSports.setEnabled(true);
			panelView.removeAll();
			panelView.add(games.scrollFighting);
			repaint();
			revalidate();
		}
	});
	btnFighting.setBounds(12, 338, 204, 38);
	panelGenre.add(btnFighting);
	
	btnAction.setFocusable(false);
	btnAdventure.setFocusable(false);
	btnCart.setFocusable(false);
	btnFighting.setFocusable(false);
	btnRolePlaying.setFocusable(false);
	btnSimulation.setFocusable(false);
	btnSports.setFocusable(false);
	btnStrategy.setFocusable(false);
	panel.setBackground(Color.WHITE);
	panel.setBounds(0, 0, 1028, 48);
	
	getContentPane().add(panel);
	panel.setOpaque(false);
	panel.setLayout(null);
	bestSeller.setIcon(new ImageIcon("images/bestseller.png"));
	bestSeller.setBounds(254, 0, 404, 48);
	panel.add(bestSeller);
	Close.setIcon(new ImageIcon("images/close.png"));
	Close.setBounds(980, 0, 48, 48);
	
	Close.addMouseListener(this);
	bestSeller.addMouseListener(this);
	panel.add(Close);
	
	Back = new JLabel("");
	Back.setIcon(new ImageIcon("images/back.png"));
	Back.setBounds(12, 0, 48, 48);
	Back.addMouseListener(this);
	panel.add(Back);
	
	bestSeller.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	Close.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	Back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	
	setUndecorated(true);
	setVisible(true);
}


public void mouseClicked(MouseEvent e) {
	if(e.getSource().equals(Close)) {
		 int reply = JOptionPane.showConfirmDialog(
		            null,
		            "Are you sure you want to exit?",
		            "Program is Terminating...",
		            JOptionPane.YES_NO_OPTION);

		        if(reply == JOptionPane.YES_OPTION){
		        	System.exit(0);
		        }
		       
		
	}else if(e.getSource().equals(bestSeller)) {
	
		new BestSeller();
	}else if(e.getSource().equals(Back)) {
		
		dispose();
		new Login();
	}
	
}
public void setUser(String na) {
	
	lblUser.setText(na);
}
public void mouseEntered(MouseEvent e) { }
public void mouseExited(MouseEvent e) { }
public void mousePressed(MouseEvent e) { }
public void mouseReleased(MouseEvent e) { }
}
