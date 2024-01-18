package cc.ehan.organization.api.permission;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author ZhangZhiYong
 */
@Component
public class OrganizationPermissionApiImpl implements OrganizationPermissionApi {
    @Override
    public boolean hasAllPermissions(List<Long> roleIds, String[] permissions) {
        return true;
    }

    @Override
    public boolean hasAnyPermissions(List<Long> roleIds, String[] permissions) {
        return true;
    }
}
