package cn.zhangdx.aihome.message;

import lombok.Data;

/**
 * 统一消息格式
 * @author zhangdx
 * @date 2025/2/28 9:33
 **/
@Data
public class UnifiedInternalMessage {

    private MessageSourcePlatformEnum platform;

    private String msgId;

    private String content;

    private String userId;

    private MessageTypeEnum messageType;
}
