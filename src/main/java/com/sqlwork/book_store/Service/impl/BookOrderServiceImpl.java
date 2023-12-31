package com.sqlwork.book_store.Service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sqlwork.book_store.Mapper.BookOrderMapper;
import com.sqlwork.book_store.Service.BookOrderService;
import com.sqlwork.book_store.Service.BookRegistrationsService;
import com.sqlwork.book_store.Service.BooksService;
import com.sqlwork.book_store.Service.OrderDetailService;
import com.sqlwork.book_store.Utils.SecurityUtils;
import com.sqlwork.book_store.domain.ResponseResult;
import com.sqlwork.book_store.domain.entity.BookOrder;
import com.sqlwork.book_store.domain.entity.BookRegistrations;
import com.sqlwork.book_store.domain.entity.Books;
import com.sqlwork.book_store.domain.entity.OrderDetail;
import com.sqlwork.book_store.domain.vo.BookBuyingVo;
import com.sqlwork.book_store.enums.HttpCodeEnum;
import com.sqlwork.book_store.exception.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private BooksService booksService;

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

    @Override
    public ResponseResult createOrder(BookBuyingVo[] books) {
        BookOrder bookOrder=new BookOrder();
        Long userId= SecurityUtils.getUserId();
        float amount=0f;
        int sum=0;
        for (BookBuyingVo book: books) {
            if(!booksService.bookNameExist(book.getName())){
                throw new RuntimeException("书名不存在");
            }
            amount+=book.getPrize()*book.getNum();
            sum+=book.getNum();
        }
        bookOrder.setCategory(1);
        bookOrder.setCreatetime(new Date());
        bookOrder.setCustomerId(userId);
        bookOrder.setTotalAmount(amount);
        bookOrder.setTotalSum(sum);
        save(bookOrder);
        Long orderId=bookOrder.getOrderId();
        int j=0;
        for (BookBuyingVo book: books) {
            OrderDetail orderDetail=new OrderDetail();
            orderDetail.setBookIsbn(book.getIsbn());
            orderDetail.setBookName(book.getName());
            orderDetail.setQuantity(book.getNum());
            orderDetail.setParentId(orderId);
            orderDetail.setAmount(book.getNum()*book.getPrize());
            orderDetailService.save(orderDetail);
            j++;
        }
        return ResponseResult.okResult();
    }




}
