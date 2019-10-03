package com.app.dao;

import com.app.dao.entity.User;

/**
 * @author Feinik
 * @discription
 * @date 2019/9/30
 * @since 1.0.0
 */
public interface UserMapper {

    User getUserByUserCode(String userCode);
}
