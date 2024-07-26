package com.jc.bigscreen.service;

import com.jc.bigscreen.entity.DirverInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (DirverInfo)表服务接口
 *
 * @author makejava
 * @since 2024-07-26 09:34:49
 */
public interface DirverInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    DirverInfo queryById(Integer userId);

    /**
     * 分页查询
     *
     * @param dirverInfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<DirverInfo> queryByPage(DirverInfo dirverInfo, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param dirverInfo 实例对象
     * @return 实例对象
     */
    DirverInfo insert(DirverInfo dirverInfo);

    /**
     * 修改数据
     *
     * @param dirverInfo 实例对象
     * @return 实例对象
     */
    DirverInfo update(DirverInfo dirverInfo);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer userId);

}
