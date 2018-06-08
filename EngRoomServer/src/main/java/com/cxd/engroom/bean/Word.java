package com.cxd.engroom.bean;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames={"lessonSeqId", "seqNo"})})
public class Word implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long seqId;
    @NotNull
    private long lessonSeqId;
    @NotNull
    @Column(precision = 4)
    private int seqNo;
    @NotNull
    private String standardContent;
    @NotNull
    private String standardAudio;
    @NotNull
    @Column(precision = 2)
    private int standardAudioDuration;
    @NotNull
    @Column(length = 19)
    private String createTime;
    @NotNull
    @Column(length = 19)
    private String modifyTime;

    @Transient
    private UserWord userWord;

    @Transient
    private List<WordS> wordS;



    public long getLessonSeqId() {
        return lessonSeqId;
    }

    public Word setLessonSeqId(long lessonSeqId) {
        this.lessonSeqId = lessonSeqId;
        return this;
    }

    public int getSeqNo() {
        return seqNo;
    }

    public Word setSeqNo(int seqNo) {
        this.seqNo = seqNo;
        return this;
    }

    public int getStandardAudioDuration() {
        return standardAudioDuration;
    }

    public Word setStandardAudioDuration(int standardAudioDuration) {
        this.standardAudioDuration = standardAudioDuration;
        return this;
    }

    public String getCreateTime() {
        return createTime;
    }

    public Word setCreateTime(String createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public Word setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }

    public String getStandardContent() {
        return standardContent;
    }

    public Word setStandardContent(String standardContent) {
        this.standardContent = standardContent;
        return this;
    }

    public String getStandardAudio() {
        return standardAudio;
    }

    public Word setStandardAudio(String standardAudio) {
        this.standardAudio = standardAudio;
        return this;
    }

    public long getSeqId() {
        return seqId;
    }

    public Word setSeqId(long seqId) {
        this.seqId = seqId;
        return this;
    }

    public UserWord getUserWord() {
        return userWord;
    }

    public Word setUserWord(UserWord userWord) {
        this.userWord = userWord;
        return this;
    }

    public List<WordS> getWordS() {
        return wordS;
    }

    public Word setWordS(List<WordS> wordS) {
        this.wordS = wordS;
        return this;
    }
}
