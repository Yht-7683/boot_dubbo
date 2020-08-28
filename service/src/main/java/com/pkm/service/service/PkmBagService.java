package com.pkm.service.service;


import com.pkm.service.object.PkmBag;


import java.util.List;


public interface PkmBagService {

    List<PkmBag> getPkmBagById(String id);
    List<PkmBag> searchPkmBag(String id,String name);
}
