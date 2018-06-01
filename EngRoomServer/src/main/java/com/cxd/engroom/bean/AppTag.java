package com.cxd.engroom.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class AppTag implements Serializable {
    @Id
    @Column(length = 64)
    private String appId;
    @NotNull
    private String appSecret;
    private String appTemplate;

    public String getAppId() {
        return appId;
    }

    public AppTag setAppId(String appId) {
        this.appId = appId;
        return this;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public AppTag setAppSecret(String appSecret) {
        this.appSecret = appSecret;
        return this;
    }

    public String getAppTemplate() {
        return appTemplate;
    }

    public AppTag setAppTemplate(String appTemplate) {
        this.appTemplate = appTemplate;
        return this;
    }
}
