package cn.zhangdx.aihome.controller;

import cn.hutool.crypto.SecureUtil;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.mp.api.WxMpMessageRouter;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @author zhangdx
 * @date 2024/8/8 15:59
 **/
@Slf4j
@RestController
@RequestMapping("/wx")
public class MpCheckController {

    @Value("${mp.config.token}")
    private String mpConfigToken;
    @Resource
    private WxMpService wxMpService;
    @Resource
    private WxMpMessageRouter messageRouter;

    @GetMapping
    public ResponseEntity<String> checkApi(@RequestParam String signature, @RequestParam String timestamp, @RequestParam String nonce,
                                   @RequestParam String echostr) {
        log.info("MpCheckController checkApi signature:{}, timestamp:{}, nonce:{}, echostr:{}", signature, timestamp, nonce, echostr);
        List<String> list = Arrays.asList(mpConfigToken, timestamp, nonce);
        Collections.sort(list);
        String signatureStr = SecureUtil.sha1(String.join("", list));
        log.info("MpCheckController checkApi signatureStr:{}", signatureStr);
        return Objects.equals(signature, signatureStr) ? ResponseEntity.ok(echostr) : ResponseEntity.ok(null);
    }

    @PostMapping(consumes = "text/xml;charset=UTF-8", produces = "application/xml;charset=UTF-8")
    public String receiveMpMessage(@RequestBody String requestBody, @RequestParam("signature") String signature, @RequestParam("timestamp") String timestamp,
                                 @RequestParam("nonce") String nonce, @RequestParam("openid") String openid,
                                 @RequestParam(name = "encrypt_type", required = false) String encType,
                                 @RequestParam(name = "msg_signature", required = false) String msgSignature) {
        log.info("MpCheckController receiveMpMessage requestBody:{}", requestBody);
        String replyMessage = null;
        if (encType == null) {
            WxMpXmlMessage receivedMessage = WxMpXmlMessage.fromXml(requestBody);
            WxMpXmlOutMessage outMessage = messageRouter.route(receivedMessage);
            replyMessage = outMessage == null ? "" : outMessage.toXml();
        }
        log.info("MpCheckController receiveMpMessage replyMessage:\n{}", replyMessage);
        return replyMessage;
    }
}
