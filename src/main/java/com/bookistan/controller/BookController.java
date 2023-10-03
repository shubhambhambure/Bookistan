package com.bookistan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.bookistan.entity.Book;
import com.bookistan.entity.MyBookList;
import com.bookistan.service.BookService;
import com.bookistan.service.MyBookService;

@Controller
public class BookController {

	@Autowired
	private BookService service;

	@Autowired
	private MyBookService mbService;

	@GetMapping("/home")
	public String home() {
		return "home";
	}

	@GetMapping("/new_book")
	public String addBook() {
		return "newBook";
	}

	@GetMapping("/all_books")
	public ModelAndView allBooks() {

		List<Book> list = service.getAllBooks();
		return new ModelAndView("allBooks", "book", list);
	}

	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b) {
		service.save(b);
		return "redirect:/all_books";
	}

	@GetMapping("/my_books")
	public String myBooks(Model model) {

		List<MyBookList> list = mbService.getMyBookList();
		model.addAttribute("book", list);
		return "myBooks";
	}

	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") Integer id) {

		Book b = service.getBookById(id);
		MyBookList ml = new MyBookList(b.getId(), b.getName(), b.getAuthor(), b.getPages(), b.getPrice());
		mbService.saveMyBook(ml);
		return "redirect:/my_books";
	}

	@RequestMapping("/bookEdit/{id}")
	public String bookEdit(@PathVariable("id") Integer id, Model model) {
		Book b = service.getBookById(id);
		model.addAttribute("book", b);
		return "bookEdit";
	}

	@RequestMapping("/bookDelete/{id}")
	public String bookDelete(@PathVariable("id") Integer id) {
		service.deleteById(id);
		return "redirect:/all_books";
	}

}
