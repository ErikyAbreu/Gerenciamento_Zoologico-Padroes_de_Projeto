package CentroDeControle;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Animais.Animal;
import DAOZoologico.DAOAnimais;

public class GerenciadorAnimal implements Gerenciador{
private ArrayList<Animal> listaAnimal;
	  DAOAnimais daoAnimais = new DAOAnimais();
	  boolean a = true;
	  public GerenciadorAnimal(){
			
		}

		public ArrayList<Animal> getListaAnimal() {
			return listaAnimal;
		}

		public void setListaAnimal(ArrayList<Animal> listaAnimal) {
			this.listaAnimal = listaAnimal;
		}
		
	  public void AddAnimal(Animal A){
      a = daoAnimais.adicionaAnimal(A); 
	      if(a){
	    	  JOptionPane.showMessageDialog(null,"ANIMAL ADICIONADO COM SUCESSO!");
	          return;
	      }
	  
	   JOptionPane.showMessageDialog(null, "ANIMAL NÃO PODE SER ADICIONADO!");
	  }
	  
	  public void remover(int idAnimal){
		a = daoAnimais.removerAnimal(idAnimal);
		if(a){
	    	  JOptionPane.showMessageDialog(null,"ANIMAL REMOVIDO COM SUCESSO!");
	          return;
	      }
	    JOptionPane.showMessageDialog(null,"NÂO FOI POSSIVEL REMOVER O ANIMAL!");
	  }

	  public void imprimir(int idAnimal){
	    daoAnimais.imprimirAnimal(idAnimal);
	    //JOptionPane.showMessageDialog(null,"ANIMAL INEXISTENTE!");
	  }

	  public void imprimirTodos(){
		  daoAnimais.imprimirAnimais();
	  }  
	  
}	  
	   
