package forza4;

public class InteractivePlayer implements Player {
	
	private String  name;
	private int id_p;
	//Costruttore
	public InteractivePlayer(String nome, int id) {
		this.name = nome;
		this.id_p=id;
	}
	@Override
	public int getId() {
		return id_p;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public int move() {
		return 0;
	}
}