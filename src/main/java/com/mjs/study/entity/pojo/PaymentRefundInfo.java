package com.mjs.study.entity.pojo;

import java.util.List;

/**
 * @Description 订单对应的退款记录
 * @ClassName PaymentRefundInfo
 * @Author Administrator
 * @Data 2019/9/19 8:59
 * @Version 1.0
 */
public class PaymentRefundInfo extends PaymentInfo{
    private List<RefundInfo> lists;

    public List<RefundInfo> getLists() {
        return lists;
    }

    public void setLists(List<RefundInfo> lists) {
        this.lists = lists;
    }
}
