package Jaulas;

import javax.swing.JOptionPane;
public class Aquarios extends Jaula{
	public Aquarios(int numero, int modelo) {
		super(numero, modelo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String descrição() {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null,"- AQUÁRIOS SÃO USADOS PARA EXIBIR UMA VARIEDADE DE ANIMAIS AQUÁTICOS, INCLUINDO PEIXES, TUBARÕES, GOLFINHOS, TARTARUGAS E INVERTEBRADOS MARINHOS.\r\n"
				+ "- TANQUES DE ÁGUA DE VIDRO OU ACRÍLICO QUE OFERECEM UMA VISÃO SUBAQUÁTICA CLARA DOS ANIMAIS.\r\n"
				+ "- OS AQUÁRIOS PODEM INCLUIR DECORAÇÕES NATURAIS, CORAIS E TÚNEIS PARA PROPORCIONAR UM AMBIENTE SEMELHANTE AO OCEANO.\r\n");
				return  "- AQUÁRIOS SÃO USADOS PARA EXIBIR UMA VARIEDADE DE ANIMAIS AQUÁTICOS, INCLUINDO PEIXES, TUBARÕES, GOLFINHOS, TARTARUGAS E INVERTEBRADOS MARINHOS.\r\n"
				+ "- TANQUES DE ÁGUA DE VIDRO OU ACRÍLICO QUE OFERECEM UMA VISÃO SUBAQUÁTICA CLARA DOS ANIMAIS.\r\n"
				+ "- OS AQUÁRIOS PODEM INCLUIR DECORAÇÕES NATURAIS, CORAIS E TÚNEIS PARA PROPORCIONAR UM AMBIENTE SEMELHANTE AO OCEANO.\r\n";
	}

	public String toString() {
		return " JAULA: " + getNumero() + "\n MODELO: AQUÁRIOS";
	}
}
