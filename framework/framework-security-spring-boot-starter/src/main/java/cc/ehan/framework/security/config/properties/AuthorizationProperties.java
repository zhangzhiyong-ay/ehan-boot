package cc.ehan.framework.security.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author ZhangZhiYong
 */
@ConfigurationProperties("system.authorization")
@Data
public class AuthorizationProperties {

    private String headerName;
}
