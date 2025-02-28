package cn.zhangdx.aihome.message;

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

    WECHAT("微信公众号")
    ;

    private final String platformName;

}
