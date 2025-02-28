package cn.zhangdx.aihome.message.parser;

import cn.zhangdx.aihome.message.UnifiedInternalMessage;

/**
 * 消息解析器接口
 * @author zhangdx
 * @date 2025/2/27 17:20
 **/
public interface MessageParser<T> {

    /**
     * 消息解析
     * @param message 原始消息
     * @return 解析的消息对象
     */
    UnifiedInternalMessage parse(T message);
}
