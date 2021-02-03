package com.atguigu.gulimall.product.controller;

import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.R;
import com.atguigu.gulimall.product.entity.PmsSkuInfoEntity;
import com.atguigu.gulimall.product.service.PmsSkuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * sku信息
 *
 * @author Illidan
 * @email 908128524@qq.com
 * @date 2021-01-07 21:11:35
 */
@RestController
@RequestMapping("product/pmsskuinfo")
public class PmsSkuInfoController {
    @Autowired
    private PmsSkuInfoService pmsSkuInfoService;
    
    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = pmsSkuInfoService.queryPage(params);
        
        return R.ok().put("page", page);
    }
    
    
    /**
     * 信息
     */
    @RequestMapping("/info/{skuId}")
    public R info(@PathVariable("skuId") Long skuId) {
        PmsSkuInfoEntity pmsSkuInfo = pmsSkuInfoService.getById(skuId);
        
        return R.ok().put("pmsSkuInfo", pmsSkuInfo);
    }
    
    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PmsSkuInfoEntity pmsSkuInfo) {
        pmsSkuInfoService.save(pmsSkuInfo);
        
        return R.ok();
    }
    
    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody PmsSkuInfoEntity pmsSkuInfo) {
        pmsSkuInfoService.updateById(pmsSkuInfo);
        
        return R.ok();
    }
    
    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] skuIds) {
        pmsSkuInfoService.removeByIds(Arrays.asList(skuIds));
        
        return R.ok();
    }
    
}
