package com.sqlwork.book_store.Service;

import com.sqlwork.book_store.domain.ResponseResult;
import com.sqlwork.book_store.domain.entity.Customers;


public interface LoginService {
    ResponseResult login(Customers user);

    ResponseResult logout();
}
