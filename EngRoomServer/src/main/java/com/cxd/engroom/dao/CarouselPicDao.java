package com.cxd.engroom.dao;

import com.cxd.engroom.bean.CarouselPic;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarouselPicDao extends CrudRepository<CarouselPic, Long> {


    @Query("from CarouselPic where levelSeqId= ?1 order by seqNo asc")
    List<CarouselPic> findCarousels(long seqId);
}
