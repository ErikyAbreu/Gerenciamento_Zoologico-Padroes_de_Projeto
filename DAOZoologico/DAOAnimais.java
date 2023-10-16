package DAOZoologico;

import java.sql.*;

import javax.swing.JOptionPane;
import Animais.*;

public class DAOAnimais {
    private String sql; //String para armazenar comando do sql
    private DAOAuxiliar auxiliar = new DAOAuxiliar(); //Classe auxiliar que auxiliar a verificar e a modificar valores no banco de dados
    private DAOJaulas jaulas = new DAOJaulas(); //Classe DAO para realizar modificações na tabela jaulas no banco de dados
    private Connection conectar = ConexaoPostgreSQL.getInstancia().getConexao(); //Classe para estabelecer uma conexão ao banco de dados
    private boolean a = true;

    //Metodo para adicionar uma jaula ao banco de dados
    public boolean adicionaAnimal(Animal A){
         a = false;
        //Primeiro, verificamos se o modelo de jaula selecionado está disponivel (quantidade para cada modelo  = 20 jaulas)
        if(auxiliar.verificaModeloDeJaula(A.getJaula().getModelo())){
        //Se houver disponibilidade, adicionamos a jaula para o animal e recuperamos o id dessa jaula direto do banco de dados
        int idJaula = jaulas.AdicionaJaula(A.getJaula());
        //Inserindo comando para realização a inserção do animal na tabela animais do banco de dados
        if(A instanceof Anfibios){
            
        sql = "INSERT INTO animais (peso, membros, idade, nome,tipo,jaulaID) VALUES (?,?,?,?,?,?) RETURNING idAnimal";
        try {
            //Preparando o comando com os valores adequados para a tabela
            int idAnimal = 0;
            PreparedStatement instrucao = conectar.prepareStatement(sql);
            instrucao.setDouble(1, A.getPeso());
            instrucao.setInt(2, A.getMembros());
            instrucao.setInt(3, A.getIdade());
            instrucao.setString(4, A.getNome());
            instrucao.setString(5, "Anfibio");
            instrucao.setInt(6, idJaula);
            //Executando comando
            ResultSet consulta = instrucao.executeQuery();
            if(consulta.next()){
                idAnimal = consulta.getInt("idAnimal");
                jaulas.atualizaIdDaJaula(idJaula,idAnimal);
                JOptionPane.showMessageDialog(null,"Animal adicionado com sucesso a jaula de modelo "+A.getJaula().getModelo());
                a = true;
            }
            
        } catch (SQLException e) {

            e.printStackTrace();
        }

        } else if(A instanceof Aves){
        
         sql = "INSERT INTO animais (peso, membros, idade, nome, tipo, cor_da_pena, jaulaID) VALUES (?,?,?,?,?,?,?) RETURNING idAnimal";
         Aves Aves = (Aves) A;
        try {
            
            //Preparando o comando com os valores adequados para a tabela
            int idAnimal = 0;
            PreparedStatement instrucao = conectar.prepareStatement(sql);
            instrucao.setDouble(1, A.getPeso());
            instrucao.setInt(2, A.getMembros());
            instrucao.setInt(3, A.getIdade());
            instrucao.setString(4, A.getNome());
            instrucao.setString(5, "Ave");
            instrucao.setString(6, Aves.getCordapena());
            instrucao.setInt(7, idJaula);
            //Executando comando
            ResultSet consulta = instrucao.executeQuery();
            if(consulta.next()){
                idAnimal = consulta.getInt("idAnimal");
                jaulas.atualizaIdDaJaula(idJaula,idAnimal);
                JOptionPane.showMessageDialog(null,"Animal adicionado com sucesso a jaula de modelo "+A.getJaula().getModelo());
                a = true;
            }
            
        } catch (SQLException e) {

            e.printStackTrace();
        }
        } else if (A instanceof Mamifero){
            Mamifero mamifero = (Mamifero) A;
            sql = "INSERT INTO animais (peso, membros, idade, nome, tipo, cor_do_pelo, gestacao, jaulaID) VALUES (?,?,?,?,?,?,?,?) RETURNING idAnimal";
        try {
            //Preparando o comando com os valores adequados para a tabela
            int idAnimal = 0;
            PreparedStatement instrucao = conectar.prepareStatement(sql);
            instrucao.setDouble(1, A.getPeso());
            instrucao.setInt(2, A.getMembros());
            instrucao.setInt(3, A.getIdade());
            instrucao.setString(4, A.getNome());
            instrucao.setString(5, "Mamifero");
            instrucao.setString(6, mamifero.getCordepelo());
            instrucao.setInt(7, mamifero.getTempodegestacao());
            instrucao.setInt(8, idJaula);
            //Executando comando
            ResultSet consulta = instrucao.executeQuery();
            if(consulta.next()){
                idAnimal = consulta.getInt("idAnimal");
                jaulas.atualizaIdDaJaula(idJaula,idAnimal);
                JOptionPane.showMessageDialog(null,"Animal adicionado com sucesso a jaula de modelo "+A.getJaula().getModelo());
                a = true;
            }
            
        } catch (SQLException e) {

            e.printStackTrace();
        }
        } else if (A instanceof Peixes){
             Peixes peixes = (Peixes) A;
            sql = "INSERT INTO animais (peso, membros, idade, nome, tipo, cor_das_escamas, jaulaID) VALUES (?,?,?,?,?,?,?) RETURNING idAnimal";
        try {
            //Preparando o comando com os valores adequados para a tabela
            int idAnimal = 0;
            PreparedStatement instrucao = conectar.prepareStatement(sql);
            instrucao.setDouble(1, A.getPeso());
            instrucao.setInt(2, A.getMembros());
            instrucao.setInt(3, A.getIdade());
            instrucao.setString(4, A.getNome());
            instrucao.setString(5, "Peixe");
            instrucao.setString(6, peixes.getCordeescama());
            instrucao.setInt(7, idJaula);
            //Executando comando
            ResultSet consulta = instrucao.executeQuery();
            if(consulta.next()){
                idAnimal = consulta.getInt("idAnimal");
                jaulas.atualizaIdDaJaula(idJaula,idAnimal);
                JOptionPane.showMessageDialog(null,"Animal adicionado com sucesso a jaula de modelo "+A.getJaula().getModelo());
                a = true;
            }
            
        } catch (SQLException e) {

            e.printStackTrace();
        }
        } else if (A instanceof Repteis){
            Repteis repteis = (Repteis) A;
            sql = "INSERT INTO animais (peso, membros, idade, nome, tipo, cor_das_escamas, jaulaID) VALUES (?,?,?,?,?,?,?) RETURNING idAnimal";
        try {
            //Preparando o comando com os valores adequados para a tabela
            int idAnimal = 0;
            PreparedStatement instrucao = conectar.prepareStatement(sql);
            instrucao.setDouble(1, A.getPeso());
            instrucao.setInt(2, A.getMembros());
            instrucao.setInt(3, A.getIdade());
            instrucao.setString(4, A.getNome());
            instrucao.setString(5, "Reptil");
            instrucao.setString(6, repteis.getCordeescama());
            instrucao.setInt(7, idJaula);
            //Executando comando
            ResultSet consulta = instrucao.executeQuery();
            if(consulta.next()){
                idAnimal = consulta.getInt("idAnimal");
                jaulas.atualizaIdDaJaula(idJaula,idAnimal);
                JOptionPane.showMessageDialog(null,"Animal adicionado com sucesso a jaula de modelo "+A.getJaula().getModelo());
                a = true;
            }
            
        } catch (SQLException e) {

            e.printStackTrace();
        }
        }

    } else {
            JOptionPane.showMessageDialog(null,"Não há espaço para adicionar o animal no modelo de jaula selecionado");
            a = false;
        }
      
        return a;
    }

