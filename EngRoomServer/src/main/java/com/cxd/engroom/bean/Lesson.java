package com.cxd.engroom.bean;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames={"chapterSeqId", "seqNo"})})
public class Lesson implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long lessonSeqId;
    @NotNull
    private long chapterSeqId;
    @Column(precision = 3)
    @NotNull
    private int seqNo;
    @Column(length = 32)
    @NotNull
    private String showText;

    private String desc;

    @Column(length = 32)
    @NotNull
    private String name;
    @NotNull
    @Column(length = 19)
    private String createTime;
    @NotNull
    @Column(length = 19)
    private String modifyTime;


    public long getLessonSeqId() {
        return lessonSeqId;
    }

    public Lesson setLessonSeqId(long lessonSeqId) {
        this.lessonSeqId = lessonSeqId;
        return this;
    }

    public long getChapterSeqId() {
        return chapterSeqId;
    }

    public Lesson setChapterSeqId(long chapterSeqId) {
        this.chapterSeqId = chapterSeqId;
        return this;
    }

    public int getSeqNo() {
        return seqNo;
    }

    public Lesson setSeqNo(int seqNo) {
        this.seqNo = seqNo;
        return this;
    }

    public String getName() {
        return name;
    }

    public Lesson setName(String name) {
        this.name = name;
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

    public String getShowText() {
        return showText;
    }

    public Lesson setShowText(String showText) {
        this.showText = showText;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public Lesson setDesc(String desc) {
        this.desc = desc;
        return this;
    }
}