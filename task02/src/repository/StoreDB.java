package repository;

import model.Book;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class StoreDB implements CRUD{
    private Map<String, Book> db = new ConcurrentHashMap<>();

    public void add(Book book){
        db.put(book.getISBN(), book);
    }

    public Book update(Book book){
        Book bookFromDB = db.get(book.getISBN());
        if(!book.equals(bookFromDB)){
            db.put(book.getISBN(), book);
        }
        return book;
    }

    public void remove(String isbn){
        db.remove(isbn);
    }

    public Book getByKey(String isbn){
        return db.get(isbn);
    }

    public List<Book> getAll(){
        return new ArrayList<>(db.values());
    }
}
