package oops;

public class Book {
	 
    String name;
    String author;
    long isbn;
    float price;
   
 
    public Book(String name, String author, long isbn, float price) {
        this.name = name;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
    }
 
 public String toString() {
        return name + "\t" + author + "\t" + isbn + "\t" + ": Rs" + price;
  }
 
}
