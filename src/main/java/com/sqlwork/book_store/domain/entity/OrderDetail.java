package com.sqlwork.book_store.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (OrderDetail)表实体类
 *
 * @author makejava
 * @since 2023-12-24 00:32:27
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("order_detail")
public class OrderDetail {
    @TableId
    private Long id;

    private Long parentId;

    private String bookIsbn;

    private String bookName;

    private Integer quantity;

    private Float amount;
    //0未发货 1已发货
    private Integer status;
}


