package com.codingdojo.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.mvc.models.Book;
import com.codingdojo.mvc.repositories.BookRepository;

@Service
public class BookService {
	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	 // devuelve todos los libros
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // crea un libro
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // recupera un libro
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
  
	public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if(optionalBook.isPresent()) {
			Book book = this.findBook(id);
			book.setTitle(title);
			book.setDescription(desc);
			book.setLanguage(lang);
			book.setNumberOfPages(numOfPages);
			System.out.println("**** In updateBook ****");
			System.out.println("T: " + book.getTitle() + " D:" + book.getDescription() + " L:" + book.getLanguage() + " P:" + book.getNumberOfPages() );
			return this.bookRepository.save(book);
		}	else {
			return null;
		}
	}
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}
    
}
