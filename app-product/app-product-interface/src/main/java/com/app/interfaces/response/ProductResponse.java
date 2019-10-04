package com.app.interfaces.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author Feinik
 * @discription
 * @date 2019/10/3
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class ProductResponse {

    /** 交易记录编号 */
    private String recordCode;

    /** 产品名称 */
    private String productName;

    /** 用户编号 */
    private String userCode;

    /** 创建时间 */
    private String createTime;

    /** 更新时间 */
    private String updateTime;
}
