package cc.ehan.modules.auth.admin.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author zhangzhiyong
 */
@Data
public class AccountLoginRequest {

    @NotEmpty
    private String accountName;

    @NotEmpty
    private String accountPassword;
}
