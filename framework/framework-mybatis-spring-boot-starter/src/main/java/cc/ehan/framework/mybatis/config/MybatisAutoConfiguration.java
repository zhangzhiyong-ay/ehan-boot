package cc.ehan.framework.mybatis.config;

import com.mybatisflex.core.keygen.impl.SnowFlakeIDKeyGenerator;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisAutoConfiguration {
    static {
        SnowFlakeIDKeyGenerator.setTwepoch(1704038400000L);
    }
}
