package com.sqlwork.book_store.Service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.injector.methods.SelectById;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sqlwork.book_store.Mapper.CustomersMapper;
import com.sqlwork.book_store.Service.CustomersService;
import com.sqlwork.book_store.Utils.BeanCopyUtils;
import com.sqlwork.book_store.Utils.SecurityUtils;
import com.sqlwork.book_store.domain.ResponseResult;
import com.sqlwork.book_store.domain.entity.Customers;
import com.sqlwork.book_store.domain.vo.UserInfoVo;
import com.sqlwork.book_store.enums.HttpCodeEnum;
import com.sqlwork.book_store.exception.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * (Customers)表服务实现类
 *
 * @author makejava
 * @since 2023-12-24 00:47:45
 */
@Service
public class CustomersServiceImpl extends ServiceImpl<CustomersMapper, Customers> implements CustomersService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public ResponseResult register(Customers user) {
        //对数据进行非空判断
        if(!StringUtils.hasText(user.getNickName())){
            throw new SystemException(HttpCodeEnum.USERNAME_NOT_NULL);
        }
        if(!StringUtils.hasText(user.getPassword())){
            throw new SystemException(HttpCodeEnum.PASSWORD_NOT_NULL);
        }
        if(!StringUtils.hasText(user.getEMail())){
            throw new SystemException(HttpCodeEnum.EMAIL_NOT_NULL);
        }
        if(!StringUtils.hasText(user.getNickName())){
            throw new SystemException(HttpCodeEnum.NICKNAME_NOT_NULL);
        }
        //对数据进行是否存在的判断
        if(nickNameExist(user.getNickName())){
            throw new SystemException(HttpCodeEnum.NICKNAME_EXIST);
        }
        if(userNameExist(user.getUserName())){
            throw new SystemException(HttpCodeEnum.USERNAME_EXIST);
        }
        //对密码进行加密
        String encodePassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodePassword);
        //存入数据库
        save(user);
        return ResponseResult.okResult();
    }

    @Override
    public ResponseResult getUserInfo() {
        //获取id
        Long userId= SecurityUtils.getUserId();
        //根据id查个人信息
        Customers user =getById(userId);
        //封装
        UserInfoVo userInfoVo= BeanCopyUtils.copyBean(user, UserInfoVo.class);
        return ResponseResult.okResult(userInfoVo);
    }

    @Override
    public ResponseResult updateUserInfo(Customers user) {

        updateById(user);
        return ResponseResult.okResult();
    }

    private boolean nickNameExist(String nickName) {
        LambdaQueryWrapper<Customers> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Customers::getNickName,nickName);
        return count(queryWrapper)>0;
    }
    private boolean userNameExist(String userName) {
        LambdaQueryWrapper<Customers> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Customers::getUserName,userName);
        return count(queryWrapper)>0;
    }
}
