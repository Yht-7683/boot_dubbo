package com.yht.web.controller;

import com.pkm.service.object.Ball;
import com.pkm.service.object.BallBag;
import com.pkm.service.object.Ball_pack;
import com.pkm.service.object.User;
import com.pkm.service.service.BallBagService;
import com.pkm.service.service.BallService;
import com.pkm.service.service.Ball_packService;
import com.pkm.service.service.UserService;
import com.yht.web.domain.Res;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BuyBallController {
    @Reference(version = "1.0.0")
    private Ball_packService ball_packService;
    @Reference(version = "1.0.0")
    private UserService userService;
    @Reference(version = "1.0.0")
    private BallService ballService;
    @Reference(version = "1.0.0")
    private BallBagService ballBagService;
    @RequestMapping("/public/upBallPack")
    public Res up(@RequestParam("userid") String userid, @RequestParam("ballid") int ballid, @RequestParam("num") int num){
        Ball ball=ballService.getBallById(ballid);
        User user=userService.getUserById(userid);
        Ball_pack ball_pack=ball_packService.getBall_packById(userid,ballid);
        int total = ball.getMoney()*num;
        if(user.getMoney()>=total){
            user.setMoney(user.getMoney()-total);
            userService.upUser(user);
            if(ball_packService.upBall_pack(userid,ballid,ball_pack.getNum()+num))
                return new Res(Res.SUCCESS,"购买成功！",null);
            else return new Res(Res.ERROR,"购买失败！",null);
        }
        else {
            return new Res(Res.ERROR,"金币不足！",null);
        }
    }
    @RequestMapping("public/showUserBall")
    public Res show(@RequestParam("userid") String userid){
        List<BallBag> list=ballBagService.getBallBagById(userid);
        return new Res(Res.SUCCESS,"查找成功",list);
    }
}
