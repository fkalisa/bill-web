package com.jb.bill.web.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConfigurationProperties("files")
@ConstructorBinding
public class FilesProperties {

    private String path;

    public FilesProperties(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
