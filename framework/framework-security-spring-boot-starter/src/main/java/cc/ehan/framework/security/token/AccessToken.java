package cc.ehan.framework.security.token;

import cn.hutool.core.date.LocalDateTimeUtil;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @author zhangzhiyong
 */
@Data
@Accessors(chain = true)
public class AccessToken {

    private String token;

    private Long userId;

    /**
     * 登录时间的毫秒时间戳
     */
    private Long loginTimestamp;

    /**
     * 过期时间的毫秒时间戳
     */
    private Long expireTimestamp;

    private String loginIp;

    public AccessToken withLoginTime(LocalDateTime loginTime) {
        this.loginTimestamp = LocalDateTimeUtil.toEpochMilli(loginTime);
        return this;
    }

    public AccessToken withExpireTimestamp(LocalDateTime expireTime) {
        this.expireTimestamp = LocalDateTimeUtil.toEpochMilli(expireTime);
        return this;
    }
}
