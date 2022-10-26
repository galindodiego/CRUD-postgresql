/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Diego
 */
public class ConexaoSql {

    Connection conexao;

    PreparedStatement pst = null;
    ResultSet rs = null;
    public boolean ok;
    public Connection conectar() {
        String url = "jdbc:postgresql://localhost:5432/empresa";
        String usuario = "postgres";
        String password = "123";
        String driver = "org.postgresql.Driver";
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, usuario, password);
            ok = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error ao conectar" + e.getStackTrace());
            ok = false;
        }
        return conexao;
    }
}
