package cc.ehan.framework.security;

import cc.ehan.common.utils.StringUtils;
import cc.ehan.framework.security.token.LoginUserInfo;
import cc.ehan.organization.api.permission.OrganizationPermissionApi;
import cn.hutool.core.util.ArrayUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @Author ZhangZhiYong
 */
@Service("permissionService")
@RequiredArgsConstructor
public class PermissionService {

    private final OrganizationPermissionApi organizationPermissionApi;

    private final SecurityManager securityManager;

    /**
     * 验证用户是否具备某权限
     *
     * @param permission 权限字符串
     * @return 用户是否具备某权限
     */
    public boolean hasPermission(String permission) {
        if (StringUtils.isEmpty(permission)) {
            return false;
        }

        LoginUserInfo loginUserInfo = securityManager.getLoginUserInfoOrThrow();
        if (securityManager.isSuperAdmin(loginUserInfo)) {
            return true;
        }
        return organizationPermissionApi.hasAllPermissions(loginUserInfo.getRoleIds(), new String[]{permission});
    }

    public boolean hasAnyPermission(String[] permissions) {
        if (ArrayUtil.isEmpty(permissions)) {
            return false;
        }
        LoginUserInfo loginUserInfo = securityManager.getLoginUserInfoOrThrow();
        if (securityManager.isSuperAdmin(loginUserInfo)) {
            return true;
        }
        return organizationPermissionApi.hasAnyPermissions(loginUserInfo.getRoleIds(), permissions);

    }

}
