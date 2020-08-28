package com.pkm.provider.dao;

import com.pkm.service.object.Bag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BagDao {
    List<Bag> searchBag(String keyword);
    List<Bag> getAllBag();
}
