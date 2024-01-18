package com.domain;

import java.io.Serializable;
import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import java.util.Date;
/**
 * 用户信息表(SysUser)表实体类
 *
 * @Author ZhangZhiYong
 * @since 2024-01-04 18:05:39
 */
@Data
@Table("sys_user")
public class UserEntity  {
/**
     * 用户ID
     */
@Id(keyType = KeyType.Auto)
    private Long id;
/**
     * 部门ID
     */
@Column(value = "dept_id")
    private Long deptId;
/**
     * 用户账号
     */
@Column(value = "account")
    private String account;
/**
     * 用户昵称
     */
@Column(value = "nick_name")
    private String nickName;
/**
     * 用户类型: 0:系统超级管理员;1:系统用户
     */
@Column(value = "user_type")
    private String userType;
/**
     * 用户邮箱
     */
@Column(value = "email")
    private String email;
/**
     * 手机号码
     */
@Column(value = "phonenumber")
    private String phonenumber;
/**
     * 头像地址
     */
@Column(value = "avatar")
    private String avatar;
/**
     * 密码
     */
@Column(value = "password")
    private String password;
/**
     * 帐号状态（0正常 1停用）
     */
@Column(value = "status")
    private String status;
/**
     * 最后登录IP
     */
@Column(value = "login_ip")
    private String loginIp;
/**
     * 最后登录时间
     */
@Column(value = "login_date")
    private Date loginDate;
/**
     * 备注
     */
@Column(value = "remark")
    private String remark;
/**
     * 创建人ID
     */
@Column(value = "creator_id")
    private Long creatorId;
/**
     * 创建人姓名
     */
@Column(value = "creator_name")
    private String creatorName;
/**
     * 创建时间
     */
@Column(value = "create_time")
    private Date createTime;
/**
     * 更新人ID
     */
@Column(value = "updater_id")
    private Long updaterId;
/**
     * 更新人姓名
     */
@Column(value = "updater_name")
    private String updaterName;
/**
     * 更新时间
     */
@Column(value = "update_time")
    private Date updateTime;
/**
     * 逻辑删除
     */
@Column(value = "deleted")
    private Boolean deleted;




}

