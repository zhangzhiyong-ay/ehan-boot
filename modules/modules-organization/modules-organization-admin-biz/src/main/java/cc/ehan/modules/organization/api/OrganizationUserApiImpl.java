package cc.ehan.modules.organization.api;

import cc.ehan.modules.organization.api.convert.UserApiConvert;
import cc.ehan.modules.organization.api.response.OrganizationUserInfoApiResponse;
import cc.ehan.modules.organization.api.response.OrganizationUserLoginAccountApiResponse;
import cc.ehan.modules.organization.business.OrganizationUserBusiness;
import cc.ehan.modules.organization.dto.LoginAccountDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @Author ZhangZhiYong
 */
@Component
@RequiredArgsConstructor
public class OrganizationUserApiImpl implements OrganizationUserApi {

    private final OrganizationUserBusiness organizationUserBusiness;

    @Override
    public OrganizationUserInfoApiResponse selectUserInfoByUserId(Long userId) {
        return null;
    }

    @Override
    public OrganizationUserLoginAccountApiResponse selectLoginAccountByAccountName(String accountName) {
        LoginAccountDTO loginAccountDTO = organizationUserBusiness.selectLoginAccountByAccountName(accountName);
        OrganizationUserLoginAccountApiResponse response = UserApiConvert.INSTANCE.loginAccount(loginAccountDTO);
        return response;
    }
}
