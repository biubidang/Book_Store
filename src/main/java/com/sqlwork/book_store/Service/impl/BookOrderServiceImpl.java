package com.sqlwork.book_store.Service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sqlwork.book_store.Mapper.BookOrderMapper;
import com.sqlwork.book_store.Service.BookOrderService;
import com.sqlwork.book_store.Service.BookRegistrationsService;
import com.sqlwork.book_store.domain.ResponseResult;
import com.sqlwork.book_store.domain.entity.BookOrder;
import com.sqlwork.book_store.domain.entity.BookRegistrations;
import com.sqlwork.book_store.enums.HttpCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * (BookOrder)表服务实现类
 *
 * @author makejava
 * @since 2023-12-24 00:46:32
 */
@Service("bookOrderService")
public class BookOrderServiceImpl extends ServiceImpl<BookOrderMapper, BookOrder> implements BookOrderService {
    @Autowired
    private BookRegistrationsService bookRegistrationsService;

    @Override
    public ResponseResult purchase() {
        BookOrder bookOrder=new BookOrder();
        float amount=0f;
        int sum=0;
        for (BookRegistrations bR: bookRegistrationsService.list()){
            amount+=bR.getPPrice()*bR.getNumbers();
            sum+=bR.getNumbers();
        }
        if(sum==0){
            return ResponseResult.errorResult(HttpCodeEnum.SYSTEM_ERROR);
        }
        bookOrder.setCategory(0);
        bookOrder.setCreatetime(new Date());
        bookOrder.setCustomerId((long) -1);
        bookOrder.setTotalAmount(amount);
        bookOrder.setTotalSum(sum);
        save(bookOrder);
        return ResponseResult.okResult(bookOrder);
    }
}
