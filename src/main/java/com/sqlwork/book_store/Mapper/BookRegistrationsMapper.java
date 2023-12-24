package com.sqlwork.book_store.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sqlwork.book_store.domain.entity.BookRegistrations;
import org.apache.ibatis.annotations.Mapper;


/**
 * (BookRegistrations)表数据库访问层
 *
 * @author makejava
 * @since 2023-12-24 00:47:17
 */
@Mapper
public interface BookRegistrationsMapper extends BaseMapper<BookRegistrations> {

}
