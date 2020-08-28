package com.yht.web.controller;



import com.pkm.service.object.Ball_pack;
import com.pkm.service.object.User;
import com.pkm.service.service.Ball_packService;
import com.pkm.service.service.UserService;
import com.yht.web.domain.Res;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api")
public class UserController {
    @Reference(version = "1.0.0")
    private UserService userService;
    @Reference(version = "1.0.0")
    private Ball_packService ball_packService;
    //获取当前所有用户
    @RequestMapping("/public/getAllUser")
    public Res show(){
        List<User> list=userService.getAllUser();
        return new Res(Res.SUCCESS,"查找成功",list);
    }
    //删除用户
    @RequestMapping("/public/delUser")
    public Res del(String id){
        if(userService.delUser(id)){
            return new Res(Res.SUCCESS,"删除成功！",null);
        }else {
            return new Res(Res.ERROR,"删除失败！",null);
        }
    }
    //添加用户
    public Res adduser(User user){
        Date date=new Date();
        user.setRegistTime(date);
        if(userService.getUserById(user.getId())!=null&&userService.getUserByName(user.getName())!=null){
            return new Res(Res.FAILURE,"用户已经存在！",null);
        }
        if(userService.addUser(user)){
            return new Res(Res.SUCCESS,"添加成功！",null);
        }else {
            return new Res(Res.ERROR,"添加失败！",null);
        }
    }
    //用户ID随机数生成
    public String getRandomString(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
    //添加新用户在道具背包的记录
    public void addBall_pack(String userid){
        for(int i=0;i<5;i++){
            Ball_pack ball_pack=new Ball_pack(i,userid,i+1,0);
            ball_packService.addBall_pack(ball_pack);

        }

    }

    //管理员添加用户
    @RequestMapping("/public/addUser")
    public Res GMadd(User user){
        user.setPhoto("https://gss0.bdstatic.com/-4o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike72%2C5%2C5%2C72%2C24/sign=ad9086b6af014c080d3620f76b12696d/4ec2d5628535e5dda3a5aec070c6a7efce1b6227.jpg");
        Res res=adduser(user);
        addBall_pack(user.getId());
        return res;

    }
    //用户注册
    @RequestMapping("/public/regist")
    public Res regist(User user){
        System.out.println(user);
        user.setPhoto("https://gss3.bdstatic.com/-Po3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike92%2C5%2C5%2C92%2C30/sign=ce1116222634349b600b66d7a8837eab/94cad1c8a786c9179402a501c73d70cf3bc75781.jpg");
        user.setId(getRandomString(6));
        user.setMoney(10000);
        user.setRole("用户");
        user.setState("正常");
        Res res=adduser(user);
        addBall_pack(user.getId());
        return res;

    }
    //更新用户信息
    @RequestMapping("/public/upUser/")
    public Res up(User user){
        if(userService.upUser(user)){
            return new Res(Res.SUCCESS,"修改成功！",null);
        }
        else {
            return new Res(Res.ERROR,"修改失败！",null);
        }
    }

    //模糊查找用户
    @RequestMapping("/public/searchUser")
    public Res select(@RequestParam("searchParam") String keyword){
        List<User> list=userService.searchUser(keyword);
        return new Res(Res.SUCCESS,"查找成功",list);
    }
@RequestMapping("/public/getUserById")
    public Res getById(@RequestParam("id") String id){
    User user =userService.getUserById(id);
    return new Res(Res.SUCCESS,"查找成功",user);
}

}
