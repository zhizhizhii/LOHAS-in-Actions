package com.lohas.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "lohas")
public class WxInfoConfig {

    private String WXAPPID;

    private String WXSECRET;

    private String WXGRANTTYPE;

    public String getWXAPPID() {
        return WXAPPID;
    }

    public void setWXAPPID(String WXAPPID) {
        this.WXAPPID = WXAPPID;
    }

    public String getWXSECRET() {
        return WXSECRET;
    }

    public void setWXSECRET(String WXSECRET) {
        this.WXSECRET = WXSECRET;
    }

    public String getWXGRANTTYPE() {
        return WXGRANTTYPE;
    }

    public void setWXGRANTTYPE(String WXGRANTTYPE) {
        this.WXGRANTTYPE = WXGRANTTYPE;
    }
}
