package cc.ehan.modules.auth.admin.api;

import cc.ehan.modules.auth.admin.api.AuthApi;
import cc.ehan.modules.auth.admin.api.dto.LoginUserInfoResponseDTO;
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
