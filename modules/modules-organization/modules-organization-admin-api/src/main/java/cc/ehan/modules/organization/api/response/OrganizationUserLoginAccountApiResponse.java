package cc.ehan.modules.organization.api.response;

import lombok.Data;

/**
 * @author zhangzhiyong
 */
@Data
public class OrganizationUserLoginAccountApiResponse {

    private Long id;

    private String accountName;

    private String accountPassword;

    private boolean enabled;
}
