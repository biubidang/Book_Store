package com.sqlwork.book_store.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sqlwork.book_store.domain.ResponseResult;
import com.sqlwork.book_store.domain.entity.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * (Supplier)表服务接口
 *
 * @author makejava
 * @since 2023-12-31 16:14:15
 */

public interface SupplierService extends IService<Supplier> {

    ResponseResult getSupplier(String supplier);
}
