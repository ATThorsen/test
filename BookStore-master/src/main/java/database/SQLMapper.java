/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author casper
 */
public class SQLMapper {
    
    
    
    public ArrayList<HashMap<String, Object>> selectAll(String filter) throws SQLException, ClassNotFoundException, IOException{
        DataBase db = new DataBase();
        ArrayList<HashMap<String,Object>> bookList = new ArrayList<>();
        
        db.connection();
        Connection connection = db.connection();
    try{
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(("SELECT * FROM books ORDER BY " +filter));
        while(result.next()){
            HashMap<String, Object> book = new HashMap<>();
            book.put("title",result.getString("title"));
            book.put("author", result.getString("author"));
            book.put("stock", result.getInt("stock"));
            book.put("price", result.getDouble("price"));
            book.put("id", result.getInt("id"));
            bookList.add(book);
        }
    }catch(SQLException ex){
        System.out.println(ex);
    }
        
        return bookList;
        
    }
    
    public ArrayList<HashMap<String, Object>> selectSearch(String search,String type ) throws SQLException, ClassNotFoundException, IOException{
        DataBase db = new DataBase();
        ArrayList<HashMap<String,Object>> bookList = new ArrayList<>();
        
        db.connection();
        Connection connection = db.connection();
    try{
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(("SELECT * FROM books WHERE " +type+ " LIKE \"%" + search+ "%\" ORDER BY title"));
        while(result.next()){
            HashMap<String, Object> book = new HashMap<>();
            book.put("title",result.getString("title"));
            book.put("author", result.getString("author"));
            book.put("stock", result.getInt("stock"));
            book.put("price", result.getDouble("price"));
            book.put("id", result.getInt("id"));
            bookList.add(book);
        }
    }catch(SQLException ex){
        System.out.println(ex);
    }
        
        return bookList;
        
    }
    
    public void createOrder(String firstName, String lastName, String email, int bookID) throws SQLException, ClassNotFoundException, IOException{
        DataBase db = new DataBase();
        Connection connection = db.connection();
        
        try{
            Statement st = connection.createStatement();
            String sql ="INSERT INTO orders(firstName, lastName, email, bookID)VALUES(?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, email);
            statement.setInt(4, bookID);
            statement.executeUpdate();
            
            
        }catch(SQLException e){
            System.out.println(e);
        }
    }
}
