package cc.ehan.modules.organization.service;

import cc.ehan.modules.organization.dto.LoginAccountDTO;
import cc.ehan.modules.organization.mapper.OrganizationUserAccountMapper;
import cc.ehan.modules.organization.mapper.OrganizationUserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author zhangzhiyong
 * @since 2024-01-25 14:21:31
 */
@Service
@RequiredArgsConstructor
public class OrganizationUserService {

    private final OrganizationUserMapper organizationUserMapper;

    private final OrganizationUserAccountMapper organizationUserAccountMapper;

    public LoginAccountDTO selectLoginAccountByAccountName(String accountName) {
        return organizationUserAccountMapper.selectLoginAccount(accountName);
    }
}

