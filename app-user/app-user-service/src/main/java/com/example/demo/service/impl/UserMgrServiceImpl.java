package com.example.demo.service.impl;

import com.example.demo.service.UserMgrService;
import org.springframework.stereotype.Service;

/**
 * @author Feinik
 * @discription
 * @date 2019/9/25
 * @since 1.0.0
 */
@Service
public class UserMgrServiceImpl implements UserMgrService {

    @Override
    public String getUserById(String uid) {
        if (uid.equals("100")) {
            return "用户信息：feinik@foxmail.com";
        }
        return null;
    }
}
