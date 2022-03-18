package model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class Book {
    private String ISBN;
    private String title;
    private String author;
    private BigDecimal price;
    private String publisher;
    private LocalDate publishDate;

    public Book(String title, String author, BigDecimal price, String publisher) {
        this.ISBN = UUID.randomUUID().toString();
        this.title = title;
        this.author = author;
        this.price = price;
        this.publisher = publisher;
        this.publishDate = LocalDate.now();
    }

    Book(){
        this.ISBN = UUID.randomUUID().toString();
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getPublisher() {
        return publisher;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(ISBN, book.ISBN) && Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(price, book.price) && Objects.equals(publisher, book.publisher) && Objects.equals(publishDate, book.publishDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ISBN, title, author, price, publisher, publishDate);
    }

    @Override
    public String toString() {
        return "Book{" +
                "ISBN='" + ISBN + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", publisher='" + publisher + '\'' +
                ", publishDate=" + publishDate +
                '}';
    }
}
