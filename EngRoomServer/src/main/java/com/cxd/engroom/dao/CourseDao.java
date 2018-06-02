package com.cxd.engroom.dao;

import com.cxd.engroom.bean.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseDao extends CrudRepository<Course,Long> {
    @Query("from Course where ishow=true order by seqNo asc")
    List<Course> findIndexCourse();
}
