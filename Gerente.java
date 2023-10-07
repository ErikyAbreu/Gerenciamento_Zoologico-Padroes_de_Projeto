package Zoologico;

import javax.swing.JOptionPane;

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
	public double calculaSalario() {
		// TODO Auto-generated method stub
		double sg = getSalario_base()*2;
		JOptionPane.showMessageDialog(null, "SALÁRIO DO GERENTE: " + sg);
		return sg;
	}

	@Override
	public String toString() {
		return getNome() + " - GERENTE - INFORMAÇÕES:\n" + " MATRÍCULA:" + getMatricula() + "\n SALÁRIO BASE:" + getSalario_base() + "\n" + getSala();
	}

}
