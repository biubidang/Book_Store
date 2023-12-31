package com.sqlwork.book_store.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sqlwork.book_store.domain.ResponseResult;
import com.sqlwork.book_store.domain.entity.Books;


/**
 * (Books)表服务接口
 *
 * @author makejava
 * @since 2023-12-24 00:47:31
 */
public interface BooksService extends IService<Books> {

    ResponseResult addBook(Books books);

    ResponseResult updateInventory(Long id,Integer addNum,Integer minusNum);

    ResponseResult getInfo(Long id);

    ResponseResult searchBook(String keyword);


    ResponseResult registration();

    ResponseResult delRegistration();

    public boolean bookNameExist(String bookName);
}
