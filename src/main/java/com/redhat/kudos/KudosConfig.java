package com.redhat.kudos;

import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithName;

@ConfigMapping(prefix = "greeting")
public interface KudosConfig {

    @WithName("message")
    String message();

}