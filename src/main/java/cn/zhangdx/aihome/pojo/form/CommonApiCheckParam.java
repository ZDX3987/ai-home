package cn.zhangdx.aihome.pojo.form;

import lombok.Data;

/**
 * 校验api的接口参数
 * @author zhangdx
 * @date 2025/3/10 16:01
 */
@Data
public class CommonApiCheckParam {

    private String signature;
    private String timestamp;
    private String nonce;
    private String echostr;
}
