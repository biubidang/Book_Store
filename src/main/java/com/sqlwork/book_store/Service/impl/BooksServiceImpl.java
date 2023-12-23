package com.sqlwork.book_store.Service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sqlwork.book_store.Mapper.BooksMapper;
import com.sqlwork.book_store.Service.BooksService;
import com.sqlwork.book_store.domain.entity.Books;
import org.springframework.stereotype.Service;

/**
 * (Books)表服务实现类
 *
 * @author makejava
 * @since 2023-12-24 00:47:32
 */
@Service("booksService")
public class BooksServiceImpl extends ServiceImpl<BooksMapper, Books> implements BooksService {

}
