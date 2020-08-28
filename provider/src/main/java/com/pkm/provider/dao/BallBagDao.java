package com.pkm.provider.dao;

import com.pkm.service.object.BallBag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BallBagDao {
    List<BallBag> getBallBagById(String id);

}
