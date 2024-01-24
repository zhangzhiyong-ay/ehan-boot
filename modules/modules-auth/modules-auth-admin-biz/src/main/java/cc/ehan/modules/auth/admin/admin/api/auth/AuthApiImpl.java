package cc.ehan.modules.auth.admin.admin.api.auth;

import cc.ehan.modules.auth.admin.api.auth.AuthApi;
import cc.ehan.modules.auth.admin.api.auth.dto.LoginUserInfoResponseDTO;
import cc.ehan.common.base.exception.service.AuthorizedException;
import org.springframework.stereotype.Component;

/**
 * @Author ZhangZhiYong
 */
@Component
public class AuthApiImpl implements AuthApi {
    @Override
    public LoginUserInfoResponseDTO checkAccessToken(String token) throws AuthorizedException {
        return null;
    }
}
