package br.com.lucasj;

import br.com.adrianob.CrudInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class iCRUD implements CrudInterface {

    private Connection classConn;

    public iCRUD(Connection con) {
        this.classConn = con;
    }

    @Override
    public void retriveAll() {
        try {
            PreparedStatement ps = classConn.prepareStatement("select * from pessoa;");
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                System.out.println(res.getString("nome"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(iCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void insert() {
        try {
            for (int i = 1; i < 6; i++) {
                PreparedStatement ps = classConn.prepareStatement("insert into pessoa(nome) values('Agente00" + i + "');");
                ps.executeUpdate();
            }

        } catch (SQLException ex) {
            Logger.getLogger(iCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update() {
        PreparedStatement ps;
        try {
            ps = classConn.prepareStatement("update pessoa set nome = 'UPDATED SEM WHERE!';");
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(iCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void delete() {
        PreparedStatement ps;
        try {
            ps = classConn.prepareStatement("delete from pessoa where id = 3;");
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(iCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
