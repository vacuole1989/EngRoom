package com.cxd.engroom.dao;

import com.cxd.engroom.bean.Lesson;
import org.springframework.data.repository.CrudRepository;

public interface LessonDao extends CrudRepository<Lesson,Long> {
}
