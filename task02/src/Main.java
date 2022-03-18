import model.Book;
import service.BookStore;
import service.Store;

import java.util.List;
import java.math.BigDecimal;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Store bookStore = new BookStore();

        Book got = new Book("Game of thrones", "George RR Martin", new BigDecimal(12.50), "Nero");
        Book got2 = new Book("Song of Ice and Fire", "George RR Martin", new BigDecimal(12.50), "Nero");
        Book lotr = new Book("Lord of the Rings", "Tolkien", new BigDecimal(15), "Paramount");
        Book hobbit = new Book("The Hobbit", "Tolkien", new BigDecimal(17.50), "BH");

        bookStore.add(got);
        bookStore.add(lotr);
        bookStore.add(hobbit);
        bookStore.add(got2);

        Map<String, List<Book>> list = bookStore.getAllBooksGroupByAuthor();
        for (String author: list.keySet()){
            System.out.println(author);
            for (Book b: list.get(author)){
                System.out.println(b);
            }
        }

    }
}
