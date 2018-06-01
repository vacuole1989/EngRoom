package com.cxd.engroom.bean;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class Level implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long levelSeqId;
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

}
