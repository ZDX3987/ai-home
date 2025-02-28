package cn.zhangdx.aihome.message.parser;

import cn.zhangdx.aihome.message.UnifiedInternalMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;

/**
 * @author zhangdx
 * @date 2025/2/27 17:19
 **/
public class WpMessageParser implements MessageParser<WxMpXmlMessage> {

    /**
     * 消息解析
     *
     * @param message 原始消息
     * @return 解析的消息对象
     */
    @Override
    public UnifiedInternalMessage parse(WxMpXmlMessage message) {
        return null;
    }
}
