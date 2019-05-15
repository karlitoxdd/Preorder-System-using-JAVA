import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class RemoveGames extends JFrame{
	JComboBox comboBoxGenre = new JComboBox();
	static JComboBox comboBoxGameslist;
	ItemListen itemlisten;
	JLabel label = new JLabel("");
	DefaultComboBoxModel cboNewModel=new DefaultComboBoxModel();
	JButton btnCancel;
	JButton btnRemove;
	
	
	public RemoveGames() {
		getContentPane().setLayout(null);
		
		comboBoxGameslist = new JComboBox();
		comboBoxGameslist.setBounds(166, 71, 204, 35);
		getContentPane().add(comboBoxGameslist);
		comboBoxGameslist.setEditable(false);
		
	    comboBoxGameslist.setModel(cboNewModel);
		comboBoxGameslist.setSelectedIndex(-1);
		comboBoxGameslist.addItemListener(new ItemListener() {
			
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
				Object item=e.getItem();
				int index=comboBoxGameslist.getSelectedIndex()+1;
				File file=new File("gameslist/"+comboBoxGenre.getSelectedItem()+"gamesicon.txt");
				try {
					FileReader fRead=new FileReader(file);
					Scanner scan=new Scanner(fRead);
					String trash="";
					int count=0;
					while(scan.hasNext()) {
						count++;
						if(count==index) {
							String img=scan.next();
							img=img.replaceAll("@", " ");
							label.setIcon(new ImageIcon(img));
						}else {
							trash=scan.next();
						}
					}
				} catch (FileNotFoundException e1) {
					System.out.print(e1.getMessage());
				}
				}
			}
		});
		
		
		
		label = new JLabel("");
		label.setBounds(22, 28, 132, 174);
		getContentPane().add(label);
		
		comboBoxGenre = new JComboBox();
		
		comboBoxGenre.setEditable(true);
		comboBoxGenre.setBounds(166, 28, 204, 35);
		getContentPane().add(comboBoxGenre);
		File fileGenre=new File("gameslist/genre.txt");
		FileReader genreReader;
		try {
			genreReader = new FileReader(fileGenre);
			Scanner genreScanner=new Scanner(genreReader);
			while(genreScanner.hasNext()) {
				comboBoxGenre.addItem(genreScanner.next());
			}
		} catch (FileNotFoundException e1) {
			
			System.out.print(e1.getMessage());
		}
		comboBoxGenre.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e)
			{
				if (e.getStateChange() == ItemEvent.SELECTED) {
				comboBoxGameslist=new JComboBox();
				Object item = e.getItem();
				File file=new File("gameslist/"+item+"games.txt");
				FileReader genreReader;
				cboNewModel.removeAllElements();
				try {
					genreReader = new FileReader(file);
					Scanner genreScanner=new Scanner(genreReader);
					while(genreScanner.hasNext()) {
						cboNewModel.addElement(genreScanner.next());
					}
				    comboBoxGameslist.setModel(cboNewModel);
				} catch (FileNotFoundException e1) {
					
				}
				comboBoxGameslist.setEditable(true);
				comboBoxGameslist.setSelectedItem("-Select a Game-");
				comboBoxGameslist.setEditable(false);
			}
			}
		});
		comboBoxGenre.setSelectedItem("-Select a Genre-");
		comboBoxGenre.setEditable(false);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new AdminWindow();
			}
		});
		btnCancel.setBounds(218, 177, 97, 25);
		getContentPane().add(btnCancel);
		
		
		btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index=comboBoxGameslist.getSelectedIndex()+1;
				File filegames=new File("gameslist/"+comboBoxGenre.getSelectedItem()+"games.txt");
				File fileicon=new File("gameslist/"+comboBoxGenre.getSelectedItem()+"gamesicon.txt");
				try {
					FileReader frgames=new FileReader(filegames);
					Scanner scangames=new Scanner(frgames);
					
					String selectedgame="",allgames="";
					int count=0;
					while(scangames.hasNext()) {
						selectedgame=scangames.next();
						count++;
						if(count!=index) {
							allgames=allgames+selectedgame+" ";
						}
					}
					FileWriter fwgames=new FileWriter(filegames);
					fwgames.write(allgames);
					
					scangames.close();
					frgames.close();
					fwgames.flush();
					fwgames.close();
					
					
					
					
					FileReader fricon=new FileReader(fileicon);
					Scanner scanicon=new Scanner(fricon);
					String selectedicon="",allicons="";
					int count2=0;
					while(scanicon.hasNext()) {
						selectedicon=scanicon.next();
						count2++;
						if(count2!=index) {
							allicons=allicons+selectedicon+" ";
						}
					}
					FileWriter fwicons=new FileWriter(fileicon);
					fwicons.write(allicons);
					
					scanicon.close();
					fricon.close();
					fwicons.flush();
					fwicons.close();
					
					JOptionPane.showMessageDialog(null, "The game is removed from the library!");
					dispose();
					new AdminWindow();
					
				} catch (Exception ex) {
					
				}
				
			}
		});
		btnRemove.setBounds(218, 136, 97, 25);
		getContentPane().add(btnRemove);
		
		setTitle("Select a game to Remove");
		setBounds(0,0,400,300);
		setVisible(true);
		setLocationRelativeTo(null);
	}

}
