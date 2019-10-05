package com.app.domain;

import com.app.dao.UserMapper;
import com.app.dao.entity.User;
import com.app.interfaces.request.ListUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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

    public int countUser(ListUserRequest request) {
        return userMapper.countUser(request);
    }

    public List<User> ListUser(ListUserRequest request) {
        return userMapper.listUser(request);
    }
}
