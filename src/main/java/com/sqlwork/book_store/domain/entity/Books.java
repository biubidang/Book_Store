package com.sqlwork.book_store.domain.entity;


import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (Books)表实体类
 *
 * @author makejava
 * @since 2023-12-24 00:47:31
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("books")
public class Books {
    //唯一标识@TableId
    private Long id;


    private String isbn;

    private String name;

    private String author1;

    private String author2;

    private String author3;

    private String author4;

    private String publishingHouse;

    private Float prize;

    private String keywords;

    private String cover;

    private Integer inventory;

    private String suppliers;


}
