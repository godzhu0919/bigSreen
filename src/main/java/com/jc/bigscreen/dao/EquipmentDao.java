package com.jc.bigscreen.dao;

import com.jc.bigscreen.entity.Equipment;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Equipment)表数据库访问层
 *
 * @author makejava
 * @since 2024-07-26 09:37:12
 */
public interface EquipmentDao {

    /**
     * 通过ID查询单条数据
     *
     * @param equipmentId 主键
     * @return 实例对象
     */
    Equipment queryById(Integer equipmentId);

    /**
     * 查询指定行数据
     *
     * @param equipment 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Equipment> queryAllByLimit(Equipment equipment, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param equipment 查询条件
     * @return 总行数
     */
    long count(Equipment equipment);

    /**
     * 新增数据
     *
     * @param equipment 实例对象
     * @return 影响行数
     */
    int insert(Equipment equipment);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Equipment> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Equipment> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Equipment> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Equipment> entities);

    /**
     * 修改数据
     *
     * @param equipment 实例对象
     * @return 影响行数
     */
    int update(Equipment equipment);

    /**
     * 通过主键删除数据
     *
     * @param equipmentId 主键
     * @return 影响行数
     */
    int deleteById(Integer equipmentId);

}

