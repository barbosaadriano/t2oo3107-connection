/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.marlenis;

import br.com.adrianob.CrudInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marlon
 */
public class Crud implements CrudInterface {
    
    private Connection conn;

    public Crud(Connection conn) {
        this.conn = conn;
    }
    
    

    @Override
    public void retriveAll() {
        try {
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM pessoa");
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                String nome = res.getString("nome");
                System.out.println(nome);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void insert() {
        try {PreparedStatement ps = this.conn.prepareStatement("INSERT INTO pessoa (nome) VALUES (?),(?),(?);");
        ps.setString(1, "MARLON");
        ps.setString(2, "POSSATTI");
        ps.setString(3, "VICTORIA");
        ps.executeUpdate();
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
    }

    @Override
    public void update() {
        try {PreparedStatement ps = this.conn.prepareStatement("UPDATE pessoa SET nome = \"FOI UPDATE\" WHERE nome = \"MARLON\";");
          ps.executeUpdate();
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
    }

    @Override
    public void delete() {
        try {PreparedStatement ps = this.conn.prepareStatement("DELETE FROM pessoa WHERE nome = \"FOI UPDATE\";");
            ps.executeUpdate();
            } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
    }
    
}
