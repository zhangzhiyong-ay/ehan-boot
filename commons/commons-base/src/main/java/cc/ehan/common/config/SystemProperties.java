package cc.ehan.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 读取项目相关配置
 *
 * @Author ZhangZhiYong
 */
@Data
@Component
@ConfigurationProperties(prefix = "system")
public class SystemProperties {

    private String projectVersion;

}
