package com.app.dao;

import com.app.dao.entity.User;
import com.app.interfaces.request.ListUserRequest;

import java.util.List;

/**
 * @author Feinik
 * @discription
 * @date 2019/9/30
 * @since 1.0.0
 */
public interface UserMapper {

    User getUserByUserCode(String userCode);

    int countUser(ListUserRequest request);

    List<User> listUser(ListUserRequest request);
}
