package com.pkm.provider.dao;

import com.pkm.service.object.Ball;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BallDao {
    Ball getBallById(int id);
    List<Ball> getAllBall();
    List<Ball> searchBall(String keyword);
    Boolean addBall(Ball object);
    Boolean delBall(int id);
    Boolean upBall(Ball object);
}
