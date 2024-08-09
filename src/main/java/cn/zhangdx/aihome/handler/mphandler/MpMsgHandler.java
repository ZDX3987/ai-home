package cn.zhangdx.aihome.handler.mphandler;

import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpMessageHandler;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
public class MpMsgHandler implements WxMpMessageHandler {

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMpXmlMessage, Map<String, Object> map, WxMpService wxMpService,
                                    WxSessionManager wxSessionManager) throws WxErrorException {
        log.info("MpMsgHandler handle wxMpXmlMessage:{}", wxMpXmlMessage);
        String content = "收到的消息内容：" + wxMpXmlMessage.getContent();
        return WxMpXmlOutMessage.TEXT().content(content).fromUser(wxMpXmlMessage.getToUser())
                .toUser(wxMpXmlMessage.getFromUser()).build();
    }
}
