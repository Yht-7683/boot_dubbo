package com.pkm.provider.dao;

import com.pkm.service.object.PkmBag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PkmBagDao {
    List<PkmBag> getPkmBagById(String id);
    List<PkmBag> searchPkmBag(@Param("id") String id, @Param("name")String name);
}
