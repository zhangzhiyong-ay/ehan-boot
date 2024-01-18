package cc.ehan;

import cc.ehan.common.config.SystemProperties;
import cn.hutool.extra.spring.SpringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动程序
 *
 * @Author ZhangZhiYong
 */
@Slf4j
@SpringBootApplication
public class AdminApiBootstrapApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminApiBootstrapApplication.class, args);
        SystemProperties systemProperties = SpringUtil.getBean(SystemProperties.class);
        log.info("服务启动成功！项目版本号：" + systemProperties.getProjectVersion());
    }
}
