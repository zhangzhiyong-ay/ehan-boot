package com.mapper;

import java.util.List;

import com.mybatisflex.core.BaseMapper;
import com.mybatisflex.core.query.QueryWrapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.domain.UserEntity;

/**
 * 用户信息表(SysUser)表数据库访问层
 *
 * @Author ZhangZhiYong
 * @since 2024-01-04 18:04:30
 */
public interface SysUserMapper extends BaseMapper<UserEntity> {

/**
* 批量新增或按主键更新数据（MyBatis原生foreach方法）
*
* @param entities List<UserEntity> 实例对象列表
* @return 影响行数
* @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
*/
int insertOrUpdateBatch(@Param("entities") List<UserEntity> entities);

}

