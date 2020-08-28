package com.pkm.provider.service;


import com.pkm.service.object.BallBag;
import com.pkm.service.object.BallNum;
import com.pkm.service.service.BallBagService;
import com.pkm.service.service.BallNumService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
@Service(version = "1.0.0" ,timeout = 2000,interfaceClass = BallNumService.class)
public class BallNumServiceImp implements BallNumService{
    @Autowired
    BallNumServiceImp ballNumService;
    public BallNum getBallNum(List<BallBag> list){
        BallNum ballNum = new BallNum();
        list.forEach(ballBag -> {
            int id=ballBag.getId();
            int num=ballBag.getNum();
            if(id==1) ballNum.setNum1(num);
            else if (id==2) ballNum.setNum2(num);
            else if (id==3) ballNum.setNum3(num);
            else if (id==4) ballNum.setNum4(num);
            else if (id==5) ballNum.setNum5(num);

        });
        return ballNum;
    }
}
