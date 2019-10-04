package com.app.controller;

import com.app.interfaces.TradeFacade;
import com.app.interfaces.request.TradeRequest;
import com.app.interfaces.response.Result;
import com.app.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
    public Result productTrade(@RequestBody TradeRequest request) {
        return tradeService.trade(request);
    }

}
