package cn.yznu.pca.utils;

/**
 * @author yangbaiwan
 * @date 2019-03-11
 */
public enum OrderStatusEnum {
    // 待付款
    WAIT_PAY("10", "待付款"),
    // 已付款
    PAID("20", "已付款"),
    // 已取消
    CANCELED("30", "已取消"),
    // 超时未支付, 交易关闭
    CLOSED("40", "交易关闭");

    public final String key;
    public final String value;

    OrderStatusEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public static String getName(String key) {
        for (OrderStatusEnum status : OrderStatusEnum.values()) {
            if (status.getKey().equals(key)) {
                return status.value;
            }
        }
        return null;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
