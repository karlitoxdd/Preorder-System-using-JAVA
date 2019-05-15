import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class UpdateUser extends JFrame{
	static JTextField txtSearch = new JTextField();
	UpdateTable up;
	JLabel lblSearch = new JLabel("Search:");
	FileWriter fWrite;
	File acc;
	JButton btnBack;

	
	public UpdateUser() {
		setBounds(0,0,800,500);
		getContentPane().setLayout(null);
		
		getContentPane().add(new UpdateTable()).setBounds(12, 13, 758, 369);
		
		btnBack = new JButton("Back to Menu");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new AdminWindow();
			}
		});
		btnBack.setBounds(642, 395, 128, 45);
		getContentPane().add(btnBack);
		
		
		lblSearch.setBounds(12, 409, 56, 16);
		getContentPane().add(lblSearch);
		txtSearch.setBounds(62, 402, 270, 31);
		getContentPane().add(txtSearch);
		txtSearch.setColumns(10);
		
		setVisible(true);
		setLocationRelativeTo(null);
	}
}
