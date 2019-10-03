package com.app.service.impl;

import com.app.interfaces.ProductFacade;
import com.app.interfaces.UserMgrFacade;
import com.app.interfaces.response.Result;
import com.app.interfaces.response.UserResponse;
import com.app.service.TradeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Feinik
 * @discription
 * @date 2019/9/25
 * @since 1.0.0
 */
@Service
@Slf4j
public class TradeServiceImpl implements TradeService {

    @Autowired
    private UserMgrFacade userMgrFacade;

    @Autowired
    private ProductFacade productFacade;

    @Override
    public String trade(String productId, String uid) {
        //UserRequest request = new UserRequest();
        //request.setUid(uid);
        //String user = userMgrFacade.getUser(request);

        Result<UserResponse> userResponseResult = userMgrFacade.getUserByUserCode("100");

        UserResponse data = userResponseResult.getData();
        //其他逻辑
        return data.getUserName();
    }
}
