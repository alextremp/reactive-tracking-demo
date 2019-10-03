package com.github.alextremp.reactivetrackingdemo.infrastructure.framework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ReactiveTrackingDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(ReactiveTrackingDemoApplication.class, args);
  }

}
