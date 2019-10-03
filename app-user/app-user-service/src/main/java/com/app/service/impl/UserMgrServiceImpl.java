package com.app.service.impl;

import com.app.common.utils.BeanUtils;
import com.app.dao.entity.User;
import com.app.domain.UserDomain;
import com.app.interfaces.enums.ReturnStatusEnum;
import com.app.interfaces.response.Result;
import com.app.interfaces.response.UserResponse;
import com.app.service.UserMgrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Feinik
 * @discription
 * @date 2019/9/25
 * @since 1.0.0
 */
@Service
public class UserMgrServiceImpl implements UserMgrService {

    @Autowired
    private UserDomain userDomain;

    @Override
    public Result<UserResponse> getUserByUserCode(String userCode) {
        User user = userDomain.getUserByUserCode(userCode);
        if (user == null) {
            return new Result<>(ReturnStatusEnum.USER_NOT_EXISTS.getValue(), ReturnStatusEnum.USER_NOT_EXISTS.getName());
        }

        final UserResponse userResponse = BeanUtils.transform(UserResponse.class, user, true);
        return new Result<>(userResponse);
    }
}
