package com.example.springboot_ssm_demo.service;

import com.example.springboot_ssm_demo.model.Books;

import java.util.List;

public interface BookService {
    //增加一本书
    int addBook(Books books);

    //根据id删除一本书
    int deleteBookById(int id);

    //更新一本书，根据id更新书籍信息
    int updateBook(Books books);

    //获取全部的书，返回list集合
    List<Books> getAllBook();

    //精确查询
    //根据书名查询,返回一本书
    Books findBookByName(String bookName);

    //精确查询
    //根据id查询,返回一本书
    Books findBookById(int bookID);

    //模糊查询
    //查询全部的书，返回list集合
    List<Books>  findAllByNameLike(String bookName);

    boolean isExist(int bookID);
}
