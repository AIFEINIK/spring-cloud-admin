package com.app.dao.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author Feinik
 * @discription
 * @date 2019/9/30
 * @since 1.0.0
 */
@Data
@Accessors(chain = true)
public class TradeRecord {

    /** 交易记录编号 */
    private String recordCode;

    /** 产品名称 */
    private String productName;

    /** 用户编号 */
    private String userCode;

    /** 创建时间 */
    private Date createTime;

    /** 更新时间 */
    private Date updateTime;

}
