package com.app.interfaces;

import com.app.interfaces.fallback.UserFallbackFactory;
import com.app.interfaces.request.UserRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Feinik
 * @discription
 * @date 2019/9/25
 * @since 1.0.0
 */
@FeignClient(value = "app-user", path = UserMgrFacade.PATH_PREFIX, fallbackFactory = UserFallbackFactory.class)
public interface UserMgrFacade {

    String PATH_PREFIX = "/userMgr";

    @GetMapping("getUserById")
    String getUserById(@RequestParam(value = "uid") String uid);

    @GetMapping("getUser")
    String getUser(UserRequest request);
}
