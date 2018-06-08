package com.cxd.engroom.dao;

import com.cxd.engroom.bean.Lesson;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LessonDao extends CrudRepository<Lesson,Long> {
    @Query("from Lesson where levelSeqId= ?1 order by seqNo asc")
    List<Lesson> findLessons(long seqId);
}
