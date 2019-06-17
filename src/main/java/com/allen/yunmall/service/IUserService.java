package com.allen.yunmall.service;

import com.allen.yunmall.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhull
 * @since 2019-05-31
 */
public interface IUserService extends IService<User> {

    /**
     * 你好
     * @param i
     * @return
     */
    String helloWordByUserId(int i);
}
