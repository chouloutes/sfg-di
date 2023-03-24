package com.example.sfgdi.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;
import org.springframework.context.annotation.Configuration;

//@ConstructorBinding //This annotation is no longer needed to do constructor binding
@ConfigurationProperties("guru")
public class SfgConstructorConfig {

    private final String userName;
    private final String password;
    private final String jdbcUrl;

    public SfgConstructorConfig(String userName, String password, String jdbcUrl) {
        this.userName = userName;
        this.password = password;
        this.jdbcUrl = jdbcUrl;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }
}
