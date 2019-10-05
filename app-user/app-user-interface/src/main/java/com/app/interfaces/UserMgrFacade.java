package com.app.interfaces;

import com.app.common.page.Page;
import com.app.interfaces.fallback.UserFallbackFactory;
import com.app.interfaces.request.ListUserRequest;
import com.app.interfaces.response.Result;
import com.app.interfaces.response.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Feinik
 * @discription
 * @date 2019/9/25
 * @since 1.0.0
 */
@FeignClient(value = "app-user", fallbackFactory = UserFallbackFactory.class, path = UserMgrFacade.PATH_PREFIX)
public interface UserMgrFacade {

    String PATH_PREFIX = "/userMgr";

    @GetMapping("getUserByUserCode/{userCode}")
    Result<UserResponse> getUserByUserCode(@PathVariable("userCode") String userCode);

    @GetMapping("listUser")
    Result<Page<UserResponse>> listUser(ListUserRequest request);

}
