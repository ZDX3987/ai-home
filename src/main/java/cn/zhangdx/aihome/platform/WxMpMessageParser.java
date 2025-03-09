package cn.zhangdx.aihome.platform;

import cn.zhangdx.aihome.message.common.UnifiedInternalMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;

/**
 * 微信公众号消息解析器
 * @author zhangdx
 * @date 2025/3/10 00:35
 */
public class WxMpMessageParser implements PlatformMessageParser {

    /**
     * 外部平台消息解析
     *
     * @param sourceMessage 原始请求消息参数
     * @return 解析为内部消息处理的对象
     */
    @Override
    public UnifiedInternalMessage parse(String sourceMessage) {
        WxMpXmlMessage receivedMessage = WxMpXmlMessage.fromXml(sourceMessage);
        return null;
    }

    /**
     * 支持的平台
     *
     * @param platformEnum 当前消息所属平台
     * @return 是否支持该消息
     */
    @Override
    public boolean support(MessageSourcePlatformEnum platformEnum) {
        return MessageSourcePlatformEnum.WECHAT_MP.equals(platformEnum);
    }
}
