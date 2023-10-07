package Zoologico;

import javax.swing.JOptionPane;

public class FactoryAnimal {
	FactoryJaula factoryJaula = new FactoryJaula();
	
	public Animal getAnimal(int TA2) {
		switch (TA2) {
			case 1:
			return (new Anfibios(Double.parseDouble(JOptionPane.showInputDialog(null,"INFORME O PESO DO ANFÍBIO: ","ANFÍBIOS",JOptionPane.INFORMATION_MESSAGE)), 
						Integer.parseInt(JOptionPane.showInputDialog(null,"INFORME A QUANTIDADE DE MEMBROS DO ANFÍBIO: ","ANFÍBIOS", JOptionPane.INFORMATION_MESSAGE)),
						Integer.parseInt(JOptionPane.showInputDialog(null,"INFORME A IDADE DO ANFÍBIO: ","ANFÍBIOS", JOptionPane.INFORMATION_MESSAGE)),
						JOptionPane.showInputDialog(null,"NOME DO ANFÍBIO:","ANFÍBIOS", JOptionPane.INFORMATION_MESSAGE), 
						factoryJaula.getJaula(Integer.parseInt(JOptionPane.showInputDialog(null,"DIGITE:\n1-RECINTO NATURALÍSTICO\n2-AQUÁRIOS\n3-RECINTO NATURAL\n4-RECINTO FRIO\n5-RECINTO NOTURNO","TIPO DE JAULA", JOptionPane.INFORMATION_MESSAGE))), 
						Integer.parseInt(JOptionPane.showInputDialog(null,"INFORME O ID DO ANFÍBIO: ","ANFÍBIOS", JOptionPane.INFORMATION_MESSAGE))));
						
			case 2:
				return (new Aves(Double.parseDouble(JOptionPane.showInputDialog(null,"INFORME O PESO DA AVE: ","AVES", JOptionPane.INFORMATION_MESSAGE)),
						Integer.parseInt(JOptionPane.showInputDialog(null,"INFORME A QUANTIDADE DE MEMBROS DA AVE: ","AVES", JOptionPane.INFORMATION_MESSAGE)), 
						Integer.parseInt(JOptionPane.showInputDialog(null,"INFORME A IDADE DA AVE: ","AVES", JOptionPane.INFORMATION_MESSAGE)), 
						JOptionPane.showInputDialog(null,"NOME DA AVE: ","AVES", JOptionPane.INFORMATION_MESSAGE), 
						factoryJaula.getJaula(Integer.parseInt(JOptionPane.showInputDialog(null,"DIGITE:\n1-RECINTO NATURALÍSTICO\n2-AQUÁRIOS\n3-RECINTO NATURAL\n4-RECINTO FRIO\n5-RECINTO NOTURNO","TIPO DE JAULA", JOptionPane.INFORMATION_MESSAGE))),  
						Integer.parseInt(JOptionPane.showInputDialog(null,"INFORME O ID DA AVE: ","AVES", JOptionPane.INFORMATION_MESSAGE)), 
						JOptionPane.showInputDialog(null,"COR DAS PENAS DA AVE: ","AVES", JOptionPane.INFORMATION_MESSAGE)));
				
			case 3:
				return (new Mamifero(Double.parseDouble(JOptionPane.showInputDialog(null,"INFORME O PESO DO MAMÍFERO:: ","MAMÍFEROS", JOptionPane.INFORMATION_MESSAGE)),
						Integer.parseInt(JOptionPane.showInputDialog(null,"INFORME A QUANTIDADE DE MEMBROS DO MAMÍFERO: ","MAMÍFEROS", JOptionPane.INFORMATION_MESSAGE)), 
						Integer.parseInt(JOptionPane.showInputDialog(null,"INFORME A IDADE DO MAMÍFERO: ","MAMÍFEROS", JOptionPane.INFORMATION_MESSAGE)), 
						JOptionPane.showInputDialog(null,"NOME DO MAMÍFERO: ","MAMÍFEROS", JOptionPane.INFORMATION_MESSAGE), 
						factoryJaula.getJaula(Integer.parseInt(JOptionPane.showInputDialog(null,"DIGITE:\n1-RECINTO NATURALÍSTICO\n2-AQUÁRIOS\n3-RECINTO NATURAL\n4-RECINTO FRIO\n5-RECINTO NOTURNO","TIPO DE JAULA", JOptionPane.INFORMATION_MESSAGE))),  
						Integer.parseInt(JOptionPane.showInputDialog(null,"INFORME O ID DO MAMÍFERO: ","MAMÍFEROS", JOptionPane.INFORMATION_MESSAGE)), 
						JOptionPane.showInputDialog(null,"COR DOS PELOS DO MAMÍFERO: ","MAMÍFEROS", JOptionPane.INFORMATION_MESSAGE),
						Integer.parseInt(JOptionPane.showInputDialog(null,"TEMPO DE GESTAÇÃO: ","MAMÍFEROS", JOptionPane.INFORMATION_MESSAGE))));
				
			case 4:
				return (new Peixes(Double.parseDouble(JOptionPane.showInputDialog(null,"INFORME O PESO DO PEIXE: ","PEIXE", JOptionPane.INFORMATION_MESSAGE)),
						Integer.parseInt(JOptionPane.showInputDialog(null,"INFORME A QUANTIDADE DE MEMBROS DO PEIXE: ","PEIXE", JOptionPane.INFORMATION_MESSAGE)), 
						Integer.parseInt(JOptionPane.showInputDialog(null,"INFORME A IDADE DO PEIXE: ","PEIXE", JOptionPane.INFORMATION_MESSAGE)), 
						JOptionPane.showInputDialog(null,"NOME DO PEIXE: ","PEIXE", JOptionPane.INFORMATION_MESSAGE), 
						factoryJaula.getJaula(Integer.parseInt(JOptionPane.showInputDialog(null,"DIGITE:\n1-RECINTO NATURALÍSTICO\n2-AQUÁRIOS\n3-RECINTO NATURAL\n4-RECINTO FRIO\n5-RECINTO NOTURNO","TIPO DE JAULA", JOptionPane.INFORMATION_MESSAGE))),  
						Integer.parseInt(JOptionPane.showInputDialog(null,"INFORME O ID DO PEIXE: ","PEIXE", JOptionPane.INFORMATION_MESSAGE)), 
						JOptionPane.showInputDialog(null,"COR DAS ESCAMAS DO PEIXE: ","PEIXE", JOptionPane.INFORMATION_MESSAGE)));
				
			case 5:
				return (new Repteis(Double.parseDouble(JOptionPane.showInputDialog(null,"INFORME O PESO DO RÉPTIL: ","RÉPTEIS", JOptionPane.INFORMATION_MESSAGE)),
						Integer.parseInt(JOptionPane.showInputDialog(null,"INFORME A QUANTIDADE DE MEMBROS DO RÉPTIL: ","RÉPTEIS", JOptionPane.INFORMATION_MESSAGE)), 
						Integer.parseInt(JOptionPane.showInputDialog(null,"INFORME A IDADE DO RÉPTIL: ","RÉPTEIS", JOptionPane.INFORMATION_MESSAGE)), 
						JOptionPane.showInputDialog(null,"NOME DO RÉPTIL: ","RÉPTEIS", JOptionPane.INFORMATION_MESSAGE), 
						factoryJaula.getJaula(Integer.parseInt(JOptionPane.showInputDialog(null,"DIGITE:\n1-RECINTO NATURALÍSTICO\n2-AQUÁRIOS\n3-RECINTO NATURAL\n4-RECINTO FRIO\n5-RECINTO NOTURNO","TIPO DE JAULA", JOptionPane.INFORMATION_MESSAGE))), 
						Integer.parseInt(JOptionPane.showInputDialog(null,"INFORME O ID DO RÉPTIL: ","RÉPTEIS", JOptionPane.INFORMATION_MESSAGE)), 
						JOptionPane.showInputDialog(null,"COR DAS ESCAMAS: ","RÉPTEIS", JOptionPane.INFORMATION_MESSAGE)));
				
			default:
			JOptionPane.showMessageDialog(null, "OPÇÃO INVÁLIDA! TENTE NOVAMENTE.");
				return null;
			
			}
	}
	
}
