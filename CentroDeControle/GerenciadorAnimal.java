package CentroDeControle;

import javax.swing.JOptionPane;

import Animais.Animal;
import DAOZoologico.DAOAnimais;

public class GerenciadorAnimal implements Gerenciador{
	  DAOAnimais daoAnimais = new DAOAnimais();
	  boolean a = true;
	  public GerenciadorAnimal(){
			
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

	  public String getTipo(int idAnimal){
		String tipoDoAnimal = daoAnimais.getTipo(idAnimal);
		return tipoDoAnimal;
	  }

	  public void gestacao(int idAnimal, int tempGravida){
		int gestacao = daoAnimais.gestacaoDoAnimal(idAnimal);
			if(tempGravida == gestacao) {
				JOptionPane.showMessageDialog(null,"O PARTO ESTÁ PRÓXIMO!");
			} if (tempGravida >= (gestacao/2) && tempGravida < gestacao) {
				JOptionPane.showMessageDialog(null,"REALIZAR ULTRASSOM!");
			}else {
				JOptionPane.showMessageDialog(null,"\n O ANIMAL ESTÁ GRÁVIDA!"); 
			}
		
	  }
	  
}	  
	   
