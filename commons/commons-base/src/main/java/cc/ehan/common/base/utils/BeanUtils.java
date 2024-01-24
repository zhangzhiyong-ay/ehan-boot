package cc.ehan.common.base.utils;

import org.springframework.beans.BeansException;

/**
 * Bean 工具类，扩展spring提供的 BeanUtils 工具类
 *
 * @Author ZhangZhiYong
 */
public class BeanUtils extends org.springframework.beans.BeanUtils {

    public static <T> T copyPropertiesByClass(Object source, Class<T> targetClazz, String... ignoreProperties) throws BeansException {
        T target = instantiateClass(targetClazz);
        copyProperties(source, target, ignoreProperties);
        return target;
    }

    public static <T> T copyPropertiesByClass(Object source, Class<T> targetClazz) throws BeansException {
        T target = instantiateClass(targetClazz);
        copyProperties(source, target, (String[]) null);
        return target;
    }

}
