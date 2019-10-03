package com.github.alextremp.reactivetrackingdemo.infrastructure.framework.rest;

import com.github.alextremp.reactivetrackingdemo.application.TrackingApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/")
public class TrackController {

  private final TrackingApplication trackingApplication;

  @Autowired
  public TrackController(TrackingApplication trackingApplication) {
    this.trackingApplication = trackingApplication;
  }

  @GetMapping
  public Mono<String> track(String data) {

  }
}
