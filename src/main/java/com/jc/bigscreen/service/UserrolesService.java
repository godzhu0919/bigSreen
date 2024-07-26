package com.jc.bigscreen.service;

import com.jc.bigscreen.entity.Userroles;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Userroles)表服务接口
 *
 * @author makejava
 * @since 2024-07-25 17:17:22
 */
public interface UserrolesService {

    /**
     * 通过ID查询单条数据
     *
     * @param userRoleId 主键
     * @return 实例对象
     */
    Userroles queryById(Integer userRoleId);

    /**
     * 分页查询
     *
     * @param userroles   筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Userroles> queryByPage(Userroles userroles, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param userroles 实例对象
     * @return 实例对象
     */
    Userroles insert(Userroles userroles);

    /**
     * 修改数据
     *
     * @param userroles 实例对象
     * @return 实例对象
     */
    Userroles update(Userroles userroles);

    /**
     * 通过主键删除数据
     *
     * @param userRoleId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer userRoleId);

}
