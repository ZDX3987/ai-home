package cn.zhangdx.aihome.chatapi.deepseek;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author zhangdx
 * @date 2025/3/15 16:25
 */
@Data
public class DpChatResponseBody {

    private String id;

    private Integer created;

    private String model;

    private String object;

    @JsonProperty("system_fingerprint")
    private String systemFingerprint;

    private List<DpChatChoice> choices;

    private List<DpChatUsage> usage;

    @Data
    public static class DpChatChoice {
        private Integer index;
        private DpChatMessage message;
        @JsonProperty("finish_reason")
        private String finishReason;
    }

    @Data
    public static class DpChatUsage {
        @JsonProperty("prompt_tokens")
        private Integer promptTokens;
        @JsonProperty("completion_tokens")
        private Integer completionTokens;
        @JsonProperty("total_tokens")
        private Integer totalTokens;
        @JsonProperty("prompt_cache_hit_tokens")
        private Integer promptCacheHitTokens;
        @JsonProperty("prompt_cache_miss_tokens")
        private Integer promptCacheMissTokens;
    }
}
