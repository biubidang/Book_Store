package com.sqlwork.book_store.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sqlwork.book_store.domain.entity.Customers;
import org.apache.ibatis.annotations.Mapper;


/**
 * (Customers)表数据库访问层
 *
 * @author makejava
 * @since 2023-12-24 00:47:45
 */
@Mapper
public interface CustomersMapper extends BaseMapper<Customers> {

}
