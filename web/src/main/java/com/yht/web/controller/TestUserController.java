package com.yht.web.controller;


import com.pkm.service.object.Ball;
import com.pkm.service.object.BallBag;
import com.pkm.service.object.Ball_pack;
import com.pkm.service.object.User;
import com.pkm.service.service.*;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/testBoot")
public class TestUserController {
    @Reference(version = "1.0.0")
    UserService userService;
    @Reference(version = "1.0.0")
    PkmBagService pkmBagService;
    @Reference(version = "1.0.0")
    Ball_packService ball_packService;
    @Reference(version = "1.0.0")
    private BallService ballService;
    @Reference(version = "1.0.0")
    private BallBagService ballBagService;
    @RequestMapping("upBallPack/{userid}/{ballid}/{num}")
    public List up(@PathVariable("userid") String userid,@PathVariable("ballid") int ballid, @PathVariable("num") int num){
        Ball ball=ballService.getBallById(ballid);
        User user=userService.getUserById(userid);
        Ball_pack ball_pack=ball_packService.getBall_packById(userid,ballid);
        int total = ball.getMoney()*num;
        if(user.getMoney()>=total) {
            user.setMoney(user.getMoney() - total);
            userService.upUser(user);
            ball_packService.upBall_pack(userid, ballid, ball_pack.getNum() + num);
            System.out.println("购买成功");
        }
        else System.out.println("购买失败");
        List<BallBag> list=ballBagService.getBallBagById(userid);
        return list;
    }
    @RequestMapping("showUserBall/{userid}")
    public List show(@PathVariable("userid") String userid){
        List<BallBag> list=ballBagService.getBallBagById(userid);
        return list;
    }

//    @RequestMapping("getUser/{id}/{name}")
//    public List<PkmBag> getId(@PathVariable("id") String id,@PathVariable("name") String name){
//        return pkmBagService.searchPkmBag(id ,name);
//    }
////    @RequestMapping("getall")
////    public List<Bag> getall(){
////        return bagService.getAllBag();
////    }
//    @RequestMapping("test")
//    public String getRandomString(){
//            String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
//            Random random=new Random();
//            StringBuffer sb=new StringBuffer();
//            for(int i=0;i<6;i++){
//                int number=random.nextInt(62);
//                sb.append(str.charAt(number));
//            }
//            return sb.toString();
//    }
//    @RequestMapping("del/{id}")
//    public List<User> del(@PathVariable String id){
//        userService.delUser(id);
//        return userService.getAllUser();
//    }
//    public void addBall_pack(String userid){
//        for(int i=0;i<5;i++){
//            Ball_pack ball_pack=new Ball_pack(i,userid,i+1,0);
//            ball_packService.addBall_pack(ball_pack);
//
//        }
//
//    }
//    @RequestMapping("add")
//    public List<User> add(){
//        Date date1=new Date();
//        System.out.println(date1);
//        User user1=new User("a124","test","123","123456","123456","正常","用户","男",new java.sql.Date(date1.getTime()),1000);
//        userService.addUser(user1);
//        addBall_pack(user1.getId());
//        return userService.getAllUser();
//    }
//    @RequestMapping("up")
//    public User upd(){
//        Date date1=new Date();
//        System.out.println(date1);
//        User user1=new User("a123","test2","123","123456","123456","正常","用户","男",date1,1000);
//        userService.upUser(user1);
//        return userService.getUserById(user1.getId());
//    }





}
