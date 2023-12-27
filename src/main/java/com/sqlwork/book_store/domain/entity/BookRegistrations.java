package com.sqlwork.book_store.domain.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (BookRegistrations)表实体类
 *
 * @author makejava
 * @since 2023-12-24 00:47:17
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("book_registrations")
public class BookRegistrations {
    @TableId
    private Long id;

    private String bookIsbn;

    private String bookName;

    private String suppliers;

    private Integer numbers;

    private Date time;

    private Float pPrice;

}
