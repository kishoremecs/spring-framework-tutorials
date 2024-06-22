package spring.aop.practice.app;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import spring.aop.practice.config.BasicAppConfig;

public class AppMain {

    public static void main(String... args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(BasicAppConfig.class);
        String appname = (String) ctx.getBean("appName");
        System.out.println(appname);
    }
}
