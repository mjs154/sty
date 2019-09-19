package com.mjs.study.entity.mapper;

import com.mjs.study.entity.pojo.PaymentRefundInfo;

import java.util.List;

/**
 * @Description 订单退款信息关联查询
 * @ClassName PaymentRefundInfoMapper
 * @Author Administrator
 * @Data 2019/9/19 9:29
 * @Version 1.0
 */
public interface PaymentRefundInfoMapper {
    List<PaymentRefundInfo> findPaymentRefundList();
}
