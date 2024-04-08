package com.husg.template.mybatisplusbase.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.husg.template.mybatisplusbase.common.PageConfig;
import com.husg.template.mybatisplusbase.dto.MqPreHandlerDTO;
import com.husg.template.mybatisplusbase.service.MqPreHandlerService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import java.util.List;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import org.ares.margin.api.model.vo.enterprise.MqPreHandlerVO;
import lombok.RequiredArgsConstructor;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hushenggui
 * @since 2023-11-03
 */
@Slf4j
@RestController
@RequestMapping("/mq-pre-handler")
@Valid
@RequiredArgsConstructor
@Api(tags = {"管理"})
public class MqPreHandlerController {

    private final MqPreHandlerService mqPreHandlerService;

    @ApiOperation(value = "分页查询", httpMethod = "POST", response = MqPreHandlerVO.class)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "current", value = "当前页", dataType = "int", example = "1"),
        @ApiImplicitParam(name = "size", value = "分页显示数量", dataType = "int", example = "10"),
    })
    @PostMapping("/page")
    public Page<MqPreHandlerVO> insidePageMqPreHandler(@RequestParam(value="current") Integer current,@RequestParam(value="size") Integer size,
                                                    @RequestBody MqPreHandlerDTO mqPreHandlerDto) {
        Integer currentPage = PageConfig.currentPagination(current);
        Integer pageSize = PageConfig.pageSize(size);
        return mqPreHandlerService.insidePageEnhance(new Page<>(currentPage, pageSize), mqPreHandlerDto);
    }

    @ApiOperation(value = "列表查询", httpMethod = "POST", response = MqPreHandlerVO.class)
    @PostMapping("/list")
    public List<MqPreHandlerVO> insideListMqPreHandler(@RequestBody MqPreHandlerDTO mqPreHandlerDto) {
        return mqPreHandlerService.insideListEnhance(mqPreHandlerDto);
    }

    @ApiOperation(value = "查询详情", httpMethod = "GET", response = MqPreHandlerVO.class)
    @GetMapping("/getById")
    public MqPreHandlerVO insideGetMqPreHandler(@RequestParam(value="id") Long id) {
        return mqPreHandlerService.insideGetEnhanceById(id);
    }

    @ApiOperation(value = "条件查询详情", httpMethod = "GET", response = MqPreHandlerVO.class)
    @GetMapping("/getByParam")
    public MqPreHandlerVO insideGetOneByParam(MqPreHandlerDTO mqPreHandlerDto) {
        return mqPreHandlerService.insideGetOneEnhanceByParam(mqPreHandlerDto);
    }

    @ApiOperation(value = "新增", httpMethod = "POST", response = Boolean.class)
    @PostMapping("/save")
    public Long insideSave(@RequestBody MqPreHandlerDTO mqPreHandlerDto) {
        return mqPreHandlerService.insideSaveEnhance(mqPreHandlerDto);
    }

    @ApiOperation(value = "修改", httpMethod = "POST", response = Boolean.class)
    @PostMapping("/update")
    public Long insideUpdate(@RequestBody MqPreHandlerDTO mqPreHandlerDto) {
        return mqPreHandlerService.insideUpdateEnhance(mqPreHandlerDto);
    }

    @ApiOperation(value = "删除", httpMethod = "DELETE", response = Boolean.class)
    @DeleteMapping("/delete")
    public Boolean insideRemoveById(@RequestParam(value="id") Long id) {
        return mqPreHandlerService.insideRemoveEnhanceById(id);
    }

}
