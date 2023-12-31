package com.sqlwork.book_store.domain.entity;


import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (Supplier)表实体类
 *
 * @author makejava
 * @since 2023-12-31 16:14:13
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("supplier")
public class Supplier {
    @TableId
    private Long id;


    private String supplier;

    private Integer bookId;

    private Float pPrice;
}


