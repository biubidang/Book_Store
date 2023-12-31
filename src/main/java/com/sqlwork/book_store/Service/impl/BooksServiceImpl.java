package com.sqlwork.book_store.Service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sqlwork.book_store.Mapper.BooksMapper;
import com.sqlwork.book_store.Service.BookRegistrationsService;
import com.sqlwork.book_store.Service.BooksService;
import com.sqlwork.book_store.Utils.TimeUtil;
import com.sqlwork.book_store.domain.ResponseResult;
import com.sqlwork.book_store.domain.entity.BookRegistrations;
import com.sqlwork.book_store.domain.entity.Books;
import com.sqlwork.book_store.enums.HttpCodeEnum;
import com.sqlwork.book_store.exception.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * (Books)表服务实现类
 *
 * @author makejava
 * @since 2023-12-24 00:47:32
 */
@Service("booksService")
public class BooksServiceImpl extends ServiceImpl<BooksMapper, Books> implements BooksService {

    @Autowired
    private BookRegistrationsService bookRegistrationsService;

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

    @Override
    public ResponseResult updateInventory(Long id, Integer addNum, Integer minusNum) {
        Books books=getById(id);
        if(addNum<0||minusNum<0){
            throw new SystemException(HttpCodeEnum.SYSTEM_ERROR);
        }
        if(books.getInventory()-minusNum<0){
            throw new SystemException(HttpCodeEnum.BOOK_INVENTORY_NOT_ENOUGH);
        }
        books.setInventory(books.getInventory()-minusNum+addNum);
        updateById(books);
        return ResponseResult.okResult();
    }

    @Override
    public ResponseResult getInfo(Long id) {
        Books book=getById(id);
        return ResponseResult.okResult(book);
    }

    @Override
    public ResponseResult searchBook(String keyword) {
        LambdaQueryWrapper<Books> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.like(Books::getKeywords,keyword).or().
                like(Books::getIsbn,keyword).or().
                like(Books::getAuthor1,keyword).or().
                like(Books::getName,keyword).or().
                like(Books::getPublishingHouse,keyword);
        List<Books> list=list(queryWrapper);
        return ResponseResult.okResult(list);
    }

    @Override
    public ResponseResult registration() {
        if(bookRegistrationsService.TimeExist(TimeUtil.getNowDateShort())){
            throw new SystemException(HttpCodeEnum.BOOK_REGISTRATION_CREATED_TODAY);
        }
        LambdaQueryWrapper<Books> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.lt(Books::getInventory,5);
        for(Books book:list(queryWrapper)){
            BookRegistrations bookRegistrations=new BookRegistrations();
            bookRegistrations.setBookIsbn(book.getIsbn());
            bookRegistrations.setBookName(book.getName());
            bookRegistrations.setNumbers(20-book.getInventory());
            bookRegistrations.setTime(new Date());
            bookRegistrations.setPPrice(book.getPrize());
            bookRegistrationsService.saveOrUpdate(bookRegistrations,new LambdaQueryWrapper<BookRegistrations>()
                    .eq(BookRegistrations::getBookName,bookRegistrations.getBookName()));
        }
        return ResponseResult.okResult();
    }

    @Override
    public ResponseResult delRegistration() {
        LambdaQueryWrapper<Books> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.ge(Books::getInventory,20);
        for (Books book:list(queryWrapper)){
            bookRegistrationsService.remove(new LambdaQueryWrapper<BookRegistrations>()
                    .eq(BookRegistrations::getBookName,book.getName()));
        }
        return ResponseResult.okResult();
    }

    public boolean bookNameExist(String bookName) {
        LambdaQueryWrapper<Books> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Books::getName,bookName);
        return count(queryWrapper)>0;
    }
}
