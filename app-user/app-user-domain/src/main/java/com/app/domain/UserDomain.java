package com.app.domain;

import com.app.dao.UserMapper;
import com.app.dao.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Feinik
 * @discription
 * @date 2019/10/3
 * @since 1.0.0
 */
@Component
public class UserDomain {

    @Autowired
    private UserMapper userMapper;

    public User getUserByUserCode(String userCode) {
        return userMapper.getUserByUserCode(userCode);
    }
}
