package com.pkm.provider.dao;

import com.pkm.service.object.Pkm_pack;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Pkm_packDao {
    Pkm_pack getPkm_packById(int id);
    List<Pkm_pack> getAllPkm_pack();
    List<Pkm_pack> searchPkm_pack(String keyword);
    Boolean addPkm_pack(Pkm_pack object);
    Boolean delPkm_pack(int id);
    Boolean upPkm_pack(Pkm_pack object);
}
