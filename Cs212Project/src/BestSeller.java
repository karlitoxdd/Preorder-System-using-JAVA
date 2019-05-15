import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Vector;
import javax.swing.ImageIcon;

public class BestSeller extends JFrame{
	private JTable table;
	private JTable table_Top;
	JScrollPane scrollPaneGames;
	JLabel lblTopSeller;
	JScrollPane scrollPaneTop;
	DefaultTableCellRenderer rendar;
	 DefaultTableCellRenderer render;
	

	public BestSeller() {
		
		scrollPaneGames = new JScrollPane();
		scrollPaneGames.setBounds(79, 78, 353, 193);
		getContentPane().add(scrollPaneGames);
		
		try {
			
			File top=new File("bestseller.txt");
			FileReader fRead=new FileReader(top);
			Scanner scan=new Scanner(fRead);
			Vector column=new Vector();
			Vector row=new Vector();
			DefaultTableModel model_Top=new DefaultTableModel();
		
			column.add("Game Name");
			column.add("Total sold");
			model_Top.setColumnIdentifiers(column);
			String game,sold;
			while(scan.hasNext()) {
				row=new Vector();
				game=scan.next();
				sold=scan.next();
				row.add(game);
				row.add(sold);
				model_Top.addRow(row);
			}
			
			table=new JTable(model_Top);
			scrollPaneGames.setViewportView(table);

			table.setAutoCreateRowSorter(true);
			TableRowSorter<DefaultTableModel> rowSorter = (TableRowSorter<DefaultTableModel>)table.getRowSorter();
			rowSorter.setComparator(1, new Comparator<String>() {

			        @Override
			        public int compare(String o1, String o2)
			        {
			            return Integer.parseInt(o1) - Integer.parseInt(o2);
			        }

			    });
			table.getRowSorter().toggleSortOrder(1);
			table.getRowSorter().toggleSortOrder(1);
		
			
			scan.close();
			fRead.close();
			
			
		} catch (IOException e) {
			System.out.print(e.getMessage());
		}
		getContentPane().setLayout(null);
		
		
		lblTopSeller = new JLabel("");
		lblTopSeller.setIcon(new ImageIcon("images/topseller.jpg"));
		lblTopSeller.setBounds(0, 0, 432, 79);
		lblTopSeller.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblTopSeller);
		
	
		
		scrollPaneTop = new JScrollPane();
		scrollPaneTop.setBounds(0, 78, 78, 194);
		getContentPane().add(scrollPaneTop);
		
		table_Top = new JTable();
		table_Top.setModel(new DefaultTableModel(
			new Object[][] {
				{"1"},
				{"2"},
				{"3"},
				{"4"},
				{"5"},
				{"6"},
				{"7"},
				{"8"},
				{"9"},
				{"10"},
			},
			new String[] {
				"Top"
			}
		));
		scrollPaneTop.setViewportView(table_Top);
		
		rendar = new DefaultTableCellRenderer();
	    rendar.setHorizontalAlignment(JLabel.CENTER);
	   table.getColumnModel().getColumn(1).setCellRenderer(rendar); 
	   
	   render = new DefaultTableCellRenderer();
	    render.setHorizontalAlignment(JLabel.CENTER);
	   table_Top.getColumnModel().getColumn(0).setCellRenderer(render); 
	   scrollPaneGames.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		
		setBounds(0,0,450,307);
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
