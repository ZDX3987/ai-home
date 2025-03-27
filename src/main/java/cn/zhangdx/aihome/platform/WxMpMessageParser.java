package cn.zhangdx.aihome.platform;

import cn.zhangdx.aihome.message.MessageTypeEnum;
import cn.zhangdx.aihome.message.common.UnifiedInputMessage;
import cn.zhangdx.aihome.message.common.UnifiedOutMessage;
import me.chanjar.weixin.mp.api.WxMpMessageRouter;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 微信公众号消息解析器
 * @author zhangdx
 * @date 2025/3/10 00:35
 */
@Component
public class WxMpMessageParser implements PlatformMessageParser {

    @Resource
    private WxMpMessageRouter messageRouter;

    /**
     * 外部平台消息解析
     *
     * @param sourceMessage 原始请求消息参数
     * @return 解析为内部消息处理的对象
     */
    @Override
    public UnifiedInputMessage parse(String sourceMessage) {
        WxMpXmlMessage receivedMessage = WxMpXmlMessage.fromXml(sourceMessage);
        UnifiedInputMessage unifiedInputMessage = UnifiedInputMessage.builder().messageType(MessageTypeEnum.TEXT)
                .content(receivedMessage.getContent()).platform(MessageSourcePlatformEnum.WECHAT_MP)
                .sourceData(receivedMessage).build();
        return unifiedInputMessage;
    }

    /**
     * 将统一的消息回复对象转换为外部平台接收的消息
     *
     * @param unifiedOutMessage 统一的消息回复对象
     * @return 外部平台接收的消息
     */
    @Override
    public String format(UnifiedOutMessage unifiedOutMessage) {
        WxMpXmlMessage wxMpXmlMessage = (WxMpXmlMessage) unifiedOutMessage.getSourceData();
        wxMpXmlMessage.setContent(unifiedOutMessage.getContent());
        WxMpXmlOutMessage outMessage = messageRouter.route(wxMpXmlMessage);
        return outMessage == null ? "" : outMessage.toXml();
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
