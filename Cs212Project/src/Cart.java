import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Cart extends JFrame{
	JLabel name = new JLabel(MainMenu.user);
	JPanel TopRight = new JPanel();
	JButton btnBack = new JButton("Back to Main Menu");
	private final JButton btnUpdateAccount = new JButton("Update Account");
	private final JComboBox comboBox = new JComboBox();
	
	
public Cart() {
	
	getContentPane().setLayout(null);
	setBounds(0,0,565,133);
	name.setVerticalAlignment(SwingConstants.TOP);
	
	name.setFont(new Font("Agency FB", Font.BOLD, 40));
	name.setBounds(25, 0, 270, 56);
	getContentPane().add(name);
	
	TopRight.setBounds(292, 13, 270, 56);
	getContentPane().add(TopRight);
	
	TopRight.add(MainMenu.lblBalance);
	btnUpdateAccount.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String[] what= {"Name","Username","Password","Contact Number","Address","E-mail","Age","Gender"};
			String option="",newvalue="";
			option=(String) JOptionPane.showInputDialog(null,"Choose what to edit","Update account information",1,null,what,what[0]);
		File acco=new File("account.txt");
		try {
			FileReader accReader=new FileReader(acco);
			Scanner accScan=new Scanner(accReader);
			String all="",na,us,pa,da,co,ad,em,ag,ge;
			while(accScan.hasNext()) {
				na=accScan.next();
				us=accScan.next();
				pa=accScan.next();
				da=accScan.next();
				co=accScan.next();
				ad=accScan.next();
				em=accScan.next();
				ag=accScan.next();
				ge=accScan.next();
				if(MainMenu.user.equals(us)) {
					switch(option) { 
					case "Name": newvalue=JOptionPane.showInputDialog("Current "+option+": "+na);all=all+newvalue+" "+us+" "+pa+" "+da+" "+co+" "+ad+" "+em+" "+ag+" "+ge+"\n";break;
					case "Username": newvalue=JOptionPane.showInputDialog("Current "+option+": "+us);all=all+na+" "+newvalue+" "+pa+" "+da+" "+co+" "+ad+" "+em+" "+ag+" "+ge+"\n";break;
					case "Password": newvalue=JOptionPane.showInputDialog("Current "+option+": "+pa);all=all+na+" "+us+" "+newvalue+" "+da+" "+co+" "+ad+" "+em+" "+ag+" "+ge+"\n";break;
					case "Contact Number": newvalue=JOptionPane.showInputDialog("Current "+option+": "+co);all=all+na+" "+us+" "+pa+" "+da+" "+newvalue+" "+ad+" "+em+" "+ag+" "+ge+"\n";break;
					case "Address": newvalue=JOptionPane.showInputDialog("Current "+option+": "+ad);all=all+na+" "+us+" "+pa+" "+da+" "+co+" "+newvalue+" "+em+" "+ag+" "+ge+"\n";break;
					case "E-mail": newvalue=JOptionPane.showInputDialog("Current "+option+": "+em);all=all+na+" "+us+" "+pa+" "+da+" "+co+" "+ad+" "+newvalue+" "+ag+" "+ge+"\n";break;
					case "Age": newvalue=JOptionPane.showInputDialog("Current "+option+": "+ag);all=all+na+" "+us+" "+pa+" "+da+" "+co+" "+ad+" "+em+" "+newvalue+" "+ge+"\n";break;
					case "Gender": newvalue=JOptionPane.showInputDialog("Current "+option+": "+ge);all=all+na+" "+us+" "+pa+" "+da+" "+co+" "+ad+" "+em+" "+ag+" "+newvalue+"\n";break;
					default:all=na+" "+us+" "+pa+" "+da+" "+co+" "+ad+" "+em+" "+ag+" "+ge+"\n";break;
					}
					
				}else {
					all=all+na+" "+us+" "+pa+" "+da+" "+co+" "+ad+" "+em+" "+ag+" "+ge+"\n";
				}
			}
			FileWriter accoWrite=new FileWriter(acco);
			accoWrite.write(all);
			accoWrite.flush();
			accoWrite.close();
			JOptionPane.showMessageDialog(null, "Your account has been successfully updated!");
		} catch (Exception e1) {
			System.out.print(e1.getMessage());
		}
			
		}
	});
	
	TopRight.add(btnUpdateAccount);
	
	
	btnBack.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			dispose();
			new MainMenu();

		}
	});
	btnBack.setBounds(398, 82, 155, 31);
	getContentPane().add(btnBack);
	comboBox.setBounds(12, 83, 189, 29);
	
	File codes=new File("sales/sales.txt");
	try {
		FileReader codesReader=new FileReader(codes);
		Scanner codesScan=new Scanner(codesReader);
		String first,second,third;
		while (codesScan.hasNext()) {
			first=codesScan.next();
			second=codesScan.next();
			third=codesScan.next();
			comboBox.addItem(second);
		}
	} catch (FileNotFoundException e1) {
		System.out.print(e1.getMessage());
	}
	
	getContentPane().add(comboBox);
	
	JButton btnViewPurchases = new JButton("View Purchases");
	btnViewPurchases.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			new ViewPurchases(comboBox.getSelectedItem().toString());
		}
	});
	btnViewPurchases.setBounds(213, 85, 123, 25);
	getContentPane().add(btnViewPurchases);
	
	setUndecorated(true);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	setVisible(true);
}
}
