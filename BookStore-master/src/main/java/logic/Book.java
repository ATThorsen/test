/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.Serializable;

/**
 *
 * @author casper
 */
public class Book implements Serializable {
    private final int id;
    private final String title;
    private final String author;
    private final double price;
    private final int qty;

    public Book(int id, String title, String author, double price, int qty) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.qty = qty;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    @Override
    public String toString() {
        return "Book{" + "title=" + title + ", author=" + author + ", price=" + price + ", id=" + id + '}';
    }
    
    
    
    
    
    
}
