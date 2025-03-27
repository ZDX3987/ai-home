package cn.zhangdx.aihome.message.handler;

import cn.zhangdx.aihome.message.common.UnifiedInputMessage;
import cn.zhangdx.aihome.message.common.UnifiedOutMessage;

/**
 * 统一消息处理器
 * @author zhangdx
 * @date 2025/3/14 15:54
 */
public interface UnifiedMessageHandler {

    /**
     * 统一消息处理方法
     * @param inputMessage 输入消息
     * @return 输出消息
     */
    UnifiedOutMessage handle(UnifiedInputMessage inputMessage);
}
