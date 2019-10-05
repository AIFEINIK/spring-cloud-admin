package com.app.common.page;

import com.app.common.annotation.RequiredParam;
import com.app.common.utils.DateUtils;
import lombok.Data;

/**
 * @author Feinik
 * @Discription 分页request
 * @Data 2019/3/25
 * @Version 1.0.0
 */
@Data
public class PageRequest {

    /** 每页大小 */
    @RequiredParam
    protected int pageSize = 20;

    /** 当前页 */
    @RequiredParam
    protected int pageNum = 1;

    /** 记录开始位置 */
    protected int pageFrom;

    /** 查询开始时间 */
    protected String startTime;

    /** 查询结束时间 */
    protected String endTime;

    public void setEndTime(String endTime) {
        this.endTime = DateUtils.getEndTime(endTime);
    }
}
