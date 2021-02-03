package com.atguigu.gulimall.order.dao;

import com.atguigu.gulimall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author Illidan
 * @email 908128524@qq.com
 * @date 2021-01-08 00:06:51
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
