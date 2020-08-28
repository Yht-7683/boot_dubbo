package com.pkm.provider.service;


import com.pkm.provider.dao.PkmBagDao;
import com.pkm.service.object.PkmBag;
import com.pkm.service.service.PkmBagService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
@Service(version = "1.0.0" ,timeout = 2000,interfaceClass = PkmBagService.class)
public class PkmBagServiceImp implements PkmBagService {
    @Autowired
    PkmBagDao pkmBagDao;
    public List<PkmBag> getPkmBagById(String id){
        return pkmBagDao.getPkmBagById(id);
    }
    public List<PkmBag> searchPkmBag(String id,String name){
        return pkmBagDao.searchPkmBag(id,"%"+name+"%");
    }
}
