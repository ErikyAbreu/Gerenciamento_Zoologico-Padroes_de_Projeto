package Funcionarios;
import Jaulas.*;

public class Gerente extends Funcionario{
	public Gerente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Gerente(String nome, int matricula, double salario_base, Sala sala) {
		super(nome, matricula, salario_base, sala);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return getNome() + " - GERENTE - INFORMAÇÕES:\n" + " MATRÍCULA:" + getMatricula() + "\n SALÁRIO BASE:" + getSalario_base() + "\n" + getSala();
	}

}
