package com.cxd.engroom.dao;

import com.cxd.engroom.bean.Activity;
import org.springframework.data.repository.CrudRepository;

public interface ActivityDao extends CrudRepository<Activity, Long> {
}
