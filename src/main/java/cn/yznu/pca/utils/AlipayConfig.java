package cn.yznu.pca.utils;

/**
 * @author yangbaiwan
 * @date 2019-03-11
 */
public class AlipayConfig {
    /**
     *应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
     */
    public static String app_id = "2016092800613469";

    /**
     *商户私钥，您的PKCS8格式RSA2私钥
     */
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCYnX8WiDBNnTHA02265yMGePO+SRTIvEDZh156FN4b7wxxw0wR0Apb0xLutRYCcb5hO4waBbTqslT930HWunSwgjZXTuDM0Doiu4BkQCh6KCUYmGEbXAXM3R7CPI/aCDwiJblCEqfSHhVIbsdriLjG0rtP90nW03hcFsqbt9e7+BjwREvOr1a25TcEKR9gf7ZkEq6FtqHu7chNlvEkHK11Y8OQ6ZEmau0QxoLdZPZXIlHL7MXW+qMdmnY5Bc25GjaoDKnLeIrfI3RSi9j2SxKLnZkv8pzj1n2aC8zfOjhRYAL4lRSWG9i2OiMbKHTmMtgbSalwxxGtjPE1xTuC5hqrAgMBAAECggEABZ+wIjVsij+jqLZh0cRYrxFf8gAhavA894ccfSUtthvN+pc2w2VGLHIPvYogwIBOgqi+Fetl6kweA6jpdS8zw5lYxUjb0dBOhB8isQ8ILtAx5cEfuvFeKVlwm7m9l0w8Ywm+1Od5Fa4UHLIwWQ8VuAXl7yFusCLkyYfxeWGB6qRAFyQMw/TGbE6hkgJ0yGnTU2ziIzlHHD43kpUNeP2lQ61VgWUumPgg8TvIvU4yPX40yMxD5OBDJGC1Zimbe1oyuHClhHb9GUly87H6barq6LdamzW5/cSWPxdHlcjAXpznTO+qSSf/aQEke8H9t8YmjMjgiEaqBoHPTDg/n2if0QKBgQDkNbUw/jUTHDkfe6WTuZNNysemf/xM/UPZTKvtuJSJirZtuQzEAW3KQg/IOTFBUQK3KmnwuuKV9IVrJLaul3oFkSNVbePoh/04UHaPyjFCTHJT6ad2IU98wZuFQfY0LQksAvvzMflSVpa98ixofOBSIRFXLqOgp56D97VVGgAiGQKBgQCrMy1F2fXuQxtoxUBcY1WXo1dfyE6zwzMEOcal63ddVjU2mcb3GyjRrQiRLy4jFtMlSKyheINTX5WLQIMZ8QD3P+VpctVy7We4Os2CByy6IXXB4C0hg2TDL2mHolF2YDPeFCGIw51S2vfvS0eUOkU9Da3zytzqsqErn2wIypujYwKBgBTkleIWY+WL/+7R8ybDJqlIl162+PJTfZK3YkYxT+gHuwvwlSqctuB9i9RY6BmCwSzjxS807OmtqUlV4yO42oMH9qQrm2H+kUBGnZQsfrYDKbRk/9/gzNYvI33fvBqqxNwyqb5qJNlU9BgPw+ENDbx3Ko9Axdo/flO2qfNQnhKBAoGBAJcVNuLqEysNdebkDIR79VE5CSayMyJZJXCZPEG4p0JrjdJ9qyTvhvpjZagapvC4d+XzWMW3AM5XEDYv3ILMOTn53Y9NlCk0cdAXtL0Hb+VjGfTazXlB526JLOxRxupcw+k8gsubNf+k1iELokOhmPDkXZtEb+l/ctR4gHLRusBZAoGBAK0zfuJpvlseoiIO18qdsLTZT+8IcCBZGWAr0Kv+8oG12bQ9ZJo+DfwyL5QPNLjMU13SzBGPRQI8xUQAAjmOrT4dwbmbbnncTGbehv9gpW3LgkOzmAWPByEY+JRUoHP6a6LK0AfkYPW8TeZe1cq4TbQl/nPxvf3K2wz09aDb0LMI";

    /**
     *付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
     */
    public static String alipay_public_key = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDIgHnOn7LLILlKETd6BFRJ0GqgS2Y3mn1wMQmyh9zEyWlz5p1zrahRahbXAfCfSqshSNfqOmAQzSHRVjCqjsAw1jyqrXaPdKBmr90DIpIxmIyKXv4GGAkPyJ/6FTFY99uhpiq0qadD/uSzQsefWo0aTvP/65zi3eof7TcZ32oWpwIDAQAB";

    /**
     *服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
     */
    public static String notify_url = "http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

    /**
     * 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
     */
    public static String return_url = "http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";

    /**
     * 签名方式
     */
    public static String sign_type = "RSA2";

    /**
     * 字符编码格式
     */
    public static String charset = "utf-8";

    /**
     * 支付宝网关
     */
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

}
