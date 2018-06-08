package com.cxd.engroom.bean;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames={"wordSeqId", "userSeqId"})})
public class UserWord implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long seqId;
    @NotNull
    private long wordSeqId;
    @NotNull
    private long userSeqId;
    private String userAudio;
    private long userFileSize;
    private long userDuration;
    private String userContent;
    @Column(precision = 3)
    private Integer userWordScore;
    @NotNull
    @Column(precision = 4)
    private int readCount;

    private String errorWords;

    public long getWordSeqId() {
        return wordSeqId;
    }

    public UserWord setWordSeqId(long wordSeqId) {
        this.wordSeqId = wordSeqId;
        return this;
    }

    public Integer getUserWordScore() {
        return userWordScore;
    }

    public UserWord setUserWordScore(Integer userWordScore) {
        this.userWordScore = userWordScore;
        return this;
    }


    public String getUserAudio() {
        return userAudio;
    }

    public UserWord setUserAudio(String userAudio) {
        this.userAudio = userAudio;
        return this;
    }

    public String getUserContent() {
        return userContent;
    }

    public UserWord setUserContent(String userContent) {
        this.userContent = userContent;
        return this;
    }


    public int getReadCount() {
        return readCount;
    }

    public UserWord setReadCount(int readCount) {
        this.readCount = readCount;
        return this;
    }

    public String getErrorWords() {
        return errorWords;
    }

    public UserWord setErrorWords(String errorWords) {
        this.errorWords = errorWords;
        return this;
    }

    public long getSeqId() {
        return seqId;
    }

    public UserWord setSeqId(long seqId) {
        this.seqId = seqId;
        return this;
    }

    public long getUserDuration() {
        return userDuration;
    }

    public UserWord setUserDuration(long userDuration) {
        this.userDuration = userDuration;
        return this;
    }

    public long getUserFileSize() {
        return userFileSize;
    }

    public UserWord setUserFileSize(long userFileSize) {
        this.userFileSize = userFileSize;
        return this;
    }

    public long getUserSeqId() {
        return userSeqId;
    }

    public UserWord setUserSeqId(long userSeqId) {
        this.userSeqId = userSeqId;
        return this;
    }
}
