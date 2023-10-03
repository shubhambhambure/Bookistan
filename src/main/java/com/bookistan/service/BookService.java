package com.bookistan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookistan.entity.Book;
import com.bookistan.repository.BookRepository;


@Service
public class BookService {
	
	@Autowired
	private BookRepository br;
	
	public void save(Book book) {
		br.save(book);
	}
	
	public List<Book> getAllBooks(){
		
		return br.findAll();
	}
	
	public Book getBookById(int id) {
		return br.findById(id).get();
	}
	
	public void deleteById(Integer id) {

		br.deleteById(id);

	}
	
}
