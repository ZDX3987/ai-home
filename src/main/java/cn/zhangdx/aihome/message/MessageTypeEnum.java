package cn.zhangdx.aihome.message;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zhangdx
 * @date 2025/2/28 9:46
 **/
@Getter
@AllArgsConstructor
public enum MessageTypeEnum {

    TEXT("文字"),
    VOICE("语音"),
    IMAGE("图片"),
    VIDEO("视频");

    private final String typeName;
}
