package com.sqlwork.book_store.enums;

public enum HttpCodeEnum {
    // 成功
    SUCCESS(200,"操作成功"),
    // 登录
    NEED_LOGIN(401,"需要登录后操作"),
    NO_OPERATOR_AUTH(403,"无权限操作"),
    SYSTEM_ERROR(500,"出现错误"),
    USERNAME_EXIST(501,"用户名已存在"),
    EMAIL_EXIST(502, "邮箱已存在"),
    REQUIRE_USERNAME(503, "必需填写用户名"),
    LOGIN_ERROR(504,"用户名或密码错误"),
    FILE_TYPE_ERROR(505,"上传文件类型错误" ),
    USERNAME_NOT_NULL(506, "用户名不能为空"),
    PASSWORD_NOT_NULL(507, "密码不能为空"),
    EMAIL_NOT_NULL(509,"邮箱不能为空" ),
    NICKNAME_NOT_NULL(510,"昵称不能为空" ),
    NICKNAME_EXIST(511, "昵称已存在"),
    BOOK_ISBN_NOT_NULL(520,"书号不能为空"),
    BOOK_NAME_EXIST(521,"书名已经存在"),
    BOOK_INVENTORY_NOT_ENOUGH(522,"库存不足"),
    BOOK_REGISTRATION_CREATED_TODAY(523,"今日已经生成过缺货提醒");
    int code;
    String msg;

    HttpCodeEnum(int code, String errorMessage){
        this.code = code;
        this.msg = errorMessage;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}

