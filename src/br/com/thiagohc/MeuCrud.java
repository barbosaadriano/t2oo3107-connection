/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.thiagohc;

import br.com.adrianob.CrudInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thiag
 */
public class MeuCrud implements CrudInterface {

    private Connection conn;

    public MeuCrud(Connection conn) {
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
            for (int i = 1; i < 6; i++) {
                PreparedStatement ps = conn.prepareStatement("insert into pessoa(nome) values('Thiago" + i + "');");
                ps.executeUpdate();
            }

        } catch (SQLException ex) {
            Logger.getLogger(MeuCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update() {
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("update pessoa set nome = 'João' Where nome = 'Thiago1'");
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MeuCrud.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void delete() {
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("delete from pessoa where id = 1;");
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MeuCrud.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
