import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GamesView extends JFrame implements ActionListener{
	Labels label = new Labels();
	JPanel panelPurchase = new JPanel();
	JLabel lblIcon = new JLabel("");
	JLabel lblGame = new JLabel("");
	JSpinner spinner = new JSpinner();
	JButton btnPurchase = new JButton("Purchase");
	JButton btnCancel = new JButton("Cancel");
	
	public void setView(String nam,Icon ico) {
		lblIcon.setIcon(ico);
		lblGame.setText(nam);
	}
	
	
	public GamesView() {
	
		setSize(390, 246);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		getContentPane().add(panelPurchase);
		
		panelPurchase.setBounds(12, 13, 351, 174);
		panelPurchase.setLayout(null);
		
		btnCancel.setBounds(227, 121, 100, 25);
		lblIcon.setBounds(0, 0, 132, 174);
		btnPurchase.setBounds(227, 66, 100, 39);
		lblGame.setBounds(133, 0, 218, 39);
		spinner.setBounds(154, 66, 51, 80);
		
		lblGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblGame.setFont(new Font("Arial Black", Font.BOLD, 20));
		spinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnPurchase.addActionListener(this);
		
		panelPurchase.add(btnCancel);
		panelPurchase.add(lblIcon);
		panelPurchase.add(lblGame);
		panelPurchase.add(spinner);
		panelPurchase.add(btnPurchase);
		
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	
	public void actionPerformed(ActionEvent e) {
		new Purchase(lblGame.getText(),(int) spinner.getValue());
		dispose();
	}
	
	

}
