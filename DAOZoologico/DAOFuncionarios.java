package DAOZoologico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Funcionarios.Veterinario;

public class DAOFuncionarios {
    String sql;
    private Connection conectar = ConexaoPostgreSQL.getInstancia().getConexao(); //Classe para estabelecer uma conexão ao banco de dados

    public Veterinario getVeterinario(int matricula){
    Veterinario vet = new Veterinario();
    sql = "SELECT * FROM funcionario WHERE matricula = ? AND cargo = 'veterinario'";
    try {
        PreparedStatement instrucao = conectar.prepareStatement(sql);
        instrucao.setInt(1, matricula);
        ResultSet consulta = instrucao.executeQuery();
        while(consulta.next()){
            int idDoVet = consulta.getInt("id");
            String nome = consulta.getString("nome");
            int matriculaVet = consulta.getInt("matricula");
            double salarioBase = consulta.getDouble("salario_base");
            vet = new Veterinario(nome, matricula, salarioBase, null, salarioBase, matriculaVet);
        }

        
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return vet;
    }
}
