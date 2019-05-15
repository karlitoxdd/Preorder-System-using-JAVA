import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Login extends JFrame {
	 JTextField txtUser= new JTextField();
	 JPasswordField txtPass= new JPasswordField();
	 JTextField txtNewUser= new JTextField();
	 JTextField txtNewPass = new JTextField();
	 JTextField txtNewPass2 = new JTextField();
	JPanel panelTop = new JPanel();
	JPanel panelBot = new JPanel();
	JPanel panelLogin = new JPanel();
	JLabel lblLogo = new JLabel("");
	JLabel lblUser = new JLabel("Username");
	JLabel lblPass = new JLabel("Password");
	JButton btnSubmit = new JButton("Login");
	JButton btnExit = new JButton("Exit");
	JPanel panelRegister = new JPanel();
	JLabel lblNewUser = new JLabel("Username");
	JLabel lblNewPass = new JLabel("Password");
	JLabel lblNewPass2 = new JLabel("Repeat Password");
	JButton btnNewSubmit = new JButton("Submit");
	JButton btnCancel = new JButton("Cancel");
	JButton btnLogin = new JButton("Login");
	JButton btnRegister = new JButton("Register");
	JLabel lblNewName = new JLabel("Name");
	FileReader fRead;
	Scanner scan;
	File accounts=new File("account.txt");
	FileWriter fWrite;
	MainMenu menu;
	int balance;
	private JTextField txtNewName = new JTextField();
	private JLabel lblNewDate = new JLabel("Date Created");
	private JTextField txtNewDate = new JTextField();
	private JButton btnLeft = new JButton("<<");
	private JButton btnRight = new JButton(">>");
	private JPanel panelLeft = new JPanel();
	private JPanel panelRight = new JPanel();
	private JPanel panelNew = new JPanel();
	private JLabel lblContact = new JLabel("Contact#");
	private JLabel Age = new JLabel("Age");
	private JLabel lblGender = new JLabel("Gender");
	private JLabel lblAddress = new JLabel("Address");
	private JTextField txtContact = new JTextField();
	private JTextField txtAddress = new JTextField();
	private JTextField txtAge = new JTextField();
	private JTextField txtEmail;
	JComboBox cboGender;
	

public Login() {
	getContentPane().setBackground(Color.YELLOW);
	
	setSize(500, 350);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setTitle("DataBlitz Preordering Station");
	setResizable(false);
	getContentPane().setLayout(null);
	
	
	panelTop.setBackground(Color.YELLOW);
	panelTop.setBounds(0, 0, 500, 72);
	getContentPane().add(panelTop);
	panelTop.setLayout(null);
	
	
	panelBot.setBackground(Color.YELLOW);
	panelBot.setBounds(0, 72, 500, 278);
	getContentPane().add(panelBot);
	panelBot.setLayout(new CardLayout(0, 0));
	

	panelLogin.setBackground(Color.YELLOW);
	panelBot.add(panelLogin);
	panelLogin.setLayout(null);
	

	lblLogo.setIcon(new ImageIcon("images/datablitz.jpg"));
	lblLogo.setBounds(70, 0, 358, 107);
	panelLogin.add(lblLogo);
	
	
	lblUser.setBounds(157, 135, 68, 16);
	panelLogin.add(lblUser);
	
	
	lblPass.setBounds(157, 177, 68, 16);
	panelLogin.add(lblPass);
	
	
	txtUser.setBounds(237, 132, 116, 22);
	panelLogin.add(txtUser);
	txtUser.setColumns(10);
	
	
	btnSubmit.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			boolean f=false;
			if(txtUser.getText().equals("admin")&&txtPass.getText().equals("admin")) {
				
				JOptionPane.showMessageDialog(null, "Admin Login Successful!");	
				dispose();
				new AdminWindow();
				
			}else {
				try {
					String un="", pwd="",name="",date,cont,add,email,age,gender;
					fRead=new FileReader(accounts);
					scan=new Scanner(fRead);
					while(scan.hasNext()){
						name=scan.next();
						un=scan.next();
						pwd=scan.next();
						date=scan.next();
						cont=scan.next();
						add=scan.next();
						email=scan.next();
						age=scan.next();
						gender=scan.next();
						
						if(un.equals(txtUser.getText()) && pwd.equals(txtPass.getText())){
							f=true;
						}
						
					}
					fRead.close();
					scan.close();
				} catch (Exception g) {
					System.err.println("Error 105: isFound \n"+g.getMessage());
				}
				if(f==true) {
					JOptionPane.showMessageDialog(null, "Login Successful\n Welcome "+txtUser.getText()+"!");	
					menu.user="";
					menu.user=txtUser.getText();
					
					
					dispose();
					new MainMenu();
				}else {
					JOptionPane.showMessageDialog(null, "Incorrect Username and/or Password");
				}
			}
			
		}});
	
	btnSubmit.setBounds(139, 223, 97, 25);
	panelLogin.add(btnSubmit);
	
	
	btnExit.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	});
	btnExit.setBounds(275, 223, 97, 25);
	panelLogin.add(btnExit);
	
	
	panelRegister.setBackground(Color.YELLOW);
	panelBot.add(panelRegister);
	panelRegister.setLayout(null);
	
	
	panelNew.setBackground(Color.YELLOW);
	panelNew.setBounds(80, 0, 349, 154);
	panelRegister.add(panelNew);
	panelNew.setLayout(new CardLayout(0, 0));
	panelNew.add(panelLeft, "name_296032960532052");
	panelLeft.setBackground(Color.YELLOW);
	panelLeft.setLayout(null);
	lblNewDate.setBounds(34, 130, 96, 16);
	panelLeft.add(lblNewDate);
	lblNewDate.setHorizontalAlignment(SwingConstants.CENTER);
	txtNewDate.setBounds(163, 124, 116, 22);
	panelLeft.add(txtNewDate);
	txtNewDate.setEditable(false);
	txtNewDate.setColumns(10);
	
	txtNewDate.setText(new SimpleDateFormat ("MM/dd/yy").format(new Date( )));
	lblNewName.setBounds(58, 13, 66, 16);
	panelLeft.add(lblNewName);
	
	
	lblNewName.setHorizontalAlignment(SwingConstants.CENTER);
	txtNewName.setBounds(163, 10, 116, 22);
	panelLeft.add(txtNewName);
	
	
	txtNewName.setColumns(10);
	txtNewPass2.setBounds(163, 96, 116, 22);
	panelLeft.add(txtNewPass2);
	txtNewPass2.setColumns(10);
	lblNewPass2.setBounds(24, 101, 106, 16);
	panelLeft.add(lblNewPass2);
	txtNewPass.setBounds(163, 67, 116, 22);
	panelLeft.add(txtNewPass);
	txtNewPass.setColumns(10);
	lblNewPass.setHorizontalAlignment(SwingConstants.TRAILING);
	lblNewPass.setBounds(46, 72, 66, 16);
	panelLeft.add(lblNewPass);
	txtNewUser.setBounds(163, 38, 116, 22);
	panelLeft.add(txtNewUser);
	txtNewUser.setColumns(10);
	lblNewUser.setBounds(58, 42, 66, 16);
	panelLeft.add(lblNewUser);
	panelNew.add(panelRight, "name_296032971875880");
	panelRight.setLayout(null);
	panelRight.setBackground(Color.YELLOW);
	lblContact.setHorizontalAlignment(SwingConstants.CENTER);
	lblContact.setBounds(60, 13, 66, 16);
	
	panelRight.add(lblContact);
	Age.setBounds(93, 125, 41, 16);
	
	panelRight.add(Age);
	lblGender.setHorizontalAlignment(SwingConstants.TRAILING);
	lblGender.setBounds(60, 96, 66, 16);
	
	panelRight.add(lblGender);
	lblAddress.setBounds(70, 42, 56, 16);
	
	panelRight.add(lblAddress);
	txtContact.setColumns(10);
	txtContact.setBounds(165, 10, 116, 22);
	
	panelRight.add(txtContact);
	txtAddress.setColumns(10);
	txtAddress.setBounds(165, 39, 116, 22);
	
	panelRight.add(txtAddress);
	txtAge.setColumns(10);
	txtAge.setBounds(165, 124, 116, 22);
	
	panelRight.add(txtAge);
	
	cboGender = new JComboBox();
	cboGender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
	cboGender.setBounds(165, 95, 116, 19);
	panelRight.add(cboGender);
	
	JLabel lblEmail = new JLabel("E-mail");
	lblEmail.setBounds(80, 69, 46, 16);
	panelRight.add(lblEmail);
	
	txtEmail = new JTextField();
	txtEmail.setColumns(10);
	txtEmail.setBounds(165, 66, 116, 22);
	panelRight.add(txtEmail);
	txtNewUser.addKeyListener(new KeyAdapter() {
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode()==KeyEvent.VK_ENTER) btnNewSubmit.doClick();
		}
	});
	txtNewPass.addKeyListener(new KeyAdapter() {
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode()==KeyEvent.VK_ENTER) btnNewSubmit.doClick();
		}
	});
	txtNewPass2.addKeyListener(new KeyAdapter() {
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode()==KeyEvent.VK_ENTER) btnNewSubmit.doClick();
		}
	});
	txtNewName.addKeyListener(new KeyAdapter() {
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode()==KeyEvent.VK_ENTER) btnNewSubmit.doClick();
		}
	});
	btnLeft.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			btnLeft.setEnabled(false);
			btnRight.setEnabled(true);
			panelNew.removeAll();
			panelNew.add(panelLeft);
			repaint();
			revalidate();
		}
	});
	btnLeft.setBounds(165, 158, 77, 16);
	
	panelRegister.add(btnLeft);
	btnLeft.setEnabled(false);
	btnRight.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			btnLeft.setEnabled(true);
			btnRight.setEnabled(false);
			panelNew.removeAll();
			panelNew.add(panelRight);
			repaint();
			revalidate();
		}
	});
	btnRight.setBounds(264, 158, 77, 16);
	
	panelRegister.add(btnRight);
	
	
	btnNewSubmit.setBounds(199, 187, 97, 25);
	panelRegister.add(btnNewSubmit);
	
	
	btnCancel.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			panelBot.removeAll();
			panelBot.add(panelLogin);
			repaint();
			revalidate();
		}
	});
	btnCancel.setBounds(199, 225, 97, 25);
	panelRegister.add(btnCancel);
	
	
	btnLogin.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			panelBot.removeAll();
			panelBot.add(panelLogin);
			repaint();
			revalidate();
		}
	});
	btnLogin.setBounds(12, 13, 221, 46);
	panelTop.add(btnLogin);
	

	btnRegister.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			panelBot.removeAll();
			panelBot.add(panelRegister);
			repaint();
			revalidate();
		}
	});
	btnRegister.setBounds(267, 13, 221, 46);
	panelTop.add(btnRegister);
	

	txtPass.addKeyListener(new KeyAdapter() {
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode()==KeyEvent.VK_ENTER) btnSubmit.doClick();
		}
	});
	txtPass.setBounds(237, 174, 116, 22);
	panelLogin.add(txtPass);
	
	txtUser.addKeyListener(new KeyAdapter() {
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode()==KeyEvent.VK_ENTER) btnSubmit.doClick();
		}
	});
	
	
	
	btnNewSubmit.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(txtNewName.getText().equals("")||txtNewUser.getText().equals("")||txtNewPass.getText().equals("")||txtNewPass2.getText().equals("")||txtContact.getText().equals("")||txtAddress.getText().equals("")||txtEmail.getText().equals("")||txtAge.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "The input fields are blanks!\nPlease enter a value.");
			}
			else if(txtNewPass.getText().equals(txtNewPass2.getText())) {
			
			try {
				fWrite=new FileWriter(accounts,true);
				fWrite.write(txtNewName.getText()+" "+txtNewUser.getText()+" "+txtNewPass.getText()+" "+txtNewDate.getText()+" "+txtContact.getText()+" "+txtAddress.getText()+" "+txtEmail.getText()+" "+txtAge.getText()+" "+cboGender.getSelectedItem()+" "+"\n");
				fWrite.flush();
				fWrite.close();
				
				File wallet=new File("wallet.txt");
				FileWriter walWrite=new FileWriter(wallet,true);
				walWrite.write(txtNewUser.getText()+" 0\n");
				walWrite.flush();
				walWrite.close();
				
				JOptionPane.showMessageDialog(null, "Account successfully created!");
				panelBot.removeAll();
				panelBot.add(panelLogin);
				repaint();
				revalidate();
				
			} catch (Exception e1) {
				System.err.println("Error 101: storeToFile \n"+e1.getMessage());
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Error! Retype the password");
		}
	}});
	
	
	btnLogin.setFocusable(false);
	btnRegister.setFocusable(false);
	btnSubmit.setFocusable(false);
	btnExit.setFocusable(false);
	btnNewSubmit.setFocusable(false);
	btnCancel.setFocusable(false);
	btnLeft.setFocusable(false);
	btnRight.setFocusable(false);
	
	btnLogin.setMnemonic('l');
	btnRegister.setMnemonic('r');
	
	setUndecorated(true);
	setLocationRelativeTo(null);
	setVisible(true);
	
	txtUser.grabFocus();
}
}
