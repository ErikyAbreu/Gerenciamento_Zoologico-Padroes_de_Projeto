package Funcionarios;
import Jaulas.*;

public class Zelador extends Funcionario {
	public Zelador() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Zelador(String nome, int matricula, double salario_base, Sala sala) {
		super(nome, matricula, salario_base, sala);
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return getNome() + " - ZELADOR - INFORMAÇÕES:\n" + " MATRÍCULA:" + getMatricula() + "\n SALÁRIO BASE:" + getSalario_base() + "\n" + getSala();
	}
	
}
