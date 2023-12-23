package com.sqlwork.book_store.Service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sqlwork.book_store.Mapper.BookRegistrationsMapper;
import com.sqlwork.book_store.Service.BookRegistrationsService;
import com.sqlwork.book_store.domain.entity.BookRegistrations;
import org.springframework.stereotype.Service;

/**
 * (BookRegistrations)表服务实现类
 *
 * @author makejava
 * @since 2023-12-24 00:47:17
 */
@Service("bookRegistrationsService")
public class BookRegistrationsServiceImpl extends ServiceImpl<BookRegistrationsMapper, BookRegistrations> implements BookRegistrationsService {

}
