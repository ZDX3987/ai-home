package cn.zhangdx.aihome.platform;

import cn.zhangdx.aihome.message.common.UnifiedInputMessage;
import cn.zhangdx.aihome.message.common.UnifiedOutMessage;

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
    UnifiedInputMessage parse(String sourceMessage);

    /**
     * 将统一的消息回复对象转换为外部平台接收的消息
     * @param unifiedOutMessage 统一的消息回复对象
     * @return 外部平台接收的消息
     */
    String format(UnifiedOutMessage unifiedOutMessage);

    /**
     * 支持的平台
     * @param platformEnum 当前消息所属平台
     * @return 是否支持该消息
     */
    boolean support(MessageSourcePlatformEnum platformEnum);
}
