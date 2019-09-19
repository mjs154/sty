package com.mjs.study.service;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Description 订单信息控制层接口
 * @ClassName IPaymentInfoService
 * @Author Administrator
 * @Data 2019/9/18 18:34
 * @Version 1.0
 */
public interface IPaymentInfoService {
    /**
     * 查询订单信息
     * @param status 订单状态
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo getPaymentInfos(String status, Integer pageNum, Integer pageSize);

    /**
     * 查询包含退款信息的所有订单
     * @param status 订单状态
     * @param pageNum 页码
     * @param pageSize 每页数量
     * @return
     */
    PageInfo findPaymentRefundList(String status, Integer pageNum, Integer pageSize);
}
