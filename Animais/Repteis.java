package Animais;

import javax.swing.JOptionPane;
import Jaulas.*;
public class Repteis extends Animal{
	 private String cordeescama;

	  
	  public Repteis() {
	   super();
	   this.cordeescama = "cordeescama";
	  }

	  public Repteis(double peso, int membros, int idade, String nome, Jaula jaula, String cordeescama) {
	   super(peso, membros, idade, nome, jaula);
	   this.cordeescama = cordeescama;
	  }

	  public String getCordeescama() {
	   return cordeescama;
	  }

	  public void setCordeescama(String cordeescama) {
	   this.cordeescama = cordeescama;
	  }

	  @Override
	  public String toString() {
		  return getNome() + " - RÉPTEIS - INFORMAÇÕES: \n" + " PESO: " + getPeso() + "\n QUANTIDADE DE MEMBROS: " + getMembros() + "\n IDADE: " + getIdade() + "\n" + getJaula() + "\n COR DAS ESCAMAS: " + cordeescama;
	  }

		 @Override
		 public void InfoAnimais() {
		  // TODO Auto-generated method stub
			 JOptionPane.showMessageDialog(null, "PRINCIPAIS CARACTERISTICAS = PELE SECA E GROSSA \\n REPRODUÇÂO =SEXUADA E REPRODUÇÃO INTERNA  \\n LOCOMOÇÂO =   POR MEIO DE PATAS.EXCETO AS COBRAS, QUE RASTEJAM  \\n RESPIRAÇÃO = PULMONAR \\n HÁBITAT = AQUÁTICO E TERRESTRE", "RÉPTEIS", JOptionPane.INFORMATION_MESSAGE);
		 }
}
