package com.allen.yunmall.mapper;

import com.allen.yunmall.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhull
 * @since 2019-05-31
 */
@Mapper
@Component
public interface UserMapper extends BaseMapper<User> {

}
