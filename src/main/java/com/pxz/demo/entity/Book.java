package com.pxz.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author pxz
 * @create 2021-01-06 18:33
 */
@Entity
@Data //这是lombok的注解,自动生成get/set等方法
public class Book {
	//属性名要和数据库字段名一一对应
	
	@Id
	//主键自增
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	private String author;
}
