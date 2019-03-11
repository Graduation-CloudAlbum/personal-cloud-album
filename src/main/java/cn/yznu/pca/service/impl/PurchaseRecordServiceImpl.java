package cn.yznu.pca.service.impl;

import cn.yznu.pca.dao.PurchaseRecordMapper;
import cn.yznu.pca.model.PurchaseRecord;
import cn.yznu.pca.service.PurchaseRecordService;
import cn.yznu.pca.utils.OrderStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author yangbaiwan
 * @date 2019-03-11
 */
@Service
public class PurchaseRecordServiceImpl implements PurchaseRecordService {

    @Autowired
    PurchaseRecordMapper purchaseRecordMapper;
    @Override
    public void saveOrder(PurchaseRecord record) {
        purchaseRecordMapper.insert(record);
    }

    @Override
    public void updateOrderStatus(Integer prId, String status, String paidAmount) {
        PurchaseRecord pcr=getOrderById(prId);
        if (pcr.getStatus().equals(OrderStatusEnum.WAIT_PAY.key)) {
            pcr = new PurchaseRecord();
            pcr.setId(prId);
            pcr.setStatus(OrderStatusEnum.PAID.key);
            pcr.setPayment(paidAmount);
            purchaseRecordMapper.updateByPrimaryKeySelective(pcr);
        }
    }

    @Override
    public PurchaseRecord getOrderById(Integer prId) {
        return purchaseRecordMapper.selectByPrimaryKey(prId);
    }
}
