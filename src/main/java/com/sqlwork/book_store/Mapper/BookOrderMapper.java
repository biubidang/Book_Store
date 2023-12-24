package com.sqlwork.book_store.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sqlwork.book_store.domain.entity.BookOrder;
import org.apache.ibatis.annotations.Mapper;


/**
 * (BookOrder)表数据库访问层
 *
 * @author makejava
 * @since 2023-12-24 00:46:15
 */
@Mapper
public interface BookOrderMapper extends BaseMapper<BookOrder> {

}
