package igoroffline.practice;

import io.micronaut.context.annotation.ConfigurationProperties;

@ConfigurationProperties("malaisha.datasource")
public record MalaishaDatasource(String url, String username, String password) {}
