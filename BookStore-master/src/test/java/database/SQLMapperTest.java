/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import database.SQLMapper;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author casper
 */
public class SQLMapperTest {

    @Test
    public void selectAllTest() throws SQLException, ClassNotFoundException, IOException {
        ArrayList<HashMap<String, Object>> bookList = new SQLMapper().selectAll("title");

        assertFalse(bookList.isEmpty());
        assertTrue(bookList.get(0).get("title").equals("Don Quixote"));

    }

    @Test
    public void selectSearchTest() throws SQLException, ClassNotFoundException, IOException {

        ArrayList<HashMap<String, Object>> books = new SQLMapper().selectSearch("The Great Gatsby", "title");

        assertTrue(books.get(0).get("title").equals("The Great Gatsby"));

    }

    @Test
    public void createOrderTest() throws SQLException, ClassNotFoundException, IOException {
        
        SQLMapper mapper = new SQLMapper();
        //mapper.createOrder("Casper", "Prejler", "prejler93@gmail.com", 1);
       
        
       
    }

}
