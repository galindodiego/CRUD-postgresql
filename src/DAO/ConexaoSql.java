/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class ConexaoSql {

    Connection conn = null;
    String url = "jdbc:postgresql://localhost:5432/empresa";

    String usuario = "postgres";
    String password = "123";

//    public void conectar() {
//        try {
//            Class.forName("org.postgresql.Driver");
//            conn = DriverManager.getConnection(url, usuario, password);
//            JOptionPane.showMessageDialog(null, "Conectado", "conexão", JOptionPane.INFORMATION_MESSAGE);
//        } catch (Exception erro) {
//            JOptionPane.showMessageDialog(null, "Error ao Conectar", erro + "conexão", JOptionPane.ERROR_MESSAGE);
//        }
//    }

    
      public Connection conectar() {
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, usuario, password);
      //    JOptionPane.showMessageDialog(null, "Conectado", "conexão", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Error ao Conectar", erro + "conexão", JOptionPane.ERROR_MESSAGE);
        }
        return conn;
    }
    
    
    public void desconectar() {
        try {
            JOptionPane.showMessageDialog(null, "Desconectado", "desconectado", JOptionPane.INFORMATION_MESSAGE);
            conn.close();
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Error ao Desconectar", erro + "desconectado", JOptionPane.ERROR_MESSAGE);
        }
    }
}
