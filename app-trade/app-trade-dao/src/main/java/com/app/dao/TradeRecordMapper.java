package com.app.dao;

import com.app.dao.entity.TradeRecord;

/**
 * @author Feinik
 * @discription
 * @date 2019/9/30
 * @since 1.0.0
 */
public interface TradeRecordMapper {

    TradeRecord getRecordByRecordCode(String recordCode);

    int saveTradeRecord(TradeRecord record);
}
