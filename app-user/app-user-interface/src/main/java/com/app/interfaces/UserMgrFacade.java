package com.app.interfaces;

import com.app.interfaces.fallback.UserFallbackFactory;
import com.app.interfaces.request.UserRequest;
import com.app.interfaces.response.Result;
import com.app.interfaces.response.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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
    Result<UserResponse> getUserByUserCode(@PathVariable (value = "userCode") String userCode);

    @GetMapping("getUser")
    String getUser(UserRequest request);
}
