package DAOZoologico;

import java.sql.*;

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

}