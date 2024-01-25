package cc.ehan.modules.organization.dto;

import lombok.Data;

/**
 * @author zhangzhiyong
 */
@Data
public class LoginAccountDTO {

    /**
     * 用户唯一标识
     */
    private Long id;

    /**
     * 用户登录账号的用户名
     */
    private String accountName;

    /**
     * 用户登录账号的密码
     */
    private String accountPassword;

    /**
     * 用户状态：1:正常 | 2:禁用
     */
    private String state;
}
