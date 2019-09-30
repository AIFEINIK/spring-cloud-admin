package com.example.demo.service.impl;

import com.example.demo.ProductFacade;
import com.example.demo.UserMgrFacade;
import com.example.demo.request.UserRequest;
import com.example.demo.service.TradeService;
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

        String user = userMgrFacade.getUserById("999");
        if (user == null) {
            return "用户信息不存在";
        }
        log.info("用户信息：{}", user);

        String product = productFacade.getProductById(productId);
        if (product == null) {
            return "商品信息不存在";
        }
        log.info("商品信息：{}", product);

        //其他逻辑
        return "交易成功";
    }
}
