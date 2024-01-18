package cc.ehan.framework.web.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Set;

/**
 * @Author ZhangZhiYong
 */
@Data
@ConfigurationProperties("system.filter")
public class FilterProperties {

    private Xss xss = new Xss();

    @Data
    public static class Xss {

        private String filterName = "xssFilter";

        private boolean enable;

        private Set<String> urlPatterns = Set.of("/");

        private Set<String> excludeUrl;
    }
}
