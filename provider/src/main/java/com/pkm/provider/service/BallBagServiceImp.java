package com.pkm.provider.service;


import com.pkm.provider.dao.BallBagDao;
import com.pkm.service.object.BallBag;
import com.pkm.service.service.BallBagService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;


import java.util.List;

@Component
@Service(version = "1.0.0" ,timeout = 2000,interfaceClass = BallBagService.class)
public class BallBagServiceImp implements BallBagService {
    @Autowired
    BallBagDao ballBagDao;
    public List<BallBag> getBallBagById(String id){
        return ballBagDao.getBallBagById(id);
    }
}
