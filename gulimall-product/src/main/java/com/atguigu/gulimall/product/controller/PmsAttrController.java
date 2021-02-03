package com.atguigu.gulimall.product.controller;

import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.R;
import com.atguigu.gulimall.product.entity.PmsAttrEntity;
import com.atguigu.gulimall.product.service.PmsAttrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 商品属性
 *
 * @author Illidan
 * @email 908128524@qq.com
 * @date 2021-01-07 21:11:35
 */
@RestController
@RequestMapping("product/pmsattr")
public class PmsAttrController {
    @Autowired
    private PmsAttrService pmsAttrService;

    /**
     * 列表
     */
    @RequestMapping("/list")
            public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = pmsAttrService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{attrId}")
            public R info(@PathVariable("attrId") Long attrId) {
            PmsAttrEntity pmsAttr = pmsAttrService.getById(attrId);

        return R.ok().put("pmsAttr", pmsAttr);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
            public R save(@RequestBody PmsAttrEntity pmsAttr) {
            pmsAttrService.save(pmsAttr);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
            public R update(@RequestBody PmsAttrEntity pmsAttr) {
            pmsAttrService.updateById(pmsAttr);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
            public R delete(@RequestBody Long[] attrIds) {
            pmsAttrService.removeByIds(Arrays.asList(attrIds));

        return R.ok();
    }

}
