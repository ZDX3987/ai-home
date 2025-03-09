package cn.zhangdx.aihome.platform;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 消息来源的平台定义
 * @author zhangdx
 * @date 2025/2/28 9:35
 **/
@Getter
@AllArgsConstructor
public enum MessageSourcePlatformEnum {

    WECHAT_MP("微信公众号", "mp")
    ;

    private final String platformName;

    private final String path;

    public static MessageSourcePlatformEnum getByPath(String path) {
        for (MessageSourcePlatformEnum platformEnum : values()) {
            if (platformEnum.getPath().equals(path)) {
                return platformEnum;
            }
        }
        return null;
    }

}
