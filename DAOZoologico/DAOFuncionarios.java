package DAOZoologico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

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

    public void imprimirFuncionario(int matriculaFunc){
        sql = "SELECT funcionarios.*, salas.numero_da_sala AS numero_da_sala, salas.setor AS setor FROM funcionarios INNER JOIN salas ON funcionarios.sala = salas.numero_da_sala WHERE matricula = ?";
        PreparedStatement instrucao;
        try {
            instrucao = conectar.prepareStatement(sql);
            instrucao.setInt(1,matriculaFunc);
            ResultSet consulta = instrucao.executeQuery();
            while(consulta.next()){
                String nome = consulta.getString("nome");
                String cargo = consulta.getString("cargo");
                int matriculaFuncionario = consulta.getInt("matricula");
                double salario = consulta.getDouble("salario_base");
                int numeroDaSala = consulta.getInt("numero_da_sala");
                int setor = consulta.getInt("setor");
                JOptionPane.showMessageDialog(null, "Nome do funcionario: "+nome+"\nCargo: "+cargo+"\nMatricula do funcionario: "+matriculaFuncionario+"\nSalario: "+salario+"\nNumero da sala: "+numeroDaSala+"\nSetor: "+setor+"\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
                
    }

    public void imprimirFuncionarios(){
        sql = "SELECT funcionarios.*, salas.numero_da_sala AS numero_da_sala, salas.setor AS setor FROM funcionarios INNER JOIN salas ON funcionarios.sala = salas.numero_da_sala ";
        PreparedStatement instrucao;
        try {
            instrucao = conectar.prepareStatement(sql);
            ResultSet consulta = instrucao.executeQuery();
            while(consulta.next()){
                String nome = consulta.getString("nome");
                String cargo = consulta.getString("cargo");
                int matriculaFuncionario = consulta.getInt("matricula");
                double salario = consulta.getDouble("salario_base");
                int numeroDaSala = consulta.getInt("numero_da_sala");
                int setor = consulta.getInt("setor");
                JOptionPane.showMessageDialog(null, "Nome do funcionario: "+nome+"\nCargo: "+cargo+"\nMatricula do funcionario: "+matriculaFuncionario+"\nSalario: "+salario+"\nNumero da sala: "+numeroDaSala+"\nSetor: "+setor+"\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
                
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
