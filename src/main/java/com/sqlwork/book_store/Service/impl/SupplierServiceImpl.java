package com.sqlwork.book_store.Service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sqlwork.book_store.Mapper.SupplierMapper;
import com.sqlwork.book_store.Service.SupplierService;
import com.sqlwork.book_store.domain.ResponseResult;
import com.sqlwork.book_store.domain.entity.Supplier;
import org.springframework.stereotype.Service;

/**
 * (Supplier)表服务实现类
 *
 * @author makejava
 * @since 2023-12-31 16:14:17
 */
@Service("supplierService")
public class SupplierServiceImpl extends ServiceImpl<SupplierMapper, Supplier> implements SupplierService {

    @Override
    public ResponseResult getSupplier(String supplier) {
        LambdaQueryWrapper<Supplier> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(Supplier::getSupplier,supplier);
        return ResponseResult.okResult(list(queryWrapper));
    }
}
