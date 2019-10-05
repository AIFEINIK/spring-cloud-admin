package com.app.service.impl;

import com.app.common.utils.IDGenerator;
import com.app.dao.entity.TradeRecord;
import com.app.domain.TradeDomain;
import com.app.interfaces.ProductFacade;
import com.app.interfaces.UserMgrFacade;
import com.app.interfaces.enums.ReturnStatusEnum;
import com.app.interfaces.request.TradeRequest;
import com.app.interfaces.response.ProductResponse;
import com.app.interfaces.response.Result;
import com.app.interfaces.response.UserResponse;
import com.app.service.TradeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

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

    @Autowired
    private TradeDomain tradeDomain;

    @Override
    public Result trade(TradeRequest request) {
        Result<UserResponse> userResponseResult = userMgrFacade.getUserByUserCode(request.getUserCode());

        if (userResponseResult.getStatus() != ReturnStatusEnum.SUCCESS.getValue()) {
            return new Result<ProductResponse>(ReturnStatusEnum.TRADE_FAILED.getValue(), ReturnStatusEnum.TRADE_FAILED.getName());
        }

        Result<ProductResponse> productResponseResult = productFacade.getProductByCode(request.getProductCode());

        if (productResponseResult.getStatus() != ReturnStatusEnum.SUCCESS.getValue()) {
            return new Result<ProductResponse>(ReturnStatusEnum.TRADE_FAILED.getValue(), ReturnStatusEnum.TRADE_FAILED.getName());
        }

        TradeRecord record = new TradeRecord()
                .setRecordCode(IDGenerator.createId().toString())
                .setCreateTime(new Date())
                .setUpdateTime(new Date())
                .setProductName(productResponseResult.getData().getProductName())
                .setUserCode(userResponseResult.getData().getUserCode());
        tradeDomain.saveTradeRecord(record);
        //其他逻辑
        return new Result<>();
    }
}
