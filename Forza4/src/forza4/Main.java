package forza4;

import java.awt.EventQueue;

public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
						F4controller window = new F4controller();
						window.SetVisF(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}); 
	}

}
