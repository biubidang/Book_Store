package com.sqlwork.book_store.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sqlwork.book_store.domain.ResponseResult;
import com.sqlwork.book_store.domain.entity.BookRegistrations;

import java.util.Date;


/**
 * (BookRegistrations)表服务接口
 *
 * @author makejava
 * @since 2023-12-24 00:47:17
 */
public interface BookRegistrationsService extends IService<BookRegistrations> {
    boolean TimeExist(Date date);
}
