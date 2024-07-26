package com.jc.bigscreen.service.impl;

import com.jc.bigscreen.entity.Userroles;
import com.jc.bigscreen.dao.UserrolesDao;
import com.jc.bigscreen.service.UserrolesService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Userroles)表服务实现类
 *
 * @author makejava
 * @since 2024-07-25 17:17:22
 */
@Service("userrolesService")
public class UserrolesServiceImpl implements UserrolesService {
    @Resource
    private UserrolesDao userrolesDao;

    /**
     * 通过ID查询单条数据
     *
     * @param userRoleId 主键
     * @return 实例对象
     */
    @Override
    public Userroles queryById(Integer userRoleId) {
        return this.userrolesDao.queryById(userRoleId);
    }

    /**
     * 分页查询
     *
     * @param userroles   筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Userroles> queryByPage(Userroles userroles, PageRequest pageRequest) {
        long total = this.userrolesDao.count(userroles);
        return new PageImpl<>(this.userrolesDao.queryAllByLimit(userroles, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param userroles 实例对象
     * @return 实例对象
     */
    @Override
    public Userroles insert(Userroles userroles) {
        this.userrolesDao.insert(userroles);
        return userroles;
    }

    /**
     * 修改数据
     *
     * @param userroles 实例对象
     * @return 实例对象
     */
    @Override
    public Userroles update(Userroles userroles) {
        this.userrolesDao.update(userroles);
        return this.queryById(userroles.getUserRoleId());
    }

    /**
     * 通过主键删除数据
     *
     * @param userRoleId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer userRoleId) {
        return this.userrolesDao.deleteById(userRoleId) > 0;
    }
}
