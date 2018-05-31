package com.cxd.engroom.bean;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
@Entity
public class Chapter implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long chapterSeqId;
    @NotNull
    @Column(length = 32)
    private String chapterTitle;
    @NotNull
    private String chapterDesc;
    @NotNull
    @Column(length = 19)
    private String createTime;
    @NotNull
    @Column(precision = 2)
    private int seqNo;
    @NotNull
    private boolean show;
    @NotNull
    @Column(length = 7)
    private String bgColor="#FFFFFF";
    @NotNull
    @Column(length = 7)
    private String textColor="#000000";


    public String getChapterTitle() {
        return chapterTitle;
    }

    public Chapter setChapterTitle(String chapterTitle) {
        this.chapterTitle = chapterTitle;
        return this;
    }

    public String getChapterDesc() {
        return chapterDesc;
    }

    public Chapter setChapterDesc(String chapterDesc) {
        this.chapterDesc = chapterDesc;
        return this;
    }

    public String getCreateTime() {
        return createTime;
    }

    public Chapter setCreateTime(String createTime) {
        this.createTime = createTime;
        return this;
    }

    public boolean isShow() {
        return show;
    }

    public Chapter setShow(boolean show) {
        this.show = show;
        return this;
    }

    public String getBgColor() {
        return bgColor;
    }

    public Chapter setBgColor(String bgColor) {
        this.bgColor = bgColor;
        return this;
    }

    public String getTextColor() {
        return textColor;
    }

    public Chapter setTextColor(String textColor) {
        this.textColor = textColor;
        return this;
    }

    public int getSeqNo() {
        return seqNo;
    }

    public Chapter setSeqNo(int seqNo) {
        this.seqNo = seqNo;
        return this;
    }

    public long getChapterSeqId() {
        return chapterSeqId;
    }

    public Chapter setChapterSeqId(long chapterSeqId) {
        this.chapterSeqId = chapterSeqId;
        return this;
    }
}
