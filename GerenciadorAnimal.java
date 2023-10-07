package Zoologico;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class GerenciadorAnimal implements Gerenciador{
private ArrayList<Animal> listaAnimal;

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
	   for(Animal Z: listaAnimal){
	      if(A.getIdAnimal() == Z.getIdAnimal() || A.getJaula().getNumero() == Z.getJaula().getNumero() ||  20 < A.getJaula().getNumero()){
	    	  JOptionPane.showMessageDialog(null,"ANIMAL NÃO PODE SER ADICIONADO!");
	          return;
	      }
	  }
	   JOptionPane.showMessageDialog(null, "ANIMAL ADICIONADO COM SUCESSO!");
	  listaAnimal.add(A);
	  }
	  
	  public void remover(int idAnimal){
	    for(Animal A1: listaAnimal){
	        if(A1.getIdAnimal() == idAnimal){
	            JOptionPane.showMessageDialog(null, "ANIMAL REMOVIDO COM SUCESSO!");
	            listaAnimal.remove(A1);
	            return;
	        }
	        
	    }
	    JOptionPane.showMessageDialog(null,"ANIMAL INEXISTENTE!");
	  }

	  public void imprimir(int idAnimal){
	    for(Animal A1: listaAnimal){
	      if(A1.getIdAnimal() == idAnimal){
	    	  JOptionPane.showMessageDialog(null,A1);
	        return;
	      }
	    }
	    JOptionPane.showMessageDialog(null,"ANIMAL INEXISTENTE!");
	  }

	 Animal buscarAnimal(int idAnimal){
	    for(Animal z : listaAnimal){
	        if(idAnimal == z.getIdAnimal()){
	            //z.imprimir();
	            return z;
	        }
	    }
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
	   
