import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

public class AddGames extends JFrame{
	private JTextField txtGameName;
	String loc="";
	JButton btnOpen;
	JLabel lblGameName;
	JButton btnCancel;
	JLabel lblGenre;
	JComboBox comboBox;
	JButton btnAdd;
	JTextArea txtImage;
	
	
	public AddGames() {
		getContentPane().setLayout(null);
		
		txtImage = new JTextArea("<-- Image Location");
		txtImage.setEditable(false);
		txtImage.setLineWrap(true);
		txtImage.setBounds(94, 102, 232, 58);
		getContentPane().add(txtImage);
		
		
		btnOpen = new JButton("");
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				fc.showOpenDialog(btnOpen);
				loc="";
				try {
				 loc=fc.getSelectedFile()+"";
				   	txtImage.setText(loc);
				}catch(Exception em) {
					
				}
			}
		});
		
		btnOpen.setBounds(49, 102, 33, 58);
		getContentPane().add(btnOpen);
		
		lblGameName = new JLabel("Game Name:");
		lblGameName.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblGameName.setBounds(49, 58, 130, 31);
		getContentPane().add(lblGameName);
		
		txtGameName = new JTextField();
		txtGameName.setBounds(191, 64, 135, 22);
		getContentPane().add(txtGameName);
		txtGameName.setColumns(10);
		
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new AdminWindow();
			}
		});
		btnCancel.setBounds(201, 190, 97, 25);
		getContentPane().add(btnCancel);
		
		lblGenre = new JLabel("Genre:");
		lblGenre.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblGenre.setBounds(49, 24, 130, 31);
		getContentPane().add(lblGenre);
		
		comboBox = new JComboBox();
		comboBox.setBounds(191, 29, 135, 22);
		File genreFile=new File("gameslist/genre.txt");
		FileReader genreReader;
		try {
			genreReader = new FileReader(genreFile);
			Scanner genreScan=new Scanner(genreReader);
			while(genreScan.hasNext()) {
				comboBox.addItem(genreScan.next());
			}
			
			genreScan.close();
		
		} catch (FileNotFoundException ea) {
			System.out.println(ea.getMessage());
		}
	
		getContentPane().add(comboBox);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File filegame=new File("gameslist/"+comboBox.getSelectedItem()+"games.txt");
				File fileicon=new File("gameslist/"+comboBox.getSelectedItem()+"gamesicon.txt");
				try {
					
					String games="";
					String gamename=txtGameName.getText();
					gamename=gamename.replaceAll("\\s", "");
					games=games+gamename+" ";
					FileWriter gameWriter=new FileWriter(filegame,true);
					gameWriter.write(games);
					gameWriter.flush();
					gameWriter.close();
					
					
					String icons="";
					loc=loc.replaceAll("\\s", "@");
					loc=loc.replaceAll("\\\\","/");
					icons=icons+loc+" ";
					FileWriter iconWriter=new FileWriter(fileicon,true);
					iconWriter.write(icons);
					iconWriter.flush();
					iconWriter.close();
					JOptionPane.showMessageDialog(null, gamename+" is added to the Library!");
					dispose();
					new AdminWindow();
					
				} catch (Exception e1) {
					
					System.out.print(e1.getMessage());
				}
			}
		});
		btnAdd.setBounds(82, 190, 97, 25);
		getContentPane().add(btnAdd);
		
		
		setBounds(0,0,400,300);
		setVisible(true);
		setLocationRelativeTo(null);
	}
}
