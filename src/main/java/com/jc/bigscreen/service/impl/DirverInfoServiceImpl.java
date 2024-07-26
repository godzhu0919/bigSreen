package com.jc.bigscreen.service.impl;

import com.jc.bigscreen.entity.DirverInfo;
import com.jc.bigscreen.dao.DirverInfoDao;
import com.jc.bigscreen.service.DirverInfoService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (DirverInfo)表服务实现类
 *
 * @author makejava
 * @since 2024-07-26 09:34:49
 */
@Service("dirverInfoService")
public class DirverInfoServiceImpl implements DirverInfoService {
    @Resource
    private DirverInfoDao dirverInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    @Override
    public DirverInfo queryById(Integer userId) {
        return this.dirverInfoDao.queryById(userId);
    }

    /**
     * 分页查询
     *
     * @param dirverInfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<DirverInfo> queryByPage(DirverInfo dirverInfo, PageRequest pageRequest) {
        long total = this.dirverInfoDao.count(dirverInfo);
        return new PageImpl<>(this.dirverInfoDao.queryAllByLimit(dirverInfo, pageRequest), pageRequest, total);
    }



    /**
     * 新增数据
     *
     * @param dirverInfo 实例对象
     * @return 实例对象
     */
    @Override
    public DirverInfo insert(DirverInfo dirverInfo) {
        this.dirverInfoDao.insert(dirverInfo);
        return dirverInfo;
    }

    /**
     * 修改数据
     *
     * @param dirverInfo 实例对象
     * @return 实例对象
     */
    @Override
    public DirverInfo update(DirverInfo dirverInfo) {
        this.dirverInfoDao.update(dirverInfo);
        return this.queryById(dirverInfo.getUserId());
    }

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer userId) {
        return this.dirverInfoDao.deleteById(userId) > 0;
    }
}
