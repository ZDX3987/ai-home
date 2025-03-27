package cn.zhangdx.aihome.message.common;

import cn.zhangdx.aihome.message.MessageTypeEnum;
import cn.zhangdx.aihome.platform.MessageSourcePlatformEnum;
import lombok.Builder;
import lombok.Data;

/**
 * 统一消息格式
 * @author zhangdx
 * @date 2025/2/28 9:33
 **/
@Builder
@Data
public class UnifiedInputMessage {

    private MessageSourcePlatformEnum platform;

    private String msgId;

    private String content;

    private String userId;

    private MessageTypeEnum messageType;

    private Object sourceData;
}
