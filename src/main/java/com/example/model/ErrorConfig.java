package com.example.model;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties
@PropertySource("classpath:errorDict.properties")
public class ErrorConfig {
    @Value("${E01.code}")
    private int er01Code;
    @Value("${E01.message}")
    private String er01msg;

    @Value("${E02.code}")
    private int er02Code;
    @Value("${E02.message}")
    private String er02msg;
    @Value("${E03.code}")
    private int er03Code;
    @Value("${E03.message}")
    private String er03msg;

    public int getEr01Code() {
        return er01Code;
    }


    public String getEr01msg() {
        return er01msg;
    }


    public int getEr02Code() {
        return er02Code;
    }

    public String getEr02msg() {
        return er02msg;
    }

    public int getEr03Code() {
        return er03Code;
    }

    public String getEr03msg() {
        return er03msg;
    }

}
