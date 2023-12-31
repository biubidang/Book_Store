package com.sqlwork.book_store.Controller;

import com.sqlwork.book_store.Service.SupplierService;
import com.sqlwork.book_store.domain.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/supplier")
public class SuppliersController {
    @Autowired
    private SupplierService supplierService;

    @GetMapping("/getSupplier")
    public ResponseResult getSupplier(String supplier){
        return supplierService.getSupplier(supplier);
    }
}
