package cc.ehan.common.base.constant.constant;

import java.time.format.DateTimeFormatter;


/**
 * 日期相关的数据常量
 * @Author ZhangZhiYong
 */
public interface DateFormatStandard {

    /**
     * yyyy-MM
     */
    String DATE_FORMAT = "yyyy-MM-dd";

    /**
     * yyyy-MM-dd HH:mm:ss
     */
    String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * HH:mm:ss
     */
    String TIME_FORMAT = "HH:mm:ss";

    /**
     * yyyy-MM
     */
    String YEAR_MONTH_FORMAT = "yyyy-MM";

    /**
     * yyyy-MM-dd 日期格式化
     */
    DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT);

    /**
     * yyyy-MM-dd HH:mm:ss
     */
    DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);

    /**
     * HH:mm:ss
     */
    DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern(TIME_FORMAT);

    /**
     * yyyy-MM
     */
    DateTimeFormatter YEAR_MONTH_FORMATTER = DateTimeFormatter.ofPattern(YEAR_MONTH_FORMAT);

}
