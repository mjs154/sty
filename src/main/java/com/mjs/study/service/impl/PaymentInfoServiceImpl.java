package com.mjs.study.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mjs.study.entity.mapper.PaymentInfoMapper;
import com.mjs.study.entity.mapper.PaymentRefundInfoMapper;
import com.mjs.study.entity.pojo.PaymentInfo;
import com.mjs.study.entity.pojo.PaymentInfoExample;
import com.mjs.study.entity.pojo.PaymentRefundInfo;
import com.mjs.study.service.IPaymentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description 订单信息实现层
 * @ClassName PaymentInfoServiceImpl
 * @Author Administrator
 * @Data 2019/9/18 18:33
 * @Version 1.0
 */
@Service
public class PaymentInfoServiceImpl implements IPaymentInfoService{
    @Autowired
    private PaymentInfoMapper paymentInfoMapper;
    @Autowired
    private PaymentRefundInfoMapper paymentRefundInfoMapper;
    /**
     * 查询订单信息
     * @param status 订单状态
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo getPaymentInfos(String status, Integer pageNum, Integer pageSize) {
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 10 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        PaymentInfoExample example = new PaymentInfoExample();
        example.createCriteria().andStatusEqualTo(Integer.valueOf(status));
        List<PaymentInfo> list = paymentInfoMapper.selectByExample(example);
        return new PageInfo(list);
    }
    @Override
    public PageInfo findPaymentRefundList(String status, Integer pageNum, Integer pageSize){
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 10 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        List<PaymentRefundInfo> list = paymentRefundInfoMapper.findPaymentRefundList();
        return new PageInfo(list);
    }
}
