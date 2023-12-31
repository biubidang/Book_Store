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
    @GetMapping("/userInfo")
    public ResponseResult getUserInfo(){
        return  customersService.getUserInfo();
    }
    @PutMapping("/userInfo")
    public ResponseResult updateUserInfo(@RequestBody Customers user){
        return  customersService.updateUserInfo(user);
    }
    @PutMapping("/updateCredit")
    public ResponseResult updateCredit(Float amount){
        return customersService.updateCredit(amount);
    }

}
