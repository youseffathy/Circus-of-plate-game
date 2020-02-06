package view;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class MainMenu extends JFrame {
	/**
	 * 
	 */
	@Override
	public void setBounds(int x, int y, int width, int height) {
		// TODO Auto-generated method stub
		super.setBounds(500, 200, 400, 400);
	}

	private static final long serialVersionUID = 1L;
	private String[] difficulties = new String[] { "amateur", "semipro", "professional", "legendary"};
	private JComboBox<String> box = new JComboBox<String>(difficulties);
	private JButton start = new JButton("start");

	public MainMenu() {
		
		JLabel jLabel = new JLabel(new ImageIcon(MainMenu.class.getResource("/res/menu.jpg")), JLabel.CENTER);
		jLabel.setBounds(0, 0, 400, 298);
		JPanel Panel = new JPanel();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 200);
		Panel.add(jLabel);
		Panel.add(box);
		Panel.add(start);
		this.getContentPane().add(Panel);
	}
	public void addStartListener(ActionListener actionListener) {
		start.addActionListener(actionListener);
	}
	public String getSelectedDifficulty() {
		return box.getSelectedItem().toString();
	}
	
}
