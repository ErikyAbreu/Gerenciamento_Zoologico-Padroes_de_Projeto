package CentroDeControle;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Animais.Animal;
import DAOZoologico.DAOAnimais;

public class GerenciadorAnimal implements Gerenciador{
private ArrayList<Animal> listaAnimal;
	  DAOAnimais daoAnimais = new DAOAnimais();
	  public GerenciadorAnimal(){
			setListaAnimal(new ArrayList<Animal>());
		}

		public ArrayList<Animal> getListaAnimal() {
			return listaAnimal;
		}

		public void setListaAnimal(ArrayList<Animal> listaAnimal) {
			this.listaAnimal = listaAnimal;
		}
		
	  public void AddAnimal(Animal A){
      boolean a = daoAnimais.adicionaAnimal(A); 
	      if(a){
	    	  JOptionPane.showMessageDialog(null,"ANIMAL ADICIONADO COM SUCESSO!");
	          return;
	      }
	  
	   JOptionPane.showMessageDialog(null, "ANIMAL NÃO PODE SER ADICIONADO!");
	  }
	  
	  public void remover(int idAnimal){
	   
	    JOptionPane.showMessageDialog(null,"ANIMAL INEXISTENTE!");
	  }

	  public void imprimir(int idAnimal){
	    
	    JOptionPane.showMessageDialog(null,"ANIMAL INEXISTENTE!");
	  }

	 Animal buscarAnimal(int idAnimal){
	    
	    JOptionPane.showMessageDialog(null,"ANIMAL INEXISTENTE!");
		return null;
	  }
	  
	 
	  
	  public void imprimirTodos(){
		  if(listaAnimal.isEmpty()) {
			  JOptionPane.showMessageDialog(null,"LISTA VAZIA!");
			} else {
				for(Animal z:listaAnimal) {
					JOptionPane.showMessageDialog(null,z);
			}
			}
	  }
}	  
	   
