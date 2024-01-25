package cc.ehan.modules.organization.business;

import cc.ehan.modules.organization.dto.LoginAccountDTO;
import cc.ehan.modules.organization.service.OrganizationUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @Author ZhangZhiYong
 */
@RequiredArgsConstructor
@Component
public class OrganizationUserBusiness {

    private final OrganizationUserService organizationUserService;

    public LoginAccountDTO selectLoginAccountByAccountName(String accountName) {
        return organizationUserService.selectLoginAccountByAccountName(accountName);
    }
}
