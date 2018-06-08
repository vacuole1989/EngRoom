package com.cxd.engroom.bean;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
@Entity
public class Course implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long seqId;
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
    private boolean ishow;
    @NotNull
    @Column(length = 7)
    private String bgColor="#FFFFFF";
    @NotNull
    @Column(length = 7)
    private String textColor="#000000";

    private String smallPic;

    public String getChapterTitle() {
        return chapterTitle;
    }

    public Course setChapterTitle(String chapterTitle) {
        this.chapterTitle = chapterTitle;
        return this;
    }

    public String getChapterDesc() {
        return chapterDesc;
    }

    public Course setChapterDesc(String chapterDesc) {
        this.chapterDesc = chapterDesc;
        return this;
    }

    public String getCreateTime() {
        return createTime;
    }

    public Course setCreateTime(String createTime) {
        this.createTime = createTime;
        return this;
    }



    public String getBgColor() {
        return bgColor;
    }

    public Course setBgColor(String bgColor) {
        this.bgColor = bgColor;
        return this;
    }

    public String getTextColor() {
        return textColor;
    }

    public Course setTextColor(String textColor) {
        this.textColor = textColor;
        return this;
    }

    public int getSeqNo() {
        return seqNo;
    }

    public Course setSeqNo(int seqNo) {
        this.seqNo = seqNo;
        return this;
    }


    public boolean isIshow() {
        return ishow;
    }

    public Course setIshow(boolean ishow) {
        this.ishow = ishow;
        return this;
    }


    public long getSeqId() {
        return seqId;
    }

    public Course setSeqId(long seqId) {
        this.seqId = seqId;
        return this;
    }

    public String getSmallPic() {
        return smallPic;
    }

    public Course setSmallPic(String smallPic) {
        this.smallPic = smallPic;
        return this;
    }
}
