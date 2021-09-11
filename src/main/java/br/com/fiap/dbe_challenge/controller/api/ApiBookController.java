package br.com.fiap.dbe_challenge.controller.api;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.fiap.dbe_challenge.model.Book;
import br.com.fiap.dbe_challenge.repository.BookRepository;

@RestController
@RequestMapping("/api/book")
public class ApiBookController {

	@Autowired
	private BookRepository repository;

	@GetMapping()
	@Cacheable("books")
	public Page<Book> index(@RequestParam(required = false) String titulo,
			@PageableDefault(page = 0, size = 10) Pageable pageable) {

		if (titulo == null) {
			return repository.findAll(pageable);
		}
		return repository.findByTituloLike("%" + titulo + "%", pageable);

	}

	@PostMapping()
	@CacheEvict(value = "books", allEntries = true)
	public ResponseEntity<Book> create(@RequestBody @Valid Book book, UriComponentsBuilder uriBuilder) {
		repository.save(book);
		URI uri = uriBuilder.path("/api/task/{id}").buildAndExpand(book.getId()).toUri();
		return ResponseEntity.created(uri).body(book);
	}

	@GetMapping("{id}")
	public ResponseEntity<Book> get(@PathVariable Long id) {

		return ResponseEntity.of(repository.findById(id));
	}

	@DeleteMapping("{id}")
	@CacheEvict(value = "books", allEntries = true)
	public ResponseEntity<Book> delete(@PathVariable Long id) {
		Optional<Book> book = repository.findById(id);

		if (book.isEmpty())
			return ResponseEntity.notFound().build();

		repository.deleteById(id);

		return ResponseEntity.ok().build();

	}

	@PutMapping("{id}")
	@CacheEvict(value = "books", allEntries = true)
	public ResponseEntity<Book> update(@PathVariable Long id, @RequestBody @Valid Book newBook) {
		Optional<Book> optional = repository.findById(id);

		if (optional.isEmpty())
			return ResponseEntity.notFound().build();

		Book book = optional.get();
		book.setTitulo(newBook.getTitulo());
		book.setAutor(newBook.getAutor());
		book.setGenero(newBook.getGenero());
		book.setValor(newBook.getValor());

		repository.save(book);

		return ResponseEntity.ok(book);
	}

}

