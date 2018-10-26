package forza4;
import java.util.Random;

public class ComputerPlayer implements Player {
	
	private String  name;
	private int id_p;
	
	public ComputerPlayer(String n, int id) {
		name=n;
		id_p=id;
	}
	@Override
	public int getId() {
		return id_p;
	}
	@Override
	public String getName() {
		return this.name;
	}
	@Override
	public void setName(String name) {
		this.name=name;
	}
	public int move(){
		Random rand = new Random();
		return rand.nextInt(7);
	}
}