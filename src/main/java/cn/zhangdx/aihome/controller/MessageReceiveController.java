package cn.zhangdx.aihome.controller;

import cn.zhangdx.aihome.pojo.CommonRequestForm;
import cn.zhangdx.aihome.service.MessageReceiveService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 统一消息接收接口
 * @author zhangdx
 * @date 2025/3/9 19:25
 */
@RestController
@RequestMapping("/message-receive")
public class MessageReceiveController {

    @Resource
    private MessageReceiveService messageReceiveService;

    @PostMapping(path = "/{platformPath}", consumes = "text/xml;charset=UTF-8", produces = "application/xml;charset=UTF-8")
    public String receiveMessage(CommonRequestForm commonRequestForm, @RequestBody String requestBody,
                                 @PathVariable String platformPath) {
        return messageReceiveService.receiveMessage(commonRequestForm, requestBody, platformPath);
    }
}
