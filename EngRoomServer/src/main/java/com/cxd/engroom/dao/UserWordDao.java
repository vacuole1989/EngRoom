package com.cxd.engroom.dao;

import com.cxd.engroom.bean.UserWord;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserWordDao extends CrudRepository<UserWord,Long> {
    List<UserWord> findByUserSeqIdAndWordSeqId(long userSeqId, long seqId);

    List<UserWord> findByUserSeqId(long userSeqId);
}
