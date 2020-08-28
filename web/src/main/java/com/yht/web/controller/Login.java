package com.yht.web.controller;



import com.pkm.service.object.User;
import com.pkm.service.service.UserService;
import com.yht.web.domain.Res;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class Login {
    @Reference(version = "1.0.0")
    UserService userService;
    private User useU;
    @CrossOrigin
    @PostMapping("/public/login")
    public Res userlogin(@RequestParam("username") String name, @RequestParam("password") String passWord, HttpSession session){
        useU=userService.getUserByName(name);
        System.out.println(name+"    "+passWord);
        if(useU!=null){
            if(useU.getPassword().equals(passWord)){
                session.setAttribute("user", useU);
                return new Res(Res.SUCCESS,"登录成功",useU);
            }else {
                return new Res(Res.ERROR,"密码错误",null);
            }
        } else return new Res(Res.ERROR,"用户不存在",null);
    }

    public User getUseU(){
        return this.useU;
    }

}
