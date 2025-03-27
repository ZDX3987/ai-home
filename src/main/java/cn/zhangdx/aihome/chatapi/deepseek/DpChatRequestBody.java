package cn.zhangdx.aihome.chatapi.deepseek;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangdx
 * @date 2025/3/14 17:14
 */
@Data
public class DpChatRequestBody {

    private List<DpChatMessage> messages;

    private String model;

    @JsonProperty("frequency_penalty")
    private Integer frequencyPenalty;

    @JsonProperty("max_tokens")
    private Integer maxTokens;

    @JsonProperty("presence_penalty")
    private Integer presencePenalty;

    @JsonProperty("response_format")
    private ResponseFormat responseFormat;

    private Boolean stream;

    private Integer temperature;

    @JsonProperty("top_p")
    private Integer topP;

    @JsonProperty("tool_choice")
    private String toolChoice;

    private Boolean logprobs;

    public static DpChatRequestBodyBuilder builder() {
        return new DpChatRequestBodyBuilder();
    }

    public static class DpChatRequestBodyBuilder {

        private DpChatRequestBody dpChatRequestBody;

        public DpChatRequestBodyBuilder() {
            dpChatRequestBody = new DpChatRequestBody();
        }

        public DpChatRequestBody build() {
            return dpChatRequestBody;
        }

        public DpChatRequestBodyBuilder message(String systemContent, String userContent, String assistantContent, String toolContent) {
            List<DpChatMessage> messages = new ArrayList<>();
            if (systemContent != null) {
                messages.add(DpChatMessage.build(systemContent, "system"));
            }
            if (userContent != null) {
                messages.add(DpChatMessage.build(userContent, "user"));
            }
            if (assistantContent != null) {
                messages.add(DpChatMessage.build(assistantContent, "assistant"));
            }
            if (toolContent != null) {
                messages.add(DpChatMessage.build(toolContent, "tool"));
            }
            dpChatRequestBody.setMessages(messages);
            return this;
        }

        public DpChatRequestBodyBuilder commonBuild() {
            dpChatRequestBody.setResponseFormat(ResponseFormat.defaultBuild());
            dpChatRequestBody.setModel("deepseek-chat");
            dpChatRequestBody.setFrequencyPenalty(0);
            dpChatRequestBody.setMaxTokens(2048);
            dpChatRequestBody.setPresencePenalty(0);
            dpChatRequestBody.setStream(false);
            dpChatRequestBody.setTemperature(1);
            dpChatRequestBody.setTopP(1);
            dpChatRequestBody.setToolChoice("none");
            dpChatRequestBody.setLogprobs(false);
            return this;
        }
    }

    @Data
    private static class ResponseFormat {

        /**
         * 消息输出的格式：text/json_object
         */
        private String type;

        private static ResponseFormat defaultBuild() {
            ResponseFormat resp = new ResponseFormat();
            resp.setType("text");
            return resp;
        }
    }
}
