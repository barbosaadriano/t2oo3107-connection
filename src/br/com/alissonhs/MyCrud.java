

package br.com.alissonhs;

import br.com.adrianob.CrudInterface;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jrockit.jfr.tools.ConCatRepository;

public class MyCrud implements CrudInterface{
    private Connection conn;
    public MyCrud(Connection conn) {
        this.conn = conn;
    }
    @Override
    public void retriveAll() {
        try {
            java.sql.PreparedStatement ps = this.conn.prepareStatement("select * from Pessoa");
            ResultSet res = ps.executeQuery();
            
            while (res.next()){
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
            java.sql.PreparedStatement ps = this.conn.prepareStatement("insert into pessoa (nome) values (?)");
            ps.setString(1, "Alisson");
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void update() {
        try {
            java.sql.PreparedStatement ps = this.conn.prepareStatement("update pessoa set nome = 'Pedro' where id = 1");
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }

    @Override
    public void delete() {
        System.out.println("Teste!");
    }
    
}
