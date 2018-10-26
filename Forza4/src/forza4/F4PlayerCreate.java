package forza4;


import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class F4PlayerCreate {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel err;

	public F4PlayerCreate() {
		initialize();
	}
	
	public F4PlayerCreate(int x) {
		initialize(x);
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("CONNECT FOUR");
		
		JLabel lblNewLabel = new JLabel("Define Players");
		lblNewLabel.setBounds(157, 0, 108, 27);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Player 1 name:");
		lblNewLabel_1.setBounds(157, 39, 119, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(157, 61, 114, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Player 2 name:");
		lblNewLabel_2.setBounds(157, 99, 119, 19);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(157, 119, 119, 19);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener( e -> onClick());
		btnStart.setBounds(157, 173, 117, 25);
		frame.getContentPane().add(btnStart);
		
		err= new JLabel("");
		err.setBounds(168, 226, 108, 15);
		frame.getContentPane().add(err);
		
	}
	
	public void initialize(int x) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("CONNECT FOUR");
		
		JLabel lblNewLabel = new JLabel("Define Player");
		lblNewLabel.setBounds(157, 0, 108, 27);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Player name:");
		lblNewLabel_1.setBounds(157, 39, 119, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(157, 61, 114, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(e -> onClick(1));
		btnStart.setBounds(157, 173, 117, 25);
		frame.getContentPane().add(btnStart);
		
		err= new JLabel("");
		err.setBounds(168, 226, 108, 15);
		frame.getContentPane().add(err);
	}
	
 	private void onClick() {
		String name1 = textField.getText();
		String name2 = textField_1.getText();
		if((!name1.isEmpty())&&(!name2.isEmpty())){
			F4Gui window = new F4Gui(name1, name2);
			window.play();
			window.SetVisF(true);
			frame.setVisible(false);
			frame.dispose();
		}
		else {
			err.setText("Inserire nomi players");
		}
	}
 	
 	private void onClick(int i) {
 		String name1 = textField.getText();
 		if(!name1.isEmpty()){
	 		F4Gui window = new F4Gui(name1);
	 		window.play();
			window.SetVisF(true);
			frame.setVisible(false);
			frame.dispose();
 		}
 		else {
 			err.setText("Inserire Nome");
 		}
 	}
	
	public void SetVisF(boolean v) {
		this.frame.setVisible(v);
	}
}
