package DAOZoologico;

import java.sql.*;

import javax.swing.JOptionPane;

import Jaulas.Sala;

public class DAOAuxiliar{
    private String sql;
    private Connection conectar = ConexaoPostgreSQL.getInstancia().getConexao();

    public boolean verificaModeloDeJaula(int modelo){     
        sql = "SELECT COUNT(*) as quantidade FROM ControleDeJaulas WHERE modelo = ?";
        boolean a = true;
        try {
            PreparedStatement instrucao = conectar.prepareStatement(sql);
            instrucao.setInt(1, modelo);
            ResultSet consulta = instrucao.executeQuery();
            while(consulta.next()){
            int quantidadeUtilizada = consulta.getInt("quantidade");
            if(quantidadeUtilizada >= 20){
                a = false;
            } else {
                a = true;
                incrementaQuantidadeDoModelo(modelo);
                }
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    private void incrementaQuantidadeDoModelo(int modelo){
    sql = "UPDATE controledejaulas SET quantidadeUtilizada = quantidadeUtilizada + 1 WHERE modelo = ?";
    try {
        PreparedStatement instrucao = conectar.prepareStatement(sql);
        instrucao.setInt(1, modelo);
        instrucao.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    }

    private void decrementaQuantidadeModelo(int modelo){
        sql = "UPDATE controledejaulas SET quantidadeUtilizada = quantidadeUtilizada - 1 WHERE modelo = ?";
    try {
        PreparedStatement instrucao = conectar.prepareStatement(sql);
        instrucao.setInt(1, modelo);
        instrucao.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }

    public boolean removerModelo(int modelo){
        sql = "SELECT COUNT(*) as quantidade FROM ControleDeJaulas WHERE modelo = ?";
        boolean a = true;
         try {
            PreparedStatement instrucao = conectar.prepareStatement(sql);
            instrucao.setInt(1, modelo);
            ResultSet consulta = instrucao.executeQuery();
            while(consulta.next()){
            int quantidadeUtilizada = consulta.getInt("quantidade");
            if(quantidadeUtilizada > 0){
                a = true;
                decrementaQuantidadeModelo(modelo);
            } else {
                a = false;
                }
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    public int selecionaModelo(int idAnimal){
        int modelo = 0;
        sql = "SELECT jaulas.modelo FROM animais JOIN jaulas ON animais.jaulaid = jaulas.idjaula WHERE idanimal = ?";
        try {
            PreparedStatement instrucao = conectar.prepareStatement(sql);
            instrucao.setInt(1, idAnimal);
            ResultSet consulta = instrucao.executeQuery();
            while(consulta.next()){
                modelo = consulta.getInt("modelo");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return modelo;
    }

    public int getGestacao(int idAnimal){
        int gestacao = 0;
        sql = "SELECT CASE WHEN tipo = 'Mamifero' THEN gestacao END AS gestacao FROM animais WHERE idAnimal = ?";
        try {
            PreparedStatement instrucao = conectar.prepareStatement(sql);
            instrucao.setInt(1, idAnimal);
            ResultSet consulta = instrucao.executeQuery();
            while(consulta.next()){
               gestacao = consulta.getInt("gestacao");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return gestacao;
    }

    public int adicionaSalaParaFuncionario(Sala s){
        int idSala = 0;
        sql = "INSERT INTO salas (setor) VALUES (?)";
        try {
            PreparedStatement instrucao = conectar.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            instrucao.setInt(1, s.getSetor());
            int linhasAfetadas = instrucao.executeUpdate();
            if(linhasAfetadas > 0){
                ResultSet consulta = instrucao.getGeneratedKeys();
                if(consulta.next()){
                    idSala = consulta.getInt(1);
                }
            } else {
                JOptionPane.showMessageDialog(null,"Não foi possivel adicionar a sala");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idSala;
    }


    public void atualizaIdDaSala(int idSala, int idFunc){
        sql ="UPDATE salas SET funcionario = ? WHERE numero_da_sala = ?";
        try {
            PreparedStatement instrucao = conectar.prepareStatement(sql);
            instrucao.setInt(1, idFunc);
            instrucao.setInt(2, idSala);
            instrucao.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

}