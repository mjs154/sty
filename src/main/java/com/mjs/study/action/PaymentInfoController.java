package com.mjs.study.action;

import com.github.pagehelper.PageInfo;
import com.mjs.study.service.IPaymentInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Description 订单信息控制层
 * @ClassName PaymentInfoController
 * @Author Administrator
 * @Data 2019/9/18 2:44
 * @Version 1.0
 */
@Controller
@RequestMapping("/paymentInfo")
public class PaymentInfoController {
    private static final Logger logger = LoggerFactory.getLogger(PaymentInfoController.class);
    @Autowired
    private IPaymentInfoService paymentInfoService;
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @ResponseBody
    public PageInfo getPaymentInfos(@RequestParam(required = false) String status,
                                                 @RequestParam(required = false, defaultValue = "0") Integer pageNum,
                                                 @RequestParam(required = false, defaultValue = "5") Integer pageSize){
        logger.debug("订单信息控制层");
        return paymentInfoService.getPaymentInfos(status, pageNum, pageSize);
    }

    @RequestMapping(value = "/searchMap", method = RequestMethod.GET)
    @ResponseBody
    public PageInfo findPaymentRefundList(@RequestParam(required = false) String status,
                                    @RequestParam(required = false, defaultValue = "0") Integer pageNum,
                                    @RequestParam(required = false, defaultValue = "5") Integer pageSize){
        logger.debug("查询包含退款信息的所有订单控制层");
        return paymentInfoService.findPaymentRefundList(status, pageNum, pageSize);
    }
}
