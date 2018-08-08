/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.adrianob;

import br.com.LunaIzahR.Classcrud;
import br.com.foo.Bar;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 *
 * @author drink
 */
public class Sample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Properties config = new Properties();
        config.put("user", "root");
        config.put("password", "root");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn
                    = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/singletton",
                            config
                    );
            CrudInterface crud = new Classcrud(conn);
            crud.retriveAll();
            crud.insert();
            crud.update();
            crud.delete();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
