package Funcionarios;
import Jaulas.*;

public class Veterinario extends Funcionario {
	
	public Veterinario() {
		super();
	}

	public Veterinario(String nome, int matricula, double salario_base, Sala sala, double comissaoAnimal, int quantAnimais) {
		super(nome, matricula, salario_base, sala);
	}

	@Override
	public String toString() {
		return getNome() + " - VETERINÁRIO - INFORMAÇÕES:\n" + " MATRÍCULA:" + getMatricula() + "\n SALÁRIO BASE:" + getSalario_base() + "\n" + getSala();
	}

	
}
