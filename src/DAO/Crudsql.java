/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.FuncionarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
/**
 *
 * @author Diego
 */
public class Crudsql {
    

    PreparedStatement pstm;
    ConexaoSql con = new ConexaoSql();
    Connection conn;

    public void insert(FuncionarioDTO objFuncionarioDto) {
        try {
            Connection conexao = new ConexaoSql().conectar();
            String url = "insert into empregados(nome,sobrenome,funcao) values(?,?,?)";
            
            pstm =conexao.prepareStatement(url);
            pstm.setString(1, objFuncionarioDto.getNome());
            pstm.setString(2, objFuncionarioDto.getSobrenome());
            pstm.setString(3,objFuncionarioDto.getFuncao());
            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(null, "Funcionário registrado");
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Error ao cadastrar funcionário "+erro);
        }
    }
}
