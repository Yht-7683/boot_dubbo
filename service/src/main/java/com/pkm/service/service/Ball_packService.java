package com.pkm.service.service;

import com.pkm.service.object.Ball_pack;


import java.util.List;

public interface Ball_packService {

    Ball_pack getBall_packById(String userid, int ballid);
    List<Ball_pack> getAllBall_pack();
    List<Ball_pack> searchBall_pack(String keyword);
    Boolean addBall_pack(Ball_pack object);
    Boolean delBall_pack(int id);
    Boolean upBall_pack(String userid, int ballid ,int num);
}
