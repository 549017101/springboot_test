package com.pxz.demo;

import com.pxz.demo.entity.Book;
import com.pxz.demo.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class DemoApplicationTests {
	@Autowired
	private BookRepository bookRepository;
	
	@Test
	public void testFindAll() {
		System.out.println(bookRepository.findAll());
	}
	
	@Test
	public void testSave() {
		Book book = new Book();
		book.setName("Spring boot");
		book.setAuthor("张三");
		Book bookSave = bookRepository.save(book);
		System.out.println(bookSave);
	}
	
	@Test
	public void testFindById() {
		//这里的findById()方法返回的是一个Optional类型.这是java8的新特性,防止空指针等异常,所以不能直接使用
		//调用findById后,还需要对其调用get方法,才能真正取到book对象(前提是book不为null)
		Optional<Book> bookOptional = bookRepository.findById(1);
		Book book = bookOptional.get();
		System.out.println(book);
	}
	
	@Test
	public void testUpdate() {
		Book book = new Book();
		book.setId(121);
		book.setName("testtest");
		Book save = bookRepository.save(book); //更新保存二合一
		System.out.println(save);
	}
	
	@Test
	public void testDelete() {
		bookRepository.deleteById(121);
	}
}
