package com.atguigu.gulimall.product;

import com.atguigu.gulimall.product.entity.PmsBrandEntity;
import com.atguigu.gulimall.product.service.PmsBrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GulimallProductApplicationTests {
    
    @Autowired
    PmsBrandService pmsBrandService;
    
    @Test
    void contextLoads() {
        PmsBrandEntity pmsBrandEntity = new PmsBrandEntity();
        pmsBrandEntity.setBrandId(1L);
        
        PmsBrandEntity byId = pmsBrandService.getById(1L);
        System.out.println(byId);
        System.out.println("查询成功");
    }
    
}
