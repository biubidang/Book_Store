package com.sqlwork.book_store.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sqlwork.book_store.domain.ResponseResult;
import com.sqlwork.book_store.domain.entity.BookOrder;
import com.sqlwork.book_store.domain.entity.Books;
import com.sqlwork.book_store.domain.vo.BookBuyingVo;


/**
 * (BookOrder)表服务接口
 *
 * @author makejava
 * @since 2023-12-24 00:46:31
 */
public interface BookOrderService extends IService<BookOrder> {

    ResponseResult purchase();

    ResponseResult createOrder(BookBuyingVo[] books);

}
