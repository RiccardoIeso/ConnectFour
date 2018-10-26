package forza4;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
public class F4win {

	private JFrame frame;

	public F4win(String arg, F4Gui obj) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("CONNECT FOUR");
		
		JLabel lblNewLabel = new JLabel(arg);
		lblNewLabel.setFont(new Font("Z003", Font.BOLD, 27));
		lblNewLabel.setBounds(126, 76, 193, 78);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnStartNewMatch = new JButton("Start New Match");
		btnStartNewMatch.addActionListener(e->{
				obj.frame_en(true);
				obj.SetVisF(false);
				F4controller window = new F4controller();
				window.SetVisF(true);
				frame.setVisible(false);
				frame.dispose();
			}
		);
		btnStartNewMatch.setBounds(118, 166, 201, 25);
		frame.getContentPane().add(btnStartNewMatch);
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.addActionListener(e->{ 
			obj.SetVisF(false);
			frame.setVisible(false);
			frame.dispose();
			System.exit(0);
		}
		);
		btnNewButton.setBounds(118, 215, 201, 25);
		frame.getContentPane().add(btnNewButton);
	}
	
	public void SetVisF(boolean v) {
		this.frame.setVisible(v);
	}
}
