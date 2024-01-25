package cc.ehan.modules.organization.service;

import cc.ehan.modules.organization.mapper.OrganizationRoleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author zhangzhiyong
 * @since 2024-01-25 14:20:37
 */
@Service
@RequiredArgsConstructor
public class OrganizationRoleService {

    private final OrganizationRoleMapper organizationRoleMapper;

}

