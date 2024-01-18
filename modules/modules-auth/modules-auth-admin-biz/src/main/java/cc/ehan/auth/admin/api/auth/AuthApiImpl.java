package cc.ehan.auth.admin.api.auth;

import cc.ehan.auth.admin.api.auth.dto.LoginUserInfoResponseDTO;
import cc.ehan.common.exception.service.AuthorizedException;
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
