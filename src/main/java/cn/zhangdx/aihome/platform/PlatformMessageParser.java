package cn.zhangdx.aihome.platform;

import cn.zhangdx.aihome.message.common.UnifiedInternalMessage;

/**
 * 外部平台消息解析器，定义支持各种平台的消息解析逻辑
 * @author zhangdx
 * @date 2025/3/10 00:29
 */
public interface PlatformMessageParser {

    /**
     * 外部平台消息解析
     * @param sourceMessage 原始请求消息参数
     * @return 解析为内部消息处理的对象
     */
    UnifiedInternalMessage parse(String sourceMessage);

    /**
     * 支持的平台
     * @param platformEnum 当前消息所属平台
     * @return 是否支持该消息
     */
    boolean support(MessageSourcePlatformEnum platformEnum);
}
