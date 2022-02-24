package com.codingdojo.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.mvc.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book,Long> {
	// este método recupera todos los libros de la base de datos
	List<Book> findAll();
    // este método encuentra libros con descripciones que contienen la cadena de búsqueda
//    List<Book> findByDescriptionContaining(String search);
    // este método cuenta cuántos títulos contienen una determinada cadena
//    Long countByTitleContaining(String search);
    // este método elimina un libro que comienza con un título específico
//    Long deleteByTitleStartingWith(String search);
}
