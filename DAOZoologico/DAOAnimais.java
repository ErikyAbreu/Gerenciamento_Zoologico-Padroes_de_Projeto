package DAOZoologico;

import java.sql.*;

import javax.swing.JOptionPane;

import Animais.Animal;

public class DAOAnimais {
    private String sql;
    private DAOAuxiliar auxiliar = new DAOAuxiliar();
    private DAOJaulas jaulas = new DAOJaulas();
    private Connection conectar = ConexaoPostgreSQL.getInstancia().getConexao();

    public boolean adicionaAnimal(Animal A){
        boolean a = false;
        if(auxiliar.verificaModeloDeJaula(A.getJaula().getModelo())){
        int idJaula = jaulas.AdicionaJaula(A.getJaula());
        sql = "INSERT INTO animais (peso, membros, idade, nome,jaulaID) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement instrucao = conectar.prepareStatement(sql);
            instrucao.setDouble(1, A.getPeso());
            instrucao.setInt(2, A.getMembros());
            instrucao.setInt(3, A.getIdade());
            instrucao.setString(4, A.getNome());
            instrucao.setInt(5, idJaula);
            int linhasAfetadas = instrucao.executeUpdate();
            if(linhasAfetadas > 0){
                JOptionPane.showMessageDialog(null,"Animal adicionado com sucesso a jaula de modelo "+A.getJaula().getModelo());
                a = true;
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        //preciso do modelo da jaula e uma jaula pronta para inserir o jaulaID 
        //Mas antes eu preciso saber o modelo da jaula para saber se vai ser possivel adicionar o animal em tal modelo (verificar quantidade de jaulas ocupadas no banco)
        } else {
            JOptionPane.showMessageDialog(null,"Não há espaço para adicionar o animal no modelo de jaula selecionado");
            a = false;
        }
        
        return a;
    }
}
