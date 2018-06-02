package com.cxd.engroom.bean;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class CarouselPic implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long seqId;
    @NotNull
    @Column(length = 32)
    private String carouselPicName;
    @Column(length = 128)
    private String carouselPicDesc;
    @NotNull
    private long levelSeqId;
    @NotNull
    private String picUrl;
    @NotNull
    @Column(length = 19)
    private String createTime;
    @NotNull
    @Column(precision = 1)
    private int seqNo=1;



    public String getCarouselPicName() {
        return carouselPicName;
    }

    public CarouselPic setCarouselPicName(String carouselPicName) {
        this.carouselPicName = carouselPicName;
        return this;
    }

    public String getCarouselPicDesc() {
        return carouselPicDesc;
    }

    public CarouselPic setCarouselPicDesc(String carouselPicDesc) {
        this.carouselPicDesc = carouselPicDesc;
        return this;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public CarouselPic setPicUrl(String picUrl) {
        this.picUrl = picUrl;
        return this;
    }

    public String getCreateTime() {
        return createTime;
    }

    public CarouselPic setCreateTime(String createTime) {
        this.createTime = createTime;
        return this;
    }

    public int getSeqNo() {
        return seqNo;
    }

    public CarouselPic setSeqNo(int seqNo) {
        this.seqNo = seqNo;
        return this;
    }

    public long getSeqId() {
        return seqId;
    }

    public CarouselPic setSeqId(long seqId) {
        this.seqId = seqId;
        return this;
    }

    public long getLevelSeqId() {
        return levelSeqId;
    }

    public CarouselPic setLevelSeqId(long levelSeqId) {
        this.levelSeqId = levelSeqId;
        return this;
    }
}
