package com.app.common.constants;

/**
 * @author Feinik
 * @discription
 * @date 2019/10/3
 * @since 1.0.0
 */
public class CommonConstant {

    public static final String DRUID_DATASOURCE_MAXPOOLPREPAREDSTATEMENTPERCONNECTIONSIZE = "druid.maxPoolPreparedStatementPerConnectionSize";
    public static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
    public static final boolean DRUID_TESTONBORROW = true;
    public static final boolean DRUID_TESTONRETURN = true;
    public static final boolean DRUID_TESTWHILEIDLE = true;
    public static final long DRUID_TIMEBETWEENEVICTIONRUNSMILLIS = 1800000;
    public static final long DRUID_MINEVICTABLEIDLETIMEMILLIS = 1800000;
    public static final boolean DRUID_POOLPREPAREDSTATEMENTS = true;
    public static final String DRUID_FILTERS = "stat";
}
