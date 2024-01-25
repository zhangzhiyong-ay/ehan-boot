package cc.ehan.modules.auth.admin.api;

import cc.ehan.common.base.exception.service.AuthorizedException;
import cc.ehan.modules.auth.admin.api.dto.LoginUserInfoResponseDTO;
import org.springframework.stereotype.Component;

/**
 * @author zhangzhiyong
 */
@Component
public class AuthApiImpl implements AuthApi {
    @Override
    public LoginUserInfoResponseDTO checkAccessToken(String token) throws AuthorizedException {
        return null;
    }
}
