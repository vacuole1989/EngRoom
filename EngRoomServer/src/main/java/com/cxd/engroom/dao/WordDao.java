package com.cxd.engroom.dao;

import com.cxd.engroom.bean.Word;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WordDao extends CrudRepository<Word, Long> {
    @Query("from Word where lessonSeqId= ?1 order by seqNo asc")
    List<Word> findWords(long seqId);
}
