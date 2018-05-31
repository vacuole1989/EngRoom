package com.cxd.engroom.bean;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class UserLesson implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userLessonSeqId;
    @NotNull
    private long userInfoSeqId;
    @NotNull
    private long lessonSeqId;
    @Column(precision = 3)
    private Integer userScore;
    @NotNull
    private boolean share;
    @NotNull
    private boolean readThree;

    private String allErrorWords;

    public long getLessonSeqId() {
        return lessonSeqId;
    }

    public UserLesson setLessonSeqId(long lessonSeqId) {
        this.lessonSeqId = lessonSeqId;
        return this;
    }

    public Integer getUserScore() {
        return userScore;
    }

    public UserLesson setUserScore(Integer userScore) {
        this.userScore = userScore;
        return this;
    }

    public boolean isShare() {
        return share;
    }

    public UserLesson setShare(boolean share) {
        this.share = share;
        return this;
    }




    public long getUserInfoSeqId() {
        return userInfoSeqId;
    }

    public UserLesson setUserInfoSeqId(long userInfoSeqId) {
        this.userInfoSeqId = userInfoSeqId;
        return this;
    }

    public long getUserLessonSeqId() {
        return userLessonSeqId;
    }

    public UserLesson setUserLessonSeqId(long userLessonSeqId) {
        this.userLessonSeqId = userLessonSeqId;
        return this;
    }

    public boolean isReadThree() {
        return readThree;
    }

    public UserLesson setReadThree(boolean readThree) {
        this.readThree = readThree;
        return this;
    }

    public String getAllErrorWords() {
        return allErrorWords;
    }

    public UserLesson setAllErrorWords(String allErrorWords) {
        this.allErrorWords = allErrorWords;
        return this;
    }
}