        public boolean removerAnimal(int idAnimal){
            sql = "DELETE FROM animais WHERE idanimal = ?";
            a = false;
            int modelo = auxiliar.selecionaModelo(idAnimal);
            if(auxiliar.removerModelo(modelo)){
                try {
                PreparedStatement instrucao = conectar.prepareStatement(sql);
                instrucao.setInt(1, idAnimal);
                int linhasAfetadas = instrucao.executeUpdate();
                if(linhasAfetadas > 0){
                    return a = true;
                }


            } catch (SQLException e) {
                e.printStackTrace();
            }
            }
            
            return a;
            
        }

        public void imprimirAnimal(int idAnimal){
            sql = "SELECT animais.*, jaulas.modelo AS modelo, jaulas.descricao AS descricao FROM animais INNER JOIN jaulas ON animais.idanimal = jaulas.animalid WHERE idanimal = ?";
            try {
                PreparedStatement instrucao = conectar.prepareStatement(sql);
                instrucao.setInt(1, idAnimal);
                ResultSet consulta = instrucao.executeQuery();
                while(consulta.next()){
                  int animalId = consulta.getInt("idAnimal");
                  double peso = consulta.getDouble("peso");
                  int membros = consulta.getInt("membros");
                  int idade = consulta.getInt("idade");
                  String nome = consulta.getString("nome");
                  String tipoDoAnimal = consulta.getString("tipo");
                  String corDaPena = consulta.getString("cor_da_pena");
                  String corDasEscamas = consulta.getString("cor_das_escamas");
                  String corDoPelo = consulta.getString("cor_do_pelo");
                  int gestacao = consulta.getInt("gestacao");
                  int idAnimalJaula = consulta.getInt("jaulaid");
                  int modelo = consulta.getInt("modelo");
                  String descricaoJaula = consulta.getString("descricao");
                  if(tipoDoAnimal.equals("Anfibio")){
                    JOptionPane.showMessageDialog(null, "DADOS DO ANIMAL\nID do animal: "+animalId+"\nTipo do animal: "+tipoDoAnimal+"\nPeso do animal: "+peso+"\nQuantidade de membros: "+membros+"\nIdade do animal: "+idade+"\nNome do animal: "+nome+"\n\nDADOS DA JAULA\nID da jaula: "+idAnimalJaula+"\nModelo da jaula: "+modelo+"\nDescricao da jaula: \n"+descricaoJaula);
                  } else if(tipoDoAnimal.equals("Ave")){
                    JOptionPane.showMessageDialog(null, "DADOS DO ANIMAL\nID do animal: "+animalId+"\nTipo do animal: "+tipoDoAnimal+"\nPeso do animal: "+peso+"\nQuantidade de membros: "+membros+"\nIdade do animal: "+idade+"\nCor das penas: "+corDaPena+"\nNome do animal: "+nome+"\n\nDADOS DA JAULA\nID da jaula: "+idAnimalJaula+"\nModelo da jaula: "+modelo+"\nDescricao da jaula: \n"+descricaoJaula);
                  } else if(tipoDoAnimal.equals("Mamifero")){
                    JOptionPane.showMessageDialog(null, "DADOS DO ANIMAL\nID do animal: "+animalId+"\nTipo do animal: "+tipoDoAnimal+"\nPeso do animal: "+peso+"\nQuantidade de membros: "+membros+"\nIdade do animal: "+idade+"\nCor dos pelos: "+corDoPelo+"\nTempo de gestação: "+gestacao+"\nNome do animal: "+nome+"\n\nDADOS DA JAULA\nID da jaula: "+idAnimalJaula+"\nModelo da jaula: "+modelo+"\nDescricao da jaula: \n"+descricaoJaula);
                  } else if(tipoDoAnimal.equals("Peixe")){
                    JOptionPane.showMessageDialog(null, "DADOS DO ANIMAL\nID do animal: "+animalId+"\nTipo do animal: "+tipoDoAnimal+"\nPeso do animal: "+peso+"\nQuantidade de membros: "+membros+"\nIdade do animal: "+idade+"\nCor das escamas: "+corDasEscamas+"\nNome do animal: "+nome+"\n\nDADOS DA JAULA\nID da jaula: "+idAnimalJaula+"\nModelo da jaula: "+modelo+"\nDescricao da jaula: \n"+descricaoJaula);
                  } else if(tipoDoAnimal.equals("Reptil")){
                    JOptionPane.showMessageDialog(null, "DADOS DO ANIMAL\nID do animal: "+animalId+"\nTipo do animal: "+tipoDoAnimal+"\nPeso do animal: "+peso+"\nQuantidade de membros: "+membros+"\nIdade do animal: "+idade+"\nCor das escamas: "+corDasEscamas+"\nNome do animal: "+nome+"\n\nDADOS DA JAULA\nID da jaula: "+idAnimalJaula+"\nModelo da jaula: "+modelo+"\nDescricao da jaula: \n"+descricaoJaula);
                  }
                  
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void imprimirAnimais(){
            sql = "SELECT animais.*, jaulas.modelo AS modelo, jaulas.descricao AS descricao FROM animais INNER JOIN jaulas ON animais.idanimal = jaulas.animalid";
            try {
                PreparedStatement instrucao = conectar.prepareStatement(sql);
                ResultSet consulta = instrucao.executeQuery();
                while(consulta.next()){
                  int animalId = consulta.getInt("idAnimal");
                  double peso = consulta.getDouble("peso");
                  int membros = consulta.getInt("membros");
                  int idade = consulta.getInt("idade");
                  String nome = consulta.getString("nome");
                  String tipoDoAnimal = consulta.getString("tipo");
                  String corDaPena = consulta.getString("cor_da_pena");
                  String corDasEscamas = consulta.getString("cor_das_escamas");
                  String corDoPelo = consulta.getString("cor_do_pelo");
                  int gestacao = consulta.getInt("gestacao");
                  int idAnimalJaula = consulta.getInt("jaulaid");
                  int modelo = consulta.getInt("modelo");
                  String descricaoJaula = consulta.getString("descricao");
                  if(tipoDoAnimal.equals("Anfibio")){
                    JOptionPane.showMessageDialog(null, "DADOS DO ANIMAL\nID do animal: "+animalId+"\nTipo do animal: "+tipoDoAnimal+"\nPeso do animal: "+peso+"\nQuantidade de membros: "+membros+"\nIdade do animal: "+idade+"\nNome do animal: "+nome+"\n\nDADOS DA JAULA\nID da jaula: "+idAnimalJaula+"\nModelo da jaula: "+modelo+"\nDescricao da jaula: \n"+descricaoJaula);
                  } else if(tipoDoAnimal.equals("Ave")){
                    JOptionPane.showMessageDialog(null, "DADOS DO ANIMAL\nID do animal: "+animalId+"\nTipo do animal: "+tipoDoAnimal+"\nPeso do animal: "+peso+"\nQuantidade de membros: "+membros+"\nIdade do animal: "+idade+"\nCor das penas: "+corDaPena+"\nNome do animal: "+nome+"\n\nDADOS DA JAULA\nID da jaula: "+idAnimalJaula+"\nModelo da jaula: "+modelo+"\nDescricao da jaula: \n"+descricaoJaula);
                  } else if(tipoDoAnimal.equals("Mamifero")){
                    JOptionPane.showMessageDialog(null, "DADOS DO ANIMAL\nID do animal: "+animalId+"\nTipo do animal: "+tipoDoAnimal+"\nPeso do animal: "+peso+"\nQuantidade de membros: "+membros+"\nIdade do animal: "+idade+"\nCor dos pelos: "+corDoPelo+"\nTempo de gestação: "+gestacao+"\nNome do animal: "+nome+"\n\nDADOS DA JAULA\nID da jaula: "+idAnimalJaula+"\nModelo da jaula: "+modelo+"\nDescricao da jaula: \n"+descricaoJaula);
                  } else if(tipoDoAnimal.equals("Peixe")){
                    JOptionPane.showMessageDialog(null, "DADOS DO ANIMAL\nID do animal: "+animalId+"\nTipo do animal: "+tipoDoAnimal+"\nPeso do animal: "+peso+"\nQuantidade de membros: "+membros+"\nIdade do animal: "+idade+"\nCor das escamas: "+corDasEscamas+"\nNome do animal: "+nome+"\n\nDADOS DA JAULA\nID da jaula: "+idAnimalJaula+"\nModelo da jaula: "+modelo+"\nDescricao da jaula: \n"+descricaoJaula);
                  } else if(tipoDoAnimal.equals("Reptil")){
                    JOptionPane.showMessageDialog(null, "DADOS DO ANIMAL\nID do animal: "+animalId+"\nTipo do animal: "+tipoDoAnimal+"\nPeso do animal: "+peso+"\nQuantidade de membros: "+membros+"\nIdade do animal: "+idade+"\nCor das escamas: "+corDasEscamas+"\nNome do animal: "+nome+"\n\nDADOS DA JAULA\nID da jaula: "+idAnimalJaula+"\nModelo da jaula: "+modelo+"\nDescricao da jaula: \n"+descricaoJaula);
                  }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public String getTipo(int idAnimal){
            sql = "SELECT tipo FROM animais WHERE idAnimal = ?";
            String tipoDoAnimal = new String();
            try {
                PreparedStatement instrucao = conectar.prepareStatement(sql);
                instrucao.setInt(1, idAnimal);
                ResultSet consulta = instrucao.executeQuery();
                while(consulta.next()){
                    tipoDoAnimal = consulta.getString("tipo");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return tipoDoAnimal;
        }

        public int gestacaoDoAnimal(int idAnimal){
            int gestacaoDoAnimal = auxiliar.getGestacao(idAnimal);
            return gestacaoDoAnimal;
        }
}
