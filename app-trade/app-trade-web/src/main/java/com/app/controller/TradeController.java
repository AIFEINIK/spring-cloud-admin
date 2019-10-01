package com.app.controller;

import com.app.TradeFacade;
import com.app.service.TradeService;
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
@RequestMapping(TradeFacade.PATH_PREFIX)
public class TradeController implements TradeFacade {

    @Autowired
    private TradeService tradeService;

    @Override
    public String productTrade(String productId, String uid) {
        return tradeService.trade(productId, uid);
    }
}
