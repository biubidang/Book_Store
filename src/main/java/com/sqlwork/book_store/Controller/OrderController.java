package com.sqlwork.book_store.Controller;

import com.sqlwork.book_store.Service.BookOrderService;
import com.sqlwork.book_store.Service.OrderDetailService;
import com.sqlwork.book_store.domain.ResponseResult;
import com.sqlwork.book_store.domain.entity.Books;
import com.sqlwork.book_store.domain.vo.BookBuyingVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private BookOrderService bookOrderService;

    @Autowired
    private OrderDetailService orderDetailService;

    @PostMapping("/purchase")
    public ResponseResult purchase(){
        return bookOrderService.purchase();
    }

    @PostMapping("/createOrder")
    public ResponseResult createOrder(@RequestBody BookBuyingVo[] books){
        return bookOrderService.createOrder(books);
    }
    @GetMapping("/getOrderStatus")
    public ResponseResult getOrderStatus(int id){
        return  orderDetailService.getOrderStatus(id);

    }
}
