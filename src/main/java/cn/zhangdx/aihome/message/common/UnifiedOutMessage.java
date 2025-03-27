package cn.zhangdx.aihome.message.common;

import lombok.Data;

/**
 * @author zhangdx
 * @date 2025/3/14 15:50
 */
@Data
public class UnifiedOutMessage {

    private String content;

    private UnifiedInputMessage inputMessage;

    public Object getSourceData() {
        return inputMessage == null ? null : inputMessage.getSourceData();
    }
}
