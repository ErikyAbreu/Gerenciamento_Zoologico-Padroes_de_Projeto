package Zoologico;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class GerenciadorFuncionarios implements Gerenciador {
private ArrayList<Funcionario> listaFuncionarios;
	
	public GerenciadorFuncionarios() {
		setListaFuncionarios(new ArrayList<Funcionario>());
	}

	public ArrayList<Funcionario> getListaFuncionarios() {
		return listaFuncionarios;
	}

	public void setListaFuncionarios(ArrayList<Funcionario> listaFuncionarios) {
		this.listaFuncionarios = listaFuncionarios;
	}
	
	public void addFuncionario(Funcionario f) {
		for(Funcionario z:listaFuncionarios) {
			if(f.getMatricula()== z.getMatricula() || f.getSala().getNumLocal() == z.getSala().getNumLocal() || f.getSala().getNumLocal() > 20) {
				JOptionPane.showMessageDialog(null,"FUNCIONÁRIO NÃO PODE SER ADICIONADO!!");
				return;
			}
		}
		listaFuncionarios.add(f);
		JOptionPane.showMessageDialog(null,"FUNCIONÁRIO CADASTRADO COM SUCESSO!");
	}	
	
	public void remover(int matricula) {
		for(Funcionario z:listaFuncionarios) {
			if(matricula == z.getMatricula()) {
				listaFuncionarios.remove(z);
				JOptionPane.showMessageDialog(null,"REMOVIDO COM SUCESSO!");
				return;
			}
		}
		JOptionPane.showMessageDialog(null,"FUNCIONÁRIO INEXISTENTE!");
	}
	
	public void imprimir(int matricula) {
		for(Funcionario z:listaFuncionarios) {
			if(matricula == z.getMatricula()) {
				JOptionPane.showMessageDialog(null,z);
				return;
			}
		}
		JOptionPane.showMessageDialog(null,"FUNCIONÁRIO INEXISTENTE!");
	}	
	
	 Funcionario buscarFuncionario(int matricula){
		    for(Funcionario z : listaFuncionarios){
		        if(matricula == z.getMatricula()){
		            //z.imprimir();
		            return z;
		        }
		    }
		    JOptionPane.showMessageDialog(null,"FUNCIONÁRIO INEXISTENTE!");
			return null;
		  }
	
	public void imprimirTodos() {
		if(listaFuncionarios.isEmpty()) {
			JOptionPane.showMessageDialog(null,"LISTA VAZIA!");
		} else {
			for(Funcionario z:listaFuncionarios) {
				JOptionPane.showMessageDialog(null,z);
		}
		}
	}
}
