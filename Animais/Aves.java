package Animais;

import javax.swing.JOptionPane;
import Jaulas.*;
public class Aves extends Animal {
	private String cordapena;

	 public Aves() {
	  super();
	  this.cordapena = "cordapena";
	 }

	 public Aves(double peso, int membros, int idade, String nome, Jaula jaula, String cordapena) {
	  super(peso, membros, idade, nome, jaula);
	  this.cordapena = cordapena;
	 }

	 public String getCordapena() {
	  return cordapena;
	 }

	 public void setCordapena(String cordapena) {
	  this.cordapena = cordapena;
	 }

	 @Override
	 public String toString() {
		 return getNome() + " - AVE - INFORMAÇÕES: \n" + " PESO: " + getPeso() + "\n QUANTIDADE DE MEMBROS:" + getMembros() + "\n IDADE:" + getIdade() + "\n" + getJaula() +"\n COR DAS PENAS:" + cordapena;
	 }

	 
	 @Override
	 public void InfoAnimais() {
	  // TODO Auto-generated method stub
		 JOptionPane.showMessageDialog(null, "PRINCIPAIS CARACTERÍSTICAS = PERNAS E BICOS, A MAIORIA VOA \\n REPRODUÇÃO= SEXUADA \\n LOCOMOÇÃO = POR MEIO DE ASAS OU PATAS \\n  RESPIRAÇÃO = PULMONAR \\\\n HÁBITAT = TERRESTRE", "AVES", JOptionPane.INFORMATION_MESSAGE);
	 }
}
