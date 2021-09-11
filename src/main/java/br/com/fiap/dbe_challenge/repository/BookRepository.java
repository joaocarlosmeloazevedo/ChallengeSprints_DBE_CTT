package br.com.fiap.dbe_challenge.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.dbe_challenge.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

	Page<Book> findByTituloLike(String string, Pageable pageable);

}
