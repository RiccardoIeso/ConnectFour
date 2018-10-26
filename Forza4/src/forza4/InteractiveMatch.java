package forza4;

import java.util.Random;

public class InteractiveMatch implements Match {
	private final Player P1;
	private final Player P2;
	private Player Current_P;
	private final Matrice mat= new Matrice();
	//Costruttore
	public InteractiveMatch( Player P1, Player P2) {
		this.P1=P1;
		this.P2=P2;
		if(this.P2 instanceof ComputerPlayer) {
			this.Current_P=P1;
		}else {
			HeadOrTail();
		}
			
	}
	@Override
	public boolean getIns(int col) {	//Metodo inserimento nella matrice
		Disk d = new Disk(Current_P.getId());
		boolean ris = mat.insertDisk(d, col);
		if (ris)
			updateCurrentP();
		return ris;
	}
	
	private void updateCurrentP() {		//Aggiornamento giocatore corrente
		if(Current_P.equals(P1)) {
			Current_P=P2;
		}
		else
			Current_P=P1;
	}
	public int checkWin() {				//Controllo vincita
		int ris = 0;
		if(mat.getNumD()>6) {
			ris = this.checkAllColumns();
			if(ris!=0)
				return ris;
			ris = this.checkAllRows();
			if (ris!=0)
				return ris;
			ris = checkDiagonal();
			if (ris!=0)
				return ris;
		}
		
		return 0;
	}
	
	private int checkAllColumns(){		//Controllo fila 4 nelle colonna
		for(int i=0; i<7;i++) {
			int ris=this.checkColumn(i);
			if(ris!=0)
				return ris;
		}		
		return 0;
	}
	
	private int checkColumn(int col) {	//Controllo fila 4 in una singola colonna
		int lastID = 0;
		int count=0;
		for(int i=5;i>=0;i--){
			Disk D=mat.getElem(i, col);
			if(D==null)
				return 0;
			else {
				int id=D.getPlayer();
				if(id==lastID) {
					count++;
					if(count==4) {
						return id;
					}
				}
				else {
					lastID=id;
					count=1;
				}
			}
		}
		return 0;
	}
	
	private int checkAllRows() {		//Controllo fila 4 nelle righe
		for(int k=5; k>=0;k--) {
			int r=this.checkRow(k);
			if(r!=0)
				return r;
			}
		return 0;
	}
	
	private int checkRow(int r) {		//Controllo fila 4 in una riga
		int lastID = 0;
		int count = 0;
		for(int i=0;i<7;i++) {
			Disk D=mat.getElem(r, i);
			if(D!=null){
				int id=D.getPlayer();
				if(id==lastID) {
					count ++;
					if(count==4) {
						return id;
					}
				}
				else{
					lastID= id;
					count = 1;
				}
			}
			else{
				lastID=0;
				count = 0;
				}
			}
		
		
		return 0;
	}
	
	private int checkDiagonal() {		//Controllo diagonali [5,0][4,0][3,0]
		for(int rowS=5; rowS>2; rowS--) {
			int lastID=0;
			int count = 0;
			int c=0,r=0;
			for(r=rowS, c=0; r>=0 && c<7; r--,c++) {
				Disk D = mat.getElem(r, c);
				if (D!=null) {
					int id = D.getPlayer();
					if (id==lastID) {
						count ++;
						if(count==4)
							return id;
					 }
					else {
						lastID=id;
						count = 1;
					 	}
				 	}
				else {
					lastID=0;
					count=0;
				}
				}
		 	} 
		for(int colS = 1; colS<4; colS++) {	//Contorlo diagonali [5,1][5,2][5,3]
			int lastID=0;
			int count = 0;
			int c =0, r=0;
			for(r=5, c = colS; r>=0 && c<7; r --,c++) {
				Disk D = mat.getElem(r, c);
				if(D!=null) {
					int id = D.getPlayer();
					if (id == lastID) {
						count ++;
						if(count == 4)
							return id;
					}
					else {
						lastID=id;
						count = 1;
					}
				}
				else {
					lastID=0;
					count=0;
				}
			}
		}
		
		for(int colS=3; colS<7; colS++) {	//Controllo diagonali [5,3][5,4][5,5][5,6]
			int lastID=0;
			int count = 0;
			int c=0, r = 0;
			for(r=5, c = colS; r>=0 && c >=0; r--, c--) {
				Disk D = mat.getElem(r, c);
				if(D!=null) {
					int id = D.getPlayer();
					if(id == lastID) {
						count ++;
						if(count == 4)
							return id;
					}
					else {
						lastID=id;
						count = 1;
					}
				}
				else {
					lastID=0;
					count=0;
				}
			}
		}
		
		for(int rowS= 4; rowS>2;rowS--){	//Controllo diagonali [4,6][3,6]
			int lastID=0;
			int count = 0;
			int c=0, r=0;
			for(r=rowS, c= 6; r>2 && c>=0; r--, c--) {
				Disk D = mat.getElem(r, c);
				if(D!=null) {
					int id = D.getPlayer();
					if (id == lastID) {
						count ++;
						if(count == 4)
							return id;
						}
					else {
						lastID=id;
						count = 1;
					}
				}
				else {
					lastID=0;
					count=0;
				}
			}
		}
		
		return 0;
	}
	
	public Matrice getMatrix() {	//getter della matrice
		return this.mat;
	}

	public Player getCurrentPlayer() {
		return Current_P;
	}
	
	public boolean isFull() {
		if(mat.getNumD()==42)
			return true;
		return false;
	}
	
	public void HeadOrTail() {
		Random r = new Random();
		if(r.nextInt(2)+1==P1.getId()) {
			Current_P=P1;
		}
		else {
			Current_P=P2;
		}
	}
}
	