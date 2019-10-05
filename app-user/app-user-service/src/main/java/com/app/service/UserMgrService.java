package com.app.service;

import com.app.common.page.Page;
import com.app.interfaces.request.ListUserRequest;
import com.app.interfaces.response.Result;
import com.app.interfaces.response.UserResponse;

/**
 * @author Feinik
 * @discription
 * @date 2019/9/25
 * @since 1.0.0
 */
public interface UserMgrService {

    Result<UserResponse> getUserByUserCode(String userCode);

    Result<Page<UserResponse>> listUser(ListUserRequest request);
}
