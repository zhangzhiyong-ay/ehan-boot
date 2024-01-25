package cc.ehan.modules.organization.entity;

import cc.ehan.framework.mybatis.entity.BaseEntity;
import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Table;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * (organization_user)表实体类
 *
 * @author zhangzhiyong
 * @since 2024-01-25 14:21:31
 */
@Data
@Accessors(chain = true)
@Table("organization_user")
public class OrganizationUserEntity extends BaseEntity {

    /**
     * 用户昵称
     */
    @Column(value = "name")
    private String name;

    /**
     * 所属部门ID
     */
    @Column(value = "department_id")
    private Long departmentId;

    /**
     * 电子邮箱
     */
    @Column(value = "email")
    private String email;

    /**
     * 手机号
     */
    @Column(value = "phone_number")
    private String phoneNumber;

    /**
     * 用户头像
     */
    @Column(value = "avatar")
    private String avatar;

    /**
     * 用户状态：1:正常 | 2:禁用
     */
    @Column(value = "state")
    private String state;

    /**
     * 备注
     */
    @Column(value = "remark")
    private String remark;

    /**
     * 上次登录IP地址
     */
    @Column(value = "last_login_ip")
    private String lastLoginIp;

    /**
     * 上次登录时间
     */
    @Column(value = "last_login_time")
    private LocalDateTime lastLoginTime;
}

