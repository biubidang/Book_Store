package com.sqlwork.book_store.domain.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (BookOrder)表实体类
 *
 * @author makejava
 * @since 2023-12-24 00:46:29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("book_order")
public class BookOrder {
    @TableId
    private Long orderId;


    private Date createtime;

    private Long customerId;

    private Integer totalSum;

    private Integer totalAmount;
    //0:未处理 1正常发货完成 2部分发货（或者有缺货等待）
    private Integer status;

    private Integer category;
}


