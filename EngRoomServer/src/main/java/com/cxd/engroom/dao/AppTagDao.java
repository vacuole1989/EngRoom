package com.cxd.engroom.dao;

import com.cxd.engroom.bean.AppTag;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AppTagDao extends CrudRepository<AppTag,String> {
    @Query("from AppTag ")
    List<AppTag> findOnlyOne();
}
