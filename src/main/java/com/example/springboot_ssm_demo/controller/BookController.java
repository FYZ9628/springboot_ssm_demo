package com.example.springboot_ssm_demo.controller;

import com.example.springboot_ssm_demo.model.Books;
import com.example.springboot_ssm_demo.result.Result;
import com.example.springboot_ssm_demo.result.Search;
import com.example.springboot_ssm_demo.result.SearchByInt;
import com.example.springboot_ssm_demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

//    @RequestMapping(value = "/api/bookList", method = RequestMethod.GET,
//            produces = "application/json; charset=UTF-8")
//    @ResponseBody
    @GetMapping("/api/getAllBook")
    public List<Books> getAllBook() {
        List<Books> bookList = bookService.getAllBook();
        return bookList;
    }

    @PostMapping("/api/findAllByNameLike")
    public List<Books> findAllByNameLike(@RequestBody Search s) throws Exception {

        List<Books> bookList = bookService.findAllByNameLike(s.getKeywords());
        return bookList;
    }


    @PostMapping("/api/findBookByName")
    public Books findBookByName(@RequestBody Search s) throws Exception {

        return bookService.findBookByName(s.getKeywords());
    }

    @PostMapping("/api/findBookById")
    public Books findBookById(@RequestBody SearchByInt searchByInt) throws Exception {

        return bookService.findBookById(searchByInt.getKeywords());
    }

    @PostMapping("/api/addBook")
    public Books addBook(@RequestBody Books books) throws Exception {

        boolean bl = bookService.isExist(books.getBookID());
        if (bl == true){
            return null;
        }else {
            bookService.addBook(books);
            Books books1 = bookService.findBookByName(books.getBookName());
            return books1;
        }
    }

//    删除
    //修改
    @PostMapping("/api/updateBooks")
    public Books updateStudent(@RequestBody Books books) throws Exception {

        boolean bl = bookService.isExist(books.getBookID());
        if (bl == true){
            bookService.updateBook(books);
            Books books1 = bookService.findBookById(books.getBookID());
            return books1;
        }else {
            return null;
        }
    }

    @PostMapping("/api/deleteBooks")
    public Result deleteStudent(@RequestBody Books BooksId) throws Exception {
        //因为前端只是传了一个 id 过来，所以 teacherId 里面只有一个 id 没有其他信息
        //所以要再通过 id 查询 teacher 的其他信息
        Books books = bookService.findBookById(BooksId.getBookID());
        if (books != null){
            bookService.deleteBookById(BooksId.getBookID());
            //   删除成功返回码 100
            return new Result(100);
        } else {
            //   删除失败返回码 400
            return new Result(400);
        }
    }
}

