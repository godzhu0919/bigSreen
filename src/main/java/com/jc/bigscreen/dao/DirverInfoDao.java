package com.jc.bigscreen.dao;

import com.jc.bigscreen.entity.DirverInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (DirverInfo)表数据库访问层
 *
 * @author makejava
 * @since 2024-07-26 09:34:49
 */
public interface DirverInfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    DirverInfo queryById(Integer userId);

    /**
     * 查询指定行数据
     *
     * @param dirverInfo 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<DirverInfo> queryAllByLimit(DirverInfo dirverInfo, @Param("pageable") Pageable pageable);


    List<DirverInfo> queryAll( @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param dirverInfo 查询条件
     * @return 总行数
     */
    long count(DirverInfo dirverInfo);

    /**
     * 新增数据
     *
     * @param dirverInfo 实例对象
     * @return 影响行数
     */
    int insert(DirverInfo dirverInfo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<DirverInfo> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<DirverInfo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<DirverInfo> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<DirverInfo> entities);

    /**
     * 修改数据
     *
     * @param dirverInfo 实例对象
     * @return 影响行数
     */
    int update(DirverInfo dirverInfo);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 影响行数
     */
    int deleteById(Integer userId);

}

