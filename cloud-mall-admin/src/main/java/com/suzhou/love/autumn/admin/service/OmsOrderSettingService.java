package com.suzhou.love.autumn.admin.service;


import com.suzhou.love.autumn.model.OmsOrderSetting;

/**
 * 订单设置Service
 * Created by macro on 2018/10/16.
 */
public interface OmsOrderSettingService {
    /**
     * 获取指定订单设置
     */
    OmsOrderSetting getItem(Long id);

    /**
     * 修改指定订单设置
     */
    int update(Long id, OmsOrderSetting orderSetting);
}
