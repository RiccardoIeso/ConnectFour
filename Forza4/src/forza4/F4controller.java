package forza4;
import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Panel;
import javax.swing.JButton;

public class F4controller {

	private JFrame frame;
	private JLabel lblNewLabel;
	public F4controller() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		frame.setTitle("CONNECT FOUR");
		
		Panel panel = new Panel();
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("CONNECT FOUR");
		lblNewLabel.setBounds(155, 12, 152, 39);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Player vs Player");
		btnNewButton.addActionListener(e-> {
				F4PlayerCreate window = new F4PlayerCreate();
				window.SetVisF(true);
				frame.setVisible(false);
				frame.dispose();}
		);
		btnNewButton.setBounds(131, 76, 176, 25);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Player vs Computer");
		btnNewButton_1.addActionListener(e-> {
			F4PlayerCreate window = new F4PlayerCreate(1);
			window.SetVisF(true);
			frame.setVisible(false);
			frame.dispose();}
			);
		btnNewButton_1.setBounds(131, 138, 176, 25);
		panel.add(btnNewButton_1);
	}
	
	public void SetVisF(boolean v) {
		this.frame.setVisible(v);
	}
	
}