package service;

import model.Book;
import repository.CRUD;
import repository.StoreDB;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BookStore implements Store{

    private CRUD dbCrud = new StoreDB();

    @Override
    public boolean add(Book o) {
        if(dbCrud.getAll().contains(o)){
            return false;
        }
        dbCrud.add(o);
        return true;
    }

    @Override
    public void remove(Book o) {
        if(dbCrud.getAll().contains(o)){
            dbCrud.remove(o.getISBN());
            System.out.println("Successfully removed Book with ISBN: " + o.getISBN());
        }else{
            System.out.println("Book does not exist");
        }
    }

    @Override
    public List<Book> getAllBooksByAuthor(String author) {
        return dbCrud.getAll().stream().filter(b -> b.getAuthor().equals(author)).toList();
    }

    @Override
    public List<Book> getAllBooksPublishedAfter(LocalDate from) {
        return dbCrud.getAll().stream().filter(b -> b.getPublishDate().isAfter(from)).toList();
    }

    @Override
    public List<Book> getAllBooksBetween(LocalDate from, LocalDate to) {
        return dbCrud.getAll().stream().filter(b -> b.getPublishDate().isAfter(from) && b.getPublishDate().isBefore(to)).toList();
    }

    @Override
    public void clear() {
        for (Book book : dbCrud.getAll()) {
            dbCrud.remove(book.getISBN());
        }
    }

    @Override
    public Map<String, List<Book>> getAllBooksGroupByAuthor() {
        return dbCrud.getAll().stream().collect(Collectors.groupingBy(Book::getAuthor));
    }

    @Override
    public Map<String, List<Book>> getAllBooksGroupByPublisher() {
        return dbCrud.getAll().stream().collect(Collectors.groupingBy(Book::getPublisher));
    }

    @Override
    public List<Book> getAllBooksFilterBy(Predicate<Book> bookPredicate) {
        return dbCrud.getAll().stream().filter(bookPredicate).toList();
    }
}
