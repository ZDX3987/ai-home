package cn.zhangdx.aihome.message.handler;

import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.zhangdx.aihome.chatapi.deepseek.DpChatRequestBody;
import cn.zhangdx.aihome.chatapi.deepseek.DpChatResponseBody;
import cn.zhangdx.aihome.config.properties.ChatApiProperties;
import cn.zhangdx.aihome.config.properties.DeepSeekApiProperties;
import cn.zhangdx.aihome.message.common.UnifiedInputMessage;
import cn.zhangdx.aihome.message.common.UnifiedOutMessage;
import com.alibaba.fastjson.JSON;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 对接DeepSeek消息处理类
 * @author zhangdx
 * @date 2025/3/14 16:07
 */
//@ConditionalOnProperty(value = "chat-api.deep-seek")
@Component
public class AskDeepSeekHandler extends AbstractUnifiedMessageHandler {

    public static final String AUTHORIZATION = "Authorization";
    private static final String BEARER = "Bearer";
    @Resource
    private ChatApiProperties chatApiProperties;

    private String apiUrl = "/chat/completions";

    /**
     * 统一消息处理方法
     *
     * @param inputMessage 输入消息
     * @return 输出消息
     */
    @Override
    public UnifiedOutMessage handle(UnifiedInputMessage inputMessage) {
        String content = inputMessage.getContent();
        DeepSeekApiProperties deepSeekApiProperties = chatApiProperties.getDeepSeek();
        DpChatRequestBody dpChatRequestBody = DpChatRequestBody.builder().commonBuild()
                .message(null, content, null, null).build();

        HttpResponse response = HttpUtil.createPost(deepSeekApiProperties.getBaseUrl() + apiUrl)
                .header(AUTHORIZATION, String.join(" ", BEARER, deepSeekApiProperties.getToken()))
                .body(JSON.toJSONString(dpChatRequestBody)).execute();
        DpChatResponseBody dpChatResponseBody = JSON.parseObject(response.body(), DpChatResponseBody.class);
        List<DpChatResponseBody.DpChatChoice> choices = dpChatResponseBody.getChoices();
        UnifiedOutMessage unifiedOutMessage = new UnifiedOutMessage();
        unifiedOutMessage.setContent(choices.get(0).getMessage().getContent());
        unifiedOutMessage.setInputMessage(inputMessage);
        return unifiedOutMessage;
    }
}
