package com.atguigu.gulimall.product.dao;

import com.atguigu.gulimall.product.entity.PmsCategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author Illidan
 * @email 908128524@qq.com
 * @date 2021-01-07 19:48:10
 */
@Mapper
public interface PmsCategoryDao extends BaseMapper<PmsCategoryEntity> {
	
}
