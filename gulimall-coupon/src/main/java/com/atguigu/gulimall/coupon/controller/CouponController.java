package com.atguigu.gulimall.coupon.controller;

import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.R;
import com.atguigu.gulimall.coupon.entity.CouponEntity;
import com.atguigu.gulimall.coupon.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;


/**
 * 优惠券信息
 *
 * @author Illidan
 * @email 908128524@qq.com
 * @date 2021-01-07 23:56:54
 */
@RefreshScope
@RestController
@RequestMapping("coupon/coupon")
public class CouponController {
    
    @Autowired
    private CouponService couponService;
    
    @Value("${nacos.config.name}")
    private String name;
    
    /**
     * 测试从配置中心获取配置信息
     *
     * @return 配置中心的配置
     */
    @RequestMapping("/test")
    public R test() {
        return R.ok().put("name", name);
    }
    
    @RequestMapping("/member/list")
    public R memberConpons() {
        CouponEntity couponEntity = new CouponEntity();
        couponEntity.setCouponName("满100减10");
        return R.ok().put("coupons", Collections.singletonList(couponEntity));
    }
    
    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = couponService.queryPage(params);
        return R.ok().put("page", page);
    }
    
    
    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        CouponEntity coupon = couponService.getById(id);
        
        return R.ok().put("coupon", coupon);
    }
    
    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CouponEntity coupon) {
        couponService.save(coupon);
        
        return R.ok();
    }
    
    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody CouponEntity coupon) {
        couponService.updateById(coupon);
        
        return R.ok();
    }
    
    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        couponService.removeByIds(Arrays.asList(ids));
        
        return R.ok();
    }
    
}
