package CentroDeControle;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAOZoologico.DAOFuncionarios;
import Funcionarios.*;
public class GerenciadorFuncionarios implements Gerenciador {
	
	private DAOFuncionarios daoFuncionario = new DAOFuncionarios();
	public GerenciadorFuncionarios() {
		setListaFuncionarios(new ArrayList<Funcionario>());
	}

	public void getListaFuncionarios() {
		
	}

	public void setListaFuncionarios(ArrayList<Funcionario> listaFuncionarios) {
		
	}
	
	public void addFuncionario(Funcionario f) {
		
		if(daoFuncionario.addFuncionario(f)){
			JOptionPane.showMessageDialog(null,"FUNCIONÁRIO CADASTRADO COM SUCESSO!");
			return;
		}

		JOptionPane.showMessageDialog(null,"NÃO FOI POSSIVEL CADASTRAR O FUNCIONARIO!");
		
	}	
	
	public void remover(int matricula) {
		if(daoFuncionario.removerFuncionario(matricula)){
			JOptionPane.showMessageDialog(null,"FUNCIONARIO REMOVIDO COM SUCESSO!");
			return;
		}
		JOptionPane.showMessageDialog(null,"FUNCIONÁRIO INEXISTENTE!");
	}
	
	public void imprimir(int matricula) {
		
		JOptionPane.showMessageDialog(null,"FUNCIONÁRIO INEXISTENTE!");
	}	
	
	 public Veterinario buscarFuncionario(int matricula){
		        Veterinario vet = daoFuncionario.getVeterinario(matricula);
					return vet;     	    
		    
		  }
	
	public void imprimirTodos() {
		
		
	}
}
