package cn.zhangdx.aihome.service;

import cn.zhangdx.aihome.message.common.UnifiedInputMessage;
import cn.zhangdx.aihome.message.common.UnifiedOutMessage;
import cn.zhangdx.aihome.message.handler.UnifiedMessageHandler;
import cn.zhangdx.aihome.platform.MessageSourcePlatformEnum;
import cn.zhangdx.aihome.platform.PlatformMessageParser;
import cn.zhangdx.aihome.platform.checkapi.MpCheckApiHandler;
import cn.zhangdx.aihome.pojo.form.CommonApiCheckParam;
import cn.zhangdx.aihome.pojo.form.CommonRequestForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 统一消息处理服务类
 * @author zhangdx
 * @date 2025/3/9 23:58
 */
@Slf4j
@Service
public class MessageReceiveServiceImpl implements MessageReceiveService {

    @Resource
    private List<PlatformMessageParser> platformMessageParserMap;
    @Resource
    private MpCheckApiHandler mpCheckApiHandler;
    @Resource
    private UnifiedMessageHandler unifiedMessageHandler;

    @Override
    public String receiveMessage(CommonRequestForm commonRequestForm, String requestBody, String platformPath) {
        MessageSourcePlatformEnum platformEnum = MessageSourcePlatformEnum.getByPath(platformPath);
        PlatformMessageParser platformMessageParser = platformMessageParserMap.stream().filter(parser ->
                parser.support(platformEnum)).findFirst().orElse(null);
        UnifiedInputMessage unifiedInputMessage = platformMessageParser.parse(requestBody);
        UnifiedOutMessage outMessage = unifiedMessageHandler.handle(unifiedInputMessage);
        String result = platformMessageParser.format(outMessage);
        log.info("MessageReceiveServiceImpl receiveMessage result-{}", result);
        return result;
    }

    /**
     * 提供的API校验接口逻辑
     *
     * @param platformPath        平台
     * @param commonApiCheckParam 参数
     * @return
     */
    @Override
    public String checkApi(String platformPath, CommonApiCheckParam commonApiCheckParam) {
        MessageSourcePlatformEnum platformEnum = MessageSourcePlatformEnum.getByPath(platformPath);
        return mpCheckApiHandler.handle(commonApiCheckParam);
    }
}
