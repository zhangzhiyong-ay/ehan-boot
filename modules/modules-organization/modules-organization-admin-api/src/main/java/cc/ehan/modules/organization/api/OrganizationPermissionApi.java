package cc.ehan.modules.organization.api;

import java.util.List;

/**
 * @Author ZhangZhiYong
 */
public interface OrganizationPermissionApi {

    boolean hasAllPermissions(List<Long> roleIds, String[] permissions);

    boolean hasAnyPermissions(List<Long> roleIds, String[] permissions);
}
