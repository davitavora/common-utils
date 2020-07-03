package com.github.davitavorah.common;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "common.utils")
public class CommonProperty {

    private boolean enableSquiggly = true;

    private String squigglyQueryParam = "campos";

}
