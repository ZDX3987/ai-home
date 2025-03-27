package cn.zhangdx.aihome.platform.checkapi;

import cn.hutool.crypto.SecureUtil;
import cn.zhangdx.aihome.pojo.form.CommonApiCheckParam;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @author zhangdx
 * @date 2025/3/10 17:18
 */
@Component
public class MpCheckApiHandler implements CheckApiHandler<CommonApiCheckParam, String>{

    @Value("${mp.config.token}")
    private String mpConfigToken;

    @Override
    public String handle(CommonApiCheckParam commonApiCheckParam) {
        List<String> list = Arrays.asList(mpConfigToken, commonApiCheckParam.getTimestamp(), commonApiCheckParam.getNonce());
        Collections.sort(list);
        String signatureStr = SecureUtil.sha1(String.join("", list));
        return Objects.equals(commonApiCheckParam.getSignature(), signatureStr) ? commonApiCheckParam.getEchostr() : null;
    }
}
