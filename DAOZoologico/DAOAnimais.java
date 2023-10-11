package DAOZoologico;

import java.sql.*;

import javax.swing.JOptionPane;

import Animais.Animal;

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
        sql = "INSERT INTO animais (peso, membros, idade, nome,jaulaID) VALUES (?,?,?,?,?) RETURNING idAnimal";
        try {
            //Preparando o comando com os valores adequados para a tabela
            int idAnimal = 0;
            PreparedStatement instrucao = conectar.prepareStatement(sql);
            instrucao.setDouble(1, A.getPeso());
            instrucao.setInt(2, A.getMembros());
            instrucao.setInt(3, A.getIdade());
            instrucao.setString(4, A.getNome());
            instrucao.setInt(5, idJaula);
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
                  int idAnimalJaula = consulta.getInt("jaulaid");
                  int modelo = consulta.getInt("modelo");
                  String descricaoJaula = consulta.getString("descricao");

                  JOptionPane.showMessageDialog(null, "DADOS DO ANIMAL\nID do animal: "+animalId+" \nPeso do animal: "+peso+"\nQuantidade de membros: "+membros+"\nIdade do animal: "+idade+"\nNome do animal: "+nome+"\n\nDADOS DA JAULA\nID da jaula: "+idAnimalJaula+"\nModelo da jaula: "+modelo+"\nDescricao da jaula: \n"+descricaoJaula);
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
                  int idAnimalJaula = consulta.getInt("jaulaid");
                  int modelo = consulta.getInt("modelo");
                  String descricaoJaula = consulta.getString("descricao");

                  JOptionPane.showMessageDialog(null, "DADOS DO ANIMAL\nID do animal: "+animalId+" \nPeso do animal: "+peso+"\nQuantidade de membros: "+membros+"\nIdade do animal: "+idade+"\nNome do animal: "+nome+"\n\nDADOS DA JAULA\nID da jaula: "+idAnimalJaula+"\nModelo da jaula: "+modelo+"\nDescricao da jaula: \n"+descricaoJaula);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


}
