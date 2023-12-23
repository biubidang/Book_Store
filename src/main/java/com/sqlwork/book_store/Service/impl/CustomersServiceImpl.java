package com.sqlwork.book_store.Service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sqlwork.book_store.Mapper.CustomersMapper;
import com.sqlwork.book_store.Service.CustomersService;
import com.sqlwork.book_store.domain.entity.Customers;
import org.springframework.stereotype.Service;

/**
 * (Customers)表服务实现类
 *
 * @author makejava
 * @since 2023-12-24 00:47:45
 */
@Service("customersService")
public class CustomersServiceImpl extends ServiceImpl<CustomersMapper, Customers> implements CustomersService {

}
