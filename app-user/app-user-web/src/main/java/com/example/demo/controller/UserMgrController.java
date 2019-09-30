package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.UserMgrFacade;
import com.example.demo.request.UserRequest;
import com.example.demo.service.UserMgrService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String getUserById(String uid) {
        if (uid.equals("999")) {
            throw new IllegalArgumentException("用户ID不合法");
        }
        return userMgrService.getUserById(uid);
    }

    @Override
    public String getUser(UserRequest request) {
        log.info(JSON.toJSONString(request));
        return "getUser";
    }

    //public String getUserByIdErrorFallback(String uid) {
    //    return "fallbackUser";
    //}
}
