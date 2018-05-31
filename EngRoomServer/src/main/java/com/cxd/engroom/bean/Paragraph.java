package com.cxd.engroom.bean;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames={"lessonSeqId", "seqNo"})})
public class Paragraph implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long paragraphSeqId;
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


    public long getParagraphSeqId() {
        return paragraphSeqId;
    }

    public Paragraph setParagraphSeqId(long paragraphSeqId) {
        this.paragraphSeqId = paragraphSeqId;
        return this;
    }

    public long getLessonSeqId() {
        return lessonSeqId;
    }

    public Paragraph setLessonSeqId(long lessonSeqId) {
        this.lessonSeqId = lessonSeqId;
        return this;
    }

    public int getSeqNo() {
        return seqNo;
    }

    public Paragraph setSeqNo(int seqNo) {
        this.seqNo = seqNo;
        return this;
    }

    public int getStandardAudioDuration() {
        return standardAudioDuration;
    }

    public Paragraph setStandardAudioDuration(int standardAudioDuration) {
        this.standardAudioDuration = standardAudioDuration;
        return this;
    }

    public String getCreateTime() {
        return createTime;
    }

    public Paragraph setCreateTime(String createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public Paragraph setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }

    public String getStandardContent() {
        return standardContent;
    }

    public Paragraph setStandardContent(String standardContent) {
        this.standardContent = standardContent;
        return this;
    }

    public String getStandardAudio() {
        return standardAudio;
    }

    public Paragraph setStandardAudio(String standardAudio) {
        this.standardAudio = standardAudio;
        return this;
    }
}
