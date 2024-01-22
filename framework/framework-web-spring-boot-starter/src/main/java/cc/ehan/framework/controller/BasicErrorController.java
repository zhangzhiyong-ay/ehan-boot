package cc.ehan.framework.controller;

import cc.ehan.framework.web.response.ResponseResult;
import cn.hutool.http.HttpStatus;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangzhiyong
 */
@RestController
@RequestMapping("${server.error.path:${error.path:/error}}")
public class BasicErrorController implements ErrorController {

    @RequestMapping
    public ResponseEntity error() {
        ResponseResult.fail().code(HttpStatus.HTTP_NOT_FOUND)
                .message(messagesou)
    }
}
