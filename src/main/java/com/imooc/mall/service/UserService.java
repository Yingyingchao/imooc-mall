package com.imooc.mall.service;

import com.imooc.mall.model.pojo.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public User getUser();
}
