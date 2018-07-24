package com.maryanto.dimas.example.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.token.TokenStore;

@EnableResourceServer
@Configuration
public class OauthResourceServerConfiguration extends ResourceServerConfigurerAdapter {


    @Autowired
    private OAuth2AccessDeniedHandler handler;

    @Autowired
    private TokenStore tokenStore;

    @Value("${oauth2.resource_id}")
    private String RESOURCE_ID;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
//        super.configure(resources);
        resources.resourceId(RESOURCE_ID)
                .tokenStore(tokenStore)
                .accessDeniedHandler(handler)
                .stateless(false);
    }
}
