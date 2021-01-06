package com.pxz.demo.repository;

import com.pxz.demo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author pxz
 * @create 2021-01-06 18:35
 */
public interface BookRepository extends JpaRepository<Book,Integer> {
	//直接继承 jpa的接口即可
	//直接继承JpaRepository,泛型的第一个参数是实体类的类型,第二个参数是主键类型,继承之后各种操作数据的方法就不用实现了,直接调用即可
}
