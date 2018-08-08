package br.com.pedroenju;

import br.com.adrianob.CrudInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Pedro Smith Enju
 */
public class Principal implements CrudInterface {

    private Connection conn;

    public Principal(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void retriveAll() {

        try {
            PreparedStatement ps = this.conn.prepareStatement("select * from Pessoa");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                String nome = rs.getString("nome");
                System.out.println(nome);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public void insert() {
        
        try {
            PreparedStatement ps = this.conn.prepareStatement("insert into Pessoa (nome) values (?)"); 
            ps.setString(1, "PEDRO H");
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }  
    }

    @Override
    public void update() {
        try {
            PreparedStatement ps = this.conn.prepareStatement("update Pessoa set nome = ? where id = ?");
            ps.setString(1, "PEDRO E");
            ps.setInt(2, 8);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void delete() {
        
        try {
            PreparedStatement ps = this.conn.prepareStatement("delete from Pessoa where id = ?");
            ps.setInt(1, 8);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }

}
