package com.sqlwork.book_store.domain.vo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserInfoVo {
    /**
     * 主键
     */
    private Long id;

    private String userName;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 邮箱
     */

    private String eMail;

    private Integer creditLevel;


}
