package com.pkm.provider.dao;

import com.pkm.service.object.BallBag;
import com.pkm.service.object.BallNum;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BallNumDao {
    BallNum getBallNum(List<BallBag> list);
}
