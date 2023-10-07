package Zoologico;

import javax.swing.JOptionPane;

public class FactoryFuncionario {
	public Funcionario getFuncionario(int TF2) {
		switch (TF2) {
			case 1:
			return (new Gerente(JOptionPane.showInputDialog(null,"NOME DO GERENTE: ","GERENTE", JOptionPane.INFORMATION_MESSAGE), 
						Integer.parseInt(JOptionPane.showInputDialog(null,"MATRÍCULA DO GERENTE: ","GERENTE", JOptionPane.INFORMATION_MESSAGE)),
						Double.parseDouble(JOptionPane.showInputDialog(null,"SALÁRIO BASE DO GERENTE: ","GERENTE", JOptionPane.INFORMATION_MESSAGE)),  
						new Sala(Integer.parseInt(JOptionPane.showInputDialog(null,"INFORME A SALA DO GERENTE: ","GERENTE", JOptionPane.INFORMATION_MESSAGE)), 1))); 
						
			case 2:
			return (new Veterinario(JOptionPane.showInputDialog(null,"NOME DO VETERINÁRIO: ","VETERINÁRIO", JOptionPane.INFORMATION_MESSAGE), 
						Integer.parseInt(JOptionPane.showInputDialog(null,"MATRÍCULA DO VETERINÁRIO: ","VETERINÁRIO", JOptionPane.INFORMATION_MESSAGE)),
						Double.parseDouble(JOptionPane.showInputDialog(null,"SALÁRIO BASE DO VETERINÁRIO: ","VETERINÁRIO", JOptionPane.INFORMATION_MESSAGE)),  
						new Sala(Integer.parseInt(JOptionPane.showInputDialog(null,"INFORME A SALA DO VETERINÁRIO: ","VETERINÁRIO", JOptionPane.INFORMATION_MESSAGE)), 2),
						250,
						Integer.parseInt(JOptionPane.showInputDialog(null,"QUANTIDADE DE ANIMAIS ATENDIDOS: ","VETERINÁRIO", JOptionPane.INFORMATION_MESSAGE)))); 
			
			case 3:
			return (new Zelador(JOptionPane.showInputDialog(null,"NOME DO ZELADOR: ","ZELADOR", JOptionPane.INFORMATION_MESSAGE), 
						Integer.parseInt(JOptionPane.showInputDialog(null,"MATRÍCULA DO ZELADOR: ","ZELADOR", JOptionPane.INFORMATION_MESSAGE)),
						Double.parseDouble(JOptionPane.showInputDialog(null,"SALÁRIO BASE DO ZELADOR: ","ZELADOR", JOptionPane.INFORMATION_MESSAGE)),  
						new Sala(Integer.parseInt(JOptionPane.showInputDialog(null,"INFORME A SALA DO ZELADOR: ","ZELADOR", JOptionPane.INFORMATION_MESSAGE)), 3))); 
			
			default:
			JOptionPane.showMessageDialog(null, "OPÇÃO INVÁLIDA! TENTE NOVAMENTE.");
			return null;
			}
	}
}
