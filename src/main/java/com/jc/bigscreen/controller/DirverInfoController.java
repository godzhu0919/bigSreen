package com.jc.bigscreen.controller;

import com.jc.bigscreen.entity.DirverInfo;
import com.jc.bigscreen.service.DirverInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (DirverInfo)表控制层
 *
 * @author makejava
 * @since 2024-07-26 09:34:49
 */
@RestController
@RequestMapping("dirverInfo")
@Api(tags="司机信息控制器")
public class DirverInfoController {
    /**
     * 服务对象
     */
    @Resource
    private DirverInfoService dirverInfoService;

    /**
     * 分页查询
     *
     * @param dirverInfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    @ApiOperation(value = "分页查询接口")
    public ResponseEntity<Page<DirverInfo>> queryByPage(DirverInfo dirverInfo,  @RequestParam(defaultValue = "0") int page,
                                                        @RequestParam(defaultValue = "10") int size,
                                                        @RequestParam(defaultValue = "name") String sortField,
                                                        @RequestParam(defaultValue = "asc") String sortDirection) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortField);
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        return ResponseEntity.ok(this.dirverInfoService.queryByPage(dirverInfo, pageRequest));
    }


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @ApiOperation(value = "通过主键查询单条数据接口")
    public ResponseEntity<DirverInfo> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.dirverInfoService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param dirverInfo 实体
     * @return 新增结果
     */
    @PostMapping
    @ApiOperation(value = "新增接口")
    public ResponseEntity<DirverInfo> add(DirverInfo dirverInfo) {
        return ResponseEntity.ok(this.dirverInfoService.insert(dirverInfo));
    }

    /**
     * 编辑数据
     *
     * @param dirverInfo 实体
     * @return 编辑结果
     */
    @PutMapping
    @ApiOperation(value = "编辑接口")
    public ResponseEntity<DirverInfo> edit(DirverInfo dirverInfo) {
        return ResponseEntity.ok(this.dirverInfoService.update(dirverInfo));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    @ApiOperation(value = "删除接口")
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.dirverInfoService.deleteById(id));
    }

}

