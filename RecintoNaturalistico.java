package Zoologico;

import javax.swing.JOptionPane;

public class RecintoNaturalistico extends Jaula{
	public RecintoNaturalistico(int numero, int modelo) {
		super(numero, modelo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void descrição() {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null,"- ESSES RECINTOS GERALMENTE ABRIGAM GRANDES PREDADORES, COMO LEÕES, TIGRES E URSOS.\r\n"
				+ "- SÃO ESPAÇOS AMPLOS COM VEGETAÇÃO, ROCHAS E TALVEZ UM LAGO OU PISCINA.\r\n"
				+ "- ELES SÃO PROJETADOS PARA IMITAR O AMBIENTE NATURAL DESSES ANIMAIS E FORNECER ESPAÇO PARA EXERCÍCIO, DESCANSO E CAÇA SIMULADA.\r\n");
	}

	public String toString() {
		return " JAULA: " + getNumero() + "\n MODELO: RECINTO NATURALÍSTICO ";
	}
}
