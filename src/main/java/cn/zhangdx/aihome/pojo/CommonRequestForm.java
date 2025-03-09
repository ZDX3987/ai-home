package cn.zhangdx.aihome.pojo;

import lombok.Data;

/**
 * @author zhangdx
 * @date 2025/3/9 19:14
 */
@Data
public class CommonRequestForm {

    private String signature;

    private String timestamp;
    private String nonce;
    private String openid;
    private String encType;
    private String msgSignature;
}
