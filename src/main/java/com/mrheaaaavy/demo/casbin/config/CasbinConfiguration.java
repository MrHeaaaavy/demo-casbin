package com.mrheaaaavy.demo.casbin.config;

import java.util.Objects;
import org.casbin.jcasbin.main.Enforcer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CasbinConfiguration {

  @Bean
  public Enforcer enforcer() {
    String modelPath = Objects.requireNonNull(getClass().getClassLoader().getResource("casbin.conf")).getPath();
    String policyFile = Objects.requireNonNull(getClass().getClassLoader().getResource("casbin.csv")).getPath();
    Enforcer enforcer = new Enforcer(modelPath, policyFile, true);
    enforcer.loadModel();
    enforcer.loadPolicy();
    return enforcer;
  }

}
