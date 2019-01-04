package oops;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookShop implements Iterable<Book> {
	
	List<Book> avail_books;
	 
    public BookShop() {
        avail_books = new ArrayList<Book>();
    }
 
    public void addBook(Book book) {
        avail_books.add(book);
    }
 
    public Iterator<Book> iterator() {
        return (Iterator<Book>) new BookShopIterator();
    }
 
    class BookShopIterator implements Iterator<Book> {
        int currentIndex = 0;
 
        @Override
        public boolean hasNext() {
            if (currentIndex >= avail_books.size()) {
                return false;
            } else {
                return true;
            }
        }
 
        @Override
        public Book next() {
            return avail_books.get(currentIndex++);
        }
 
        @Override
        public void remove() {
            avail_books.remove(--currentIndex);
        }
 
    }
    
    //main method
    
  public static void main(String[] args) {
 
        Book book1 = new Book("Java", "JamesGosling", 123456, 1000.0f);
        Book book2 = new Book("Spring", "RodJohnson", 789123, 1500.0f);
        Book book3 = new Book("Struts", "Apache    ", 456789, 800.00f);
 
        BookShop avail_books = new BookShop();
        avail_books.addBook(book1);
        avail_books.addBook(book2);
        avail_books.addBook(book3);
        
        Iterator<Book> itr = avail_books.iterator();     
        
 
        System.out.println("Displaying Books:");
       
        	while (itr.hasNext()) {        	       
                Object obj = itr.next();
                System.out.print(obj + "\n");                
                }
        	itr.remove();
        	System.out.println("Displaying Books: after remove");
        	 for(Book total_books : avail_books){
                 System.out.println(total_books);
             }
       
        }
 
    }
 

