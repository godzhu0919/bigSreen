package com.jc.bigscreen.dao;

import com.jc.bigscreen.entity.Userroles;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (Userroles)表数据库访问层
 *
 * @author makejava
 * @since 2024-07-25 17:17:22
 */
public interface UserrolesDao {

    /**
     * 通过ID查询单条数据
     *
     * @param userRoleId 主键
     * @return 实例对象
     */
    Userroles queryById(Integer userRoleId);

    /**
     * 查询指定行数据
     *
     * @param userroles 查询条件
     * @param pageable  分页对象
     * @return 对象列表
     */
    List<Userroles> queryAllByLimit(Userroles userroles, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param userroles 查询条件
     * @return 总行数
     */
    long count(Userroles userroles);

    List<Userroles> queryByUserId(@Param("userId") Integer userId);
    /**
     * 新增数据
     *
     * @param userroles 实例对象
     * @return 影响行数
     */
    int insert(Userroles userroles);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Userroles> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Userroles> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Userroles> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Userroles> entities);

    /**
     * 修改数据
     *
     * @param userroles 实例对象
     * @return 影响行数
     */
    int update(Userroles userroles);

    /**
     * 通过主键删除数据
     *
     * @param userRoleId 主键
     * @return 影响行数
     */
    int deleteById(Integer userRoleId);

}

