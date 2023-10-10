package DAOZoologico;

import java.sql.*;

import Jaulas.Jaula;

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
            }
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    public void incrementaQuantidadeDoModelo(int modelo){

    }

}