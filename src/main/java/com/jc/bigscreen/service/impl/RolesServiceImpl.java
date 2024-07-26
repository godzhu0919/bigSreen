package com.jc.bigscreen.service.impl;

import com.jc.bigscreen.entity.Roles;
import com.jc.bigscreen.dao.RolesDao;
import com.jc.bigscreen.service.RolesService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Roles)表服务实现类
 *
 * @author makejava
 * @since 2024-07-25 17:16:53
 */
@Service("rolesService")
public class RolesServiceImpl implements RolesService {
    @Resource
    private RolesDao rolesDao;

    /**
     * 通过ID查询单条数据
     *
     * @param roleId 主键
     * @return 实例对象
     */
    @Override
    public Roles queryById(Integer roleId) {
        return this.rolesDao.queryById(roleId);
    }

    /**
     * 分页查询
     *
     * @param roles       筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Roles> queryByPage(Roles roles, PageRequest pageRequest) {
        long total = this.rolesDao.count(roles);
        return new PageImpl<>(this.rolesDao.queryAllByLimit(roles, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param roles 实例对象
     * @return 实例对象
     */
    @Override
    public Roles insert(Roles roles) {
        this.rolesDao.insert(roles);
        return roles;
    }

    /**
     * 修改数据
     *
     * @param roles 实例对象
     * @return 实例对象
     */
    @Override
    public Roles update(Roles roles) {
        this.rolesDao.update(roles);
        return this.queryById(roles.getRoleId());
    }

    /**
     * 通过主键删除数据
     *
     * @param roleId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer roleId) {
        return this.rolesDao.deleteById(roleId) > 0;
    }
}
