package DAOZoologico;

import java.sql.*;

import Jaulas.Jaula;

public class DAOJaulas {
    private Connection conectar = ConexaoPostgreSQL.getInstancia().getConexao();
    private String sql;

    public int AdicionaJaula(Jaula j){
        sql = "INSERT INTO jaulas (modelo, descricao) VALUES (?,?)";
        int idJaula = 0;
        try {
            PreparedStatement instrucao = conectar.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            instrucao.setInt(1, j.getModelo());
            instrucao.setString(2, j.descrição());
            int linhas = instrucao.executeUpdate();
            if(linhas > 0){
                ResultSet consulta = instrucao.getGeneratedKeys();
                if(consulta.next()){
                    idJaula = consulta.getInt(1);
                }
                
            } else {
                System.out.println("Não foi possivel adicionar a jaula");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(idJaula);
        return idJaula;
    }



}
