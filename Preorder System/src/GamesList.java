import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class GamesList extends JFrame{
	Listener listen;
	
	JScrollPane scrollAction = new JScrollPane();
	JPanel panelActionFlow = new JPanel();
	JPanel panelActionGrid = new JPanel();
	JScrollPane scrollAdventure = new JScrollPane();
	JPanel panelAdventureFlow = new JPanel();
	JPanel panelAdventureGrid = new JPanel();
	JScrollPane scrollRolePlaying = new JScrollPane();
	JPanel panelRolePlayingFlow = new JPanel();
	JPanel panelRolePlayingGrid = new JPanel();
	JScrollPane scrollSimulation = new JScrollPane();
	JPanel panelSimulationFlow = new JPanel();
	JPanel panelSimulationGrid = new JPanel();
	JScrollPane scrollStrategy = new JScrollPane();
	JPanel panelStrategyFlow = new JPanel();
	JPanel panelStrategyGrid = new JPanel();
	JScrollPane scrollSports = new JScrollPane();
	JPanel panelSportsFlow = new JPanel();
	JPanel panelSportsGrid = new JPanel();
	JScrollPane scrollFighting = new JScrollPane();
	JPanel panelFightingFlow = new JPanel();
	JPanel panelFightingGrid = new JPanel();
	
	ArrayList <JButton>actionGames=new ArrayList<JButton>();
	ArrayList <JButton>adventureGames=new ArrayList<JButton>();
	ArrayList <JButton>roleplayingGames=new ArrayList<JButton>();
	ArrayList <JButton>simulationGames=new ArrayList<JButton>();
	ArrayList <JButton>strategyGames=new ArrayList<JButton>();
	ArrayList <JButton>sportsGames=new ArrayList<JButton>();
	ArrayList <JButton>fightingGames=new ArrayList<JButton>();
	
	File file;
	FileReader fRead;
	Scanner scan;
	int index;
	ArrayList arr=new ArrayList();
	GamesView gview;
	
	
	
	public GamesList() {
		listen= new Listener();
		
		scrollAction.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollAction.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollAction.setViewportView(panelActionFlow);
		panelActionFlow.add(panelActionGrid);
		panelActionGrid.setLayout(new GridLayout(0, 3, 50, 50));
		
		actionGames=new ArrayList<JButton>();
		file=new File("gameslist/actiongames.txt");
		try {
			fRead=new FileReader(file);
			scan=new Scanner(fRead);
			JButton game;
			while(scan.hasNext()) {
				game=new JButton();
				game.setName(scan.next());
				actionGames.add(game);
			}
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}
	arr=new ArrayList();
		file=new File("gameslist/actiongamesicon.txt");
		try {
			fRead=new FileReader(file);
			scan=new Scanner(fRead);
			String ico;
			while(scan.hasNext()) {
				ico=scan.next();
				ico=ico.replaceAll("@", " ");
				arr.add(ico);
			}
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}
		index=0;
		for(final JButton btn:actionGames) {
			btn.setIcon(new ImageIcon(arr.get(index)+""));
			panelActionGrid.add(btn);
			if(btn.getActionListeners().length==0)	btn.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					gview=new GamesView();
					gview.setView(btn.getName(), btn.getIcon());
					
				}
			});
			index++;
		}
	
		
		
		scrollAdventure.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollAdventure.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollAdventure.setViewportView(panelAdventureFlow);
		panelAdventureFlow.add(panelAdventureGrid);
		panelAdventureGrid.setLayout(new GridLayout(0, 3, 50, 50));
		
		
		adventureGames=new ArrayList<JButton>();
		file=new File("gameslist/adventuregames.txt");
		try {
			fRead=new FileReader(file);
			scan=new Scanner(fRead);
			JButton game;
			while(scan.hasNext()) {
				game=new JButton();
				game.setName(scan.next());
				adventureGames.add(game);
			}
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}
		arr=new ArrayList();
		file=new File("gameslist/adventuregamesicon.txt");
		try {
			fRead=new FileReader(file);
			scan=new Scanner(fRead);

			String ico;
			while(scan.hasNext()) {
				ico=scan.next();
				ico=ico.replaceAll("@", " ");
				arr.add(ico);
			}
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}
		index=0;
		for(final JButton btn:adventureGames) {
			btn.setIcon(new ImageIcon(arr.get(index)+""));
			panelAdventureGrid.add(btn);
			if(btn.getActionListeners().length==0)	btn.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					gview=new GamesView();
					gview.setView(btn.getName(), btn.getIcon());
					
				}
			});
			index++;
		}
		
		
		scrollRolePlaying.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollRolePlaying.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollRolePlaying.setViewportView(panelRolePlayingFlow);
		panelRolePlayingFlow.add(panelRolePlayingGrid);
		panelRolePlayingGrid.setLayout(new GridLayout(0, 3, 50, 50));
		
		
		roleplayingGames=new ArrayList<JButton>();
		file=new File("gameslist/roleplayinggames.txt");
		try {
			fRead=new FileReader(file);
			scan=new Scanner(fRead);
			JButton game;
			while(scan.hasNext()) {
				game=new JButton();
				game.setName(scan.next());
				roleplayingGames.add(game);
			}
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}
		arr=new ArrayList();
		file=new File("gameslist/roleplayinggamesicon.txt");
		try {
			fRead=new FileReader(file);
			scan=new Scanner(fRead);

			String ico;
			while(scan.hasNext()) {
				ico=scan.next();
				ico=ico.replaceAll("@", " ");
				arr.add(ico);
			}
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}
		index=0;
		for(final JButton btn:roleplayingGames) {
			btn.setIcon(new ImageIcon(arr.get(index)+""));
			panelRolePlayingGrid.add(btn);
			if(btn.getActionListeners().length==0)	btn.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					gview=new GamesView();
					gview.setView(btn.getName(), btn.getIcon());
					
				}
			});
			index++;
		}
		
		
		scrollSimulation.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollSimulation.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollSimulation.setViewportView(panelSimulationFlow);
		panelSimulationFlow.add(panelSimulationGrid);
		panelSimulationGrid.setLayout(new GridLayout(0, 3, 50, 50));
		
		
		simulationGames=new ArrayList<JButton>();
		file=new File("gameslist/simulationgames.txt");
		try {
			fRead=new FileReader(file);
			scan=new Scanner(fRead);
			JButton game;
			while(scan.hasNext()) {
				game=new JButton();
				game.setName(scan.next());
				simulationGames.add(game);
			}
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}
		arr=new ArrayList();
		file=new File("gameslist/simulationgamesicon.txt");
		try {
			fRead=new FileReader(file);
			scan=new Scanner(fRead);

			String ico;
			while(scan.hasNext()) {
				ico=scan.next();
				ico=ico.replaceAll("@", " ");
				arr.add(ico);
			}
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}
		index=0;
		for(final JButton btn:simulationGames) {
			btn.setIcon(new ImageIcon(arr.get(index)+""));
			panelSimulationGrid.add(btn);
			if(btn.getActionListeners().length==0)	btn.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					gview=new GamesView();
					gview.setView(btn.getName(), btn.getIcon());
					
				}
			});
			index++;
		}
		
		
		scrollStrategy.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollStrategy.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollStrategy.setViewportView(panelStrategyFlow);
		panelStrategyFlow.add(panelStrategyGrid);
		panelStrategyGrid.setLayout(new GridLayout(0, 3, 50, 50));
		
		
		strategyGames=new ArrayList<JButton>();
		file=new File("gameslist/strategygames.txt");
		try {
			fRead=new FileReader(file);
			scan=new Scanner(fRead);
			JButton game;
			while(scan.hasNext()) {
				game=new JButton();
				game.setName(scan.next());
				strategyGames.add(game);
			}
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}
		arr=new ArrayList();
		file=new File("gameslist/strategygamesicon.txt");
		try {
			fRead=new FileReader(file);
			scan=new Scanner(fRead);

			String ico;
			while(scan.hasNext()) {
				ico=scan.next();
				ico=ico.replaceAll("@", " ");
				arr.add(ico);
			}
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}
		index=0;
		for(final JButton btn:strategyGames) {
			btn.setIcon(new ImageIcon(arr.get(index)+""));
			panelStrategyGrid.add(btn);
			if(btn.getActionListeners().length==0)	btn.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					gview=new GamesView();
					gview.setView(btn.getName(), btn.getIcon());
					
				}
			});
			index++;
		}
		

		scrollSports.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollSports.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollSports.setViewportView(panelSportsFlow);
		panelSportsFlow.add(panelSportsGrid);
		panelSportsGrid.setLayout(new GridLayout(0, 3, 50, 50));
		
		
		sportsGames=new ArrayList<JButton>();
		file=new File("gameslist/sportsgames.txt");
		try {
			fRead=new FileReader(file);
			scan=new Scanner(fRead);
			JButton game;
			while(scan.hasNext()) {
				game=new JButton();
				game.setName(scan.next());
				sportsGames.add(game);
			}
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}
		arr=new ArrayList();
		file=new File("gameslist/sportsgamesicon.txt");
		try {
			fRead=new FileReader(file);
			scan=new Scanner(fRead);
	
			String ico;
			while(scan.hasNext()) {
				ico=scan.next();
				ico=ico.replaceAll("@", " ");
				arr.add(ico);
			}
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}
		index=0;
		for(final JButton btn:sportsGames) {
			btn.setIcon(new ImageIcon(arr.get(index)+""));
			panelSportsGrid.add(btn);
			if(btn.getActionListeners().length==0)	btn.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					gview=new GamesView();
					gview.setView(btn.getName(), btn.getIcon());
					
				}
			});
			index++;
		}
		
		
		scrollFighting.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollFighting.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollFighting.setViewportView(panelFightingFlow);
		panelFightingFlow.add(panelFightingGrid);
		panelFightingGrid.setLayout(new GridLayout(0, 3, 50, 50));
		
		
		fightingGames=new ArrayList<JButton>();
		file=new File("gameslist/fightinggames.txt");
		try {
			fRead=new FileReader(file);
			scan=new Scanner(fRead);
			JButton game;
			while(scan.hasNext()) {
				game=new JButton();
				game.setName(scan.next());
				fightingGames.add(game);
			}
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}
		arr=new ArrayList();
		file=new File("gameslist/fightinggamesicon.txt");
		try {
			fRead=new FileReader(file);
			scan=new Scanner(fRead);

			String ico;
			while(scan.hasNext()) {
				ico=scan.next();
				ico=ico.replaceAll("@", " ");
				arr.add(ico);
			}
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}
		index=0;
		for(final JButton btn:fightingGames) {
			btn.setIcon(new ImageIcon(arr.get(index)+""));
			panelFightingGrid.add(btn);
			if(btn.getActionListeners().length==0)	btn.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					gview=new GamesView();
					gview.setView(btn.getName(), btn.getIcon());
					
				}
			});
			index++;
		}
		
	}
}
