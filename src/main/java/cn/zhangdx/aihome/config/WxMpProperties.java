package cn.zhangdx.aihome.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 公众号配置
 */
@Data
@ConfigurationProperties(prefix = "mp.config")
public class WxMpProperties {

    /**
     * 公众号对接令牌
     */
    private String token;

    /**
     * 加密key
     */
    private String aesKey;

    /**
     * 公众号ID
     */
    private String appId;

    /**
     * 公众号密码
     */
    private String appSecret;

}
