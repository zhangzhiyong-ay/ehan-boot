package cc.ehan.modules.organization.entity;

import cc.ehan.framework.mybatis.entity.BaseEntity;
import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Table;
import lombok.Data;

/**
 * (organization_user_account)表实体类
 *
 * @author zhangzhiyong
 * @since 2024-01-25 14:42:20
 */
@Data
@Table("organization_user_account")
public class OrganizationUserAccountEntity extends BaseEntity {

    /**
     * 账号用户名
     */
    @Column(value = "account_name")
    private String accountName;

    /**
     * 账号密码
     */
    @Column(value = "account_password")
    private String accountPassword;
}

