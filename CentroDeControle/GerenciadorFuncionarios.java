package CentroDeControle;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAOZoologico.DAOFuncionarios;
import Funcionarios.*;
public class GerenciadorFuncionarios implements Gerenciador {
	
	DAOFuncionarios daoFuncionario = new DAOFuncionarios();

	public GerenciadorFuncionarios() {
		setListaFuncionarios(new ArrayList<Funcionario>());
	}

	public void getListaFuncionarios() {
		
	}

	public void setListaFuncionarios(ArrayList<Funcionario> listaFuncionarios) {
		
	}
	
	public void addFuncionario(Funcionario f) {
		
		JOptionPane.showMessageDialog(null,"FUNCIONÁRIO CADASTRADO COM SUCESSO!");
	}	
	
	public void remover(int matricula) {
		
		
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
