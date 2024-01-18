package cc.ehan.auth.admin.security.authentication;

import cc.ehan.auth.admin.security.AccountUserDetails;
import cc.ehan.common.utils.BeanUtils;
import cc.ehan.framework.security.token.LoginUserInfo;
import cc.ehan.organization.api.user.OrganizationUserApi;
import cc.ehan.organization.api.user.dto.OrganizationUserInfoResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

@RequiredArgsConstructor
public class AccountAuthenticationProvider extends DaoAuthenticationProvider {

    private final OrganizationUserApi organizationUserApi;

    @Override
    protected Authentication createSuccessAuthentication(Object principal, Authentication authentication, UserDetails user) {
        if (principal instanceof AccountUserDetails) {
            Long userId = ((AccountUserDetails) principal).getUserId();
            OrganizationUserInfoResponseDTO userInfo = organizationUserApi.selectUserInfoByUserId(userId);
            LoginUserInfo loginUserInfo = BeanUtils.copyPropertiesByClass(userInfo, LoginUserInfo.class);
            return super.createSuccessAuthentication(loginUserInfo, authentication, user);
        }
        throw new ClassCastException();
    }
}
