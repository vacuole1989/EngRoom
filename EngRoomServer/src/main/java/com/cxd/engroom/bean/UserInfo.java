package com.cxd.engroom.bean;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
/**
 * @author ws03089
 */
@Entity
public class UserInfo implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long seqId;
    @NotNull
    @Column(length = 32)
    private String openId;
    @NotNull
    @Column(length = 64)
    private String sessionKey;
    @NotNull
    @Column(length = 128)
    private String nickName;
    @NotNull
    private String avatarUrl;
    @Column(length = 1)
    private String gender;
    private String province;
    private String city;
    private String country;
    @NotNull
    @Column(length = 19)
    private String createTime;


    public String getOpenId() {
        return openId;
    }

    public UserInfo setOpenId(String openId) {
        this.openId = openId;
        return this;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public UserInfo setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
        return this;
    }

    public String getNickName() {
        return nickName;
    }

    public UserInfo setNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public UserInfo setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public UserInfo setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getProvince() {
        return province;
    }

    public UserInfo setProvince(String province) {
        this.province = province;
        return this;
    }

    public String getCity() {
        return city;
    }

    public UserInfo setCity(String city) {
        this.city = city;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public UserInfo setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getCreateTime() {
        return createTime;
    }

    public UserInfo setCreateTime(String createTime) {
        this.createTime = createTime;
        return this;
    }


    public long getSeqId() {
        return seqId;
    }

    public UserInfo setSeqId(long seqId) {
        this.seqId = seqId;
        return this;
    }
}
