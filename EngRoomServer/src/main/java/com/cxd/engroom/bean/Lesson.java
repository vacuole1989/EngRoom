package com.cxd.engroom.bean;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames={"levelSeqId", "seqNo"})})
public class Lesson implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long seqId;
    @NotNull
    private long levelSeqId;
    @Column(precision = 3)
    @NotNull
    private int seqNo;
    @Column(length = 32)
    @NotNull
    private String showText;

    private String lessonDesc;

    @Column(length = 32)
    @NotNull
    private String lessonName;
    @NotNull
    @Column(length = 19)
    private String createTime;
    @NotNull
    @Column(length = 19)
    private String modifyTime;
    @Column(precision = 4)
    private int pleft=0;
    @Transient
    private String showStyle;

    public int getPleft() {
        return pleft;
    }

    public Lesson setPleft(int pleft) {
        this.pleft = pleft;
        return this;
    }

    public int getSeqNo() {
        return seqNo;
    }

    public Lesson setSeqNo(int seqNo) {
        this.seqNo = seqNo;
        return this;
    }

    public String getShowText() {
        return showText;
    }

    public Lesson setShowText(String showText) {
        this.showText = showText;
        return this;
    }

    public String getLessonDesc() {
        return lessonDesc;
    }

    public Lesson setLessonDesc(String lessonDesc) {
        this.lessonDesc = lessonDesc;
        return this;
    }

    public String getLessonName() {
        return lessonName;
    }

    public Lesson setLessonName(String lessonName) {
        this.lessonName = lessonName;
        return this;
    }

    public String getCreateTime() {
        return createTime;
    }

    public Lesson setCreateTime(String createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public Lesson setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }

    public long getSeqId() {
        return seqId;
    }

    public Lesson setSeqId(long seqId) {
        this.seqId = seqId;
        return this;
    }

    public long getLevelSeqId() {
        return levelSeqId;
    }

    public Lesson setLevelSeqId(long levelSeqId) {
        this.levelSeqId = levelSeqId;
        return this;
    }

    public String getShowStyle() {
        return showStyle;
    }

    public Lesson setShowStyle(String showStyle) {
        this.showStyle = showStyle;
        return this;
    }
}
