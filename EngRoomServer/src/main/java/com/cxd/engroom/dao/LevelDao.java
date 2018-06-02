package com.cxd.engroom.dao;

import com.cxd.engroom.bean.Level;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LevelDao extends CrudRepository<Level,Long> {
    @Query("from Level where courseSeqId = ?1 order by seqNo asc")
    List<Level> findLevels(long seqId);
}
