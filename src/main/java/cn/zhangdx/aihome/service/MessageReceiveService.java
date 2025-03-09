package cn.zhangdx.aihome.service;

import cn.zhangdx.aihome.pojo.CommonRequestForm;

/**
 * @author zhangdx
 * @date 2025/3/9 23:57
 */
public interface MessageReceiveService {

    String receiveMessage(CommonRequestForm commonRequestForm, String requestBody, String platformPath);
}
