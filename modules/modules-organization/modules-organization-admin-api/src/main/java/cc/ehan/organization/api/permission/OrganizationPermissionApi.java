package cc.ehan.organization.api.permission;

import java.util.List;

/**
 * @Author ZhangZhiYong
 */
public interface OrganizationPermissionApi {

    boolean hasAllPermissions(List<Long> roleIds, String[] permissions);

    boolean hasAnyPermissions(List<Long> roleIds, String[] permissions);
}
