package com.micah.eshop.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.ApiOperation;
import com.micah.eshop.entity.EvaluationEntity;
import com.micah.eshop.service.EvaluationService;
import com.micah.eshop.util.PageUtils;
import com.micah.eshop.util.R;



/**
 * 评价表
 *
 * @author micah
 * @email mxmicah@qq.com
 * @date 2023-04-10 16:01:25
 */
@RestController
@RequestMapping("api/evaluation")
@Api(tags = "评价表接口")
@RequiredArgsConstructor
@CrossOrigin
public class EvaluationController {
    @Autowired
    private EvaluationService evaluationService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @ApiOperation("评价表:列表:自定义参数")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = evaluationService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @ApiOperation("评价表:信息:id")
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		EvaluationEntity evaluation = evaluationService.getById(id);

        return R.ok().put("evaluation", evaluation);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation("评价表:保存")
    public R save(@RequestBody EvaluationEntity evaluation){
		evaluationService.save(evaluation);

        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("评价表:更新")
    public R update(@RequestBody EvaluationEntity evaluation){
		evaluationService.updateById(evaluation);

        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("评价表:删除")
    public R delete(@RequestBody Integer[] ids){
		evaluationService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
