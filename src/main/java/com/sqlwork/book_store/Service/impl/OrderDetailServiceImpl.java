package com.sqlwork.book_store.Service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sqlwork.book_store.Mapper.OrderDetailMapper;
import com.sqlwork.book_store.Service.OrderDetailService;
import com.sqlwork.book_store.domain.entity.OrderDetail;
import org.springframework.stereotype.Service;

/**
 * (OrderDetail)表服务实现类
 *
 * @author makejava
 * @since 2023-12-31 14:48:52
 */
@Service("orderDetailService")
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {

}
