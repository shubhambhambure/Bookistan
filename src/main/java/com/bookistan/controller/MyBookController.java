package com.bookistan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import com.bookistan.service.MyBookService;

import org.springframework.web.bind.annotation.*;

@Controller
public class MyBookController {
	
	@Autowired
	private MyBookService mbService;
	
	@RequestMapping("/deleteMyBook/{id}")
	public String deleteMyBook(@PathVariable("id") Integer id) {
		mbService.deleteById(id);
		return "redirect:/my_books";
	}

}
