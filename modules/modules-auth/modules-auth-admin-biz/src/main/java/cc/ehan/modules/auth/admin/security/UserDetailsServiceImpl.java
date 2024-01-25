package cc.ehan.modules.auth.admin.security;

import cc.ehan.modules.organization.api.OrganizationUserApi;
import cc.ehan.modules.organization.api.response.OrganizationUserLoginAccountApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * 用户验证处理
 *
 * @Author ZhangZhiYong
 */
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final OrganizationUserApi organizationUserApi;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        OrganizationUserLoginAccountApiResponse response = organizationUserApi.selectLoginAccountByAccountName(username);
        return new AccountUserDetails(response.getId(), response.getAccountName(), response.getAccountPassword(), response.isEnabled());
    }

}
