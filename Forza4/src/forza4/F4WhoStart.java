package forza4;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class F4WhoStart {

	private JFrame frame;
	JLabel lblNewLabel;
	public F4WhoStart(String name) {
		initialize( name);
	}

	private void initialize(String name) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("CONNECT FOUR");
		
		JButton btnNewButton = new JButton(name + " Start");
		btnNewButton.addActionListener(e-> {frame.setVisible(false);
											frame.dispose();});
		btnNewButton.setBounds(164, 199, 117, 25);
		frame.getContentPane().add(btnNewButton);
		
		lblNewLabel = new JLabel();
		lblNewLabel.setBounds(164, 39, 117, 108);
		ImageIcon imageIcon = new ImageIcon("moneta.gif");
		lblNewLabel.setIcon(imageIcon);
		frame.getContentPane().add(lblNewLabel);
		
	}
	
	public void setVisF(boolean v) {
		frame.setVisible(v);
	}
}
