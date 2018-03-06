package kz.kaznitu.lessons.models;

import javax.persistence.*;

@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String email;
    private int phone;
    private String address;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public Publisher() {
    }

    public Publisher(String name, String email, int phone, String address, Book book) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.book = book;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
