package com.app.interfaces;

import com.app.interfaces.request.TradeRequest;
import com.app.interfaces.response.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author Feinik
 * @discription
 * @date 2019/9/25
 * @since 1.0.0
 */
@FeignClient(value = "app-trade", path = TradeFacade.PATH_PREFIX)
public interface TradeFacade {

    String PATH_PREFIX = "/trade";

    @PostMapping(value = "productTrade")
    Result productTrade(@RequestBody TradeRequest request);

}
