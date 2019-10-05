package com.app.web.controller;

import com.app.common.page.Page;
import com.app.interfaces.UserMgrFacade;
import com.app.interfaces.request.ListUserRequest;
import com.app.interfaces.response.Result;
import com.app.interfaces.response.UserResponse;
import com.app.service.UserMgrService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Feinik
 * @discription
 * @date 2019/9/25
 * @since 1.0.0
 */
@RestController
@Slf4j
@RequestMapping(UserMgrFacade.PATH_PREFIX)
public class UserMgrController implements UserMgrFacade {

    @Autowired
    private UserMgrService userMgrService;

    @Override
    //服务熔断保护
    //@HystrixCommand(fallbackMethod = "getUserByIdErrorFallback")
    public Result<UserResponse> getUserByUserCode(@PathVariable("userCode") String userCode) {
        return userMgrService.getUserByUserCode(userCode);
    }

    //public String getUserByUserCodeErrorFallback(@PathVariable("userCode") String userCode) {
    //    return "fallbackUser";
    //}


    @Override
    public Result<Page<UserResponse>> listUser(ListUserRequest request) {
        return userMgrService.listUser(request);
    }
}
