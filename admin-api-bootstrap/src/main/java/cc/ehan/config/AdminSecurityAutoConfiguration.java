package cc.ehan.config;

import cc.ehan.auth.admin.api.auth.AuthApi;
import cc.ehan.auth.admin.security.UserDetailsServiceImpl;
import cc.ehan.auth.admin.security.authentication.AccountAuthenticationProvider;
import cc.ehan.framework.security.checks.DefaultPreAuthenticationChecks;
import cc.ehan.framework.security.config.properties.AuthorizationProperties;
import cc.ehan.framework.security.token.AccessTokenResolver;
import cc.ehan.framework.security.filter.AuthenticationTokenFilter;
import cc.ehan.framework.security.handle.AuthenticationEntryPointImpl;
import cc.ehan.organization.api.user.OrganizationUserApi;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * spring security配置
 *
 * @Author ZhangZhiYong
 */
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
@EnableConfigurationProperties(AuthorizationProperties.class)
@RequiredArgsConstructor
public class AdminSecurityAutoConfiguration extends WebSecurityConfigurerAdapter {

    private final OrganizationUserApi organizationUserApi;

    private final AuthApi authApi;

    private final AuthorizationProperties authorizationProperties;

    @Bean
    public AuthenticationEntryPoint unauthorizedHandler() {
        return new AuthenticationEntryPointImpl();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }


    @Bean
    public AccessTokenResolver accessTokenResolver() {
        return new AccessTokenResolver(authorizationProperties.getHeaderName());
    }

    /**
     * 解决 无法直接注入 AuthenticationManager
     *
     * @return
     * @throws Exception
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public DefaultPreAuthenticationChecks defaultPreAuthenticationChecks() {
        return new DefaultPreAuthenticationChecks();
    }

    @Bean
    public AccountAuthenticationProvider accountAuthenticationProvider() {
        AccountAuthenticationProvider accountAuthenticationProvider = new AccountAuthenticationProvider(organizationUserApi);
        accountAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        accountAuthenticationProvider.setUserDetailsService(userDetailsService());
        accountAuthenticationProvider.setPreAuthenticationChecks(defaultPreAuthenticationChecks());

        return accountAuthenticationProvider;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // 不走 securityFilter 过滤
        web.ignoring()
                .antMatchers(
                        "/login"
                )
                .antMatchers(
                        "/",
                        "/*.html",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js",
                        "/druid/**"
                );
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        // 注解标记允许匿名访问的url
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = httpSecurity.authorizeRequests();

        httpSecurity
                // CSRF禁用
                .csrf().disable()
                .headers().cacheControl().disable()
                .and()
                // 认证失败处理类
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler())
                .and()
                // 禁用 session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                // 过滤请求
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                // 认证器
                .authenticationProvider(accountAuthenticationProvider())
                .headers()
                .frameOptions()
                .disable()
                .and()
                .addFilterBefore(new AuthenticationTokenFilter(authApi, accessTokenResolver()), UsernamePasswordAuthenticationFilter.class);
    }

    /**
     * 强散列哈希加密实现
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
