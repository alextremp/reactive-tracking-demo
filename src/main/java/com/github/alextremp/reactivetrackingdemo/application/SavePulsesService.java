package com.github.alextremp.reactivetrackingdemo.application;

import com.github.alextremp.reactivetrackingdemo.application.savepulses.io.SavePulsesRequest;
import com.github.alextremp.reactivetrackingdemo.application.savepulses.io.SavePulsesResponse;
import reactor.core.publisher.Mono;

public interface SavePulsesService {

  Mono<SavePulsesResponse> savePulses(SavePulsesRequest request);
}
