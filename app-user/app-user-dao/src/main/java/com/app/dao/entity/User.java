package com.app.dao.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author Feinik
 * @discription
 * @date 2019/9/30
 * @since 1.0.0
 */
@Data
public class User {

    /** 用户编号 */
    private String userCode;

    /** 用户名 */
    private String userName;

    /** email */
    private String email;

    /** 创建时间 */
    private String createTime;

    /** 更新时间 */
    private String updateTime;

    /** 电话 */
    private String telephone;

    private Integer status;
}
