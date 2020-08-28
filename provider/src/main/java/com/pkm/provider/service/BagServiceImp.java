package com.pkm.provider.service;


import com.pkm.provider.dao.BagDao;
import com.pkm.service.object.Bag;
import com.pkm.service.service.BagService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Service(version = "1.0.0" ,timeout = 2000,interfaceClass = BagService.class)
public class BagServiceImp implements BagService{
    @Autowired
    private BagDao bagDao;
    public List<Bag> searchBag(String keyword){
        return  bagDao.searchBag("%"+keyword+"%");

    }
    public List<Bag> getAllBag(){
        return  bagDao.getAllBag();
    }

}
