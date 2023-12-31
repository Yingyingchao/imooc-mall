package com.imooc.mall.service;

import com.imooc.mall.exception.ImoocMallException;
import com.imooc.mall.model.pojo.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public User getUser();

    public void register(String username,String password) throws ImoocMallException;
}
