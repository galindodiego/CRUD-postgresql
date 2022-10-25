/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.EmpregadoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import DTO.EmpregadoDTO;
import VIEW.pesquisar;

/**
 *
 * @author Diego
 */
public class Crudsql extends ConexaoSql {

    PreparedStatement pstm;
    ConexaoSql con = new ConexaoSql();
    Connection conn;
    ResultSet rs;
   // EmpregadoDTO objEmpregadoDto;

    public void insert(EmpregadoDTO objEmpregadoDto) {
        try {
            Connection conexao = conectar();
            String sql = "insert into empregados(nome,sobrenome,funcao) values(?,?,?)";

            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, objEmpregadoDto.getNome());
            pstm.setString(2, objEmpregadoDto.getSobrenome());
            pstm.setString(3, objEmpregadoDto.getFuncao());
            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(null, "Empregado registrado");
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Error ao cadastrar Empregado " + erro);
        }
    }

    public void select(EmpregadoDTO objEmpregadoDto) {
        try {
            Connection conexao = conectar();
            String sql = "select * from empregados where id_empregado = ?";
            pstm = conexao.prepareStatement(sql);
        
            pstm.setInt(1, objEmpregadoDto.getIdempregado());
            rs = pstm.executeQuery();
            
            if (rs.next()) {
                objEmpregadoDto.setIdempregado(rs.getInt("id_empregado"));
                objEmpregadoDto.setNome(rs.getString("nome"));
                objEmpregadoDto.setSobrenome(rs.getString("sobrenome"));
                objEmpregadoDto.setFuncao(rs.getString("funcao"));
                
            }else{
                objEmpregadoDto.setIdempregado(0);
                objEmpregadoDto.setNome("");
                objEmpregadoDto.setNome("");
                objEmpregadoDto.setNome("");
                JOptionPane.showMessageDialog(null, "Registro não encontrado ");
            }
            pstm.close();
            conexao.close();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Error ao buscar empregado " + erro);

        }
    }
}
