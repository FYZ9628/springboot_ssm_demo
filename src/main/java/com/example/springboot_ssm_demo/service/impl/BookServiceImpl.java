package com.example.springboot_ssm_demo.service.impl;

import com.example.springboot_ssm_demo.mapper.BookMapper;
import com.example.springboot_ssm_demo.model.Books;
import com.example.springboot_ssm_demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;

    public BookMapper getBookMapper() {
        return bookMapper;
    }

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public int addBook(Books books) {
        return bookMapper.addBook(books);
    }

    @Override
    public int deleteBookById(int id) {
        return bookMapper.deleteBookById(id);
    }

    @Override
    public int updateBook(Books books) {
        return bookMapper.updateBook(books);
    }

    @Override
    public List<Books> getAllBook() {
        return bookMapper.getAllBook();
    }

    @Override
    public Books findBookByName(String bookName) {
        return bookMapper.findBookByName(bookName);
    }

    @Override
    public Books findBookById(int bookID) {
        return bookMapper.findBookById(bookID);
    }

    @Override
    public List<Books> findAllByNameLike(String bookName) {
        return bookMapper.findAllByNameLike(bookName);
    }

    @Override
    public boolean isExist(int bookID) {
        Books books = findBookById(bookID);
        return null!=books;
    }

}
