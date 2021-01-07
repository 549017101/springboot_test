package com.pxz.demo.controller;

import com.pxz.demo.entity.Book;
import com.pxz.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

/**
 * @author pxz
 * @create 2021-01-06 20:48
 */
@RestController
@RequestMapping("/book")
public class BookController {
	@Autowired
	private BookRepository bookRepository;
	
	@GetMapping("findAll/{page}/{size}")
	public Page<Book> findAll(@PathVariable("page")Integer page, @PathVariable("size") Integer size){
		//Pageable:分页信息的抽象接口,这是spring Data JPA 提供好的一个分页接口,Pageable对象表示的就是分页信息
		//PageRequest是Pageable的实现类,调用PageRequest.of,传入 页码信息等即可
		
		//页码是从0开始的,做一个减一处理即可
		Pageable pageable = PageRequest.of(page - 1,size);
		return bookRepository.findAll(pageable);
	}
	
	@PostMapping("/save")
	public String save(@RequestBody Book book){
		Book result = bookRepository.save(book);
		if(result != null){
		    return "success";
		}else {
			return "error";
		}
	}
	
	@GetMapping("/findById/{id}")
	public Book findById(@PathVariable("id") Integer id){
		return bookRepository.findById(id).get();
	}
	
	@PutMapping("/update")
	public String update(@RequestBody Book book ){
		Book result = bookRepository.save(book);
		if (result != null) {
			return "success";
		} else {
			return "error";
		}
	}
	
	@DeleteMapping("/deleteById/{id}")
	public void DeleteById(@PathVariable("id") Integer id){
		bookRepository.deleteById(id);
	}
}
