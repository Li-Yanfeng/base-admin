package org.utility.modules.system.service.impl;

import cn.hutool.core.lang.Dict;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.extra.template.Template;
import cn.hutool.extra.template.TemplateConfig;
import cn.hutool.extra.template.TemplateEngine;
import cn.hutool.extra.template.TemplateUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.utility.exception.BadRequestException;
import org.utility.model.vo.EmailVO;
import org.utility.modules.system.service.VerifyService;
import org.utility.util.RedisUtils;

import java.util.Collections;

/**
 * 验证码 服务实现类
 *
 * @author Li Yanfeng
 * @since 2021-06-27
 */
@Service
public class VerifyServiceImpl implements VerifyService {

    @Value("${code.expiration}")
    private Long expiration;

    private final RedisUtils redisUtils;

    public VerifyServiceImpl(RedisUtils redisUtils) {
        this.redisUtils = redisUtils;
    }


    @Override
    public EmailVO sendEmail(String email, String key) {
        EmailVO emailVo;
        String content;
        String redisKey = key + email;
        // 如果不存在有效的验证码，就创建一个新的
        TemplateEngine engine = TemplateUtil.createEngine(new TemplateConfig("template", TemplateConfig.ResourceMode.CLASSPATH));
        Template template = engine.getTemplate("email/email.ftl");
        Object oldCode = redisUtils.get(redisKey);
        if (oldCode == null) {
            String code = RandomUtil.randomNumbers(6);
            // 存入缓存
            if (!redisUtils.set(redisKey, code, expiration)) {
                throw new BadRequestException("服务异常，请联系网站负责人");
            }
            content = template.render(Dict.create().set("code", code));
            emailVo = new EmailVO(Collections.singletonList(email), "ADMIN后台管理系统", content);
            // 存在就再次发送原来的验证码
        } else {
            content = template.render(Dict.create().set("code", oldCode));
            emailVo = new EmailVO(Collections.singletonList(email), "ADMIN后台管理系统", content);
        }
        return emailVo;
    }

    @Override
    public void validated(String key, String code) {
        Object value = redisUtils.get(key);
        if (value == null || !value.toString().equals(code)) {
            throw new BadRequestException("无效验证码");
        } else {
            redisUtils.del(key);
        }
    }
}
