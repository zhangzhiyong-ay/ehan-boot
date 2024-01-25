package cc.ehan.framework.security.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author ZhangZhiYong
 */
@ConfigurationProperties("system.authorization")
@Data
public class AuthorizationProperties {

    /**
     * request 获取 token 的请求头
     */
    private String headerName;

    /**
     * token 缓存的key前缀
     */
    private String tokenCacheKey;

    /**
     * token 过期时间，单位分钟
     */
    private Long tokenExpireTime;

}
