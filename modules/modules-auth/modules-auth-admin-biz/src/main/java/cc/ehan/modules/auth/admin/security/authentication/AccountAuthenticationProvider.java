package cc.ehan.modules.auth.admin.security.authentication;

import cc.ehan.modules.auth.admin.security.AccountUserDetails;
import cc.ehan.common.base.utils.BeanUtils;
import cc.ehan.framework.security.token.LoginUserInfo;
import cc.ehan.modules.organization.api.OrganizationUserApi;
import cc.ehan.modules.organization.api.response.OrganizationUserInfoApiResponse;
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
            OrganizationUserInfoApiResponse userInfo = organizationUserApi.selectUserInfoByUserId(userId);
            LoginUserInfo loginUserInfo = BeanUtils.copyPropertiesByClass(userInfo, LoginUserInfo.class);
            return super.createSuccessAuthentication(loginUserInfo, authentication, user);
        }
        throw new ClassCastException();
    }
}
