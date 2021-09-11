package br.com.fiap.dbe_challenge.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.dbe_challenge.model.Account;
import br.com.fiap.dbe_challenge.model.Book;
import br.com.fiap.dbe_challenge.repository.AccountRepository;
import br.com.fiap.dbe_challenge.repository.BookRepository;

@Controller
public class MainController {

	@Autowired
	private AccountRepository repository;
	
	@Autowired
	private BookRepository repository2;

	@RequestMapping("/home")
	public String index() {
		return "index";
	}

	@RequestMapping("/list")
	public String list() {
		return "list";
	}
	
	@RequestMapping("/library")
	public String library() {
		return "library";
	}

	@GetMapping(value = { "", "/", "/home"})
	public ModelAndView listagem() {
		ModelAndView modelAndView = new ModelAndView("index");
		List<Account> list = repository.findAll();
		modelAndView.addObject("user", list);

		List<Book> list2 = repository2.findAll();
		modelAndView.addObject("book", list2);
		return modelAndView;
	}
	
	@GetMapping("/library")
	public ModelAndView biblioteca() {
		ModelAndView modelAndView = new ModelAndView("library");
		List<Book> list2 = repository2.findAll();
		modelAndView.addObject("book", list2);
		return modelAndView;
	}
	

	@PostMapping("/list")
	public String save(@Valid Account account, BindingResult result) {
		if (result.hasErrors()) {
			return "register";
		}
		repository.save(account);
		return "register";
	}
	
	@PostMapping("/bookregister")
	public String save(@Valid Book book, BindingResult result) {
		if (result.hasErrors()) {
			return "bookregister";
		}
		repository2.save(book);
		return "bookregister";
	}

	@RequestMapping("/register")
	public String register(Account account) {
		return "register";
	}
	
	@RequestMapping("/bookregister")
	public String bookregister(Book book) {
		return "bookregister";
	}

}
