package com.jc.bigscreen.service;

import com.jc.bigscreen.entity.Roles;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Roles)表服务接口
 *
 * @author makejava
 * @since 2024-07-25 17:16:53
 */
public interface RolesService {

    /**
     * 通过ID查询单条数据
     *
     * @param roleId 主键
     * @return 实例对象
     */
    Roles queryById(Integer roleId);

    /**
     * 分页查询
     *
     * @param roles       筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Roles> queryByPage(Roles roles, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param roles 实例对象
     * @return 实例对象
     */
    Roles insert(Roles roles);

    /**
     * 修改数据
     *
     * @param roles 实例对象
     * @return 实例对象
     */
    Roles update(Roles roles);

    /**
     * 通过主键删除数据
     *
     * @param roleId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer roleId);

}
