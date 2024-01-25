package cc.ehan.modules.auth.admin.controller;

import cc.ehan.framework.web.response.ResponseResult;
import cc.ehan.modules.auth.admin.business.AuthBusiness;
import cc.ehan.modules.auth.admin.request.AccountLoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangzhiyong
 */
@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
@Validated
public class AuthController {

    private AuthBusiness authBusiness;

    @PostMapping("account")
    public ResponseResult account(@RequestBody @Validated AccountLoginRequest accountLoginRequest) {
        authBusiness.loginByAccount(accountLoginRequest);
        return ResponseResult.success();
    }
}
