package com.sqlwork.book_store.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sqlwork.book_store.domain.entity.OrderDetail;
import org.apache.ibatis.annotations.Mapper;


/**
 * (OrderDetail)表数据库访问层
 *
 * @author makejava
 * @since 2023-12-24 00:32:26
 */
@Mapper
public interface OrderDetailMapper extends BaseMapper<OrderDetail> {

}
