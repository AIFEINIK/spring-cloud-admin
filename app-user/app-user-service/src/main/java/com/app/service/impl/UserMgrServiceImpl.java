package com.app.service.impl;

import com.app.common.page.Page;
import com.app.common.utils.BeanUtils;
import com.app.common.utils.PageUtils;
import com.app.dao.entity.User;
import com.app.domain.UserDomain;
import com.app.interfaces.enums.ReturnStatusEnum;
import com.app.interfaces.enums.UserStatusEnum;
import com.app.interfaces.request.ListUserRequest;
import com.app.interfaces.response.Result;
import com.app.interfaces.response.UserResponse;
import com.app.service.UserMgrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public Result<Page<UserResponse>> listUser(ListUserRequest request) {
        int count = userDomain.countUser(request);
        if (count == 0) {
            return Result.emptyPageResult();
        }
        List<User> users = userDomain.ListUser(PageUtils.calculatePage(request, count));

        List<UserResponse> userResponses = new ArrayList<>();
        for (User user : users) {
            UserResponse res = BeanUtils.transform(UserResponse.class, user, true);
            res.setStatus(UserStatusEnum.getType(user.getStatus()));
            userResponses.add(res);
        }
        return new Result<>(new Page<>(count, userResponses));
    }
}
