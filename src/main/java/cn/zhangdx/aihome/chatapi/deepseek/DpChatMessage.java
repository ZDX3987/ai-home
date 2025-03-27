package cn.zhangdx.aihome.chatapi.deepseek;

import lombok.Data;

/**
 * @author zhangdx
 * @date 2025/3/14 17:16
 */
@Data
public class DpChatMessage {

    private String content;

    private String role;

    public static DpChatMessage build(String content, String role) {
        DpChatMessage dpChatMessage = new DpChatMessage();
        dpChatMessage.setContent(content);
        dpChatMessage.setRole(role);
        return dpChatMessage;
    }
}
