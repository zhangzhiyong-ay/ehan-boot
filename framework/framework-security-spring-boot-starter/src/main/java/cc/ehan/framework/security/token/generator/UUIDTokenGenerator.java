package cc.ehan.framework.security.token.generator;

import cn.hutool.core.lang.UUID;

/**
 * 使用安全的 32位 UUID 生成token
 * @author zhangzhiyong
 */
public class UUIDTokenGenerator implements TokenGenerator {

    @Override
    public String generator(Object data) {
        return UUID.randomUUID().toString(true);
    }
}
