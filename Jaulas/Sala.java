package Jaulas;

public class Sala {
	private int setor;
	
	public Sala() {
		this.setor = 00;
	}
	
	public Sala( int setor) {
		this.setor = setor;
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
		return "\nSETOR: " + infSetor();
	}
}
