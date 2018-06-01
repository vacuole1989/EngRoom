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
    private String activityName;

    private String activityDesc;
    @NotNull
    @Column(length = 19)
    private String finishTime;


    public long getActivitySeqId() {
        return activitySeqId;
    }

    public Activity setActivitySeqId(long activitySeqId) {
        this.activitySeqId = activitySeqId;
        return this;
    }

    public String getActivityName() {
        return activityName;
    }

    public Activity setActivityName(String activityName) {
        this.activityName = activityName;
        return this;
    }

    public String getActivityDesc() {
        return activityDesc;
    }

    public Activity setActivityDesc(String activityDesc) {
        this.activityDesc = activityDesc;
        return this;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public Activity setFinishTime(String finishTime) {
        this.finishTime = finishTime;
        return this;
    }
}
