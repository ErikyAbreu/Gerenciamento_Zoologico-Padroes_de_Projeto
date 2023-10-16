package CentroDeControle;
import Funcionarios.*;
import Animais.*;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Principal {
	public static void main(String[] args) {
		  GerenciadorAnimal A = new GerenciadorAnimal();
		  GerenciadorFuncionarios F = new GerenciadorFuncionarios();
		  FactoryAnimal factoryAnimal = new FactoryAnimal();
		  FactoryFuncionario factoryFuncionario = new FactoryFuncionario();
		  Scanner sc = new Scanner(System.in);
		  int T1 = 0; //PARÂMETRO PARA O MENU
		  int TA = 0; //PARÂMETRO PARA ESCOLHA DO MENU ANIMAL 
		  int TA2 = 0; //PARÂMETRO PARA ESCOLHA DO TIPO DE ANIMAL
		  int TAVV = 0;
		  int TAINF = 0;
		  int TF = 0; //PARÂMETRO PARA ESCOLHA DO MENU FUNCIONÁRIO
		  int TF2 = 0; //PARÂMETRO PARA ESCOLHA DO TIPO DE FUNCIONÁRIO
		  int TFCS = 0;
		  
		  do{
			  try {
		 T1 = Integer.parseInt(JOptionPane.showInputDialog(null,"DIGITE:\n1-ANIMAIS\n2-FUNCINÁRIOS\n3-SAIR DO PROGRAMA", "MENU", JOptionPane.INFORMATION_MESSAGE));
		  switch(T1) {
		  	case 1:
		  		TA = Integer.parseInt(JOptionPane.showInputDialog(null, "DIGITE:\n1-ADICIONAR ANIMAL\n2-REMOVER ANIMAL\n3-IMPRIMIR ANIMAL\n4-IMPRIMIR TODOS ANIMAIS\n5-INFORMAÇÕES DE ANIMAIS\n6-INFORMAÇÕES DE JAULAS\n7-VISITA AO VETERINÁRIO\n8-ANÁLISE DA GESTAÇÃO - MAMÍFEROS","MENU ANIMAL", JOptionPane.INFORMATION_MESSAGE));
		  		switch(TA) {
		  		case 1:
		  			TA2 = Integer.parseInt(JOptionPane.showInputDialog(null, "DIGITE:\n1-ANFÍBIOS\n2-AVES\n3-MAMÍFEROS \n4-PEIXES \n5-RÉPTEIS", "ANIMAL",JOptionPane.INFORMATION_MESSAGE));
		  			A.AddAnimal(factoryAnimal.getAnimal(TA2));
						break;
						
		  		case 2: 
					//A.imprimirTodos();
		  			A.remover(Integer.parseInt(JOptionPane.showInputDialog(null, "ID DO ANIMAL QUE DESEJA REMOVER: ","REMOVER ANIMAL", JOptionPane.INFORMATION_MESSAGE)));
		  			break;
		  			
		  		case 3:
		  			A.imprimir(Integer.parseInt(JOptionPane.showInputDialog(null, "ID DO ANIMAL QUE DESEJA IMPRIMIR: ","IMPRIMIR ANIMAL", JOptionPane.INFORMATION_MESSAGE)));
		  			break;
		  			
		  		case 4:
		  			A.imprimirTodos();
		  			break;
		  			
		  		case 5:
		  			TAINF = Integer.parseInt(JOptionPane.showInputDialog(null, "INFORME A CLASSE DO ANIMAL:\n1-ANFÍBIOS\n2-AVES\n3-MAMÍFEROS \n4-PEIXES \n5-RÉPTEIS", "ANIMAL",JOptionPane.INFORMATION_MESSAGE));
		  			switch (TAINF) {
		  			case 1:
		  				Anfibios AINF = new Anfibios();
		  				AINF.InfoAnimais();
		  				break;
		  			case 2:
		  				Aves AvINF = new Aves();
		  				AvINF.InfoAnimais();
		  				break;
		  			case 3:
		  				Mamifero MINF = new Mamifero();
		  				MINF.InfoAnimais();
		  				break;
		  			case 4:
		  				Peixes PINF = new Peixes();
		  				PINF.InfoAnimais();
		  				break;
		  			case 5:
		  				Repteis RINF = new Repteis();
		  				RINF.InfoAnimais();
		  				break;
		  			default:
						JOptionPane.showMessageDialog(null, "OPÇÃO INVÁLIDA! TENTE NOVAMENTE.");
						break;
		  			}
		  			break;
		  			
		  		case 6:
		  			int tipoJaula = Integer.parseInt(JOptionPane.showInputDialog(null, "DIGITE:\n1-RECINTO NATURALÍSTICO\n2-AQUÁRIOS\n3-RECINTO FLORESTA\n4-RECINTO FRIO\n5-RECINTO NOTURNO", "ANIMAL",JOptionPane.INFORMATION_MESSAGE)); 
		  			switch (tipoJaula) {
		  			case 1:
		  				JOptionPane.showMessageDialog(null,"- ESSES RECINTOS GERALMENTE ABRIGAM GRANDES PREDADORES, COMO LEÕES, TIGRES E URSOS.\r\n"
		  						+ "- SÃO ESPAÇOS AMPLOS COM VEGETAÇÃO, ROCHAS E TALVEZ UM LAGO OU PISCINA.\r\n"
		  						+ "- ELES SÃO PROJETADOS PARA IMITAR O AMBIENTE NATURAL DESSES ANIMAIS E FORNECER ESPAÇO PARA EXERCÍCIO, DESCANSO E CAÇA SIMULADA.\r\n", "RECINTO NATURALÍSTICO", JOptionPane.INFORMATION_MESSAGE);
		  				break;
		  				
		  			case 2:
		  				JOptionPane.showMessageDialog(null,"- AQUÁRIOS SÃO USADOS PARA EXIBIR UMA VARIEDADE DE ANIMAIS AQUÁTICOS, INCLUINDO PEIXES, TUBARÕES, GOLFINHOS, TARTARUGAS E INVERTEBRADOS MARINHOS.\r\n"
		  						+ "- TANQUES DE ÁGUA DE VIDRO OU ACRÍLICO QUE OFERECEM UMA VISÃO SUBAQUÁTICA CLARA DOS ANIMAIS.\r\n"
		  						+ "- OS AQUÁRIOS PODEM INCLUIR DECORAÇÕES NATURAIS, CORAIS E TÚNEIS PARA PROPORCIONAR UM AMBIENTE SEMELHANTE AO OCEANO.\r\n", "AQUÁRIOS", JOptionPane.INFORMATION_MESSAGE);
		  				break;
		  			case 3:
		  				JOptionPane.showMessageDialog(null, "- ESSES RECINTOS SÃO PROJETADOS PARA ACOMODAR AVES E PRIMATAS.\n" +
		  						"- ELES INCLUEM ÁREAS DE VOO COM ESPAÇO SUFICIENTE PARA AS AVES ESTICAREM SUAS ASAS E PRATICAREM VOO.\n" +
		  						"- ÁRVORES E POLEIROS SÃO FORNECIDOS PARA REPLICAR O HABITAT NATURAL.\n" +
		  						"- OFERECEM ÁREAS DE ESCALADA, REDES, ÁRVORES E VEGETAÇÃO.\n" +
		  						"- COSTUMAM INCLUIR ÁREAS COBERTAS PARA PROTEÇÃO CONTRA INTEMPÉRIES.\n", "RECINTO FLORESTA", JOptionPane.INFORMATION_MESSAGE);
		  				break;
		  			case 4:
		  				JOptionPane.showMessageDialog(null, "-	ESSES RECINTOS SÃO CLIMATIZADOS E PROJETADOS PARA ACOMODAR ESPÉCIES ADAPTADAS A CLIMAS FRIOS, COMO PINGUINS, URSOS POLARES E LOBOS DO ÁRTICO.\n" +
		  						"-	ELES INCLUEM PISCINAS OU TANQUES DE ÁGUA FRIA, ÁREAS DE NATAÇÃO, CAVERNAS DE GELO E ÁREAS DE EXPOSIÇÃO AO AR LIVRE.\n" +
		  						"-	CONTROLES DE TEMPERATURA E ILUMINAÇÃO ARTIFICIAL SÃO USADOS PARA REPLICAR AS CONDIÇÕES DO HABITAT NATURAL.\n", "RECINTO FRIO", JOptionPane.INFORMATION_MESSAGE);
		  				break;
		  			case 5:
		  				JOptionPane.showMessageDialog(null, "-	PROJETADOS PARA ANIMAIS NOTURNOS, COMO MORCEGOS E LÊMURES, ESSES RECINTOS TÊM AMBIENTES ESCUROS COM ILUMINAÇÃO ESPECÍFICA PARA PERMITIR QUE OS ANIMAIS SEJAM ATIVOS DURANTE A NOITE.", "RECINTO NOTURNO", JOptionPane.INFORMATION_MESSAGE);
		  				break;
		  			default:
						JOptionPane.showMessageDialog(null, "OPÇÃO INVÁLIDA! TENTE NOVAMENTE.");
						break;
		  			}
		  			
		  			break;
		  		case 7:
		  			
		  			int IDVV = 0;
					IDVV = Integer.parseInt(JOptionPane.showInputDialog(null,"ID DO ANIMAL:"));
		  			String tipoDoAnimal = A.getTipo(IDVV); 
		  			Veterinario VVV = F.buscarFuncionario(Integer.parseInt(JOptionPane.showInputDialog(null,"MATRÍCULA DO VETERINÁRIO:")));	
		  			if(!VVV.equals(null)){
		  			if(tipoDoAnimal.equals("Anfibio")){
						factoryAnimal.getAnimalVazio(IDVV).VisitaAoVeterinario(VVV, 0, IDVV);
					} else if (tipoDoAnimal.equals("Ave")){
						factoryAnimal.getAnimalVazio(IDVV).VisitaAoVeterinario(VVV, 0, IDVV);
					} else if(tipoDoAnimal.equals("Mamifero")){
						factoryAnimal.getAnimalVazio(IDVV).VisitaAoVeterinario(VVV, 0, IDVV);
					} else if(tipoDoAnimal.equals("Peixe")){
						factoryAnimal.getAnimalVazio(IDVV).VisitaAoVeterinario(VVV, 0, IDVV);
					} else if(tipoDoAnimal.equals("Reptil")){
						factoryAnimal.getAnimalVazio(IDVV).VisitaAoVeterinario(VVV, 0, IDVV);
					} else {
						JOptionPane.showMessageDialog(null, "ID DO ANIMAL INVÁLIDO! TENTE NOVAMENTE.");
					}	
				} else {
					JOptionPane.showMessageDialog(null, "MATRICULA DO VETERINARIO INVÁLIDA! TENTE NOVAMENTE.");
				}
						
		  			
		  			break;
		  		case 8:
		  			Integer.parseInt(JOptionPane.showInputDialog(null,"ID DO ANIMAL:", "ANÁLISE DA GESTAÇÃO", JOptionPane.QUESTION_MESSAGE));
		  			Mamifero MG = new Mamifero();
		  			MG.Analisedagestacao(Integer.parseInt(JOptionPane.showInputDialog(null,"TEMPO DE GESTAÇÃO: ")));
		  			break;
		  		default:
					JOptionPane.showMessageDialog(null, "OPÇÃO INVÁLIDA! TENTE NOVAMENTE.");
					break;
					
		  		}
					break;
		  	case 2:
		  	TF = Integer.parseInt(JOptionPane.showInputDialog(null, "DIGITE:\n1-ADICIONAR FUNCIONÁRIO\n2-REMOVER FUNCIONÁRIO\n3-IMPRIMIR FUNCIONÁRIO \n4-IMPRIMIR TODOS FUNCIONÁRIOS\n5-CALCULAR SALÁRIO DO FUNCIONÁRIO","MENU FUNCIONÁRIOS", JOptionPane.INFORMATION_MESSAGE));
		  			switch (TF) {
		  			case 1:
		  				TF2 = Integer.parseInt(JOptionPane.showInputDialog(null, "DIGITE:\n1-GERENTE\n2-VETERINÁRIO\n3-ZELADOR","FUNCIONÁRIOS", JOptionPane.INFORMATION_MESSAGE));
		  				F.addFuncionario(factoryFuncionario.getFuncionario(TF2));
						break;
			  		case 2:
			  			F.remover(Integer.parseInt(JOptionPane.showInputDialog(null, "MATRÍCULA DO FUNCIONÁRIO QUE DESEJA REMOVER: ","REMOVER FUNCIONÁRIO", JOptionPane.INFORMATION_MESSAGE)));
			  			break;
			  		case 3:
			  			F.imprimir(Integer.parseInt(JOptionPane.showInputDialog(null, "MATRÍCULA DO FUNCIONÁRIO QUE DESEJA IMPRIMIR: ","IMPRIMIR FUNCINÁRIO", JOptionPane.INFORMATION_MESSAGE)));
			  			break;
			  		case 4:
			  			F.imprimirTodos();
			  			break;
			  		case 5:
			  			TFCS = Integer.parseInt(JOptionPane.showInputDialog(null, "DIGITE:\n1-GERENTE\n2-VETERINÁRIO\n3-ZELADOR","ESCOLHA O TIPO DO FUNCIONÁRIOS", JOptionPane.INFORMATION_MESSAGE));
			  			int MCS = 0;
			  			if(TFCS < 4) {
			  				MCS = Integer.parseInt(JOptionPane.showInputDialog(null,"MATRICULA DO FUNCIONÁRIO:"));
			  			}
			  			switch (TFCS) {
			  			case 1:
			  			//	Gerente GCS = (Gerente) F.buscarFuncionario(MCS);
				  			//GCS.calculaSalario();
				  			break;
			  			case 2:
			  				Veterinario VCS = (Veterinario) F.buscarFuncionario(MCS);
				  			VCS.calculaSalario();
				  			break;
			  			case 3:
				  		//	Zelador ZCS = (Zelador) F.buscarFuncionario(MCS);
				  			//ZCS.calculaSalario();
				  			break;
			  			default:
							JOptionPane.showMessageDialog(null, "OPÇÃO INVÁLIDA! TENTE NOVAMENTE.");
							break;
		  			}
			  		default:
			  			JOptionPane.showMessageDialog(null, "OPÇÃO INVÁLIDA! TENTE NOVAMENTE.");
			  			break;
					}
		  			break;
		  	case 3: 
		  		JOptionPane.showMessageDialog(null, "VOLTE SEMPRE!");
		  		break;
		  	default:
	  			JOptionPane.showMessageDialog(null, "OPÇÃO INVÁLIDA! TENTE NOVAMENTE.");
	  			break;
					}
			} catch(Exception E) {
	  			  JOptionPane.showMessageDialog(null, "VALOR INVÁLIDO!", "ERRO!", JOptionPane.INFORMATION_MESSAGE);
			}
		  }while(T1 != 3);
		  sc.close();
}
	}