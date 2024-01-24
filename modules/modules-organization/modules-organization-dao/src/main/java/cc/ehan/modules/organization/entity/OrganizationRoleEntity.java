package cc.ehan.modules.organization.entity;

import cc.ehan.framework.mybatis.entity.BaseEntity;
import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Table;
import lombok.Data;

/**
 * (OrganizationRole)表实体类
 *
 * @author zhangzhiyong
 * @since 2024-01-24 18:07:32
 */
@Data
@Table("organization_role")
public class OrganizationRoleEntity extends BaseEntity {

    /**
     * 角色名称
     */

    @Column(value = "name")
    private String name;

    /**
     * 角色字符，administrator为保留关键字，表示系统管理员
     */

    @Column(value = "key")
    private String key;

    /**
     * 角色状态(1:启用 | 2:禁用)
     */

    @Column(value = "state")
    private String state;

    /**
     * 备注
     */

    @Column(value = "remark")
    private String remark;
}

