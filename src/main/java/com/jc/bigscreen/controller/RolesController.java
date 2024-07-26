package com.jc.bigscreen.controller;

import com.jc.bigscreen.entity.Roles;
import com.jc.bigscreen.service.RolesService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Roles)表控制层
 *
 * @author makejava
 * @since 2024-07-25 17:16:53
 */
@RestController
@RequestMapping("roles")
public class RolesController {
    /**
     * 服务对象
     */
    @Resource
    private RolesService rolesService;

    /**
     * 分页查询
     *
     * @param roles       筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Roles>> queryByPage(Roles roles, PageRequest pageRequest) {
        return ResponseEntity.ok(this.rolesService.queryByPage(roles, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Roles> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.rolesService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param roles 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Roles> add(Roles roles) {
        return ResponseEntity.ok(this.rolesService.insert(roles));
    }

    /**
     * 编辑数据
     *
     * @param roles 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Roles> edit(Roles roles) {
        return ResponseEntity.ok(this.rolesService.update(roles));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.rolesService.deleteById(id));
    }

}

