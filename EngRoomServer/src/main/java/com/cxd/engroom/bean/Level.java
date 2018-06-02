package com.cxd.engroom.bean;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class Level implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long seqId;
    @NotNull
    private long courseSeqId;
    @NotNull
    @Column(length = 64)
    private String levelName;
    @NotNull
    @Column(length = 128)
    private String levelDesc;
    @NotNull
    @Column(length = 2)
    private int seqNo;
    @NotNull
    @Column(length = 19)
    private String createTime;


    public long getSeqId() {
        return seqId;
    }

    public Level setSeqId(long seqId) {
        this.seqId = seqId;
        return this;
    }

    public long getCourseSeqId() {
        return courseSeqId;
    }

    public Level setCourseSeqId(long courseSeqId) {
        this.courseSeqId = courseSeqId;
        return this;
    }

    public String getLevelName() {
        return levelName;
    }

    public Level setLevelName(String levelName) {
        this.levelName = levelName;
        return this;
    }

    public String getLevelDesc() {
        return levelDesc;
    }

    public Level setLevelDesc(String levelDesc) {
        this.levelDesc = levelDesc;
        return this;
    }

    public int getSeqNo() {
        return seqNo;
    }

    public Level setSeqNo(int seqNo) {
        this.seqNo = seqNo;
        return this;
    }

    public String getCreateTime() {
        return createTime;
    }

    public Level setCreateTime(String createTime) {
        this.createTime = createTime;
        return this;
    }

}
