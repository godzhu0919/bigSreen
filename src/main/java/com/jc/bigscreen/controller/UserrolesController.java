package com.jc.bigscreen.controller;

import com.jc.bigscreen.entity.Userroles;
import com.jc.bigscreen.service.UserrolesService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Userroles)表控制层
 *
 * @author makejava
 * @since 2024-07-25 17:17:22
 */
@RestController
@RequestMapping("userroles")
public class UserrolesController {
    /**
     * 服务对象
     */
    @Resource
    private UserrolesService userrolesService;

    /**
     * 分页查询
     *
     * @param userroles   筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Userroles>> queryByPage(Userroles userroles, PageRequest pageRequest) {
        return ResponseEntity.ok(this.userrolesService.queryByPage(userroles, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Userroles> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.userrolesService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param userroles 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Userroles> add(Userroles userroles) {
        return ResponseEntity.ok(this.userrolesService.insert(userroles));
    }

    /**
     * 编辑数据
     *
     * @param userroles 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Userroles> edit(Userroles userroles) {
        return ResponseEntity.ok(this.userrolesService.update(userroles));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.userrolesService.deleteById(id));
    }

}

