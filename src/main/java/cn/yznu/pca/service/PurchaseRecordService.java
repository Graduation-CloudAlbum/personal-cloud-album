package cn.yznu.pca.service;

import cn.yznu.pca.model.PurchaseRecord;

/**
 * @author yangbaiwan
 * @date 2019-03-11
 */
public interface PurchaseRecordService {
    /**
     * 新增订单
     * @param record
     */
     void saveOrder(PurchaseRecord record);

    /**
     * @Description: 修改订单状态，改为 支付成功，已付款
     */
     void updateOrderStatus(Integer prId, String status,String paidAmount);

    /**
     * 获取订单
     * @param prId
     * @return
     */
     PurchaseRecord getOrderById(Integer prId);
}
