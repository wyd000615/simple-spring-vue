package com.demo.config;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TomcatConfig {
    @Bean
    public TomcatServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory tomcat =
                new TomcatServletWebServerFactory() {

                    @Override
                    protected void postProcessContext(Context context) {
                        SecurityConstraint securityConstraint = new SecurityConstraint();
                        securityConstraint.setUserConstraint("CONFIDENTIAL");
                        SecurityCollection collection = new SecurityCollection();
                        collection.addPattern("/*");
                        securityConstraint.addCollection(collection);
                        context.addConstraint(securityConstraint);
                    }
                };
        tomcat.addAdditionalTomcatConnectors(creatTomcatConnector());
        return tomcat;
    }
    private Connector creatTomcatConnector() {
        Connector connector = new Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL);
        connector.setScheme("http");
        connector.setSecure(false);
        connector.setPort(8080);
        connector.setRedirectPort(8081);
        return connector;
    }
}
