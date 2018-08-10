
package br.com.foo;

import br.com.adrianob.CrudInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author drink
 */
public class Bar implements CrudInterface{

    private Connection conn;

    public Bar(Connection conn) {
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
