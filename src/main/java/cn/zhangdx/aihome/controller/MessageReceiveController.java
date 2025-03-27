package cn.zhangdx.aihome.controller;

import cn.zhangdx.aihome.pojo.form.CommonApiCheckParam;
import cn.zhangdx.aihome.pojo.form.CommonRequestForm;
import cn.zhangdx.aihome.service.MessageReceiveService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/{platformPath}")
    public ResponseEntity<String> checkApi(@PathVariable String platformPath, CommonApiCheckParam commonApiCheckParam) {
        String result = messageReceiveService.checkApi(platformPath, commonApiCheckParam);
        return ResponseEntity.ok(result);
    }
}
