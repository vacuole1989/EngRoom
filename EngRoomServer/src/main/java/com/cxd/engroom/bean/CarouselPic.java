package com.cxd.engroom.bean;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class CarouselPic implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long carouselPicSeqId;
    @NotNull
    @Column(length = 32)
    private String carouselPicName;
    @Column(length = 128)
    private String carouselPicDesc;
    /**
     * 1-超链接，2-图片
     */
    @NotNull
    @Column(precision = 1)
    private int type = 1;
    @NotNull
    private long articleSeqId;
    @NotNull
    private String picUrl;
    @NotNull
    @Column(length = 19)
    private String createTime;
    @NotNull
    @Column(precision = 1)
    private int seqNo=1;

    public long getCarouselPicSeqId() {
        return carouselPicSeqId;
    }

    public CarouselPic setCarouselPicSeqId(long carouselPicSeqId) {
        this.carouselPicSeqId = carouselPicSeqId;
        return this;
    }

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

    public int getType() {
        return type;
    }

    public CarouselPic setType(int type) {
        this.type = type;
        return this;
    }

    public long getArticleSeqId() {
        return articleSeqId;
    }

    public CarouselPic setArticleSeqId(long articleSeqId) {
        this.articleSeqId = articleSeqId;
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
}
