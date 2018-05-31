package com.cxd.engroom.bean;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames={"userInfoSeqId", "activitySeqId"})})
public class ActivityUser implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long seqId;

    @NotNull
    private long userInfoSeqId;
    @NotNull
    private long activitySeqId;
    @Column(length = 128)
    private String openGId;
    @NotNull
    @Column(precision = 3)
    private int score;

    public long getSeqId() {
        return seqId;
    }

    public ActivityUser setSeqId(long seqId) {
        this.seqId = seqId;
        return this;
    }

    public long getUserInfoSeqId() {
        return userInfoSeqId;
    }

    public ActivityUser setUserInfoSeqId(long userInfoSeqId) {
        this.userInfoSeqId = userInfoSeqId;
        return this;
    }

    public long getActivitySeqId() {
        return activitySeqId;
    }

    public ActivityUser setActivitySeqId(long activitySeqId) {
        this.activitySeqId = activitySeqId;
        return this;
    }

    public String getOpenGId() {
        return openGId;
    }

    public ActivityUser setOpenGId(String openGId) {
        this.openGId = openGId;
        return this;
    }

    public int getScore() {
        return score;
    }

    public ActivityUser setScore(int score) {
        this.score = score;
        return this;
    }
}
