package com.pkm.provider.service;


import com.pkm.provider.dao.Ball_packDao;
import com.pkm.service.object.Ball_pack;
import com.pkm.service.service.Ball_packService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
@Service(version = "1.0.0" ,timeout = 2000,interfaceClass = Ball_packService.class)
public class Ball_packServiceImp implements Ball_packService {
    @Autowired
    private Ball_packDao ball_packDao;
    public Ball_pack getBall_packById(String userid, int ballid){
        return ball_packDao.getBall_packById(userid,ballid);
    }
    public List<Ball_pack> getAllBall_pack(){
        return ball_packDao.getAllBall_pack();
    }
    public List<Ball_pack> searchBall_pack(String keyword){
        return ball_packDao.searchBall_pack("%"+keyword+"%");
    }
    public Boolean addBall_pack(Ball_pack object){
        return ball_packDao.addBall_pack(object);
    }
    public Boolean delBall_pack(int id){
        return ball_packDao.delBall_pack(id);
    }
    public Boolean upBall_pack(String userid, int ballid ,int num){
        return ball_packDao.upBall_pack(userid,ballid,num);
    }
}
