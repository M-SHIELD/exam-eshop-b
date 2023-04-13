package com.micah.eshop.controller;

import java.math.BigDecimal;
import java.util.Date;

import java.util.Arrays;
import java.util.Map;

import com.micah.eshop.entity.model.AddressParam;
import com.micah.eshop.util.BeanCopyUtils;
import com.micah.eshop.util.module.GetUserInfo;
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
import com.micah.eshop.entity.dao.AddressEntity;
import com.micah.eshop.service.AddressService;
import com.micah.eshop.util.PageUtils;
import com.micah.eshop.util.R;

import javax.servlet.http.HttpServletRequest;


/**
 * 收货地址表
 *
 * @author micah
 * @email mxmicah@qq.com
 * @date 2023-04-10 16:01:25
 */
@RestController
@RequestMapping("api/address")
@Api(tags = "收货地址表接口")
@RequiredArgsConstructor
@CrossOrigin
public class AddressController {
    @Autowired
    private AddressService addressService;

    /**
     * 列表
     */
    @PostMapping("/getAddresses")
    @ApiOperation("获取地址列表")
    public R list(@RequestBody AddressParam param, HttpServletRequest request) {
        Long uid = GetUserInfo.getUid(request);
        PageUtils page = addressService.queryPage(param, uid);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @ApiOperation("地址详情")
    @GetMapping("/detail/{id}")
    public R info(@PathVariable("id") Integer id, HttpServletRequest request) {

        AddressEntity address = addressService.getById(id);

        GetUserInfo.havePermission(request, Long.valueOf(address.getUid()));

        return R.ok().put("address", address);
    }

    /**
     * 保存
     */
    @PostMapping("/add")
    @ApiOperation("新建地址")
    public R save(@RequestBody AddressParam param, HttpServletRequest request) {
        Long uid = GetUserInfo.getUid(request);
        //新建对象

        AddressEntity address = BeanCopyUtils.copyBean(param, AddressEntity.class);
        address.setUid(Math.toIntExact(uid));
        address.setId(null);
        address.setLongitude(new BigDecimal("0"));
        address.setLatitude(new BigDecimal("0"));
        address.setCreateTime(new Date());
        address.setUpdateTime(new Date());
        address.setIsDel(0);

        addressService.save(address);
        return R.ok("新建地址成功");
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("更新收货地址")
    public R update(@RequestBody AddressParam param, HttpServletRequest request) {

        Long uid = GetUserInfo.getUid(request);
        AddressEntity address = BeanCopyUtils.copyBean(param, AddressEntity.class);
        address.setUid(Math.toIntExact(uid));
        address.setUpdateTime(new Date());
        address.setIsDel(0);

        addressService.updateById(address);

        return R.ok("更新地址成功");
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("批量删除地址")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request) {

        //循环判断是否拥有权限
        for (AddressEntity listById : addressService.listByIds(Arrays.asList(ids))) {
            GetUserInfo.havePermission(request, Long.valueOf(listById.getUid()));

        }
        //有权限删除
        addressService.removeByIds(Arrays.asList(ids));

        return R.ok("批量删除地址成功");
    }

}
