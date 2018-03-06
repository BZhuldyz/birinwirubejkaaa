package kz.kaznitu.lessons.models;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long book_id;
    private String book_name;
    private int years;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    public Book() {
    }

    public Book(String book_name, int years, Author author) {
        this.book_name = book_name;
        this.years = years;
        this.author = author;
    }

    public long getBook_id() {
        return book_id;
    }

    public void setBook_id(long book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }


    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
