package com.example.springboot_ssm_demo.mapper;

import com.example.springboot_ssm_demo.model.Books;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BookMapper {
    //增加一本书
    int addBook(Books books);

    //根据id删除一本书
    int deleteBookById(@Param("bookId") int id);

    //更新一本书，根据id更新书籍信息
    int updateBook(Books books);

    //查询全部的书，返回list集合
    List<Books> getAllBook();

    //根据书名查询,返回一本书
    Books findBookByName(@Param("bookName") String bookName);

    //根据id查询,返回一本书
    Books findBookById(@Param("bookID") int bookID);

    //根据书名查询,返回所有书
    List<Books> findAllByNameLike(@Param("bookName") String bookName);
}
