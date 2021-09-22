package com.github.hero;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
@Slf4j
public class HeroApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(HeroApplication.class, args);
        final ConfigurableEnvironment environment = context.getEnvironment();
        final String port = environment.getProperty("server.port");
        final String contextPath = environment.getProperty("server.servlet.context-path");
        log.info("项目启动成功，访问地址：http://**:"+port + contextPath);
    }

}
