import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class AdminWindow extends JFrame{
	JPanel panel;
	JButton btnUpdate;
	JButton btnAddCredit;
	JButton btnAddGames;
	JButton btnRemoveGames;
	JButton btnReturn;
	JButton btnViewTransactions;
	private JButton btnSetPrice;
	private JButton btnViewWalletRecords;
	
	public AdminWindow() {
		getContentPane().setLayout(null);
		
		setTitle("Admin Menu");
		setBounds(0,0,454,600);
		panel = new JPanel();
		panel.setBounds(12, 13, 412, 527);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(8, 0, 0, 5));
		
		btnUpdate = new JButton("View User Account Info");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new UpdateUser();
			}
		});
		
		btnViewTransactions = new JButton("View Sales");
		btnViewTransactions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new ViewSales();
			}
		});
		panel.add(btnViewTransactions);
		panel.add(btnUpdate);
		
		btnAddCredit = new JButton("Add Credit to User's Wallet");
		btnAddCredit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new AddCredit();
			}
		});
		panel.add(btnAddCredit);
		
		btnAddGames = new JButton("Add Games");
		btnAddGames.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new AddGames();
			}
		});
		
		btnSetPrice = new JButton("Set Pre-order Price");
		btnSetPrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File price=new File("price.txt");
				FileReader fRead;
				
				try {
					
					fRead = new FileReader(price);
					Scanner scan=new Scanner(fRead);
					
					
					String newPrice="",oldPrice="";
					while(scan.hasNext()) {
					oldPrice=scan.next();
					}
					
					newPrice=JOptionPane.showInputDialog("Current Pre-order Price: "+oldPrice);
					
					FileWriter fWrite=new FileWriter(price);
					if(newPrice!=null)
					fWrite.write(newPrice);
					else fWrite.write(oldPrice);
					
					fWrite.flush();
					fWrite.close();
					
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
				}
				
				
			}
		});
		panel.add(btnSetPrice);
		panel.add(btnAddGames);
		
		btnRemoveGames = new JButton("Remove Games");
		btnRemoveGames.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new RemoveGames();
			}
		});
		panel.add(btnRemoveGames);
		
		btnReturn = new JButton("Return to Login Screen");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new Login();
			}
		});
		
		btnViewWalletRecords = new JButton("View Wallet Records");
		btnViewWalletRecords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				new ViewWalletRecords();
			}
		});
		panel.add(btnViewWalletRecords);
		panel.add(btnReturn);
		
		btnViewTransactions.setFocusable(false);
		btnAddCredit.setFocusable(false);
		btnAddGames.setFocusable(false);
		btnRemoveGames.setFocusable(false);
		btnUpdate.setFocusable(false);
		btnReturn.setFocusable(false);
		btnSetPrice.setFocusable(false);
		btnViewWalletRecords.setFocusable(false);
		
		setVisible(true);
		setLocationRelativeTo(null);
	}
}
