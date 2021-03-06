package com.atguigu.gulimall.product.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.gulimall.product.entity.PmsSkuImagesEntity;
import com.atguigu.gulimall.product.service.PmsSkuImagesService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.R;


/**
 * sku图片
 *
 * @author Illidan
 * @email 908128524@qq.com
 * @date 2021-01-07 21:11:35
 */
@RestController
@RequestMapping("product/pmsskuimages")
public class PmsSkuImagesController {
    @Autowired
    private PmsSkuImagesService pmsSkuImagesService;

    /**
     * 列表
     */
    @RequestMapping("/list")
            public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = pmsSkuImagesService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
            public R info(@PathVariable("id") Long id) {
            PmsSkuImagesEntity pmsSkuImages = pmsSkuImagesService.getById(id);

        return R.ok().put("pmsSkuImages", pmsSkuImages);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
            public R save(@RequestBody PmsSkuImagesEntity pmsSkuImages) {
            pmsSkuImagesService.save(pmsSkuImages);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
            public R update(@RequestBody PmsSkuImagesEntity pmsSkuImages) {
            pmsSkuImagesService.updateById(pmsSkuImages);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
            public R delete(@RequestBody Long[] ids) {
            pmsSkuImagesService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
