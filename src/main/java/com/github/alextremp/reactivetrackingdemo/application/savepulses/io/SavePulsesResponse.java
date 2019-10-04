package com.github.alextremp.reactivetrackingdemo.application.savepulses.io;

public class SavePulsesResponse {

    private final String code;

    public SavePulsesResponse(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
