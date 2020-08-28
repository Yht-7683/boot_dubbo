package com.pkm.service.service;


import com.pkm.service.object.Ball;

import org.springframework.stereotype.Service;

import java.util.List;


public interface BallService {
   Ball getBallById(int id);
   List<Ball> getAllBall();
   List<Ball> searchBall(String keyword);
   Boolean addBall(Ball object);
   Boolean delBall(int id);
   Boolean upBall(Ball object);
}
