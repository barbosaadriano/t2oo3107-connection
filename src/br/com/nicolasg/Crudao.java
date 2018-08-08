package br.com.nicolasg;

import br.com.adrianob.CrudInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Crudao implements CrudInterface{

    private Connection conn;

    public Crudao(Connection conn) {
        this.conn = conn;
    }
    
    
    @Override
    public void retriveAll() {
        try {
            PreparedStatement ps = this.conn.prepareStatement("select * from pessoa");
            ResultSet res = ps.executeQuery();
            
            while(res.next()){
                String nome = res.getString("nome");
                System.out.println(nome);
            }
                            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void insert() {
        try{
            PreparedStatement ps=this.conn.prepareStatement("insert into pessoa (nome) values (?)");
            ps.setString(1, "PO");
            ps.executeUpdate();
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    
    }

    @Override
    public void update() {
        try{
            PreparedStatement ps = this.conn.prepareStatement("update pessoa set nome = ? where nome = ? ");
            ps.setString(1, "ABC");
            ps.setString(2, "Fulano");
            ps.executeUpdate();
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void delete() {
        try {
            PreparedStatement ps = this.conn.prepareStatement("delete from pessoa where nome = ?");
            ps.setString(1, "ABC");
            ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
}
