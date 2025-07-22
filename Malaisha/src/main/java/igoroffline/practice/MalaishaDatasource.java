package igoroffline.practice;

import io.micronaut.context.annotation.ConfigurationProperties;

@ConfigurationProperties("datasources.default")
public record MalaishaDatasource(String url, String username, String password) {}
