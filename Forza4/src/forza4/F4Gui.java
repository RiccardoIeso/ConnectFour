package forza4;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JTextPane;

public class F4Gui {
	private InteractivePlayer P1, P2;
	private InteractiveMatch m;
	private ComputerPlayer CP;
	private Matrice mat;
	private static final String yellow= "yellow.png",red =  "red.png",empty = "null.png";
	private JFrame frame= new JFrame();
	private JTextPane TextP = new JTextPane();
	private JButton[] btn;
	private JPanel panel;

	public F4Gui(String Nome1, String Nome2) {
		this.P1 = new InteractivePlayer(Nome1,1);
		this.P2 = new InteractivePlayer(Nome2,2);
		this.m = new InteractiveMatch(P1,P2);
		btn = new JButton[7];
		initialize();
	}
	
	public F4Gui(String Nome) {
		this.P1 = new InteractivePlayer(Nome, 1);
		this.CP = new ComputerPlayer("Computer",2);
		this.m=new InteractiveMatch(P1,CP);
		btn = new JButton[7];
		initialize();
	}
	
	private void PanelDisplay() {
		mat = m.getMatrix();
		for(int i=0; i<6;i++) {
			for(int k=0;k<7;k++) {
				Disk D=mat.getElem(i, k);
				if(D==null) {
					ImageIcon icon = new ImageIcon(empty); 
					JLabel lab= new JLabel(icon);
					panel.add(lab);
				}
				else if(D.getPlayer()==1)
				{
					ImageIcon icon = new ImageIcon(red); 
					JLabel lab= new JLabel(icon);
					panel.add(lab);
				}
				else {
					ImageIcon icon = new ImageIcon(yellow); 
					JLabel lab= new JLabel(icon);
					panel.add(lab);
				}
			}
		}
		TurnSetterText();	
	}
	
	private void initialize() {
		F4WhoStart w = new F4WhoStart(m.getCurrentPlayer().getName());
		w.setVisF(true);
		frame = new JFrame();
		frame.setBounds(500, 500, 660, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("CONNECT FOUR");
		
		panel = new JPanel();		
		panel.setBounds(12, 82, 630, 540);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(6, 7, 0, 0));
		PanelDisplay();
		
		for(int i=0;i<btn.length;i++) {
			btn[i]=new JButton(Integer.toString(i+1));
			btn[i].setBounds(12+(i*92), 45, 80, 25);
			frame.getContentPane().add(btn[i]);
		}
		TextP.setEditable(false);
		TextP.setBounds(12, 15, 538, 21);
		frame.getContentPane().add(TextP);
		TurnSetterText();
	}	

	private void updatePanel() {
		panel.removeAll();
		PanelDisplay();
		panel.revalidate();
	}
	
	private void ActionList() {
		btn[0].addActionListener(e -> onClick(0));
		btn[1].addActionListener(e -> onClick(1));
		btn[2].addActionListener(e -> onClick(2));
		btn[3].addActionListener(e -> onClick(3));
		btn[4].addActionListener(e -> onClick(4));
		btn[5].addActionListener(e -> onClick(5));
		btn[6].addActionListener(e -> onClick(6));
	}
	public void play() {
	ActionList();
	}
	
	public Player getPlayer1() {
	return this.P1;
	}
	
	public Player getPlayer2() {
	return this.P2;
	}
	
	private void win_() {
		int id=m.checkWin();
		if(id!=0){
			if(id==P1.getId())
				winFrame(P1.getName()+" WIN");
			else if(P2!=null)
				winFrame(P2.getName()+" WIN");
			else
				winFrame(CP.getName()+" WIN");
		}
	}
	
	private void TurnSetterText() {
		Player P = m.getCurrentPlayer();
		if(P.equals(P1)) {
			TextP.setText("TURN -> "+P1.getName());
		}
		else if(P.equals(P2)){
			TextP.setText("TURN ->"+P2.getName());
		}
		else {
			TextP.setText("");
		}			
	}
	
	private void onClick(int col) {
		m.getIns(col);
		Check();
		if(CP!=null) {
			m.getIns(CP.move());
			Check();
		}
	}
	public void Check() {
		updatePanel();
		TurnSetterText();
		win_();
		Full();
	}
	@SuppressWarnings("deprecation")
	public void frame_en(boolean v){
		frame.enable(v);
		}
	private void winFrame(String str){
		
		F4win window = new F4win(str,this);
		window.SetVisF(true);
		frame_en(false);
	}
	public void SetVisF(boolean v) {
		this.frame.setVisible(v);
	}
	private void Full() {
		if( m.isFull())
			winFrame("BALANCE");
	}
}