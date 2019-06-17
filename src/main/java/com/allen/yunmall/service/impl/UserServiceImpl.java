package com.allen.yunmall.service.impl;

import com.allen.yunmall.entity.User;
import com.allen.yunmall.mapper.UserMapper;
import com.allen.yunmall.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhull
 * @since 2019-05-31
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public String helloWordByUserId(int i) {
        User user = userMapper.selectById(i);
        return user.getNickName()+"，你好!欢迎来到云商城。";
    }
}
