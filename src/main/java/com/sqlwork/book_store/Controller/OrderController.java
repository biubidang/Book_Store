package com.sqlwork.book_store.Controller;

import com.sqlwork.book_store.Service.BookOrderService;
import com.sqlwork.book_store.domain.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private BookOrderService bookOrderService;

    @PostMapping("/purchase")
    public ResponseResult purchase(){
        return bookOrderService.purchase();
    }
}
