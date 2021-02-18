package com.example.demothymeleaf.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
/*
* 配置授权服务器
* */
@Configuration
@EnableAuthorizationServer  //开启授权服务器
public class AuthorizationServerConfig  extends AuthorizationServerConfigurerAdapter {
    @Autowired
    AuthenticationManager authenticationManager;//该对象将用来支持password模式
    @Autowired
    RedisConnectionFactory redisConnectionFactory; //该对象将用来完成redis缓存，讲令牌信息存储到redis缓存中
    @Autowired
    UserDetailsService userDetailsService;//该对象将为刷新token提供支持


    @Bean
    PasswordEncoder passwordEncoder(){
        //return  new BCryptPasswordEncoder();
        return  NoOpPasswordEncoder.getInstance();
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //super.configure(clients);
        //配置password授权模式
        clients.inMemory()
                .withClient("password")
                //配置两种授权模式 一种为password  一种为refresh_token
                .authorizedGrantTypes("password","refresh_token")
                //acces_tokne过期时间
                .accessTokenValiditySeconds(1800)
                .resourceIds("rid")
                .scopes("all")
                .secret("123");
    }


    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        //super.configure(endpoints);
        //配置令牌的存储
        endpoints.tokenStore(new RedisTokenStore(redisConnectionFactory))
                .authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        //super.configure(security);
        //配置表示支持client_id he client_srcret做登录认证
        security.allowFormAuthenticationForClients();
    }
}
