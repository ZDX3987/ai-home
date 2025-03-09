package cn.zhangdx.aihome.service;

import cn.zhangdx.aihome.message.common.UnifiedInternalMessage;
import cn.zhangdx.aihome.platform.MessageSourcePlatformEnum;
import cn.zhangdx.aihome.platform.PlatformMessageParser;
import cn.zhangdx.aihome.pojo.CommonRequestForm;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 统一消息处理服务类
 * @author zhangdx
 * @date 2025/3/9 23:58
 */
@Service
public class MessageReceiveServiceImpl implements MessageReceiveService {

    @Resource
    private List<PlatformMessageParser> platformMessageParserMap;

    @Override
    public String receiveMessage(CommonRequestForm commonRequestForm, String requestBody, String platformPath) {
        MessageSourcePlatformEnum platformEnum = MessageSourcePlatformEnum.getByPath(platformPath);
        PlatformMessageParser platformMessageParser = platformMessageParserMap.stream().filter(parser -> parser.support(platformEnum)).findFirst().orElse(null);
        UnifiedInternalMessage unifiedInternalMessage = platformMessageParser.parse(requestBody);
        return "";
    }
}
