package com.pxz.demo;

import com.pxz.demo.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
	@Autowired
	private BookRepository bookRepository;
	
	@Test
	public void testFindAll() {
		System.out.println(bookRepository.findAll());
	}
}
