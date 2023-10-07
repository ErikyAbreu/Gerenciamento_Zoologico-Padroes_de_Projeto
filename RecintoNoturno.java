package Zoologico;

import javax.swing.JOptionPane;

public class RecintoNoturno extends Jaula{
	public RecintoNoturno(int numero, int modelo) {
		super(numero, modelo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void descrição() {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "-	PROJETADOS PARA ANIMAIS NOTURNOS, COMO MORCEGOS E LÊMURES, ESSES RECINTOS TÊM AMBIENTES ESCUROS COM ILUMINAÇÃO ESPECÍFICA PARA PERMITIR QUE OS ANIMAIS SEJAM ATIVOS DURANTE A NOITE.");
	}

	public String toString() {
		return " JAULA: " + getNumero() + "\n MODELO: RECINTO NOTURNO";
	}
}
