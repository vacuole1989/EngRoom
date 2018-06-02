package com.cxd.engroom.mapper;

import com.cxd.engroom.bean.CarouselPic;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface CarouselPicMapper {
    List<CarouselPic> findIndexPic();
}
