package com.pkm.provider.service;


import com.pkm.provider.dao.BallDao;
import com.pkm.service.object.Ball;
import com.pkm.service.service.BallService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import javax.annotation.Resource;
import java.util.List;

@Component
@Service(version = "1.0.0" ,timeout = 2000, interfaceClass = BallService.class)
public class BallServiceImp implements BallService {
    @Resource
    private BallDao ballDao;
    public Ball getBallById(int id){
        return ballDao.getBallById(id);
    }
    public List<Ball> getAllBall(){
        return ballDao.getAllBall();
    }
    public List<Ball> searchBall(String keyword){
        return ballDao.searchBall("%"+keyword+"%");
    }
    public Boolean addBall(Ball object){
        return ballDao.addBall(object);
    }
    public Boolean delBall(int id){
        return ballDao.delBall(id);
    }
    public Boolean upBall(Ball object){
        return ballDao.upBall(object);
    }
}
