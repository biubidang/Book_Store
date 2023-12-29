package com.sqlwork.book_store.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sqlwork.book_store.domain.ResponseResult;
import com.sqlwork.book_store.domain.entity.Customers;


/**
 * (Customers)表服务接口
 *
 * @author makejava
 * @since 2023-12-24 00:47:45
 */
public interface CustomersService extends IService<Customers> {

    ResponseResult register(Customers user) ;
}
