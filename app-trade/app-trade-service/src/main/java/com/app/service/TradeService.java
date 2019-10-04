package com.app.service;

import com.app.interfaces.request.TradeRequest;
import com.app.interfaces.response.Result;

/**
 * @author Feinik
 * @discription
 * @date 2019/9/25
 * @since 1.0.0
 */
public interface TradeService {

    Result trade(TradeRequest request);
}
