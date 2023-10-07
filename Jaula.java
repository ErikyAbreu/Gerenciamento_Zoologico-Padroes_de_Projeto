package Zoologico;

public abstract class Jaula {
	private int numero;
	private int modelo;
	
	public Jaula(){
		super();
	}

	public Jaula(int numero, int modelo) {
		super();
		this.numero = numero;
		this.modelo = modelo;
	}

	public abstract void descrição();

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getModelo() {
		return modelo;
	}

	public void setModelo(int modelo) {
		this.modelo = modelo;
	}	
}
