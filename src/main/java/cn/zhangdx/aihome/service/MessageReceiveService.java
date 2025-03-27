package cn.zhangdx.aihome.service;

import cn.zhangdx.aihome.pojo.form.CommonApiCheckParam;
import cn.zhangdx.aihome.pojo.form.CommonRequestForm;

/**
 * @author zhangdx
 * @date 2025/3/9 23:57
 */
public interface MessageReceiveService {

    String receiveMessage(CommonRequestForm commonRequestForm, String requestBody, String platformPath);

    /**
     * 提供的API校验接口逻辑
     * @param platformPath 平台
     * @param commonApiCheckParam 参数
     * @return
     */
    String checkApi(String platformPath, CommonApiCheckParam commonApiCheckParam);

}
