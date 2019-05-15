import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddCredit extends JFrame implements ItemListener{
	File acc=new File("wallet.txt");
	FileReader fRead;
	Scanner scan;
	JLabel lblselectedBal = new JLabel("");
	JLabel lblselectedUser = new JLabel("");
	String wallet[]= {"10","50","100","250","500","1000","5000","10000"};
	JComboBox comboBox;
	JLabel lblSelectUser;
	JPanel panel_View;
	JLabel lblUsername;
	JLabel lblCurrentBalance;
	JButton btnAddCredits;
	JButton btnBack;
	
	
	public AddCredit()  {
		setBounds(0,0,500,350);
		JPanel panel_Select = new JPanel();
		getContentPane().add(panel_Select, BorderLayout.NORTH);
		
		comboBox = new JComboBox();
		
		
		try {
			fRead=new FileReader(acc);
			scan=new Scanner(fRead);
			String un,wal;
			while(scan.hasNext()) {
				un=scan.next();
				wal=scan.next();
				comboBox.addItem(un);
			}
			
			lblSelectUser = new JLabel("Select User: ");
			panel_Select.add(lblSelectUser);
			panel_Select.add(comboBox);
		} catch (FileNotFoundException e) {
			System.out.print(e.getMessage());
		}
		
		
		panel_View = new JPanel();
		getContentPane().add(panel_View, BorderLayout.CENTER);
		panel_View.setLayout(null);
		
		lblUsername = new JLabel("Username:");
		lblUsername.setHorizontalAlignment(SwingConstants.TRAILING);
		lblUsername.setFont(new Font("Arial", Font.PLAIN, 15));
		lblUsername.setBounds(146, 48, 91, 33);
		panel_View.add(lblUsername);
		
		lblCurrentBalance = new JLabel("Current Balance:");
		lblCurrentBalance.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCurrentBalance.setFont(new Font("Arial", Font.PLAIN, 15));
		lblCurrentBalance.setBounds(102, 104, 135, 33);
		panel_View.add(lblCurrentBalance);
		
		
		lblselectedUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblselectedUser.setFont(new Font("Arial", Font.BOLD, 15));
		lblselectedUser.setBounds(255, 48, 135, 33);
		panel_View.add(lblselectedUser);
		
		
		lblselectedBal.setHorizontalAlignment(SwingConstants.CENTER);
		lblselectedBal.setFont(new Font("Arial", Font.BOLD, 15));
		lblselectedBal.setBounds(255, 104, 135, 33);
		panel_View.add(lblselectedBal);
		
		btnAddCredits = new JButton("Add Credit");
		btnAddCredits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num="0";
				try {
				num=JOptionPane.showInputDialog(null,"Select an Amount","Add Wallet",1,null,wallet,wallet[0]).toString();
				}catch(Exception em){
					
				}
				if(num.equals("0")) {
					
				}else {
				File change=new File("wallet.txt");
				FileReader balRead;
				try {
					balRead = new FileReader(change);
					Scanner balScan=new Scanner(balRead);
					String all="",un="",mon="";
					int newBal=0;
					while(balScan.hasNext()) {
						un=balScan.next();
						mon=balScan.next();
						if(un.equals(lblselectedUser.getText())) {
							newBal=Integer.parseInt(mon)+Integer.parseInt(num);
							all=all+un+" "+(newBal)+"\n";
						}else {
							all=all+un+" "+mon+"\n";
						}
					}
					FileWriter balWrite=new FileWriter(change);
					balWrite.write(all);
					lblselectedBal.setText(newBal+"");
					JOptionPane.showMessageDialog(null, "Credits are added to the Account");
					
					File rec=new File("walletrecord.txt");
					FileWriter recs=new FileWriter(rec,true);
					recs.write(new SimpleDateFormat ("MM/dd/yy").format(new Date( ))+" "+lblselectedUser.getText()+" "+num+"\n");
					
					recs.flush();
					recs.close();
					balScan.close();
					balRead.close();
					balWrite.flush();
					balWrite.close();
				} catch (IOException em) {
					System.out.print(em.getMessage());
				}
				
				}
			}
		});
		btnAddCredits.setBounds(122, 200, 128, 39);
		panel_View.add(btnAddCredits);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new AdminWindow();
			}
		});
		btnBack.setBounds(262, 200, 128, 39);
		panel_View.add(btnBack);
		
		comboBox.addItemListener(this);
		
		
		setVisible(true);
		setLocationRelativeTo(null);
		comboBox.setSelectedIndex(-1);
	}

	
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
	          Object item = e.getItem();
	          try {
	  			fRead=new FileReader(acc);
	  			scan=new Scanner(fRead);
	  			String un,wal;
	  			while(scan.hasNext()) {
	  				un=scan.next();
	  				wal=scan.next();
	  			if(item.equals(un)) {
	  				lblselectedUser.setText(un);
	  				lblselectedBal.setText(wal);
	  			}
	  			}
	  			
	  		
	  		} catch (FileNotFoundException ev) {
	  			System.out.print(ev.getMessage());
	  		}
	       }
		
	}
}
