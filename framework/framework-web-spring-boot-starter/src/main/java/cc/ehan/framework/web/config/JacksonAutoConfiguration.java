package cc.ehan.framework.web.config;

import cc.ehan.common.utils.JsonUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonAutoConfiguration {

    @Bean
    public ObjectMapper objectMapper() {
        return JsonUtils.OBJECT_MAPPER;
    }
}
