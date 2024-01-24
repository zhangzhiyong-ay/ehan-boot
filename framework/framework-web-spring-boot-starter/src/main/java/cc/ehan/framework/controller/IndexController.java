package cc.ehan.framework.controller;

import cc.ehan.common.base.config.config.SystemProperties;
import cc.ehan.framework.web.response.ResponseResult;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ZhangZhiYong
 */
@RestController
@ConditionalOnProperty(name = "system.index.enable", havingValue = "true")
@RequiredArgsConstructor
public class IndexController {

    private final SystemProperties systemProperties;

    @GetMapping("/")
    public ResponseResult index() {
        return ResponseResult
                .success()
                .message("项目启动成功，当前项目版本号为：" + systemProperties.getProjectVersion());
    }
}
