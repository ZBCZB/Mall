package com.ljl.mall.tiny.service.impl;

import com.ljl.mall.tiny.common.api.CommonResult;
import com.ljl.mall.tiny.component.CancelOrderSender;
import com.ljl.mall.tiny.dto.OrderParam;
import com.ljl.mall.tiny.service.OmsPortalOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OmsPortalOrderServiceImpl implements OmsPortalOrderService {

    private static final Logger LOGGER= LoggerFactory.getLogger(OmsPortalOrderServiceImpl.class);

    @Autowired
    private CancelOrderSender cancelOrderSender;

    @Override
    public CommonResult generateOrder(OrderParam orderParam) {
        //todo 执行下单之类的操作
        LOGGER.info("process generateOrder");
        //下单完成后开启一个消息队列,用于用户当时没有付款取消订单（OrderId应该在下单后生成）
        sendDelayMessageCancelOrder(11L);
        return CommonResult.success(null,"下单成功");
    }

    @Override
    public void cancelOrder(Long orderId) {
        //todo 执行下单操作
        LOGGER.info("process cancelOrder orderId:{}",orderId);
    }

    private void sendDelayMessageCancelOrder(Long orderId){
        //订单时限(毫秒)
        long delayTimes =30*1000;
        //发送给延时队列
        cancelOrderSender.sendMessage(orderId,delayTimes);
    }
}

