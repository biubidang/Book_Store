package com.sqlwork.book_store.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sqlwork.book_store.domain.ResponseResult;
import com.sqlwork.book_store.domain.entity.OrderDetail;


/**
 * (OrderDetail)表服务接口
 *
 * @author makejava
 * @since 2023-12-31 14:48:51
 */
public interface OrderDetailService extends IService<OrderDetail> {

    ResponseResult getOrderStatus(int id);
}
