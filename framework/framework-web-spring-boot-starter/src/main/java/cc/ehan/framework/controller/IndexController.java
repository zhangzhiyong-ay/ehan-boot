package cc.ehan.framework.controller;

import cc.ehan.common.config.SystemProperties;
import cc.ehan.framework.web.response.ResponseResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ZhangZhiYong
 */
@RestController
@RequiredArgsConstructor
public class IndexController {

    private final SystemProperties systemProperties;

    @GetMapping("/")
    public ResponseResult index() {
        return ResponseResult.success("项目启动成功，当前项目版本号为：" + systemProperties.getProjectVersion());
    }
}
