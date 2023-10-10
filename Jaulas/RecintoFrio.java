package Jaulas;

import javax.swing.JOptionPane;

public class RecintoFrio extends Jaula{
	public RecintoFrio(int numero, int modelo) {
		super(numero, modelo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String descrição() {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "-	ESSES RECINTOS SÃO CLIMATIZADOS E PROJETADOS PARA ACOMODAR ESPÉCIES ADAPTADAS A CLIMAS FRIOS, COMO PINGUINS, URSOS POLARES E LOBOS DO ÁRTICO.\n" +
				"-	ELES INCLUEM PISCINAS OU TANQUES DE ÁGUA FRIA, ÁREAS DE NATAÇÃO, CAVERNAS DE GELO E ÁREAS DE EXPOSIÇÃO AO AR LIVRE.\n" +
				"-	CONTROLES DE TEMPERATURA E ILUMINAÇÃO ARTIFICIAL SÃO USADOS PARA REPLICAR AS CONDIÇÕES DO HABITAT NATURAL.\n");

				return "-	ESSES RECINTOS SÃO CLIMATIZADOS E PROJETADOS PARA ACOMODAR ESPÉCIES ADAPTADAS A CLIMAS FRIOS, COMO PINGUINS, URSOS POLARES E LOBOS DO ÁRTICO.\n" +
				"-	ELES INCLUEM PISCINAS OU TANQUES DE ÁGUA FRIA, ÁREAS DE NATAÇÃO, CAVERNAS DE GELO E ÁREAS DE EXPOSIÇÃO AO AR LIVRE.\n" +
				"-	CONTROLES DE TEMPERATURA E ILUMINAÇÃO ARTIFICIAL SÃO USADOS PARA REPLICAR AS CONDIÇÕES DO HABITAT NATURAL.\n";
	}

	public String toString() {
		return " JAULA: " + getNumero() + "\nMODELO: RECINTO FRIO";
	}
}
