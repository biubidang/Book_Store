package com.sqlwork.book_store.Service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sqlwork.book_store.Mapper.BooksMapper;
import com.sqlwork.book_store.Service.BooksService;
import com.sqlwork.book_store.domain.ResponseResult;
import com.sqlwork.book_store.domain.entity.Books;
import com.sqlwork.book_store.enums.HttpCodeEnum;
import com.sqlwork.book_store.exception.SystemException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * (Books)表服务实现类
 *
 * @author makejava
 * @since 2023-12-24 00:47:32
 */
@Service("booksService")
public class BooksServiceImpl extends ServiceImpl<BooksMapper, Books> implements BooksService {

    @Override
    public ResponseResult addBook(Books books) {
        if(!StringUtils.hasText(books.getIsbn())){
            throw new SystemException(HttpCodeEnum.BOOK_ISBN_NOT_NULL);
        }
        if(bookNameExist(books.getName())){
            throw new SystemException(HttpCodeEnum.BOOK_NAME_EXIST);
        }
        save(books);
        return ResponseResult.okResult();
    }
    private boolean bookNameExist(String bookName) {
        LambdaQueryWrapper<Books> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Books::getName,bookName);
        return count(queryWrapper)>0;
    }
}
