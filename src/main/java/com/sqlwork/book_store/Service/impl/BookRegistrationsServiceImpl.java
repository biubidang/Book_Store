package com.sqlwork.book_store.Service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sqlwork.book_store.Mapper.BookRegistrationsMapper;
import com.sqlwork.book_store.Service.BookRegistrationsService;
import com.sqlwork.book_store.domain.ResponseResult;
import com.sqlwork.book_store.domain.entity.BookRegistrations;
import com.sqlwork.book_store.domain.entity.Books;
import com.sqlwork.book_store.enums.HttpCodeEnum;
import com.sqlwork.book_store.exception.SystemException;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * (BookRegistrations)表服务实现类
 *
 * @author makejava
 * @since 2023-12-24 00:47:17
 */
@Service("bookRegistrationsService")
public class BookRegistrationsServiceImpl extends ServiceImpl<BookRegistrationsMapper, BookRegistrations> implements BookRegistrationsService {


    public boolean TimeExist(Date date){
        LambdaQueryWrapper<BookRegistrations> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(BookRegistrations::getTime,date);
        return count(queryWrapper)>0;
    }


}
