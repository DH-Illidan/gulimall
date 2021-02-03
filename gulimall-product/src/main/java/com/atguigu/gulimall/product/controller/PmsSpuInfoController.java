package com.atguigu.gulimall.product.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.gulimall.product.entity.PmsSpuInfoEntity;
import com.atguigu.gulimall.product.service.PmsSpuInfoService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.R;


/**
 * spu信息
 *
 * @author Illidan
 * @email 908128524@qq.com
 * @date 2021-01-07 21:11:34
 */
@RestController
@RequestMapping("product/pmsspuinfo")
public class PmsSpuInfoController {
    @Autowired
    private PmsSpuInfoService pmsSpuInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
            public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = pmsSpuInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
            public R info(@PathVariable("id") Long id) {
            PmsSpuInfoEntity pmsSpuInfo = pmsSpuInfoService.getById(id);

        return R.ok().put("pmsSpuInfo", pmsSpuInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
            public R save(@RequestBody PmsSpuInfoEntity pmsSpuInfo) {
            pmsSpuInfoService.save(pmsSpuInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
            public R update(@RequestBody PmsSpuInfoEntity pmsSpuInfo) {
            pmsSpuInfoService.updateById(pmsSpuInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
            public R delete(@RequestBody Long[] ids) {
            pmsSpuInfoService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
