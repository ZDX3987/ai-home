package cn.zhangdx.aihome.config;

import cn.zhangdx.aihome.handler.mphandler.MpMsgHandler;
import me.chanjar.weixin.mp.api.WxMpMessageRouter;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.config.WxMpConfigStorage;
import me.chanjar.weixin.mp.config.impl.WxMpDefaultConfigImpl;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@EnableConfigurationProperties(WxMpProperties.class)
@Configuration
public class WxMpConfiguration {

    @Resource
    private WxMpProperties wxMpProperties;
    @Resource
    private MpMsgHandler msgHandler;

    @Bean
    public WxMpService wxMpService() {
        WxMpServiceImpl wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(buildWxMpConfigStorage());
        return wxMpService;
    }

    @Bean
    public WxMpMessageRouter messageRouter(WxMpService wxMpService) {
        WxMpMessageRouter wxMpMessageRouter = new WxMpMessageRouter(wxMpService);
        // 默认消息处理器
        wxMpMessageRouter.rule().async(false).handler(msgHandler).end();
        return wxMpMessageRouter;
    }

    private WxMpConfigStorage buildWxMpConfigStorage() {
        WxMpDefaultConfigImpl wxMpDefaultConfig = new WxMpDefaultConfigImpl();
        wxMpDefaultConfig.setAppId(wxMpProperties.getAppId());
        wxMpDefaultConfig.setSecret(wxMpProperties.getAppSecret());
        wxMpDefaultConfig.setToken(wxMpProperties.getToken());
        wxMpDefaultConfig.setAesKey(wxMpProperties.getAesKey());
        return wxMpDefaultConfig;
    }
}
