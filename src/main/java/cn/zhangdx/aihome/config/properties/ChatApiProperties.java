package cn.zhangdx.aihome.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author zhangdx
 * @date 2025/3/14 16:54
 */
@Data
@Component
@ConfigurationProperties(prefix = "chat-api")
public class ChatApiProperties {

    private DeepSeekApiProperties deepSeek;
}
