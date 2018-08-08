/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.thallyscalory;

import br.com.adrianob.CrudInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class MeuCrud implements CrudInterface{
    
    private Connection connect;

    public MeuCrud(Connection connect) {
        this.connect = connect;
    }

    @Override
    public void retriveAll() {
        try {
            PreparedStatement ps = this.connect.prepareStatement("select * from pessoa");
            ResultSet result = ps.executeQuery();
            
            while (result.next()) {
                String id = result.getString("id");
                String nome = result.getString("nome");
                System.out.println(id + ' ' +nome);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void insert() {
        try {
            PreparedStatement ps = this.connect.prepareStatement("insert into pessoa (nome) values (?)");
            ps.setString(1, "Fulano");
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void update() {
        try {
            PreparedStatement ps = this.connect.prepareStatement("update pessoa set nome = ? where id = ?;");
            ps.setString(1, "maria");
            ps.setInt(2, 2);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }

    @Override
    public void delete() {
       PreparedStatement ps;
        try {
            ps = this.connect.prepareStatement("delete from pessoa where id = ?;");
            ps.setInt(1, 1);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       
    }
    
}
