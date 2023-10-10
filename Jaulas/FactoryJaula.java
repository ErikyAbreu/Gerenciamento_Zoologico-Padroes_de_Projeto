package Jaulas;

import javax.swing.JOptionPane;
public class FactoryJaula {
	public Jaula getJaula(int TJ) {
		switch (TJ) {
			case 1:
				return (new RecintoNaturalistico(Integer.parseInt(JOptionPane.showInputDialog(null,"INFORME O NÚMERO DA JAULA: ","RECINTO NATURALÍSTICO",JOptionPane.INFORMATION_MESSAGE)), 1)); 
						
			case 2:
				return (new Aquarios(Integer.parseInt(JOptionPane.showInputDialog(null,"INFORME O NÚMERO DA JAULA: ","AQUÁRIOS",JOptionPane.INFORMATION_MESSAGE)), 2)); 
				
			case 3:
				return (new RecintoFloresta(Integer.parseInt(JOptionPane.showInputDialog(null,"INFORME O NÚMERO DA JAULA: ","RECINTO FLORESTA",JOptionPane.INFORMATION_MESSAGE)), 3));
				
			case 4:
				return (new RecintoFrio(Integer.parseInt(JOptionPane.showInputDialog(null,"INFORME O NÚMERO DA JAULA: ","RECINTO FRIO",JOptionPane.INFORMATION_MESSAGE)), 4));
				
			case 5:
				return (new RecintoNoturno(Integer.parseInt(JOptionPane.showInputDialog(null,"INFORME O NÚMERO DA JAULA: ","RECINTO NOTURNO",JOptionPane.INFORMATION_MESSAGE)), 5));
				
			default:
			JOptionPane.showMessageDialog(null, "OPÇÃO INVÁLIDA! TENTE NOVAMENTE.");
				return null;
			
			}
	}
}
