package forza4;

public class Matrice {
	private static final int DEFAULT_COL = 7;
	private static final int DEFAULT_ROW = 6;
	private int num_disk=0;
	//Creazione matrice
	public final Disk[][] field;
	
	public Matrice(){
		this.field= new Disk[DEFAULT_ROW][DEFAULT_COL];
	}
	//Inserimento del disco nella colonna
	public boolean insertDisk(Disk d, int col) {
		int ind;
		ind = this.checkGravity(col);
		if(ind!=0) {
			field[ind-1][col] = d;
			num_disk++;
			return true;
		}
		return false;
	}
	//getter elemento matrice
	public Disk getElem(int r, int c) {
		return field[r][c];
	}
	//metodo per controllo inserimento di un disco nella matrice
	private int checkGravity(int col) {
		for (int i=0; i<DEFAULT_ROW; i++){
			 if(this.field[i][col]!=null) {
				return i;
			}
			
		}
		return DEFAULT_ROW;			//Nel caso non si possa inserire
	}
	//getter del numero dei dischi
	public int getNumD(){
		return num_disk;
	}
}
