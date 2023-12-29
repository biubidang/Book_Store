package com.sqlwork.book_store.Controller;

import com.sqlwork.book_store.Service.CustomersService;
import com.sqlwork.book_store.domain.ResponseResult;
import com.sqlwork.book_store.domain.entity.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@ResponseBody
@RequestMapping("/customer")

public class CustomerController {
    @Autowired
    private CustomersService customersService;
    @PostMapping("/register")
    public ResponseResult register(@RequestBody Customers user){
        return customersService.register(user);
    }

}
