package com.app.domain;

import com.app.dao.TradeRecordMapper;
import com.app.dao.entity.TradeRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Feinik
 * @discription
 * @date 2019/10/3
 * @since 1.0.0
 */
@Component
public class TradeDomain {

    @Autowired
    private TradeRecordMapper recordMapper;

    public void saveTradeRecord(TradeRecord record) {
        recordMapper.saveTradeRecord(record);
    }
}
