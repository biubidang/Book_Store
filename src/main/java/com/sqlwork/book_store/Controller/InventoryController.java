package com.sqlwork.book_store.Controller;

import com.sqlwork.book_store.Service.BooksService;
import com.sqlwork.book_store.domain.ResponseResult;
import com.sqlwork.book_store.domain.entity.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//        接口1：新增书籍信息
//        Endpoint: POST
//        接口2：更新书籍信息
//        Endpoint: PUT
//        接口3：缺书登记
//        Endpoint: POST
//        接口4：生成采购单
//        Endpoint: POST

@RestController
@RequestMapping("/Inventory")
public class InventoryController {
    @Autowired
    private BooksService booksService;
    @PostMapping("/new")
    public ResponseResult addBook(@RequestBody Books books){
        return booksService.addBook(books);
    }
}
