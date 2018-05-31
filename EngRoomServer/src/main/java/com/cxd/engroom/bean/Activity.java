package com.cxd.engroom.bean;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
@Entity
public class Activity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long activitySeqId;
    @NotNull
    @Column(length = 128)
    private String name;

    private String desc;
    @NotNull
    @Column(length = 19)
    private String finishTime;


    public String getFinishTime() {
        return finishTime;
    }

    public Activity setFinishTime(String finishTime) {
        this.finishTime = finishTime;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public Activity setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public String getName() {
        return name;
    }

    public Activity setName(String name) {
        this.name = name;
        return this;
    }

    public long getActivitySeqId() {
        return activitySeqId;
    }

    public Activity setActivitySeqId(long activitySeqId) {
        this.activitySeqId = activitySeqId;
        return this;
    }
}
