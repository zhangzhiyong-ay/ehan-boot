package cc.ehan.common.base.constant.constant;

/**
 * i18n 资源 key 常量
 *
 * @Author ZhangZhiYong
 */
public interface MessageSourceCodeStandard {

    /**
     * 用户账号锁定
     */
    String ORGANIZATION_USER_ACCOUNT_LOCKED = "organization.user.account.locked";

    /**
     * 用户账号禁用
     */
    String ORGANIZATION_USER_ACCOUNT_DISABLED = "organization.user.account.disabled";

    /**
     * 账号已过期
     */
    String ORGANIZATION_USER_ACCOUNT_EXPIRED = "organization.user.account.expired";

    /**
     * http 401 状态码，登录未认证授权
     */
    String HTTP_UNAUTHORIZED = "http.unauthorized";

    /**
     * http 403 状态码，无操作权限，禁止操作
     */
    String HTTP_FORBIDDEN = "http.forbidden";

    /**
     * http 404 状态码
     */
    String HTTP_NOT_FOUND = "http.not.found";

    /**
     * http 405 状态码
     */
    String HTTP_BAD_METHOD = "http.bad.method";

    /**
     * http 500 状态码
     */
    String HTTP_INTERNAL_ERROR = "http.internal.error";


}
