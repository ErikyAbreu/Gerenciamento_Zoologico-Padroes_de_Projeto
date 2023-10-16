package DAOZoologico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Funcionarios.Funcionario;
import Funcionarios.Veterinario;

public class DAOFuncionarios {
    private String sql;
    private Connection conectar = ConexaoPostgreSQL.getInstancia().getConexao(); //Classe para estabelecer uma conexão ao banco de dados
    private boolean a;
    private DAOAuxiliar auxiliar = new DAOAuxiliar();

    public boolean addFuncionario(Funcionario f){
        a = false;
        int idSala = auxiliar.adicionaSalaParaFuncionario(f.getSala());
        int idFunc = 0;
        sql = "INSERT INTO funcionarios (nome,cargo,matricula,sala,salario_base) VALUES (?,?,?,?,?) RETURNING id";
        try {
            PreparedStatement instrucao = conectar.prepareStatement(sql);
            instrucao.setString(1, f.getNome());
            instrucao.setString(2, f.getClass().getSimpleName());
            instrucao.setInt(3, f.getMatricula());
            instrucao.setInt(4, idSala);
            instrucao.setDouble(5, f.getSalario_base());
            ResultSet consulta = instrucao.executeQuery();
            if(consulta.next()){
                idFunc = consulta.getInt("id");
                auxiliar.atualizaIdDaSala(idSala, idFunc);
                a = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    public boolean removerFuncionario(int matriculaFunc){
        sql = "DELETE FROM funcionarios WHERE matricula = ?";
            a = false;
           
                try {
                PreparedStatement instrucao = conectar.prepareStatement(sql);
                instrucao.setInt(1, matriculaFunc);
                int linhasAfetadas = instrucao.executeUpdate();
                if(linhasAfetadas > 0){
                    return a = true;
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            
            
            return a;
    }


    public Veterinario getVeterinario(int matricula){
    Veterinario vet = null;
    sql = "SELECT * FROM funcionarios WHERE matricula = ? AND cargo = 'Veterinario'";
    try {
        PreparedStatement instrucao = conectar.prepareStatement(sql);
        instrucao.setInt(1, matricula);
        ResultSet consulta = instrucao.executeQuery();
        if(consulta.next()){
           // int idDoVet = consulta.getInt("id");
            String nome = consulta.getString("nome");
            int matriculaVet = consulta.getInt("matricula");
            double salarioBase = consulta.getDouble("salario_base");
            vet = new Veterinario(nome, matricula, salarioBase, null, salarioBase, matriculaVet);
        } else {

        }

        
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return vet;
    }
}
