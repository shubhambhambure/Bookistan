package com.bookistan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookistan.entity.MyBookList;
import com.bookistan.repository.MyBookRepository;

@Service
public class MyBookService {

	@Autowired
	private MyBookRepository mbr;

	public void saveMyBook(MyBookList myBook) {

		mbr.save(myBook);
	}

	public List<MyBookList> getMyBookList() {

		return mbr.findAll();
	}

	public void deleteById(Integer id) {

		mbr.deleteById(id);

	}

}
