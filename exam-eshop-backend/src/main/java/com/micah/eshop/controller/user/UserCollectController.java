package com.micah.eshop.controller.user;

import cn.hutool.core.util.NumberUtil;
import com.micah.eshop.entity.ProductEntity;
import com.micah.eshop.entity.UserBehaviorEntity;
import com.micah.eshop.entity.model.UserBehaviorParam;
import com.micah.eshop.enums.AppHttpCodeEnum;
import com.micah.eshop.handler.SystemException;
import com.micah.eshop.service.ProductService;
import com.micah.eshop.service.UserBehaviorService;
import com.micah.eshop.util.PageUtils;
import com.micah.eshop.util.R;
import com.micah.eshop.util.module.GetUserInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


/**
 * 用户行为表
 *
 * @author micah
 * @email mxmicah@qq.com
 * @date 2023-04-10 16:01:25
 */
@RestController
@RequestMapping("api/collect")
@Api(tags = "收藏接口")
@RequiredArgsConstructor
@CrossOrigin
public class UserCollectController {
    @Autowired
    private UserBehaviorService userBehaviorService;

    @Autowired
    private ProductService productService;


    /**
     * 信息
     */
    @ApiOperation("获取收藏列表")
    @PostMapping("/getCollects")
    public R info(@RequestBody UserBehaviorParam param,HttpServletRequest request){
        Long uid = GetUserInfo.getUid(request);

        //获取所有行为类
        PageUtils behaviors = userBehaviorService.getBehaviors(param.getCurrPage(), uid, 1);
        //提取商品id集合
        ArrayList<Long> pids = new ArrayList<>();
        behaviors.getList().forEach(e->{
            pids.add(((UserBehaviorEntity)e).getProductId());
        });

        //根据ids查询List<ProductEntity> 并且通过分页插件封装
        List<ProductEntity> productEntities = productService.listByIds(pids);
        PageUtils pageUtils = new PageUtils(productEntities, productEntities.size(),10, param.getCurrPage());

        return R.ok().put("page",pageUtils);
    }


    @PostMapping("/add")
    @ApiOperation("添加收藏")
    public R addCollect(@RequestBody UserBehaviorParam param, HttpServletRequest request) {
        Long uid = GetUserInfo.getUid(request);
        //判断商品id是否合法
        if (!NumberUtil.isNumber(param.getProductId())) {
            throw new SystemException(AppHttpCodeEnum.NO_PARAMETE_OPERATE);
        }
        Boolean aBoolean = userBehaviorService.addBehavior(param, uid);

        return R.init(aBoolean, "添加收藏");
    }

    @PostMapping("/del")
    @ApiOperation("取消收藏")
    public R delCollect(@RequestBody UserBehaviorParam param, HttpServletRequest request) {
        Long uid = GetUserInfo.getUid(request);
        //判断商品id是否合法
        if (!NumberUtil.isNumber(param.getProductId())) {
            throw new SystemException(AppHttpCodeEnum.NO_PARAMETE_OPERATE);
        }
        Boolean aBoolean = userBehaviorService.delBehavior(param, uid);

        return R.init(aBoolean, "取消收藏");
    }



    @PostMapping("/dels/{productIds}")
    @ApiOperation("批量取消收藏")
    @ApiImplicitParam(paramType="query", name = "productIds", value = "商品id集合 如: 1,2,3 ", required = true, dataType = "String")
    public R collectDels(@PathVariable String productIds, @RequestBody UserBehaviorParam param, HttpServletRequest request) {
        Long uid = GetUserInfo.getUid(request);
        //获取传来的ID
        String[] listid = productIds.split(",");
        if (listid.length > 0) {
            for (String id : listid) {
                userBehaviorService.delBehavior(new UserBehaviorParam()
                        .setBehaviorType(param.getBehaviorType())
                        .setProductId(id), uid);
            }
        } else {
            throw new SystemException(AppHttpCodeEnum.NO_PARAMETE_OPERATE);
        }
        return R.ok();
    }



//
//    /**
//     * 修改
//     */
//    @PostMapping("/update")
//    @ApiOperation("用户行为表:更新")
//    public R update(@RequestBody UserBehaviorEntity userBehavior){
//		userBehaviorService.updateById(userBehavior);
//
//        return R.ok();
//    }
//
//    /**
//     * 删除
//     */
//    @PostMapping("/delete")
//    @ApiOperation("用户行为表:删除")
//    public R delete(@RequestBody Long[] ids){
//		userBehaviorService.removeByIds(Arrays.asList(ids));
//
//        return R.ok();
//    }

}
