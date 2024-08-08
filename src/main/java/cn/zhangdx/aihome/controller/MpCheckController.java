package cn.zhangdx.aihome.controller;

import cn.hutool.crypto.SecureUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @author zhangdx
 * @date 2024/8/8 15:59
 **/
@Slf4j
@RestController
@RequestMapping("/wx")
public class MpCheckController {

    @Value("${mp.config.token}")
    private String mpConfigToken;

    @GetMapping
    public ResponseEntity<String> checkApi(@RequestParam String signature, @RequestParam String timestamp, @RequestParam String nonce,
                                   @RequestParam String echostr) {
        log.info("MpCheckController checkApi signature:{}, timestamp:{}, nonce:{}, echostr:{}", signature, timestamp, nonce, echostr);
        List<String> list = Arrays.asList(mpConfigToken, timestamp, nonce);
        Collections.sort(list);
        String signatureStr = SecureUtil.sha1(String.join("", list));
        log.info("MpCheckController checkApi signatureStr:{}", signatureStr);
        return Objects.equals(signature, signatureStr) ? ResponseEntity.ok(echostr) : ResponseEntity.ok(null);
    }
}
