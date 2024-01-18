package cc.ehan.framework.redis.config;

import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;

/**
 * @Author ZhangZhiYong
 */
@Configuration
public class RedisCacheAutoConfiguration implements RedisCacheManagerBuilderCustomizer {
    @Override
    public void customize(RedisCacheManager.RedisCacheManagerBuilder builder) {

    }
}
