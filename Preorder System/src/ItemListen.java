import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import javax.swing.JComboBox;

public class ItemListen implements ItemListener{
RemoveGames rem;
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			rem.comboBoxGameslist=new JComboBox();
			Object item = e.getItem();
			File file=new File("gameslist/"+item+"games.txt");
			FileReader genreReader;
			try {
				genreReader = new FileReader(file);
				Scanner genreScanner=new Scanner(genreReader);
				while(genreScanner.hasNext()) {
				rem.comboBoxGameslist.addItem(genreScanner.next());
				}
			} catch (FileNotFoundException e1) {
				System.out.print(e1.getMessage());
			}
			
		}
		
	}

}
