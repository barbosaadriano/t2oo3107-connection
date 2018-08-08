/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.LunaIzahR;

import br.com.adrianob.CrudInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author izahR
 */
public class Classcrud implements CrudInterface {

    private Connection conn;

    public Classcrud(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void retriveAll() {
        try {
            PreparedStatement ps = this.conn.prepareStatement("select * from pessoa");
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
        try {
            PreparedStatement ps = this.conn.prepareStatement("insert into pessoa(nome) values('ananda')");
            ps.executeUpdate(); 
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void update() {
        try {
            PreparedStatement ps = this.conn.prepareStatement("update pessoa set nome = 'flavia' where nome = 'ananda'");
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void delete() {
        try {
            PreparedStatement ps = this.conn.prepareStatement("delete from pessoa where nome = 'zé'");
            ps.executeUpdate(); 
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
