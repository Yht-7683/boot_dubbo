package com.yht.web.controller;


import com.pkm.service.object.*;
import com.pkm.service.service.*;
import com.yht.web.domain.Res;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BagController {
    @Reference(version = "1.0.0")
    private BagService bagService;
    @Reference(version = "1.0.0")
    private BallBagService ballBagService;
    @Reference(version = "1.0.0")
    private PkmBagService pkmBagService;
    @Reference(version = "1.0.0")
    private Ball_packService ball_packService;
    @Reference(version = "1.0.0")
    private Pkm_packService pkm_packService;
    @Reference(version = "1.0.0")
    private BallNumService ballNumService;
    //获取所有用户们的精灵数和道具数
    @RequestMapping("/public/getAllBag")
    public Res showAll(){
        List<Bag> list=bagService.getAllBag();
        return new Res(Res.SUCCESS,"查找成功",list);
    }
    //模糊查找用户的精灵数和道具数
    @RequestMapping("/public/searchBag")
    public Res searchBag(@RequestParam("searchParam") String keyword){
        List<Bag> list=bagService.searchBag(keyword);
        return new Res(Res.SUCCESS,"查找成功",list);
    }
    //获取用户拥有的道具信息
    @RequestMapping("/public/getBallBag")
    public Res getBallBag(@RequestParam("searchParam") String id){
        List<BallBag> list=ballBagService.getBallBagById(id);
        BallNum ballNum=ballNumService.getBallNum(list);
        return new Res(Res.SUCCESS,"查找成功",ballNum);
    }
    //获取用户拥有的精灵信息
    @RequestMapping("/public/getPkmBag")
    public Res getPkmBag(@RequestParam("searchParam") String id){
        List<PkmBag> list=pkmBagService.getPkmBagById(id);
        return new Res(Res.SUCCESS,"查找成功",list);
    }
    //模糊查找用户拥有的精灵
    @RequestMapping("/public/getPkmBagById")
    public Res getPkmBagById(@RequestParam("userid") String id,@RequestParam("pokemon") String name){
        List<PkmBag> list=pkmBagService.searchPkmBag(id,name);
        return new Res(Res.SUCCESS,"查找成功",list);
    }
    //更新用户的精灵球数量
    @RequestMapping("/public/upBall_pack")
    public Res up(@RequestParam("userid") String id,@RequestParam("ball1") int num1,@RequestParam("ball2") int num2,@RequestParam("ball3") int num3,@RequestParam("ball4") int num4,@RequestParam("ball5") int num5){

        for(int i=1;i<=5;i++){
            Ball_pack ball_pack=new Ball_pack();
            ball_pack.setBall_id(i);
            ball_pack.setUser_id(id);
            if(i==1) ball_pack.setNum(num1);
            else if(i==2) ball_pack.setNum(num2);
            else if(i==3) ball_pack.setNum(num3);
            else if(i==4) ball_pack.setNum(num4);
            else if(i==5) ball_pack.setNum(num5);
            ball_packService.upBall_pack(id,ball_pack.getBall_id(),ball_pack.getNum());
        }
        return new Res(Res.SUCCESS,"修改完成！",null);
    }
    //根据精灵背包id删除用户的精灵
    @RequestMapping("/public/delPkm_pack")
    public Res del(@RequestParam("bagid") int id){
        if(pkm_packService.delPkm_pack(id)){
            return new Res(Res.SUCCESS,"删除成功！",null);
        }else {
            return new Res(Res.ERROR,"删除失败！",null);
        }
    }
}
