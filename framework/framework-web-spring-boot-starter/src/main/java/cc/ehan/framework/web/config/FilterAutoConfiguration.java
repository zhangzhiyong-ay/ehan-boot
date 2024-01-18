package cc.ehan.framework.web.config;

import cc.ehan.framework.web.config.properties.FilterProperties;
import cc.ehan.framework.web.filter.RepeatableFilter;
import cc.ehan.framework.web.filter.XssFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import javax.servlet.DispatcherType;

/**
 * Filter配置
 *
 * @Author ZhangZhiYong
 */
@Configuration
@EnableConfigurationProperties(FilterProperties.class)
public class FilterAutoConfiguration {

    @Bean
    public FilterRegistrationBean<RepeatableFilter> someFilterRegistration() {
        FilterRegistrationBean<RepeatableFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new RepeatableFilter());
        registration.addUrlPatterns("/*");
        registration.setName("repeatableFilter");
        registration.setOrder(1);
        return registration;
    }

    @Bean
    @ConditionalOnProperty(value = "system.filter.xss.enabled", havingValue = "true")
    public FilterRegistrationBean<XssFilter> xssFilterRegistration(FilterProperties filterProperties) {
        FilterRegistrationBean<XssFilter> registration = new FilterRegistrationBean<>();
        registration.setDispatcherTypes(DispatcherType.REQUEST);
        registration.setFilter(new XssFilter(filterProperties.getXss().getExcludeUrl()));
        registration.addUrlPatterns(filterProperties.getXss().getUrlPatterns().toArray(String[]::new));
        registration.setName(filterProperties.getXss().getFilterName());
        registration.setOrder(2);
        return registration;
    }


}
