package com.sqlwork.book_store.domain.entity;


import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (Customers)表实体类
 *
 * @author makejava
 * @since 2023-12-24 00:47:45
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("customers")
public class Customers {
    @TableId
    private Long id;

    private String password;

    private String userName;

    private String nickName;

    private String address;

    private String eMail;

    private Integer creditLevel;

    private Float accountBalance;

    private Integer isAdmin;
}

