/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import com.sun.jdi.connect.Connector;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author casper
 */
public class DataBase {

    /*
    public Connection connection() {
        Connection connection = null;
        try {
            String DRIVER = "com.mysql.cj.jdbc.Driver";
            String user = "root";
            String password = "Rootprejler1";
            String IP = "localhost";
            String PORT = "3306";
            String DATABASE = "test";
            String url = "jdbc:mysql://" + IP + ":" + PORT + "/" + DATABASE
                    + "?useUnicode=true&useJDBCcompliantTimezoneShift=true&"
                    + "useLegacyDatetimeCode=false&"
                    + "serverTimezone=UTC";
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(url, user, password);

        } catch (Exception e) {
            System.out.println(e);
        }
        
        return connection;
    }
     */
    public Connection connection() throws SQLException, FileNotFoundException, ClassNotFoundException, IOException {
        
        try {
            //InputStream input = DataBase.class.getClassLoader().getResourceAsStream("/database.properties");
            Properties props = new Properties();
            //FileInputStream f = new FileInputStream("/database.database.properties"); 
            FileInputStream f = new FileInputStream("/Users/casper/Documents/NetBeansProjects/BookShop/src/main/java/database/database.properties");
            
            // load the properties file
            props.load(f);

            // assign db parameters
            String driver = props.getProperty("jdbc.driver");
            if (driver != null) {
                Class.forName(driver);
                String url = props.getProperty("jdbc.url");
                String user = props.getProperty("jdbc.username");
                String password = props.getProperty("jdbc.password");

                // create a connection to the database
                Connection connection = DriverManager.getConnection(url, user, password);
                return connection;
            }
        } catch (FileNotFoundException e) {
            throw new Error("Properties file not found");
        }
        throw new Error("Error in establishing conneciton");
    }
}
