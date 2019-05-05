package cn.yznu.pca.utils;

/**支付宝支付所需的配置类
 * @author yangbaiwan
 * @date 2019-03-11
 */
public class AlipayConfig {
    /**
     *应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
     */
    public static String app_id ="2016092800613469";

    /**
     *商户私钥，您的PKCS8格式RSA2私钥
     */
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCi0pER6cykc01DJzidwsDdFgWzJ8NkVIrWrBfj6Gc1yawXDriA9LPP8BiAdXw070Df97SRClNnhrUAG8INd0ELuLhiD88DD3zHrr+3EYBB+vVe+VKycWRCdzRthWeZG0l4J5vSR2wRwcndh5SiN6Lncu1lXHxSN+ITbaqB3+LUKQErSnVr1hUZpgYDmx0JaaWOfBGjTAsPd/TglMj0mqB2QDWNDorDoa4GFulhUzwtfiyzdRmtMXbDt57diik1uGd1/fVgaXfA87bmyUpQcP1iKNdMts+otr8mZONPhL3dOyt3XRJV3KsFrwKfrV/JzZ9siEiQVDJS/aZ1nzlLTqZLAgMBAAECggEAEmomJhR/JIo1zsZ8zLrd/SMkeeKhYpN9MFI+UXRTV+37HJB5pXwHahkJbF3dMk9s0ue88DpuvGKrzdtV0xgNrzmxAMYw73Os9Rh6bkX4b33miltAUxYn9KxurYRM9y/y2zf/k4SoYEm+fuN6l+4a6npBBxmypcnUM8ZPZmjfyoa6Ks1Xiq3oHhAFkvSRu2nZ7y6CSdl3w9jxzaZQM2R4pzYQ9f9BkcF74cSdWc+00MvbQSodDEeowsTSjCutLMNi39KQmnFBPE/5ZV0YYDW6kkABJsApVje3Wfu2Y6CvrXQFhc2nU0VeC0sLaCPsV56c+HNL2JhqzOo2Zs5dTfr+oQKBgQDmUaa6tWGl6E82hNMY/1zgzdUOuE8k87pDnnQVTDH0dtd8m4Uwq3s6E1F8eAt77BDIRQvbkr4KSQOC49z36WPZ+7Jkl5uwLPOgv6+4QrfLdXrptrGZCKqFdre2BpBFki4dgqw3zV3ibgZzy/x78ZTpujXW168ntLANXX3fJCzSVwKBgQC0+kLNXOF6zHtLuzgJA27PxOt8NH6R7UvvMzP6v5h4wN6P6NNHi/TMh/XysvL4vkuuTwC4s6O96BEuCgpDGtoFswbjXauHSD/+NLDtd3oZv41YJWEVP3EGGJFlH0OoBUsfBiBxgQLQTmYmjG0tfyXmf1V5L3LGL5tDrgBUVqWbLQKBgQCwqJhWRaGse8+mZaL1XYmD9N0i+UPbeAa6ruMjItp+RFlsfm1es2lFVmP+MKW+W4dT1YIO3TNe+Dn1P4nRrfak0GY4ugD01MXZ2q2Ri7smF+o7MaJvWzJQRIsM12P5uPIeOIiYFLGaaAIS97el6drqm6WIMM9siS8wUTGm4jxu6QKBgEdXnHvuUGijMTuSay2Kb+VxwE7vNrH59IQwEB6Z5tY7WcErTBaZQoBaXIc3KfcKtTTaqfMlxbe4QwV+Kbt4W1gB0gZRR6wFvExOoyyJe9WooGSOH65LmxeHGdHeOEKFC68IMEPuUpihPz2U//j+dYdezOf/32PnInLUpgaZPaFlAoGBALUwy6sURl7+/hHbncwcW/7RePSUuXmlogZ5byromMVBpZI2dvvf7ueQste920x8ox6CWJG8YCy1uyOlJs9Dt1eubhmkDrQ+akWYLhNxpjeSiP/CAtcd+gz2VGz54qiYBYue6mNsxkcTkkXfy+RjETs+cvDau+JmaN7VZxIxLQKf";

    /**
     *支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
     */
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAv7QeeC1OSt6Ha4xzeSnuCJc3t10BuOkTdRqMhWLeU/vXGt7WEaImdhUEiqsAEHXSe/BJoWZWfYzXFpFR0/euFJdiKe3gFSXb1nKOrxudyKYV5URF8ptHQfe34uyzfNU0NWG5XbWNRs91X2RjSYVl1r3BP8sXy6tTKdwlyRv0mSo6prx3/jAKlkhHox1/XacNyFR0Z02/PLC/pw72c4YmNOSkVWvGnH8R3PTsgKlB1p3PS6JUUOFZnGtfX0ifSQFV1NRvnpuHOZB9TqxKVT9FtVXJlX26Cw4V/NBt1xhlly8X7Wbh9EUm5qkXAdMZG9TiKUuEUNrbzKRV9OXBHDx6zwIDAQAB";

    /**
     *服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
     */
    //public static String notify_url = "http://www.1024album.cn/pca/alipay/alipayNotifyNotice";
    public static String notify_url = "http://localhost:8080/pca/alipay/alipayNotifyNotice";

    /**
     * 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
     */
    //public static String return_url = "http://www.1024album.cn/pca/alipay/alipayReturnNotice";
    public static String return_url = "http://localhost:8080/pca/alipay/alipayReturnNotice";


    /**
     * 签名方式
     */
    public static String sign_type = "RSA2";

    /**
     * 字符编码格式
     */
    public static String charset = "UTF-8";

    /**
     * 支付宝网关
     */
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

}
