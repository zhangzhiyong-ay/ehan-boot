package cc.ehan.modules.auth.admin.business;

import cc.ehan.framework.security.token.LoginUserInfo;
import cc.ehan.modules.auth.admin.request.AccountLoginRequest;
import cc.ehan.modules.auth.admin.security.AccountUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

/**
 * @author zhangzhiyong
 */
@Service
@RequiredArgsConstructor
public class AuthBusiness {

    private final AuthenticationManager authenticationManager;

    public void loginByAccount(AccountLoginRequest accountLoginRequest) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(accountLoginRequest.getAccountName(), accountLoginRequest.getAccountPassword());
        try {
            authentication = authenticationManager.authenticate(authentication);
        } catch (AuthenticationException e) {
            // TODO 处理登录失败
            throw e;
        }

        LoginUserInfo loginUserInfo = (LoginUserInfo) authentication.getPrincipal();
        Long userId = loginUserInfo.getUserId();
    }
}
