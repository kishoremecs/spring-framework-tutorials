package com.practice.config;

import com.practice.shop.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.Resource;

@Configuration
@PropertySource("file:C:/data/workspaces/spring-framework-tutorials/spring-recipies/src/main/resources/application.properties")
@ComponentScan("com.practice.shop")
public class ShopConfiguration {

  @Value("classpath:banner.txt")
  private Resource banner;

  @Value("${endofyear.discount:0}")
  private double specialEndofyearDiscountField;

  @Bean
  public BannerLoader bannerLoader() {
    return new BannerLoader(banner);
  }

  @Bean
  public static PropertySourcesPlaceholderConfigurer pspc() {
    return new PropertySourcesPlaceholderConfigurer();
  }

  @Bean
  public Product aaa() {
    return new Battery("AAA", 2.5, true);
  }

  @Bean
  public Product cdrw() {
    return new Disc("CD-RW", 1.5, 700, specialEndofyearDiscountField);
  }

  @Bean
  public Product dvdrw() {
    return new Disc("DVD-RW", 3.0, 4900, specialEndofyearDiscountField);
  }
}