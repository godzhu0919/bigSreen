package com.jc.bigscreen.service.impl;

import com.jc.bigscreen.entity.Equipment;
import com.jc.bigscreen.dao.EquipmentDao;
import com.jc.bigscreen.service.EquipmentService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Equipment)表服务实现类
 *
 * @author makejava
 * @since 2024-07-26 09:37:12
 */
@Service("equipmentService")
public class EquipmentServiceImpl implements EquipmentService {
    @Resource
    private EquipmentDao equipmentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param equipmentId 主键
     * @return 实例对象
     */
    @Override
    public Equipment queryById(Integer equipmentId) {
        return this.equipmentDao.queryById(equipmentId);
    }

    /**
     * 分页查询
     *
     * @param equipment 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Equipment> queryByPage(Equipment equipment, PageRequest pageRequest) {
        long total = this.equipmentDao.count(equipment);
        return new PageImpl<>(this.equipmentDao.queryAllByLimit(equipment, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param equipment 实例对象
     * @return 实例对象
     */
    @Override
    public Equipment insert(Equipment equipment) {
        this.equipmentDao.insert(equipment);
        return equipment;
    }

    /**
     * 修改数据
     *
     * @param equipment 实例对象
     * @return 实例对象
     */
    @Override
    public Equipment update(Equipment equipment) {
        this.equipmentDao.update(equipment);
        return this.queryById(equipment.getEquipmentId());
    }

    /**
     * 通过主键删除数据
     *
     * @param equipmentId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer equipmentId) {
        return this.equipmentDao.deleteById(equipmentId) > 0;
    }
}
