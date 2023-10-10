package Jaulas;

import javax.swing.JOptionPane;

public class RecintoFloresta extends Jaula{
	public RecintoFloresta(int numero, int modelo) {
		super(numero, modelo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String descrição() {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "- ESSES RECINTOS SÃO PROJETADOS PARA ACOMODAR AVES E PRIMATAS.\n" +
				"- ELES INCLUEM ÁREAS DE VOO COM ESPAÇO SUFICIENTE PARA AS AVES ESTICAREM SUAS ASAS E PRATICAREM VOO.\n" +
				"- ÁRVORES E POLEIROS SÃO FORNECIDOS PARA REPLICAR O HABITAT NATURAL.\n" +
				"- OFERECEM ÁREAS DE ESCALADA, REDES, ÁRVORES E VEGETAÇÃO.\n" +
				"- COSTUMAM INCLUIR ÁREAS COBERTAS PARA PROTEÇÃO CONTRA INTEMPÉRIES.\n");

				return "- ESSES RECINTOS SÃO PROJETADOS PARA ACOMODAR AVES E PRIMATAS.\n" +
				"- ELES INCLUEM ÁREAS DE VOO COM ESPAÇO SUFICIENTE PARA AS AVES ESTICAREM SUAS ASAS E PRATICAREM VOO.\n" +
				"- ÁRVORES E POLEIROS SÃO FORNECIDOS PARA REPLICAR O HABITAT NATURAL.\n" +
				"- OFERECEM ÁREAS DE ESCALADA, REDES, ÁRVORES E VEGETAÇÃO.\n" +
				"- COSTUMAM INCLUIR ÁREAS COBERTAS PARA PROTEÇÃO CONTRA INTEMPÉRIES.\n";
	}

	public String toString() {
		return " JAULA: " + getNumero() + "\n MODELO: RECINTO NATURAL";
	}
}
