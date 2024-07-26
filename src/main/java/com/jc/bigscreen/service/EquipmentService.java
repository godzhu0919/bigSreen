package com.jc.bigscreen.service;

import com.jc.bigscreen.entity.Equipment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Equipment)表服务接口
 *
 * @author makejava
 * @since 2024-07-26 09:37:12
 */
public interface EquipmentService {

    /**
     * 通过ID查询单条数据
     *
     * @param equipmentId 主键
     * @return 实例对象
     */
    Equipment queryById(Integer equipmentId);

    /**
     * 分页查询
     *
     * @param equipment 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Equipment> queryByPage(Equipment equipment, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param equipment 实例对象
     * @return 实例对象
     */
    Equipment insert(Equipment equipment);

    /**
     * 修改数据
     *
     * @param equipment 实例对象
     * @return 实例对象
     */
    Equipment update(Equipment equipment);

    /**
     * 通过主键删除数据
     *
     * @param equipmentId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer equipmentId);

}
