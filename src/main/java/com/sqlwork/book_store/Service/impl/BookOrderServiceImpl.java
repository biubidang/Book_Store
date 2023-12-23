package com.sqlwork.book_store.Service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sqlwork.book_store.Mapper.BookOrderMapper;
import com.sqlwork.book_store.Service.BookOrderService;
import com.sqlwork.book_store.domain.entity.BookOrder;
import org.springframework.stereotype.Service;

/**
 * (BookOrder)表服务实现类
 *
 * @author makejava
 * @since 2023-12-24 00:46:32
 */
@Service("bookOrderService")
public class BookOrderServiceImpl extends ServiceImpl<BookOrderMapper, BookOrder> implements BookOrderService {

}
