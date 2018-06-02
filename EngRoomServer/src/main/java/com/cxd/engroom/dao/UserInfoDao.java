package com.cxd.engroom.dao;

import com.cxd.engroom.bean.UserInfo;
import org.springframework.data.repository.CrudRepository;

public interface UserInfoDao extends CrudRepository<UserInfo,Long> {
}
