package com.pxz.demo.controller;

import com.pxz.demo.entity.Book;
import com.pxz.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author pxz
 * @create 2021-01-06 20:48
 */
@RestController
@RequestMapping("/book")
public class BookController {
	@Autowired
	private BookRepository bookRepository;
	
	@GetMapping("findAll")
	public List<Book> findAll(){
		return bookRepository.findAll();
	}
}
