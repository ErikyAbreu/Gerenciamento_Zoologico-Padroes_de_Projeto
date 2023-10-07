package Zoologico;

public class Sala {
	private int numLocal;
	private int setor;
	
	public Sala() {
		this.numLocal = 00;
		this.setor = 00;
	}
	
	public Sala(int numLocal, int setor) {
		this.numLocal = numLocal;
		this.setor = setor;
	}


	public int getNumLocal() {
		return numLocal;
	}
	public void setNumLocal(int numLocal) {
		this.numLocal = numLocal;
	}
	public int getSetor() {
		return setor;
	}
	public void setSetor(int setor) {
		this.setor = setor;
	}
	
	public String infSetor() {
		if(setor == 1) {
			return "SETOR ADMINISTRATIVO.";
		}
		if(setor == 2) {
			return "CENTRO VETERINÁRIO.";
		}
		if(setor == 3) {
			return "SETOR DOS TERCEIRIZADOS.";
		}
		return null;
	}
	
	@Override
	public String toString() {
		return " SALA: " + numLocal + "\nSETOR: " + infSetor();
	}
}
