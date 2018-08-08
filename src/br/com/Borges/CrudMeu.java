/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Borges;

import br.com.adrianob.CrudInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Erica
 */
public class CrudMeu implements CrudInterface{

    private Connection conn; 

    public CrudMeu(Connection conn) {
        this.conn = conn;
    }
    
    @Override //sobrescreve o metodo da classe 'PAI' que está sendo implementada
    public void retriveAll() {
        try {
            PreparedStatement ps = this.conn.prepareStatement("select * from pessoa");
            ResultSet res = ps.executeQuery();
            
            while (res.next()) {
                String nome = res.getString("nome"); //retorna o valor da linha nome no BD
                System.out.println(nome);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void insert() {
          try {
            PreparedStatement ps = this.conn.prepareStatement("insert into pessoa(nome) values('erica') ");
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void update() {
        try {
            PreparedStatement ps = this.conn.prepareStatement("update pessoa set nome = 'Borges' where nome = 'erica'");
            ps.executeUpdate();
        }
        catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void delete() {
         try {
            PreparedStatement ps = this.conn.prepareStatement("delete from pessoa where nome = 'Eu' ");
            ps.executeUpdate();
         }
        catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    
}
