package com.pkm.provider.dao;


import com.pkm.service.object.Ball_pack;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface Ball_packDao {
    Ball_pack getBall_packById(@Param("userid") String userid,@Param("ballid") int ballid);
    List<Ball_pack> getAllBall_pack();
    List<Ball_pack> searchBall_pack(String keyword);
    Boolean addBall_pack(Ball_pack object);
    Boolean delBall_pack(int id);
    Boolean upBall_pack(@Param("userid") String userid,@Param("ballid") int ballid,@Param("num") int num);

}
