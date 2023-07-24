package com.imooc.mall.service.impl;

import com.imooc.mall.exception.ImoocMallExceptionEnum;
import com.imooc.mall.exception.ImoocMallException;
import com.imooc.mall.model.dao.UserMapper;
import com.imooc.mall.model.pojo.User;
import com.imooc.mall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserService实现类
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User getUser() {
        return userMapper.selectByPrimaryKey(1);
    }

    @Override
    public void register(String username, String password) throws ImoocMallException {
        User result = userMapper.selectByName(username);
        if(result != null){
            throw new ImoocMallException(ImoocMallExceptionEnum.NAME_EXISTED);
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        int count = userMapper.insertSelective(user);
        if(count == 0){
            throw new ImoocMallException(ImoocMallExceptionEnum.INSERT_FAILED);
        }
    }


}
