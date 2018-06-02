package com.cxd.engroom.bean;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class UserParagraph implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long seqId;
    @NotNull
    private long userLessonSeqId;
    @NotNull
    private long paragraphSeqId;
    @NotNull
    private String standardContent;
    private String userAudio;
    private String userContent;
    @Column(precision = 3)
    private Integer userParagraphScore;
    @NotNull
    @Column(precision = 4)
    private int readCount;

    private String errorWords;


    public long getParagraphSeqId() {
        return paragraphSeqId;
    }

    public UserParagraph setParagraphSeqId(long paragraphSeqId) {
        this.paragraphSeqId = paragraphSeqId;
        return this;
    }

    public String getStandardContent() {
        return standardContent;
    }

    public UserParagraph setStandardContent(String standardContent) {
        this.standardContent = standardContent;
        return this;
    }

    public String getUserAudio() {
        return userAudio;
    }

    public UserParagraph setUserAudio(String userAudio) {
        this.userAudio = userAudio;
        return this;
    }

    public String getUserContent() {
        return userContent;
    }

    public UserParagraph setUserContent(String userContent) {
        this.userContent = userContent;
        return this;
    }


    public int getReadCount() {
        return readCount;
    }

    public UserParagraph setReadCount(int readCount) {
        this.readCount = readCount;
        return this;
    }

    public String getErrorWords() {
        return errorWords;
    }

    public UserParagraph setErrorWords(String errorWords) {
        this.errorWords = errorWords;
        return this;
    }

    public long getUserLessonSeqId() {
        return userLessonSeqId;
    }

    public UserParagraph setUserLessonSeqId(long userLessonSeqId) {
        this.userLessonSeqId = userLessonSeqId;
        return this;
    }


    public Integer getUserParagraphScore() {
        return userParagraphScore;
    }

    public UserParagraph setUserParagraphScore(Integer userParagraphScore) {
        this.userParagraphScore = userParagraphScore;
        return this;
    }

    public long getSeqId() {
        return seqId;
    }

    public UserParagraph setSeqId(long seqId) {
        this.seqId = seqId;
        return this;
    }
}
