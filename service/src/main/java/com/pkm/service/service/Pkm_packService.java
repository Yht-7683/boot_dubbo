package com.pkm.service.service;


import com.pkm.service.object.Pkm_pack;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;


public interface Pkm_packService {

    Pkm_pack getPkm_packById(int id);
    List<Pkm_pack> getAllPkm_pack();
    List<Pkm_pack> searchPkm_pack(String keyword);
    Boolean addPkm_pack(Pkm_pack object);
    Boolean delPkm_pack(int id);
    Boolean upPkm_pack(Pkm_pack object);
}
